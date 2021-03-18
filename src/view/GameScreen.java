package view;

import model.LevelRandomizer;
import model.Player;
import model.Exit;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Label;

public class GameScreen extends LevelScreen {

    /**
     * Initial Game Screen Constructor
     *
     * @param width width of window
     * @param height height of window
     * @param hero player
     * @param lr level randomizer
     * @param exits array of exits in screen
     */
    public GameScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits) {
        super(width, height, hero, lr, exits, "Game Screen");
    }

    /**
     * Loads in all other objects such as carts, text boxes,
     * and flowers.
     */
    @Override
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

        super.board.addObject(leftStackPane, "text box", true, 3, 5, 1, 6);
        super.board.addObject(rightStackPane, "text box", true, 3, 5, 12, 6);

        Label startLabel = new Label("  start");
        startLabel.setFont(DOGICA_FONT);
        startLabel.setAlignment(Pos.CENTER);
        super.board.addObject(startLabel, "start", false, 0, 1, 8, 3);

        Label exitLabel = new Label("   exit");
        exitLabel.setFont(DOGICA_FONT);
        exitLabel.setAlignment(Pos.CENTER);
        super.board.addObject(exitLabel, "exit", false, 18, 1, 8, 3);
    }
}
