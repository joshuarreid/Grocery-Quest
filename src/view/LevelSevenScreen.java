package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelSevenScreen extends LevelScreen{
    public LevelSevenScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 7");
    }

    @Override
    void loadObjects() {
    }
}
