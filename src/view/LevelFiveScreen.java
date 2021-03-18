package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelFiveScreen extends LevelScreen{
    public LevelFiveScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 5");
    }

    @Override
    void loadObjects() {
    }
}
