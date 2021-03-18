package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelOneScreen extends LevelScreen{
    public LevelOneScreen(int width, int height, Player hero, int levelDeterminant, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, levelDeterminant, lr, exits, "Level 1");
    }

    @Override
    void loadObjects() {
    }
}
