package view;

import controller.Board;
import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class LevelScreen {
    private int width;
    private int height;
    private ImageView coinBar;
    private ImageView healthBar;
    private Player hero;
    private Board board;
    private String background;
    private int levelDeterminant;
    private Exit[] exits;
    private String ID;

    protected static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 15);

    /**
     * Initial Game Screen Constructor
     *
     * @param width width of window
     * @param height height of window
     * @param hero player
     */
    public LevelScreen(int width, int height, Player hero, int levelDeterminant, LevelRandomizer lr, Exit[] exits, String ID) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.board = new Board(19, 19, exits, ID);
        this.background = lr.getLayout();
        this.levelDeterminant = levelDeterminant;
        this.exits = exits;
        this.ID = ID;
    }

    /**
     * Getter for board
     * @return board
     */
    public Board getBoard() {
        return this.board;
    }
    /**
     * Gets the scene for the stage.
     *
     * @return the scene
     */
    public Scene getScene() {
        board.createBoard(height, width);

        //Set up gridPane
        GridPane gridPane = board.getGridPane();
        ImageView borderExitImage = new ImageView(
                new Image("file:resources/pngs/LevelFrame4Exits-01.png"));
        borderExitImage.setFitWidth(width);
        borderExitImage.setFitHeight(height);
        gridPane.setStyle("-fx-background-color: " + background);

        //Load in all entities
        loadCoinHealthBar();
        loadMainCharacter();
        loadObjects(); //Load all objects: Carts, Flowers, Text Boxes
        StackPane pane = new StackPane(gridPane, borderExitImage);
        Scene gameScene = new Scene(pane, width, height);
        return gameScene;
    }

    /**
     * loads hero's health and money
     */
    private void loadCoinHealthBar() {
        healthBar = hero.getHealthBar();
        board.addObject(healthBar, "health", true, 0, 1, 1, 5);
        coinBar = hero.getMoneyBar();
        board.addObject(coinBar, "money", true, 1, 1, 1, 5);
    }

    /**
     * Adds hero to the board
     */
    private void loadMainCharacter() {
        board.addObject(hero.getPlayerImage(),
                "player", false,
                hero.getPlayerMovement().getYPosition(), 0,
                hero.getPlayerMovement().getXPosition(), 0);
    }

    /**
     * Loads in all other objects
     */
    abstract void loadObjects();
}
