package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelThreeScreen extends LevelScreen{
    public LevelThreeScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 3");
    }

    @Override
    void loadObjects() {
    }
}
