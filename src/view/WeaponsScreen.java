package view;

import controller.Exit;
import controller.LevelRandomizer;
import controller.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class WeaponsScreen extends LevelScreen{
    public WeaponsScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits){
        super(width, height, hero, lr, exits, "Weapons Screen");
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("weapons room\n     ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Weapons Label", false, 0, 2, 13, 5);
    }
}
