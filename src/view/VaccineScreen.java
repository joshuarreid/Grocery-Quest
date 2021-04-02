package view;

import model.Exit;
import model.LevelRandomizer;
import model.Monster;
import model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class VaccineScreen extends LevelScreen {
    public VaccineScreen(int width, int height, Player hero,
                         LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters) {
        super(width, height, hero, lr, exits, "Vaccine Screen", monsters);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("Covid-19 \nVaccine");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Vaccine Label", false, 0, 2, 15, 4);
    }
}
