package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
    private ImageView door1;
    private ImageView tileset;
    private Button exitButton;


    private static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 20);

    public GameScreen(int width, int height, int difficultyLevel, String weaponChoice) {
        this.width = width;
        this.height = height;
        this.difficultyLevel = difficultyLevel;
        this.weaponChoice = weaponChoice;
    }

    public Scene getScene() {
        Pane pane = new Pane();

        tileset = new ImageView(new Image("file:resources/pngs/blank_tileset.png"));
        tileset.setFitHeight(height);
        tileset.setFitWidth(width);

        door1 = new ImageView(new Image("file:resources/pngs/tileset_door_main.png"));

        exitButton = new Button("Exit Game");

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

        VBox coinHealthBox = new VBox(5);
        coinHealthBox.getChildren().addAll(healthBar, coinBar);

        //Basically CSS
        coinBar.setFitWidth(225);
        coinBar.setFitHeight(37.5);
        healthBar.setFitWidth(225);
        healthBar.setFitHeight(37.5);

        mainPerson.setFitWidth(75);
        mainPerson.setFitHeight(75);
        mainPerson.setLayoutX(150);
        mainPerson.setLayoutY(150);

        door1.setFitWidth(50);
        door1.setFitHeight(100);
        door1.setLayoutX(550);
        door1.setLayoutY(250);

        pane.getChildren().addAll(tileset, coinHealthBox, mainPerson, door1);
        VBox base = new VBox(10);
        base.getChildren().add(pane);
        base.setAlignment(Pos.CENTER);
        Scene gameScene = new Scene(base, width, height);
        return gameScene;
    }
}
