package model;

public class GameModel {
    private String state;
    public GameModel() {
        this.state = "None";
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
