package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartScreen {
    private int width;
    private int height;
    private Button startButton;


    private StartScreen() {}
    public StartScreen(int width, int height) {
        this.width = width;
        this.height = height;
        startButton = new Button();
    }
    public Scene getScene() {
        BorderPane pane = new BorderPane();
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #a0d3b2");

        ImageView title = new ImageView(new Image("file:resources/pngs/Grocery Quest Screens-04.png"));
        title.setFitWidth(450);
        title.setPreserveRatio(true);

        ImageView start = new ImageView(new Image("file:resources/pngs/Grocery Quest Screens-03.png"));
        start.setFitWidth(190);
        start.setPreserveRatio(true);

        startButton.setGraphic(start);
        startButton.setStyle("-fx-background-color: #a0d3b2; -fx-background-radius: 30px");
        startButton.setMinSize(190, 148);
        startButton.setMaxSize(190, 148);

        Label inst = new Label("click to start");
        inst.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 30));

        //scene
        pane.setCenter(center);
        center.getChildren().addAll(title, startButton, inst );
        center.setSpacing(20);
        Scene welcomeScene = new Scene(pane, width,height);

        return welcomeScene;
    }

    public Button getStartButton() {
        return startButton;
    }

}
