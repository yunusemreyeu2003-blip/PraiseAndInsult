package Interface;

import Data.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Page {
    Pane pane;

    protected Data data;

    protected Scene scene;
    protected StackPane root;
    protected Page nextPage;
    protected Page prevPage;

    protected BorderPane borderPane = new BorderPane();
    protected StackPane centerStack = new StackPane();
    protected StackPane upperStack = new StackPane();
    protected StackPane bottomStack = new StackPane();
    protected StackPane leftStack = new StackPane();
    protected StackPane rightStack = new StackPane();
    protected HBox navigation = new HBox();
    protected Button prevButton = new Button();
    protected Button nextButton = new Button();

    public Page(Data data, Scene scene, StackPane root) {
        this.data = data;
        this.scene = scene;
        this.root = root;

        borderPane.setBackground(Background.fill(Color.WHITESMOKE));

        borderPane.setTop(upperStack);
        borderPane.setBottom(bottomStack);
        borderPane.setLeft(leftStack);
        borderPane.setRight(rightStack);
        borderPane.setCenter(centerStack);

        bottomStack.getChildren().add(navigation);

        this.pane = borderPane;
    }

    public void setPrevPage(Page prevPage) {
        this.prevPage = prevPage;

        prevButton.setOnAction(event -> {;
            root.getChildren().setAll(prevPage.pane);
            prevPage.onShow();
        });
    }

    public void setNextPage(Page nextPage) {
        this.nextPage = nextPage;

        nextButton.setOnAction(event -> {;
            root.getChildren().setAll(nextPage.pane);
            nextPage.onShow();
        });
    }

    public void onShow() {}
    public void handleSpace() {}

}
