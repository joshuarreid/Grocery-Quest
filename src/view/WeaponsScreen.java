package view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import model.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class WeaponsScreen extends LevelScreen {
    private static final Font DOGICA_FONT_MY = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 12);
    public WeaponsScreen(int width, int height, Player hero,
                         LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters, ArrayList<Collectable> items) {
        super(width, height, hero, lr, exits, "Weapons Screen", monsters, items);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("weapons room\n     ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Weapons Label", false, 0, 2, 13, 5);


        //Textbox
        ImageView rightTextBox = new ImageView(new Image("file:resources/pngs/EmptyTextBox.png"));
        rightTextBox.setFitWidth(198);
        rightTextBox.setFitHeight(165);

        Label instrLabel = new Label("pickup with SPACE \n\n change item with C \n\n use item with X");
        instrLabel.setFont(DOGICA_FONT_MY);
        instrLabel.setAlignment(Pos.CENTER);
        instrLabel.setLineSpacing(30);
        instrLabel.setPrefWidth(190);
        instrLabel.setPrefHeight(160);

        ImageView xkey = new ImageView(new Image("file:resources/pngs/XKey.png"));
        xkey.setFitWidth(37);
        xkey.setFitHeight(37);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(xkey);
        hbox.setPadding(new Insets(130, 50, 50, 50));
        hbox.setAlignment(Pos.CENTER);
        StackPane rightStackPane = new StackPane();
        rightStackPane.getChildren().addAll(rightTextBox, instrLabel);

        super.board.addObject(rightStackPane, "text box", true, 7, 5, 3, 6);
    }
}
