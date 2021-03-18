package view;

import controller.Board;
import controller.LevelRandomizer;
import controller.Player;
import controller.Exit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import org.assertj.core.internal.bytebuddy.asm.Advice;

public class GameScreen extends LevelScreen{
//    private int width;
//    private int height;
//    private ImageView coinBar;
//    private ImageView healthBar;
//    private Player hero;
//    private ImageView cart;
//    private ImageView flower;
//    private ImageView leftTextBox;
//    private ImageView rightTextBox;
//    private Board board;
//    private int levelDeterminant;
//    private Exit[] exits;

    private static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 15);

    /**
     * Initial Game Screen Constructor
     *
     * @param width width of window
     * @param height height of window
     * @param hero player
     */
    public GameScreen(int width, int height, Player hero, int levelDeterminant, LevelRandomizer lr, Exit[] exits) {
        super(width, height, hero, levelDeterminant, lr, exits, "Game Screen");
//        this.width = width;
//        this.height = height;
//        this.hero = hero;
//        this.board = new Board(19, 19, exits, "Game Screen");
//        this.levelDeterminant = levelDeterminant;
//        this.exits = exits;

    }

//    /**
//     * Getter for board
//     * @return board
//     */
//    public Board getBoard() {
//        return this.board;
//    }
//    /**
//     * Gets the scene for the stage.
//     *
//     * @return the scene
//     */
//    public Scene getScene() {
//        board.createBoard(height, width);
//
//        //Set up gridPane
//        GridPane gridPane = board.getGridPane();
//        ImageView borderExitImage = new ImageView(
//                new Image("file:resources/pngs/LevelFrame4Exits-01.png"));
//        borderExitImage.setFitWidth(width);
//        borderExitImage.setFitHeight(height);
////        gridPane.setBackground(
////                new Background(new BackgroundFill((Color.PINK), CornerRadii.EMPTY, Insets.EMPTY)));
//        gridPane.setStyle("-fx-background-color: pink");
//
//        //Load in all entities
//        loadCoinHealthBar();
//        loadMainCharacter();
//        loadObjects(); //Load all objects: Carts, Flowers, Text Boxes
//        StackPane pane = new StackPane(gridPane, borderExitImage);
//        Scene gameScene = new Scene(pane, width, height);
//        return gameScene;
//    }
//
//    /**
//     * loads hero's health and money
//     */
//    private void loadCoinHealthBar() {
//        healthBar = hero.getHealthBar();
//        board.addObject(healthBar, "health", true, 0, 1, 1, 5);
//        coinBar = hero.getMoneyBar();
//        board.addObject(coinBar, "money", true, 1, 1, 1, 5);
//    }
//
//    /**
//     * Adds hero to the board
//     */
//    private void loadMainCharacter() {
//        board.addObject(hero.getPlayerImage(),
//                "player", false,
//                hero.getPlayerMovement().getYPosition(), 0,
//                hero.getPlayerMovement().getXPosition(), 0);
//    }

    /**
     * Loads in all other objects such as carts, text boxes,
     * and flowers.
     */
    void loadObjects() {
        //Carts
        for (int i = 12; i < 15; i++) { // row
            for (int j = 1; j < 18; j++) { // col
                //Doesn't place cart in that one spot
                if ((i == 14  && j == 6) || (i == 14 && j == 12)) {
                    continue;
                }
                //Replace with actual image of cart
                ImageView cart = new ImageView(new Image("file:resources/pngs/ShoppingCart.png"));
                cart.setFitWidth(30);
                cart.setFitHeight(30);
                if (j <= 6 || j >= 12) {
                    super.board.addObject(cart, "cart", true, i, 0, j, 0);
                }
            }
        }

        //Flowers
        for (int i = 17, j = 2; j < 16; j++) { // row 18 + col
            if (j > 5 && j < 12) {
                continue;
            }
            //Replace with actual image of flowers
            ImageView flower = new ImageView(new Image("file:resources/pngs/Flower.png"));
            flower.setFitWidth(30);
            flower.setFitHeight(45);
            super.board.addObject(flower, "flower", true, i, 2, j, 1);
        }

        //Textboxes using a StackPane
        ImageView leftTextBox = new ImageView(new Image("file:resources/pngs/EmptyTextBox.png"));
        leftTextBox.setFitWidth(198);
        leftTextBox.setFitHeight(165);
        Label leftLabel = new Label("go to weaponry \n\n\nto swap \n\n\nweapons");
        leftLabel.setFont(DOGICA_FONT);
        leftLabel.setAlignment(Pos.CENTER);
        leftLabel.setPrefWidth(190);
        leftLabel.setPrefHeight(160);
        StackPane leftStackPane = new StackPane();
        leftStackPane.getChildren().addAll(leftTextBox, leftLabel);

        ImageView rightTextBox = new ImageView(new Image("file:resources/pngs/EmptyTextBox.png"));
        rightTextBox.setFitWidth(198);
        rightTextBox.setFitHeight(165);
        Label rightLabel = new Label("go to training \n\n\nto learn \n\n\ncontrols");
        rightLabel.setFont(DOGICA_FONT);
        rightLabel.setAlignment(Pos.CENTER);
        rightLabel.setPrefWidth(190);
        rightLabel.setPrefHeight(160);
        StackPane rightStackPane = new StackPane();
        rightStackPane.getChildren().addAll(rightTextBox, rightLabel);

        super.board.addObject(leftStackPane, "text box", true, 2, 5, 1, 6);
        super.board.addObject(rightStackPane, "text box", true, 2, 5, 11, 6);
    }
}
