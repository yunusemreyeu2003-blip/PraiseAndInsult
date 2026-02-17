package com.ovnc.Interface;

import com.ovnc.Data.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Page6 extends Page{
    Text text;

    public Page6(Data data, Scene scene, StackPane root) {
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

        text = new Text("Önümüzde testimizin 2. aşaması bulunmaktadır. Bu aşamada size hitaben bazı sözler " +
                "söylenecektir; bunları dikkatlice dinlemeniz ve hatırlamanız rica olunur. Ayrıca, önceki " +
                "testte olduğu gibi belirsiz bir süre sonra ekran KIRMIZI veya MAVİ renge dönecektir.\n" +
                "Ekran KIRMIZI yandığında, olabildiğince hızlı bir şekilde klavyedeki en büyük tuş olan " +
                "BOŞLUK tuşunun ortasına basmanız gerekmektedir.\n" +
                "Ekran MAVİ yandığında ise, ekran tekrar beyaz olana kadar hiçbir tuşa basmamanız " +
                "gerekmektedir.");

        text.wrappingWidthProperty().bind(scene.widthProperty().multiply(0.6));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(new Font(40));
        centerStack.getChildren().addAll(text);
    }
}
