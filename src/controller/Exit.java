package controller;

import model.ExitType;
import model.GameModel;

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

    public ExitType getExitType(String ID) {
        if(ID.equals(screen1)) {
            return side1;
        } else {
            return side2;
        }
    }

    public String getAdjacentState(GameModel model) {
        if (model.getState().equals(screen1)) {
            return screen2;
        } else {
            return screen1;
        }
    }



}
