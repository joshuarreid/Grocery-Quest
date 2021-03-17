package view;

import controller.LevelRandomizer;
import controller.Player;

public class LevelOneScreen extends LevelScreen{
    public LevelOneScreen(int width, int height, Player hero, int levelDeterminant, LevelRandomizer lr){
        super(width, height, hero, levelDeterminant, lr);
    }

    @Override
    void loadObjects() {
    }
}
