package view;

import model.Exit;
import model.LevelRandomizer;
import model.Monster;
import model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class WeaponsScreen extends LevelScreen {
    public WeaponsScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters) {
        super(width, height, hero, lr, exits, "Weapons Screen", monsters);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("weapons room\n     ");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Weapons Label", false, 0, 2, 13, 5);
    }
}
