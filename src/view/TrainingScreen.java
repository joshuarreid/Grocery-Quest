package view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class TrainingScreen extends LevelScreen {
    public TrainingScreen(int width, int height, Player hero,
                          LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters, ArrayList<Collectable> items) {
        super(width, height, hero, lr, exits, "Training Screen", monsters, items);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("training room\n     ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Training Label", false, 0, 2, 13, 5);

        //Textbox
        ImageView rightTextBox = new ImageView(new Image("file:resources/pngs/EmptyTextBox.png"));
        rightTextBox.setFitWidth(198);
        rightTextBox.setFitHeight(165);
        Label rightLabel = new Label("move     attack");
        rightLabel.setFont(DOGICA_FONT);
        rightLabel.setAlignment(Pos.CENTER);
        rightLabel.setPrefWidth(190);
        rightLabel.setPrefHeight(160);
        ImageView zkey = new ImageView(new Image("file:resources/pngs/ZKey.png"));
        zkey.setFitWidth(37);
        zkey.setFitHeight(37);
        ImageView arrowkeys = new ImageView(new Image("file:resources/pngs/ArrowKeys.png"));
        arrowkeys.setFitWidth(56);
        arrowkeys.setFitHeight(35);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(arrowkeys, zkey);
        hbox.setPadding(new Insets(130, 50, 50, 50));
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(50);
        StackPane rightStackPane = new StackPane();
        rightStackPane.getChildren().addAll(rightTextBox, rightLabel, hbox);

        super.board.addObject(rightStackPane, "text box", true, 7, 5, 9, 6);
    }
}
