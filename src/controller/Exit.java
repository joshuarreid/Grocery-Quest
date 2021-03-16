package controller;

import javafx.scene.layout.Background;

class Exit {
    private Level previousLevel;
    private Level nextLevel;
    private int rowNumber;
    private int columnNumber;

    /**
     * @return previous level reference
     */
    public Level getPreviousLevel() {
        return previousLevel;
    }

    /**
     * @return next level reference
     */
    public Level getNextLevel() {
        return nextLevel;
    }

    /**
     * @param previousLevel the level to which previous level is to be set
     * @throws IllegalArgumentException if argument is null
     */
    public void setPreviousLevel(Level previousLevel)
            throws IllegalArgumentException {
        if (nextLevel == null) {
            throw new IllegalArgumentException("Previous level can't be null.");
        }
        this.previousLevel = previousLevel;
    }

    /**
     * @param nextLevel the level to which next level is to be set
     * @throws IllegalArgumentException if argument is null
     */
    public void setNextLevel(Level nextLevel)
            throws IllegalArgumentException {
        if (nextLevel == null) {
            throw new IllegalArgumentException("Next level can't be null.");
        }
        this.nextLevel = nextLevel;
    }

    /**
     * @return row number of exit location
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * @return column number of exit location
     */
    public int getColumnNumber() {
        return columnNumber;
    }

    /**
     * @param rowNumber the row number to which the exit is to be set
     * @throws IllegalArgumentException if the row number is not at the
     * board edge
     */
    public void setRowNumber(int rowNumber) throws IllegalArgumentException {
        boolean validRow = (rowNumber == 0) || (rowNumber == 18);
        if (!(validRow)) {
            throw new IllegalArgumentException("Exit can only be on end rows");
        }
        this.rowNumber = rowNumber;
    }

    /**
     * @param columnNumber the column number to which the exit is to be set
     * @throws IllegalArgumentException if the column number is not at the
     * board edge
     */
    public void setColumnNumber(int columnNumber)
            throws IllegalArgumentException {
        boolean validColumn = (rowNumber == 0) || (rowNumber == 18);
        if (!(validColumn)) {
            throw new IllegalArgumentException("Exit can only be on end"
                    + " columns");
        }
        this.columnNumber = columnNumber;
    }

    /**
     * setter for coordinates of exit in a level.
     * @param rowNumber the row number to which the exit is to be set
     * @param columnNumber the column number to which the exit is to be set
     */
    public void changeExitLocation(int rowNumber, int columnNumber) {
        setRowNumber(rowNumber);
        setColumnNumber(columnNumber);
    }


    /**
     * exit method called when player is on exit to
     * initiate exit action.
     * @param futureNextLevel the level supposed to be next level after change
     * @return Background of the nextLevel
     */
    public Background exit(Level futureNextLevel) {
        setPreviousLevel(getNextLevel()); //updating previous level to current one
        setNextLevel(futureNextLevel); //updating next level to user input
        LevelRandomizer generateNextLevelGraphics = new LevelRandomizer();
        return generateNextLevelGraphics.getLayout();
    }

}
