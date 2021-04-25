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
import model.Statistics;

public class WinScreen {
    private int width;
    private int height;
    private Button replayButton;
    private Button exitButton;
    private Statistics statistics;

    private static final String IDLE_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #83AA51";
    private static final String HOVERED_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #688741";

    public WinScreen(int width, int height, Statistics statistics) {
        this.width = width;
        this.height = height;
        this.statistics = statistics;
        replayButton = new Button();
        exitButton = new Button();
    }
    public Scene getScene() {
        VBox pane = new VBox();
        VBox top = new VBox();
        VBox middle = new VBox();
        VBox left = new VBox();
        VBox right = new VBox();
        HBox bottom = new HBox();
        pane.setAlignment(Pos.CENTER);
        top.setAlignment(Pos.CENTER);
        middle.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #83AA51");

        Label timeText = new Label("time - " + (statistics.getTimeElapsed() / 60) + ":" + (statistics.getTimeElapsed() % 60));
        timeText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));
        Label itemsText = new Label("items collected - " + statistics.getItems());
        itemsText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));
        Label monstersText = new Label("antimaskers masked - " + statistics.getAntimaskers());
        monstersText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        ImageView title = new ImageView(
                new Image("file:resources/pngs/YouWon.png"));
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
        replayButton.setStyle("-fx-background-color: #83AA51; -fx-background-radius: 30px");
        replayButton.setMinSize(190, 148);
        replayButton.setMaxSize(190, 148);
        replayButton.setOnMouseEntered(e -> replayButton.setStyle(HOVERED_BUTTON_STYLE));
        replayButton.setOnMouseExited(e -> replayButton.setStyle(IDLE_BUTTON_STYLE));
        replayButton.setId("replayButton");

        exitButton.setGraphic(exit);
        exitButton.setStyle("-fx-background-color: #83AA51; -fx-background-radius: 30px");
        exitButton.setMinSize(190, 148);
        exitButton.setMaxSize(190, 148);
        exitButton.setOnMouseEntered(e -> exitButton.setStyle(HOVERED_BUTTON_STYLE));
        exitButton.setOnMouseExited(e -> exitButton.setStyle(IDLE_BUTTON_STYLE));
        exitButton.setId("exitButton");

        Label replayText = new Label("play again");
        replayText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        Label exitText = new Label("exit game");
        exitText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        //scene
        top.getChildren().addAll(timeText, itemsText, monstersText);
        top.setSpacing(20);

        middle.getChildren().addAll(title);
//        middle.setSpacing(20);

        left.getChildren().addAll(replayButton, replayText);
        left.setSpacing(10);

        right.getChildren().addAll(exitButton, exitText);
        right.setSpacing(10);

        bottom.getChildren().addAll(left, right);
        bottom.setSpacing(100);

        pane.getChildren().addAll(top,middle,bottom);
        pane.setSpacing(30);

        Scene winScene = new Scene(pane, width, height);

        return winScene;
    }

    public Button getReplayButton() {
        return replayButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

}

