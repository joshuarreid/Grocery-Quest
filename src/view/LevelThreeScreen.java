package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class LevelThreeScreen extends LevelScreen{
    public LevelThreeScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 3");
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("Level 3\n      ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Level 3 Label", false, 0, 2, 15, 3);
    }
}
