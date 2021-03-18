package view;

import model.Exit;
import model.LevelRandomizer;
import model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class VaccineScreen extends LevelScreen {
    public VaccineScreen(int width, int height, Player hero, LevelRandomizer lr, Exit[] exits) {
        super(width, height, hero, lr, exits, "Vaccine Screen");
    }

    @Override
    void loadObjects() {
        Label levelLabel = new Label("Covid-19 \nVaccine");
        levelLabel.setFont(DOGICA_FONT);
        levelLabel.setAlignment(Pos.CENTER);
        super.board.addObject(levelLabel, "Vaccine Label", false, 0, 2, 15, 4);
    }
}
