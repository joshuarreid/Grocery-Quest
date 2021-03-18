package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelSixScreen extends LevelScreen{
    public LevelSixScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 6");
    }

    @Override
    void loadObjects() {
    }
}
