package model;

/**
 * The Exit Class
 *
 * The Exit Class helps the player move between levels.
 */
public class Exit {
    private ExitType side1;
    private ExitType side2;
    private String screen1;
    private String screen2;
    private Boolean isOpen;

    /**
     * Exit Constructor:
     * An exit is an object that represents the connection between two screens or levels
     *
     * @param side1 the side exit is on in Screen1
     * @param side2 the side exit is on in Screen2
     * @param screen1 the level id of the first screen the exit is on
     * @param screen2 the level id of the second screen the exit is on
     * @param isOpen boolean to indicate if the exit is open (aka can player use it)
     */
    public Exit(ExitType side1, ExitType side2, String screen1, String screen2, Boolean isOpen) {
        this.side1 = side1;
        this.side2 = side2;
        this.screen1 = screen1;
        this.screen2 = screen2;
        this.isOpen = isOpen;
    }

    /**
     * Method to identify what side the exit is on the current level
     *
     * @param iD of the current level
     * @return the location exit on the passed
     *         in level in terms of an ExitType
     */
    public ExitType getExitType(String iD) {
        if (iD.equals(screen1)) {
            return side1;
        } else {
            return side2;
        }
    }

    /**
     * Method to get the id of the screen that
     * the exit connects the current screen to
     *
     * @param model current game model
     * @return id of screen the exit connects to
     */
    public String getAdjacentState(GameModel model) {
        if (model.getState().equals(screen1)) {
            return screen2;
        } else {
            return screen1;
        }
    }

    /**
     *
     * @return true if open, false otherwise
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     *
     * @param isOpen isOpen condition to set
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }



}
