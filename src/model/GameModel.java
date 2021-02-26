package model;

public class GameModel {
    private int state = 0;
    public void decrementState() {
        state = state - 1;
    }
    public void incrementState() {
        state = state + 1;
    }
    public int getState() { return state; }
}
