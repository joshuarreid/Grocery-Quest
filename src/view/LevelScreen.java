package view;

import model.Board;
import model.Exit;
import model.LevelRandomizer;
import model.Player;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public abstract class LevelScreen {
    private int width;
    private int height;
    private ImageView coinBar;
    private ImageView healthBar;
    private Player hero;
    protected Board board;
    private String background;
    private Exit[] exits;
    private String iD;
    private Scene gameScene;

    protected static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 15);

    /**
     * Initial Game Screen Constructor
     *
     * @param width width of window
     * @param height height of window
     * @param hero player
     * @param lr level randomizer
     * @param exits exits on level
     * @param iD level name
     */
    public LevelScreen(int width, int height, Player hero,
                       LevelRandomizer lr, Exit[] exits, String iD) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.board = new Board(19, 19, exits, iD);
        this.background = lr.getLayout();
        this.exits = exits;
        this.iD = iD;
        board.createBoard(height, width);
        //Set up gridPane
        GridPane gridPane = board.getGridPane();
        ImageView borderExitImage = new ImageView(
                new Image("file:resources/pngs/LevelFrame4Exits-01.png"));
        borderExitImage.setFitWidth(width);
        borderExitImage.setFitHeight(height);
        gridPane.setStyle("-fx-background-color: " + background);

        StackPane pane = new StackPane(gridPane, borderExitImage);
        gameScene = new Scene(pane, width, height);
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
        loadCoinHealthBar();
        loadMainCharacter();
        loadObjects();
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
