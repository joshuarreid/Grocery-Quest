package controller;

import javafx.scene.layout.Background;
import model.ExitType;

public class Exit {
    private ExitType side1;
    private ExitType side2;
    private String screen1;
    private String screen2;

    public Exit(ExitType side1, ExitType side2, String screen1, String screen2) {
        this.side1 = side1;
        this.side2 = side2;
        this.screen1 = screen1;
        this.screen2 = screen2;
    }
//TODO fix later
    public ExitType getSide() {
        return this.side;
    }

}
