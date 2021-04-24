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
import model.*;

import java.util.ArrayList;

public class ChallengeScreen extends LevelScreen {
    private int width;
    private int height;
    private Button playButton;
    private Button exitButton;

    private static final String IDLE_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #F68C35";
    private static final String HOVERED_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #BF6C2E";

    public ChallengeScreen(Player hero,
                           LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters,
                           ArrayList<Collectable> items) {
        super(hero, lr, exits, "Challenge 1", monsters, items);
        playButton = new Button();
        exitButton = new Button();
    }

    public Scene getScene(boolean condition) {
        System.out.println("I'm in here");
        BorderPane pane = new BorderPane();
        VBox top = new VBox();
        HBox middle = new HBox();
        HBox bottom = new HBox();
        top.setAlignment(Pos.CENTER);
        middle.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #F68C35");

        ImageView title = new ImageView(
                new Image("file:resources/pngs/Challenge.png"));
        title.setFitWidth(500);
        title.setPreserveRatio(true);
        //super.board.addObject(title, "Challenge 1 Title", false, 0, 2, 15, 3);

        ImageView replay = new ImageView(
                new Image("file:resources/pngs/PlayButton.png"));
        replay.setFitWidth(190);
        replay.setPreserveRatio(true);
        //super.board.addObject(replay, "Challenge 1 Replay", false, 0, 2, 15, 3);

        ImageView exit = new ImageView(
                new Image("file:resources/pngs/QuitButton.png"));
        exit.setFitWidth(190);
        exit.setPreserveRatio(true);
        //super.board.addObject(exit, "Challenge 1 Exit", false, 0, 2, 15, 3);

        playButton.setGraphic(replay);
        playButton.setStyle("-fx-background-color: #F68C35; -fx-background-radius: 30px");
        playButton.setMinSize(190, 148);
        playButton.setMaxSize(190, 148);
        playButton.setOnMouseEntered(e -> playButton.setStyle(HOVERED_BUTTON_STYLE));
        playButton.setOnMouseExited(e -> playButton.setStyle(IDLE_BUTTON_STYLE));
        playButton.setId("replayButton");

        exitButton.setGraphic(exit);
        exitButton.setStyle("-fx-background-color: #F68C35; -fx-background-radius: 30px");
        exitButton.setMinSize(190, 148);
        exitButton.setMaxSize(190, 148);
        exitButton.setOnMouseEntered(e -> exitButton.setStyle(HOVERED_BUTTON_STYLE));
        exitButton.setOnMouseExited(e -> exitButton.setStyle(IDLE_BUTTON_STYLE));
        exitButton.setId("exitButton");

        Label playText = new Label("play again");
        playText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));
        

        Label exitText = new Label("exit game");
        exitText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        //scene
        pane.setTop(top);
        top.getChildren().addAll(title);
        top.setSpacing(40);
        Insets insets = new Insets(100,0,100, 0);
        BorderPane.setMargin(top, insets);

        pane.setCenter(middle);
        middle.getChildren().addAll(playButton, exitButton);
        middle.setSpacing(30);

        pane.setBottom(bottom);
        bottom.getChildren().addAll(playText, exitText);
        bottom.setSpacing(60);
        BorderPane.setMargin(bottom, insets);

        Scene challengeScene = new Scene(pane, width, height);

        return challengeScene;


    }

    @Override
    void loadObjects() {
        ImageView cart = new ImageView(new Image("file:resources/pngs/ShoppingCart.png"));
        cart.setFitWidth(30);
        cart.setFitHeight(30);
        super.board.addObject(cart, "cart", true, 10, 1, 10, 1);
    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

}

