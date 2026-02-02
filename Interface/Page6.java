package Interface;

import Data.Data;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
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

        prevButton.setText("Previous");
        nextButton.setText("Next");
        navigation.getChildren().addAll(prevButton, nextButton);

        centerStack.setAlignment(Pos.CENTER);

        text = new Text("Önümüzde testimizin 2. Aşamsı bulunmaktadır bu aşamada size hitaben sözler söylenecektir " +
                "bunlar dikkatlice dinlemeniz ve hatırlamanız rica olunur. Ayrıca önceki tested olduğu gibi " +
                "belirsiz bir süre sonra ekran KIRMIZI veya MAVİ yanacaktır KIRMIZI yanması durumunda " +
                "OLABİLDİĞİNCE hızlı bir şekilde klavyedeki en büyük tuş olan BOŞLUK tuşunun ortasına basmanız " +
                "gerekmektedir yada MAVİ yanması durumunda ekran tekrardan beyaz olana kadar hiçbir tuşa " +
                "BASMAMANIZ gerekmektedir.");
        text.wrappingWidthProperty().bind(scene.widthProperty().multiply(0.6));
        text.setTextAlignment(TextAlignment.CENTER);
        centerStack.getChildren().addAll(text);
    }
}
