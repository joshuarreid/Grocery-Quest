package view;

import model.Exit;
import model.LevelRandomizer;
import model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class LevelFourScreen extends LevelScreen{
    public LevelFourScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Level 4");
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("Level 4\n      ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Level 4 Label", false, 0, 2, 15, 3);
    }
}
