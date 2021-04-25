package view;

import model.*;

import java.util.ArrayList;

public class ChallengeScreenSecond extends ChallengeScreen{
    public ChallengeScreenSecond(Player hero, LevelRandomizer lr, Exit[] exits,
                                 ArrayList<Monster> monsters, ArrayList<Collectable> items) {
        super(hero, lr, exits,"Challenge 2", monsters, items);
    }

    @Override
    void loadObjects() {
        //claudia add tings
    }
}
