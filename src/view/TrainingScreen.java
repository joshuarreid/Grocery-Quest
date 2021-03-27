package view;

import model.Exit;
import model.LevelRandomizer;
import model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class TrainingScreen extends LevelScreen {
    public TrainingScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits) {
        super(width, height, hero, lr, exits, "Training Screen");
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("training room\n     ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Training Label", false, 0, 2, 13, 5);
    }
}
