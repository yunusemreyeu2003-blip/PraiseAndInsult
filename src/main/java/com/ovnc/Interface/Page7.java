package com.ovnc.Interface;

import com.ovnc.Data.*;
import com.ovnc.Time.*;
import com.ovnc.Sound.*;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.Random;

public class Page7 extends Page{

    Text countdownText = new Text();
    Text praise_insultText = new Text();
    Text endText = new Text();
    State currentState;
    int currentTestIndex;
    Timer timer = new Timer();

    public Page7(Data data, Scene scene, StackPane root) {
        super(data, scene, root);

        upperStack.setPrefHeight(0);
        bottomStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        leftStack.setPrefWidth(0);
        rightStack.setPrefWidth(0);

        navigation.setAlignment(Pos.CENTER);
        navigation.spacingProperty().bind(bottomStack.widthProperty().multiply(0.1));

        nextButton.setText("Sonraki");
        navigation.getChildren().addAll(nextButton);

        centerStack.setAlignment(Pos.CENTER);

        countdownText.setFont(new Font(80));

        praise_insultText.setVisible(false);
        praise_insultText.wrappingWidthProperty().bind(scene.widthProperty().multiply(0.8));
        praise_insultText.setTextAlignment(TextAlignment.CENTER);
        praise_insultText.setFont(new Font(40));

        endText.setText("Başarı ile testin 2.ci aşamasını tamamladınız.");
        endText.wrappingWidthProperty().bind(scene.widthProperty().multiply(0.8));
        endText.setTextAlignment(TextAlignment.CENTER);

        centerStack.getChildren().addAll(countdownText, praise_insultText, endText);

        borderPane.setFocusTraversable(true);
        borderPane.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case KeyCode.SPACE -> {
                    handleSpace();
                    event.consume();
                }
            }
        });
    }

    @Override
    public void onShow() {
        nextButton.setVisible(false);
        endText.setVisible(false);

        borderPane.requestFocus();
        countdown();
    }

    @Override
    public void handleSpace() {
        switch (currentState) {
            case WAIT -> {
                data.experimentData[currentTestIndex].earlyPress = true;
            }
            case TRIGGER -> {
                timer.stop();
                data.experimentData[currentTestIndex].reactionTime = timer.duration;
                startTest();
            }
            case FALSE_TRIGGER -> {
                timer.stop();
                data.experimentData[currentTestIndex].reactionTime = timer.duration;
                data.experimentData[currentTestIndex].falsePress = true;
                startTest();
            }
        }
    }

    private void countdown() {
        currentTestIndex = -1;

        currentState = State.COUNTDOWN;

        int[] count = {3};

        Timeline countdown = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (count[0] > 0) {
                countdownText.setVisible(true);
                countdownText.setText(String.valueOf(count[0]--));
            } else {
                countdownText.setVisible(false);
                startTest();
            }
        }));
        countdown.setCycleCount(4);
        countdown.play();
    }

    private void startTest() {
        currentTestIndex++;
        System.out.println(currentTestIndex);
        if (currentTestIndex >= Config.EXPERIMENT_TEST_COUNT) {
            finish();
        }
        else {
            praise_insult();
        }
    }

    private void praise_insult() {
        currentState = State.PRAISE_INSULT;
        borderPane.setBackground(Background.fill(Color.WHITE));

        Random rand = new Random();

        Praise_Insult praise_insult;

        if (data.praise_insult == Praise_InsultType.PRAISE) {
            int index = rand.nextInt(Config.PRAISES.size());
            praise_insult = Config.PRAISES.get(index);
            data.experimentData[currentTestIndex].praise_insult = Config.PRAISES.get(index);
            Config.PRAISES.remove(index);
        } else {
            int index = rand.nextInt(Config.INSULTS.size());
            praise_insult = Config.INSULTS.get(index);
            data.experimentData[currentTestIndex].praise_insult = Config.INSULTS.get(index);
            Config.INSULTS.remove(index);
        }

        praise_insultText.setVisible(true);

        praise_insultText.setText(praise_insult.text);
        SoundPlayer.playSound(praise_insult.sound);

        PauseTransition praise_insultPhase = new PauseTransition(DurationHelper.DoubleSecondsToJavaFX(praise_insult.sound.length));
        praise_insultPhase.setOnFinished(event -> {
            praise_insultText.setVisible(false);
            waitPhase();
        });
        praise_insultPhase.play();
    }

    private void waitPhase() {
        currentState = State.WAIT;
        borderPane.setBackground(Background.fill(Color.WHITE));

        double waitTime = 2 + Math.random() * 5;
        data.experimentData[currentTestIndex].waitTime = DurationHelper.DoubleSecondsToJava(waitTime);
        PauseTransition waitPhase = new PauseTransition(DurationHelper.DoubleSecondsToJavaFX(waitTime));

        TriggerType triggerType;

        if (Math.random() < 0.5) {
            triggerType = TriggerType.TRIGGER;
        } else {
            triggerType = TriggerType.FALSE_TRIGGER;
        }

        data.experimentData[currentTestIndex].triggerType = triggerType;

        switch (currentTestIndex) {
            case 0, 2 -> triggerType = TriggerType.TRIGGER;
            case 1 -> triggerType = TriggerType.FALSE_TRIGGER;
        }

        data.experimentData[currentTestIndex].triggerType = triggerType;

        TriggerType[] triggerTypeRef = {triggerType};

        waitPhase.setOnFinished(event -> {
            if (triggerTypeRef[0] == TriggerType.TRIGGER) {
                currentState = State.TRIGGER;
                triggerPhase();
            }
            else {
                currentState = State.FALSE_TRIGGER;
                falseTriggerPhase();
            }
        });
        waitPhase.play();
    }

    private void triggerPhase() {
        currentState = State.TRIGGER;
        borderPane.setBackground(Background.fill(Color.RED));
        timer.start();
    }

    private void falseTriggerPhase() {
        currentState = State.FALSE_TRIGGER;
        borderPane.setBackground(Background.fill(Color.BLUE));
        timer.start();

        double falsePressWaitTime = 1 + Math.random() * 3;
        data.experimentData[currentTestIndex].FalsePressWaitTime = DurationHelper.DoubleSecondsToJava(falsePressWaitTime);
        PauseTransition wait = new PauseTransition(DurationHelper.DoubleSecondsToJavaFX(falsePressWaitTime));

        int falseTriggerIndex = currentTestIndex;

        wait.setOnFinished(event -> {
            if (falseTriggerIndex == currentTestIndex) {
                startTest();
            }
        });
        wait.play();
    }

    private void finish() {
        currentState = State.FINISHED;
        borderPane.setBackground(null);

        endText.setVisible(true);
        countdownText.setVisible(false);
        nextButton.setVisible(true);
    }
}
