package view;

import javafx.scene.layout.StackPane;
import model.LevelRandomizer;
import model.Monster;
import model.Player;
import model.Exit;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class GameScreen extends LevelScreen {

    /**
     * GameScreen Constructor
     *
     * @param width width
     * @param height height
     * @param hero player hero
     * @param lr lr
     * @param exits exits
     * @param monsters monsters list
     */
    public GameScreen(int width, int height, Player hero,
                      LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters) {
        super(width, height, hero, lr, exits, "Game Screen", monsters);
    }

    /*
     * Loads in all other objects such as carts, text boxes,
     * and flowers.
     */
    @Override
    void loadObjects() {
        String weaponString = super.hero.getWeaponInUse();
        ImageView playerWeaponImgView = new ImageView(new Image("file:resources/pngs/" + weaponString + ".png"));
        playerWeaponImgView.setFitWidth(30);
        playerWeaponImgView.setFitHeight(30);
        if (super.hero.getInventoryList().size() == 0) {
            super.hero.pickUpItem(weaponString);
            super.inventory.addObject(playerWeaponImgView, weaponString, 0, 0);
        }

        //TODO: Delete two blocks of code below after hardcoding items in levelSetup
        ImageView tempCart2 = new ImageView(new Image("file:resources/pngs/ShoppingCart.png"));
        tempCart2.setFitWidth(30);
        tempCart2.setFitHeight(30);
        super.board.addObject(tempCart2, "itemPotion_1", false, 10, 1, 10, 1);

        ImageView tempCart3 = new ImageView(new Image("file:resources/pngs/ShoppingCart.png"));
        tempCart3.setFitWidth(30);
        tempCart3.setFitHeight(30);
        super.board.addObject(tempCart3, "itemPotion_2", false, 11, 1, 11, 1);

        //Carts
        for (int i = 13; i < 16; i++) {
            for (int j = 1; j < 18; j++) {
                //Doesn't place cart in that one spot
                if ((i == 15  && j == 6) || (i == 15 && j == 12)) {
                    continue;
                }
                ImageView cart = new ImageView(new Image("file:resources/pngs/ShoppingCart.png"));
                cart.setFitWidth(30);
                cart.setFitHeight(30);
                if (j <= 6 || j >= 12) {
                    super.board.addObject(cart, "cart", true, i, 1, j, 1);
                }
            }
        }

        //Flowers
        for (int i = 17, j = 2; j < 16; j++) { // row 18 + col
            if (j > 5 && j < 12) {
                continue;
            }
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

        Label spaceBarInstr = new Label("press space to move between rooms");
        spaceBarInstr.setFont(DOGICA_FONT);
        spaceBarInstr.setAlignment(Pos.CENTER);
        super.board.addObject(spaceBarInstr, "spaceBarInstr", false, 9, 1, 3, 16);
    }
}
