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

public abstract class ChallengeScreen extends LevelScreen {
    private int width;
    private int height;
    private Button acceptButton;
    private Button declineButton;
    private Scene challengeScreenScene;
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
                           LevelRandomizer lr, Exit[] exits, String id,ArrayList<Monster> monsters,
                           ArrayList<Collectable> items) {
        super(hero, lr, exits, id, monsters, items);
        acceptButton = new Button();
        declineButton = new Button();
        this.state = "question";
        getChallenge();
    }

    private int roomLoading = 0;

    @Override
    public Scene getScene(boolean initialEntrance) {

        if(initialEntrance) {
            return getChallengeScene();
        } else {
            if(roomLoading == 0){
                roomLoading++;
                return super.getScene(true);
            } else {
                return super.getScene(false);
            }
        }
    }

    private Scene getChallengeScene(){
        return this.challengeScreenScene;
    }

    private void getChallenge() {
        BorderPane pane = new BorderPane();
        VBox top = new VBox();
        VBox left = new VBox();
        VBox right = new VBox();
        HBox middle = new HBox();
//        HBox bottom = new HBox();
        top.setAlignment(Pos.CENTER);
        middle.setAlignment(Pos.CENTER);
        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);
//        bottom.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #F68C35");

        ImageView title = new ImageView(
                new Image("file:resources/pngs/Challenge.png"));
        title.setFitWidth(500);
        title.setPreserveRatio(true);

        ImageView replay = new ImageView(
                new Image("file:resources/pngs/PlayButton.png"));
        replay.setFitWidth(190);
        replay.setPreserveRatio(true);

        ImageView exit = new ImageView(
                new Image("file:resources/pngs/QuitButton.png"));
        exit.setFitWidth(190);
        exit.setPreserveRatio(true);

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

        Label acceptText = new Label("accept");
        acceptText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));
        

        Label declineText = new Label("decline");
        declineText.setFont(Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20));

        //scene
        pane.setTop(top);
        top.getChildren().addAll(title);
        top.setSpacing(40);
        Insets insets = new Insets(100,40,40,40);
        BorderPane.setMargin(top, insets);

        left.getChildren().addAll(acceptButton, acceptText);
        left.setSpacing(10);

        right.getChildren().addAll(declineButton, declineText);
        right.setSpacing(10);

        pane.setCenter(middle);
        middle.getChildren().addAll(left, right);
        middle.setSpacing(100);

        challengeScreenScene = new Scene(pane, 660, 610);

    }

    @Override
    abstract void loadObjects();

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

