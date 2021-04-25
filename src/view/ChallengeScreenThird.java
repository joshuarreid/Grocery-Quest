package view;

import model.*;

import java.util.ArrayList;

public class ChallengeScreenThird extends ChallengeScreen{
    public ChallengeScreenThird(Player hero, LevelRandomizer lr, Exit[] exits,
                                ArrayList<Monster> monsters, ArrayList<Collectable> items) {
        super(hero, lr, exits,"Challenge 3", monsters, items);
    }

    @Override
    void loadObjects() {
        //claudia add tings
    }
}
