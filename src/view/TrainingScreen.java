package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;

public class TrainingScreen extends LevelScreen{
    public TrainingScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Training Screen");
    }

    @Override
    void loadObjects() {
    }
}
