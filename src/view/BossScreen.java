package view;

import model.Exit;
import model.LevelRandomizer;
import model.Monster;
import model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class BossScreen extends LevelScreen {
    public BossScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters) {
        super(width, height, hero, lr, exits, "Boss Screen", monsters);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("Item Checkout: \n Boss Level");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Boss Level Label", false, 0, 2, 13, 6);
    }
}
