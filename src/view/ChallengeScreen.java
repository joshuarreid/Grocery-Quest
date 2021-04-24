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
    private Button acceptButton;
    private Button declineButton;
    /**
     * "question" == current scene is question scene.
     * "room" == current scene is room.
     */
    private String state;


    private static final String IDLE_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #F68C35";
    private static final String HOVERED_BUTTON_STYLE =
            "-fx-background-radius: 20; -fx-background-color: #BF6C2E";

    public ChallengeScreen(Player hero,
                           LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters,
                           ArrayList<Collectable> items) {
        super(hero, lr, exits, "Challenge 1", monsters, items);
        acceptButton = new Button();
        declineButton = new Button();
        this.state = "question";
    }

    private int roomLoading = 0;

    @Override
    public Scene getScene(boolean initialEntrance) {

        if(initialEntrance) {
            return getChallenge();
        } else {
            if(roomLoading == 0){
                roomLoading++;
                return super.getScene(true);
            } else {
                return super.getScene(false);
            }
        }
    }

    public Scene getChallenge() {
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

        acceptButton.setGraphic(replay);
        acceptButton.setStyle("-fx-background-color: #F68C35; -fx-background-radius: 30px");
        acceptButton.setMinSize(190, 148);
        acceptButton.setMaxSize(190, 148);
        acceptButton.setOnMouseEntered(e -> acceptButton.setStyle(HOVERED_BUTTON_STYLE));
        acceptButton.setOnMouseExited(e -> acceptButton.setStyle(IDLE_BUTTON_STYLE));
        acceptButton.setId("replayButton");

        declineButton.setGraphic(exit);
        declineButton.setStyle("-fx-background-color: #F68C35; -fx-background-radius: 30px");
        declineButton.setMinSize(190, 148);
        declineButton.setMaxSize(190, 148);
        declineButton.setOnMouseEntered(e -> declineButton.setStyle(HOVERED_BUTTON_STYLE));
        declineButton.setOnMouseExited(e -> declineButton.setStyle(IDLE_BUTTON_STYLE));
        declineButton.setId("exitButton");

        Label playText = new Label("accept");
        playText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));
        

        Label exitText = new Label("decline");
        exitText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        //scene
        pane.setTop(top);
        top.getChildren().addAll(title);
        top.setSpacing(40);
        Insets insets = new Insets(100,0,100, 0);
        BorderPane.setMargin(top, insets);

        pane.setCenter(middle);
        middle.getChildren().addAll(acceptButton, declineButton);
        middle.setSpacing(30);

        pane.setBottom(bottom);
        bottom.getChildren().addAll(playText, exitText);
        bottom.setSpacing(60);
        BorderPane.setMargin(bottom, insets);

        Scene challengeScene = new Scene(pane, 660, 610);

        return challengeScene;
    }

    @Override
    void loadObjects() {
        ImageView cart = new ImageView(new Image("file:resources/pngs/ShoppingCart.png"));
        cart.setFitWidth(30);
        cart.setFitHeight(30);
        super.board.addObject(cart, "cart", true, 10, 1, 10, 1);
    }

    public Button getAcceptButton() {
        return acceptButton;
    }

    public Button getDeclineButton() {
        return declineButton;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Exit getExit() {
       return super.exits[0];
    }
}

