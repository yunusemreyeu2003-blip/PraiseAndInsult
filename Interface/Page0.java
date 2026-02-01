package Interface;

import Data.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class Page0 extends Page {

    public Page0(Data data, Scene scene, StackPane root) {
        super(data, scene, root);

        upperStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.2));
        bottomStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        leftStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        rightStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));

        navigation.setAlignment(Pos.CENTER);
        navigation.spacingProperty().bind(scene.widthProperty().multiply(0.25));

        nextButton.setText("Next");
        navigation.getChildren().addAll(nextButton);

    }
}
