package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelTwoScreen extends LevelScreen{
    public LevelTwoScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 2");
    }

    @Override
    void loadObjects() {
    }
}
