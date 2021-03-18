package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelEightScreen extends LevelScreen{
    public LevelEightScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 8");
    }

    @Override
    void loadObjects() {
    }
}
