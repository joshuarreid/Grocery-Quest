package view;

import javafx.geometry.Insets;
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


public class LoseScreen {
    private int width;
    private int height;
    private Button replayButton;
    private Button exitButton;

    private static final String IDLE_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #a0d3b2";
    private static final String HOVERED_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #91bfa1";


    private LoseScreen() { }
    public LoseScreen(int width, int height) {
        this.width = width;
        this.height = height;
        replayButton = new Button();
        exitButton = new Button();
    }
    public Scene getScene() {
        BorderPane pane = new BorderPane();
        VBox top = new VBox();
        HBox middle = new HBox();
        HBox bottom = new HBox();
        top.setAlignment(Pos.CENTER);
        middle.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #C54741");

        ImageView title = new ImageView(
                new Image("file:resources/pngs/YouLose-02.png"));
        title.setFitWidth(250);
        title.setPreserveRatio(true);

        ImageView replay = new ImageView(
                new Image("file:resources/pngs/PlayButton.png"));
        replay.setFitWidth(190);
        replay.setPreserveRatio(true);

        ImageView exit = new ImageView(
                new Image("file:resources/pngs/QuitButton.png"));
        exit.setFitWidth(190);
        exit.setPreserveRatio(true);

        replayButton.setGraphic(replay);
        replayButton.setStyle("-fx-background-color: #C54741; -fx-background-radius: 30px");
        replayButton.setMinSize(190, 148);
        replayButton.setMaxSize(190, 148);
        replayButton.setOnMouseEntered(e -> replayButton.setStyle(HOVERED_BUTTON_STYLE));
        replayButton.setOnMouseExited(e -> replayButton.setStyle(IDLE_BUTTON_STYLE));
        replayButton.setId("replayButton");

        exitButton.setGraphic(exit);
        exitButton.setStyle("-fx-background-color: #C54741; -fx-background-radius: 30px");
        exitButton.setMinSize(190, 148);
        exitButton.setMaxSize(190, 148);
        exitButton.setOnMouseEntered(e -> replayButton.setStyle(HOVERED_BUTTON_STYLE));
        exitButton.setOnMouseExited(e -> replayButton.setStyle(IDLE_BUTTON_STYLE));
        exitButton.setId("exitButton");

        Label replayText = new Label("play again");
        replayText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        Label exitText = new Label("exit game");
        exitText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        //scene
        pane.setTop(top);
        top.getChildren().addAll(title);
        top.setSpacing(20);
        Insets insets = new Insets(50);
        BorderPane.setMargin(top, insets);

        pane.setCenter(middle);
        middle.getChildren().addAll(replayButton, exitButton);
        middle.setSpacing(30);

        pane.setBottom(bottom);
        bottom.getChildren().addAll(replayText, exitText);
        bottom.setSpacing(60);
        BorderPane.setMargin(bottom, insets);

        Scene loseScene = new Scene(pane, width, height);

        return loseScene;
    }

    public Button getReplayButton() {
        return replayButton;
    }
    public Button getExitButton() { return exitButton; }

}
