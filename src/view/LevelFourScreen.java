package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class LevelFourScreen extends LevelScreen {
    public LevelFourScreen(Player hero,
                           LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters,
                           ArrayList<Collectable> items) {
        super(hero, lr, exits, "Level 4", monsters, items);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("Level 4\n      ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Level 4 Label", false, 0, 2, 15, 3);

        //AISLE2
        ImageView aisle2 = new ImageView(new Image("file:resources/pngs/Aisle2.png"));
        aisle2.setFitWidth(60);
        aisle2.setFitHeight(30);
        super.board.addObject(aisle2, "Aisle2", true, 7, 1, 10, 2);

        ImageView aisle21 = new ImageView(new Image("file:resources/pngs/Aisle2.png"));
        aisle21.setFitWidth(60);
        aisle21.setFitHeight(30);
        super.board.addObject(aisle21, "Aisle2.1", true, 14, 1, 10, 2);

        ImageView aisle22 = new ImageView(new Image("file:resources/pngs/Aisle2.png"));
        aisle22.setFitWidth(60);
        aisle22.setFitHeight(30);
        super.board.addObject(aisle22, "Aisle2.1", true, 16, 1, 2, 2);

        //AISLE3
        ImageView aisle3 = new ImageView(new Image("file:resources/pngs/Aisle3.png"));
        aisle3.setFitWidth(90);
        aisle3.setFitHeight(30);
        super.board.addObject(aisle3, "Aisle3", true, 8, 1, 12, 3);

        ImageView aisle31 = new ImageView(new Image("file:resources/pngs/Aisle3.png"));
        aisle31.setFitWidth(90);
        aisle31.setFitHeight(30);
        super.board.addObject(aisle31, "Aisle3.1", true, 12, 1, 9, 3);

        ImageView aisle32 = new ImageView(new Image("file:resources/pngs/Aisle3.png"));
        aisle32.setFitWidth(90);
        aisle32.setFitHeight(30);
        super.board.addObject(aisle32, "Aisle3.2", true, 5, 1, 7, 3);

        // AISLE4
        ImageView aisle4 = new ImageView(new Image("file:resources/pngs/Aisle4.png"));
        aisle4.setFitWidth(30);
        aisle4.setFitHeight(120);
        super.board.addObject(aisle4, "Aisle4", true, 10, 4, 16, 1);

        ImageView aisle41 = new ImageView(new Image("file:resources/pngs/Aisle4.png"));
        aisle41.setFitWidth(30);
        aisle41.setFitHeight(120);
        super.board.addObject(aisle41, "Aisle4.1", true, 2, 4, 6, 1);

        //AISLE5
        ImageView aisle5 = new ImageView(new Image("file:resources/pngs/Aisle5.png"));
        aisle5.setFitWidth(30);
        aisle5.setFitHeight(150);
        super.board.addObject(aisle5, "Aisle5", true, 7, 5, 7, 1);

        ImageView aisle51 = new ImageView(new Image("file:resources/pngs/Aisle5.png"));
        aisle51.setFitWidth(30);
        aisle51.setFitHeight(150);
        super.board.addObject(aisle51, "Aisle5.1", true, 5, 5, 1, 1);
    }
}
