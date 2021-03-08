package view;

import controller.Board;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GameScreen {
    private int width;
    private int height;
    private int difficultyLevel;
    private String weaponChoice;
    private ImageView coinBar;
    private ImageView healthBar;
    private ImageView mainPerson;
    private ImageView cart;
    private ImageView flower;
    private Board board;


    private static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 20);

    /**
     * Initial Game Screen Constructor
     *
     * @param width width of window
     * @param height height of window
     * @param difficultyLevel level of difficulty
     */
    public GameScreen(int width, int height, int difficultyLevel) {
        this.width = width;
        this.height = height;
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Gets the scene for the stage.
     *
     * @return the scene
     */
    public Scene getScene() {
        board = new Board(18, 18, false);
        board.createBoard();

        //Set up gridPane
        GridPane gridPane = board.getGridPane();
        gridPane.setBackground(new Background(new BackgroundImage(
                new Image("file:resources/pngs/blank_tileset.png"), null, null,
                null, null)));

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
    public void loadCoinHealthBar() {
        //Sets the coin and health bars
        switch (difficultyLevel) {
        case 1: //Easy: 4(full) hearts + 4 magic coins
            healthBar = new ImageView(new Image("file:resources/pngs/GQHealthMoneyBars-09.png"));
            coinBar = new ImageView((new Image("file:resources/pngs/GQHealthMoneyBars-10.png")));
            break;
        case 2: //Medium: 2 hearts + 2 magic coins
            healthBar = new ImageView(new Image("file:resources/pngs/GQHealthMoneyBars-05.png"));
            coinBar = new ImageView((new Image("file:resources/pngs/GQHealthMoneyBars-06.png")));
            break;
        case 3: //Hard: 1 heart + 1 magic coin
            healthBar = new ImageView(new Image("file:resources/pngs/GQHealthMoneyBars-03.png"));
            coinBar = new ImageView((new Image("file:resources/pngs/GQHealthMoneyBars-04.png")));
            break;
        default:
        }
        //Basically CSS
        coinBar.setFitWidth(225);
        coinBar.setFitHeight(37.5);
        healthBar.setFitWidth(225);
        healthBar.setFitHeight(37.5);

    }

    /**
     * Loads in the player with the correct weapon
     * choice from the initial config screen.
     */
    public void loadMainCharacter() {
        //Sets the main character imageview
        switch (weaponChoice) {
        case "wipe crossbow":
            mainPerson = new ImageView(new Image("file:resources/pngs/CrossbowGrandmaRight.png"));
            break;
        case "disinfectant spray":
            mainPerson = new ImageView(new Image("file:resources/pngs/SprayGrandmaRight.png"));
            break;
        case "thermometer sword":
            mainPerson = new ImageView(new Image("file:resources/pngs/SwordGrandmaRight.png"));
            break;
        default:
            break;
        }
        mainPerson.setFitWidth(60);
        mainPerson.setFitHeight(60);
        board.addObject(mainPerson, "mainPerson", false, 15, 0, 8, 0);
    }

    /**
     * Loads in all other objects such as carts, text boxes,
     * and flowers.
     */
    public void loadObjects() {
        //Carts
        for (int i = 12; i < 15; i++) {
            for (int j = 1; j < 17; j++) {
                if ((i == 14  && j == 6) || (i == 14 && j == 11)) { //Doesn't place cart in that one spot
                    continue;
                }
                //Replace with actual image of cart
                cart = new ImageView(new Image("file:resources/pngs/Tissues.png"));
                cart.setFitWidth(20);
                cart.setFitHeight(20);
                if (j <= 6 || j >= 11) {
                    board.addObject(cart, "cart", false, i, 0, j, 0);
                }
            }
        }

        //Flowers
        for (int i = 17, j = 2; j < 16; j++) {
            if (j > 5 && j < 12) {
                continue;
            }
            //Replace with actual image of flowers
            flower = new ImageView(new Image("file:resources/pngs/Tissues.png"));
            flower.setFitWidth(20);
            flower.setFitHeight(20);
            board.addObject(flower, "flower", false, i, 0, j, 0);
        }

    }
}
