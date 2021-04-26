package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartScreen {
    private int width;
    private int height;
    private Button startButton;
    private Button mute;

    private static final String IDLE_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #a0d3b2";
    private static final String HOVERED_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #91bfa1";


    private StartScreen() { }
    public StartScreen(int width, int height) {
        this.width = width;
        this.height = height;
        startButton = new Button();
        mute = new Button();
    }
    public Scene getScene() {
        BorderPane pane = new BorderPane();
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #a0d3b2");

        ImageView title = new ImageView(
                new Image("file:resources/pngs/Grocery Quest Screens-04.png"));
        title.setFitWidth(450);
        title.setPreserveRatio(true);

        ImageView start = new ImageView(
                new Image("file:resources/pngs/Grocery Quest Screens-03.png"));
        start.setFitWidth(190);
        start.setPreserveRatio(true);

        startButton.setGraphic(start);
        startButton.setStyle("-fx-background-color: #a0d3b2; -fx-background-radius: 30px");
        startButton.setMinSize(190, 148);
        startButton.setMaxSize(190, 148);
        startButton.setOnMouseEntered(e -> startButton.setStyle(HOVERED_BUTTON_STYLE));
        startButton.setOnMouseExited(e -> startButton.setStyle(IDLE_BUTTON_STYLE));
        startButton.setId("startButton");

        Label inst = new Label("click to start");
        inst.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 30));

        ImageView muteImage = new ImageView(
                new Image("file:resources/pngs/Music.png"));
        muteImage.setFitWidth(40);
        muteImage.setPreserveRatio(true);
//        muteImage.setFitHeight(40);


        mute.setGraphic(muteImage);
        mute.setStyle("-fx-background-color: #a0d3b2; -fx-background-radius: 5px;");
        mute.setMinSize(50, 50);
        mute.setMaxSize(50, 50);
        mute.setOnMouseEntered(e -> mute.setStyle("-fx-background-color: #91bfa1; -fx-background-radius: 5px;"));
        mute.setOnMouseExited(e -> mute.setStyle("-fx-background-color: #a0d3b2; -fx-background-radius: 5px;"));
        mute.setId("muteButton");

        VBox muteBox = new VBox();
        muteBox.getChildren().addAll(mute);
        muteBox.setAlignment(Pos.TOP_RIGHT);
        muteBox.setPadding(new Insets(10));
        muteBox.setMaxWidth(40);

        //scene
        pane.setCenter(center);
        center.getChildren().addAll(title, startButton, inst);
        center.setSpacing(20);

        pane.setRight(muteBox);
        VBox imaginaryLeft = new VBox();
        imaginaryLeft.setMinWidth(60);
        pane.setLeft(imaginaryLeft);

        Scene welcomeScene = new Scene(pane, width, height);

        return welcomeScene;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getMute() {
        return mute;
    }
}
