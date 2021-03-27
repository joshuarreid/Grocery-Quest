package model;

public class Exit {
    private ExitType side1;
    private ExitType side2;
    private String screen1;
    private String screen2;
    private Boolean isOpen;

    public Exit(ExitType side1, ExitType side2, String screen1, String screen2, Boolean isOpen) {
        this.side1 = side1;
        this.side2 = side2;
        this.screen1 = screen1;
        this.screen2 = screen2;
        this.isOpen = isOpen;
    }

    public ExitType getExitType(String iD) {
        if (iD.equals(screen1)) {
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

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }



}
