package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class LevelFourScreen extends LevelScreen{
    public LevelFourScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 4");
    }

    @Override
    void loadObjects() {
    }
}
