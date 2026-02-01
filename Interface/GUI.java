package Interface;

import Data.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class GUI extends Application {
    private Stage primaryStage;
    private final StackPane root = new StackPane();
    private Scene scene;
    Data data = new Data();

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        scene = new Scene(root, 800, 600);

        if(Config.DEBUG_MODE) {
            scene.getStylesheets().add(
                    Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        }


        primaryStage.setScene(scene);
        primaryStage.setTitle("Övgü ve Hakaret Test Uygulaması");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F11) {
                primaryStage.setFullScreen(!primaryStage.isFullScreen());
            }
        });

        primaryStage.show();

        Page page0 = new Page0(data, scene, root);
        Page page1 = new Page1(data, scene, root);
        Page page2 = new Page2(data, scene, root);
        Page page3 = new Page3(data, scene, root);

        page0.setNextPage(page1);
        page1.setPrevPage(page0);
        page1.setNextPage(page2);
        page2.setPrevPage(page1);
        page2.setNextPage(page3);
        page3.setPrevPage(page2);

        root.getChildren().setAll(page0.pane);
    }

    public static void main(String[] args) {
        launch(args);
    }



}