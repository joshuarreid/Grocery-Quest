package view;

import controller.Board;
import controller.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

public class GameScreen {
    private int width;
    private int height;
    private ImageView coinBar;
    private ImageView healthBar;
    private Player mainPerson;
    private ImageView cart;
    private ImageView flower;
    private ImageView leftTextBox;
    private ImageView rightTextBox;
    private Board board;


    private static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 15);

    /**
     * Initial Game Screen Constructor
     *
     * @param width width of window
     * @param height height of window
     * @param hero player
     */
    public GameScreen(int width, int height, Player hero) {
        this.width = width;
        this.height = height;
        this.mainPerson = hero;
        this.board = new Board(18, 18);
    }

    /**
     * Gets the scene for the stage.
     *
     * @return the scene
     */
    public Scene getScene() {
        board.createBoard();

        //Set up gridPane
        GridPane gridPane = board.getGridPane();
        //gridPane.setBackground(new Background(new BackgroundImage(
        //        new Image("file:resources/pngs/TileGrid.png"), null, null,
        //        null, null)));
        //ImageView borderExitImage = new ImageView(new Image("file:resources/pngs/LevelFrame4Exits-01.png"));
        gridPane.setBackground(new Background(new BackgroundFill((Color.PINK), CornerRadii.EMPTY, Insets.EMPTY)));

        //Load in all entities
        loadCoinHealthBar();
        loadMainCharacter();
        loadObjects(); //Load all objects: Carts, Flowers, Text Boxes

        //Coin Health Box
        VBox coinHealthBox = new VBox(5);
        coinHealthBox.getChildren().addAll(healthBar, coinBar);

        VBox base = new VBox(10);
        base.getChildren().addAll(coinHealthBox, gridPane);
        base.setAlignment(Pos.CENTER);
        Scene gameScene = new Scene(base, width, height);
        return gameScene;
    }

    /**
     * Determines which coin and health bar to load
     * depening on what the user chooses in the initial
     * config screen.
     */
    private void loadCoinHealthBar() {
        healthBar = mainPerson.getHealthBar();
        coinBar = mainPerson.getMoneyBar();

    }

    /**
     * Loads in the player with the correct weapon
     * choice from the initial config screen.
     */
    private void loadMainCharacter() {
        board.addObject(mainPerson.getPlayerImage(),
                "player",
                false,
                15,
                0,
                8,
                0);
    }

    /**
     * Loads in all other objects such as carts, text boxes,
     * and flowers.
     */
    private void loadObjects() {
        //Carts
        for (int i = 12; i < 15; i++) {
            for (int j = 1; j < 17; j++) {
                if ((i == 14  && j == 6) || (i == 14 && j == 11)) { //Doesn't place cart in that one spot
                    continue;
                }
                //Replace with actual image of cart
                cart = new ImageView(new Image("file:resources/pngs/ShoppingCart.png"));
                cart.setFitWidth(30);
                cart.setFitHeight(30);
                if (j <= 6 || j >= 11) {
                    board.addObject(cart, "cart", true, i, 0, j, 0);
                }
            }
        }

        //Flowers
        for (int i = 17, j = 2; j < 16; j++) {
            if (j > 5 && j < 12) {
                continue;
            }
            //Replace with actual image of flowers
            flower = new ImageView(new Image("file:resources/pngs/Flower.png"));
            flower.setFitWidth(30);
            flower.setFitHeight(45);
            board.addObject(flower, "flower", true, i, 0, j, 0);
        }

        //Textboxes using a StackPane
        leftTextBox = new ImageView(new Image("file:resources/pngs/EmptyTextBox.png"));
        leftTextBox.setFitWidth(198);
        leftTextBox.setFitHeight(165);
        Label leftLabel = new Label("go to weaponry \n\n\nto swap \n\n\nweapons");
        leftLabel.setFont(DOGICA_FONT);
        leftLabel.setAlignment(Pos.CENTER);
        leftLabel.setPrefWidth(190);
        leftLabel.setPrefHeight(160);
        StackPane leftStackPane = new StackPane();
        leftStackPane.getChildren().addAll(leftTextBox, leftLabel);

        rightTextBox = new ImageView(new Image("file:resources/pngs/EmptyTextBox.png"));
        rightTextBox.setFitWidth(198);
        rightTextBox.setFitHeight(165);
        Label rightLabel = new Label("go to training \n\n\nto learn \n\n\ncontrols");
        rightLabel.setFont(DOGICA_FONT);
        rightLabel.setAlignment(Pos.CENTER);
        rightLabel.setPrefWidth(190);
        rightLabel.setPrefHeight(160);
        StackPane rightStackPane = new StackPane();
        rightStackPane.getChildren().addAll(rightTextBox, rightLabel);

        board.addObject(leftStackPane, "text box", true, 1, 5, 1, 6);
        board.addObject(rightStackPane, "text box", true, 1, 5, 11, 6);
    }
}
