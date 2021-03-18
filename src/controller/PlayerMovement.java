package controller;

public class PlayerMovement {
    private static int xPosition; //current x or col position
    private static int yPosition; //current y or row position

    /**
     * Constructor for player movement
     *
     * @param x intial x or col location
     * @param y inital y or row location
     */
    public PlayerMovement(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
//
    public static int getXPosition() {
        return xPosition;
    }

    public static int getYPosition() {
        return yPosition;
    }
    public void setxPosition(int newXPos) {
        xPosition = newXPos;
    }

    public void setyPosition(int newYPos) {
        yPosition = newYPos;
    }

}
