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
    }
}
