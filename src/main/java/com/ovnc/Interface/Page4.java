package com.ovnc.Interface;

import com.ovnc.Data.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Page4 extends Page{
    Text text;

    public Page4(Data data, Scene scene, StackPane root) {
        super(data, scene, root);

        upperStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.2));
        bottomStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        leftStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        rightStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));

        navigation.setAlignment(Pos.CENTER);
        navigation.spacingProperty().bind(bottomStack.widthProperty().multiply(0.1));

        nextButton.setText("Sonraki");
        navigation.getChildren().addAll(nextButton);

        centerStack.setAlignment(Pos.CENTER);

        text = new Text("Sample Text");
        text.wrappingWidthProperty().bind(scene.widthProperty().multiply(0.6));
        text.setTextAlignment(TextAlignment.CENTER);
        centerStack.getChildren().addAll(text);
    }
}
