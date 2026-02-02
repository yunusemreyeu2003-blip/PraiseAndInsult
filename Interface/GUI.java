package Interface;

import Data.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GUI extends Application {
    private Stage primaryStage;
    private final StackPane root = new StackPane();
    private Scene scene;
    Data data = new Data();
    List<Page> pages = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        scene = new Scene(root, 800, 600);

        if (Config.DEBUG_MODE) {
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

        Collections.addAll(pages,
                new Page0(data, scene, root),
                new Page1(data, scene, root),
                new Page2(data, scene, root),
                new Page3(data, scene, root),
                new Page4(data, scene, root),
                new Page5(data, scene, root),
                new Page6(data, scene, root)
        );



        for (int i = 0; i < pages.size(); i++) {
            if (i != 0) {
                pages.get(i).setPrevPage(pages.get(i - 1));
            }
            if (i != pages.size() - 1) {
                pages.get(i).setNextPage(pages.get(i + 1));
            }
        }

        root.getChildren().setAll(pages.get(4).pane);

    }

    public static void main(String[] args) {
        launch(args);
    }
}