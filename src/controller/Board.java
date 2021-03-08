package controller;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

//**************************NOTE: 3 THINGS TO ADDRESS**********************************************
//1. 2 potential methods: removeObject and playerMovement()
//2. Is win, a global boolean variable, necessary?
//3. When one of you guys, yes you, not the player, accidentally adds an object at a location
//that already has an object, do you want a print statement or throw an exception? Right now,
//there's a print statement because if we go the other way, we'd need to make a custom exception.

/**The Board Class
 *
 * Represents the coordinate system - GridPane that the user
 * stands or moves on
 */
public class Board {
    private final int maxRow, maxColumn;
    private boolean win = false, blocked = false; //is win variable even necessary?
    private String[][] hiddenBoard;
    private GridPane gridPane;

    /**
     * Fixed row and column is 18 but any amount
     * can be used for flexibility.
     *
     * @param row Number of vertical lines
     * @param column Number of horizontal locations
     * @param win Condition if player won or not
     */
    public Board(int row, int column, boolean win) {
        this.maxRow = row;
        this.maxColumn = column;
        this.win = win;
    }

    /**
     * Creates the game board and the hidden String 2D
     * array with fixed rows and columns
     */
    public void createBoard() {
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        for (int i = 0; i < maxRow; i++) { //Makes 18 rows = Fixed number of rows
            RowConstraints rowConst = new RowConstraints(33);
            //rowConst.setPercentHeight(600.0 / maxRow);
            gridPane.getRowConstraints().add(rowConst);
        }
        for (int i = 0; i < maxColumn; i++) { //Makes 18 columns = Fixed number of columns
            ColumnConstraints colConst = new ColumnConstraints(33);
            //colConst.setPercentWidth(600.0 / maxColumn);
            gridPane.getColumnConstraints().add(colConst);
        }
        hiddenBoard = new String[maxRow][maxColumn];
    }

    /**
     * Checks whether the spot ahead is blocked
     * by an aisle or a wall.
     *
     * @param row The vertical location of the spot ahead.
     * @param column The horizontal location of the spot ahead.
     * @return true if spot ahead is blocked
     */
    public boolean isBlocked(int row, int column) {
        if (row < 1 || row > 18 || column < 1 || column > 18) { //If blocked by wall
            return true;
        }
        //If blocked by node except door
        if (hiddenBoard[row][column] != null && !hiddenBoard[row][column].equals("door")) {
            return true;
        }
        return true;
    }

    /**
     * Sets object's location in the gridPane and the hidden
     * game board. This method has two parameters for row and
     * column to set objects that only occupy one place but
     * also bigger objects that occupy more than one row
     * and/or column.
     *
     * @param thing The object that is being placed in the gridPane
     * @param thingName The object being placed in the hidden game board
     * @param blockPlayer If the object should block the player
     * @param firstRow Starting vertical location
     * @param rowSpan The number of rows the node should span
     * @param firstCol Starting horizontal location
     * @param colSpan The number of columns the node should span
     */
    public void addObject(Node thing, String thingName, boolean blockPlayer,
                          int firstRow, int rowSpan, int firstCol, int colSpan) {
        if (hiddenBoard[firstRow][firstCol] != null) { //If object already exists at specified location
            System.out.println("There's already an object here."); //Other option: Throw an exception?
            return;
        }
        if (rowSpan == 0 && colSpan == 0) { //If thing occupies one spot
            gridPane.add(thing, firstCol, firstRow);
            if (blockPlayer) {
                hiddenBoard[firstRow][firstCol] = thingName;
            }
        } else { //If thing occupies more than one spot
            gridPane.add(thing, firstCol, firstRow, colSpan, rowSpan);
            if (blockPlayer) {
                for (int i = firstRow, j = firstCol; i < firstCol + rowSpan && j < firstCol + colSpan; i++, j++) {
                    hiddenBoard[firstRow][firstCol] = thingName;
                }
            }
        }
    }

    //Potential method?? If player has ability to break through aisles or something
    //public void removeObject() {}

    /**
     * Gets the gridPne to be used in the initial game
     * screen and level classes.
     *
     * @return the gridPane
     */
    public GridPane getGridPane() {
        return gridPane;
    }

    //Potential method
    //public void playerMovement(){}
}
