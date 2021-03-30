package view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.Exit;
import model.LevelRandomizer;
import model.Monster;
import model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class WeaponsScreen extends LevelScreen {
    public WeaponsScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters) {
        super(width, height, hero, lr, exits, "Weapons Screen", monsters);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("weapons room\n     ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Weapons Label", false, 0, 2, 13, 5);

        //weapons
        ImageView crossBow = new ImageView(new Image("file:resources/pngs/WipeCrossbow.png"));
        crossBow.setFitWidth(30);
        crossBow.setFitHeight(30);
        super.board.addObject(crossBow, "crossBow", true, 6, 1, 11, 1);

        ImageView spray = new ImageView(new Image("file:resources/pngs/DisenfectantSpray.png"));
        spray.setFitWidth(30);
        spray.setFitHeight(30);
        super.board.addObject(spray, "spray", true, 9, 1, 11, 1);

        ImageView sword = new ImageView(new Image("file:resources/pngs/ThermometerSword.png"));
        sword.setFitWidth(30);
        sword.setFitHeight(30);
        super.board.addObject(sword, "crossBow", true, 12, 1, 11, 1);

        //Textbox
        ImageView rightTextBox = new ImageView(new Image("file:resources/pngs/EmptyTextBox.png"));
        rightTextBox.setFitWidth(198);
        rightTextBox.setFitHeight(165);
        Label rightLabel = new Label("swap weapon");
        rightLabel.setFont(DOGICA_FONT);
        rightLabel.setAlignment(Pos.CENTER);
        rightLabel.setPrefWidth(190);
        rightLabel.setPrefHeight(160);
        ImageView xkey = new ImageView(new Image("file:resources/pngs/XKey.png"));
        xkey.setFitWidth(37);
        xkey.setFitHeight(37);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(xkey);
        hbox.setPadding(new Insets(130,50,50,50));
        hbox.setAlignment(Pos.CENTER);
        StackPane rightStackPane = new StackPane();
        rightStackPane.getChildren().addAll(rightTextBox, rightLabel, hbox);

        super.board.addObject(rightStackPane, "text box", true, 7, 5, 3, 6);
    }
}
