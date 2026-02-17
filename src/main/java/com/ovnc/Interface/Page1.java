package com.ovnc.Interface;

import com.ovnc.Data.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class Page1 extends Page {
    public Page1(Data data, Scene scene, StackPane root) {
        super(data, scene, root);

        upperStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        bottomStack.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        leftStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        rightStack.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));

        centerStack.maxWidthProperty().bind(scene.widthProperty().multiply(0.6));

        navigation.setAlignment(Pos.CENTER);
        navigation.spacingProperty().bind(bottomStack.widthProperty().multiply(0.1));

        nextButton.setText("Sonraki");
        navigation.getChildren().addAll(nextButton);


        // Agreement content box

        VBox contentBox = new VBox();

        Text title = new Text("ÇEVRİM İÇİ GÖNÜLLÜ KATILIMCI ONAM FORMU");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(new Font(20));

        Region spacer1 = new Region();
        spacer1.maxHeightProperty().bind(contentBox.heightProperty().multiply(0.05));
        VBox.setVgrow(spacer1, Priority.ALWAYS);

        TextFlow contentFlow = new TextFlow();
        contentFlow.setBackground(Background.fill(Color.WHITESMOKE));
        contentFlow.setPadding(new Insets(10,10,10,10));

        Text content = new Text("" +
                "Değerli Katılımcılar,\n" +
                "\n" +
                "\tBu çalışma; İzmir Demokrasi Üniversitesi Psikoloji Bölümü lisans öğrencileri Yunus Emre Uysal, Uğur Çaka, Oğuzhan Demiray, Enes Bayram tarafından Dr. Öğr. Üyesi Yılmaz Orhun Gürlük danışmanlığında TÜBİTAK 2209-A projesi kapsamında yürütülmektedir.\n" +
                "\n" +
                "Bu çalışma Övgü ve Hakaret kelimelerinden türkçe envanter oluşturmak için yapılmaktadır.\n" +
                "\n" +
                "Anket yaklaşık 5 dakika sürecektir. Veriler anonim toplanacak sadece araştırma için kullanılacaktır.\n" +
                "\n" +
                "Katılım tamamen gönüllük esası üzerinedir, istediğiniz vakitte çıkabilir yada hiç başlamayabilirsiniz.\n" +
                "\n" +
                "Bu araştırma katılımcıya herhangi bir risk teşkil etmemektedir.\n" +
                "\n" +
                "Katılımcı Kriterleri ;\n" +
                "\n" +
                "18 yaşından büyük olmak.\n" +
                "\n" +
                "Ana dili Türkçe olmak.\n" +
                "\n" +
                "Herhangi bir Nörolojik ya da psikiyatrik tanı öyküsüne sahip olmamak.\n" +
                "\n" +
                "Tıbbi sedatif veya uyarıcı ilaç etkisi altında bulunmamak.\n" +
                "\n" +
                "\n" +
                "Proje Yürütücüsü Adı Soyadı: Yunus Emre Uysal\n" +
                "\n" +
                "E-mail: yunusemreyeu2003@gmail.com");

        contentFlow.getChildren().add(content);

        ScrollPane contentScrollPane = new ScrollPane(contentFlow);

        contentScrollPane.setFitToWidth(true);
        contentScrollPane.setFitToHeight(true);
        VBox.setVgrow(contentScrollPane, Priority.ALWAYS);

        Region spacer2 = new Region();
        spacer2.maxHeightProperty().bind(contentBox.heightProperty().multiply(0.05));
        VBox.setVgrow(spacer2, Priority.ALWAYS);

        CheckBox agreeCheckBox = new CheckBox("I agree");

        nextButton.setDisable(true);
        agreeCheckBox.setSelected(false);

        agreeCheckBox.setOnAction(event -> {
            if(agreeCheckBox.isSelected()) {
                nextButton.setDisable(false);
            } else {
                nextButton.setDisable(true);
            }
        });

        contentBox.getChildren().setAll(title, spacer1, contentScrollPane, spacer2, agreeCheckBox);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setFillWidth(true);
        centerStack.getChildren().add(contentBox);

    }
}