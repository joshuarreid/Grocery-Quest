package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class WeaponsScreen extends LevelScreen{
    public WeaponsScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Weapons Screen");
    }

    @Override
    void loadObjects() {
    }
}
