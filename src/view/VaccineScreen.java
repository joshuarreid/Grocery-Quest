package view;

import model.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class VaccineScreen extends LevelScreen {
    public VaccineScreen(int width, int height, Player hero,
                         LevelRandomizer lr, Exit[] exits, ArrayList<Monster> monsters, ArrayList<Collectable> items) {
        super(width, height, hero, lr, exits, "Vaccine Screen", monsters, items);
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("Covid-19 \nVaccine");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Vaccine Label", false, 0, 2, 15, 4);
    }
}
