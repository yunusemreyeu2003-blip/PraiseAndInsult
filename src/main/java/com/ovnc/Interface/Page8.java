package com.ovnc.Interface;

import com.ovnc.Data.Data;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Page8 extends Page{
    Text text;

    public Page8(Data data, Scene scene, StackPane root) {
        super(data, scene, root);

        upperStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.2));
        bottomStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        leftStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        rightStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));

        navigation.setAlignment(Pos.CENTER);
        navigation.spacingProperty().bind(bottomStack.widthProperty().multiply(0.1));

        navigation.getChildren().addAll();

        centerStack.setAlignment(Pos.CENTER);

        text = new Text("Test tamamlandı. Katılımınız için teşekkür ederiz!");
        text.wrappingWidthProperty().bind(scene.widthProperty().multiply(0.6));
        text.setTextAlignment(TextAlignment.CENTER);
        centerStack.getChildren().addAll(text);
    }

    @Override
    public void onShow() {
        data.writeToCSV();
    }
}
