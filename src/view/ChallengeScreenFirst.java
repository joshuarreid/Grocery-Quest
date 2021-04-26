package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

import java.util.ArrayList;

public class ChallengeScreenFirst extends ChallengeScreen{
    public ChallengeScreenFirst(Player hero, LevelRandomizer lr, Exit[] exits,
                              ArrayList<Monster> monsters, ArrayList<Collectable> items) {
        super(hero, lr, exits,"Challenge 1", monsters, items);
    }

    @Override
    void loadObjects() {
        //claudia add tings
        for(int i = 6; i < 16; i+=2) {
            ImageView aisle = new ImageView(new Image("file:resources/pngs/Aisle2.png"));
            aisle.setFitWidth(60);
            aisle.setFitHeight(30);
            super.board.addObject(aisle, "AisleTop"+i, true, 0, 1, i, 2);
        }

        for(int i = 0; i < 16; i+=2) {
            ImageView aisle = new ImageView(new Image("file:resources/pngs/Aisle2.png"));
            aisle.setFitWidth(60);
            aisle.setFitHeight(30);
            super.board.addObject(aisle, "AisleBottom"+i, true, 18, 1, i, 2);
        }

        for(int i = 0; i < 19; i += 18){
            ImageView aisle = new ImageView(new Image("file:resources/pngs/Aisle3.png"));
            aisle.setFitWidth(90);
            aisle.setFitHeight(30);
            super.board.addObject(aisle, "AisleBottom3"+i, true, i, 1, 16, 3);
        }

        for(int i = 2; i < 18; i+=4) {
            ImageView aisle = new ImageView(new Image("file:resources/pngs/Aisle4.png"));
            aisle.setFitWidth(30);
            aisle.setFitHeight(120);
            super.board.addObject(aisle, "Aisle4" + i, true, i, 4, 0, 1);
        }

        ImageView aisle5 = new ImageView(new Image("file:resources/pngs/Aisle5.png"));
        aisle5.setFitWidth(30);
        aisle5.setFitHeight(150);
        super.board.addObject(aisle5, "Aisle5.1", true, 1, 5, 18, 1);

        ImageView aisle52 = new ImageView(new Image("file:resources/pngs/Aisle5.png"));
        aisle52.setFitWidth(30);
        aisle52.setFitHeight(150);
        super.board.addObject(aisle52, "Aisle5.2", true, 13, 5, 18, 1);
    }
}
