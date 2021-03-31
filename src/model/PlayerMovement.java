package model;

/**
 * The PlayerMovement Class
 *
 * The PlayerMovement Class is responsible for moving the
 * player.
 *
 * xPosition - the current x or col position
 * yPosition - the current y or row position
 */
public class PlayerMovement {
    private static int xPosition;
    private static int yPosition;

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

    /**
     *
     * @return current x or col position
     */
    public static int getXPosition() {
        return xPosition;
    }

    /**
     *
     * @return current y or row position
     */
    public static int getYPosition() {
        return yPosition;
    }

    /**
     *
     * @param newXPos new x or col position to move to
     */
    public void setXPosition(int newXPos) {
        xPosition = newXPos;
    }

    /**
     *
     * @param newYPos new y or row position to move to
     */
    public void setYPosition(int newYPos) {
        yPosition = newYPos;
    }

}
