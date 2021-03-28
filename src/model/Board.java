package model;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**The Board Class
 *
 * Represents the coordinate system - GridPane that the user
 * stands or moves on
 */
public class Board {
    private final int maxRow;
    private final int maxColumn;
    private String[][] hiddenBoard;
    private GridPane gridPane;
    private Exit[] exits;
    private Exit[][] exitBoard;
    private String iD;

    /**
     * Fixed row and column is 18 but any amount
     * can be used for flexibility.
     *
     * @param row Number of vertical lines
     * @param column Number of horizontal locations
     * @param exits array of levels exits
     * @param iD name of the level
     */
    public Board(int row, int column, Exit[] exits, String iD) {
        this.maxRow = row;
        this.maxColumn = column;
        this.gridPane = new GridPane();
        this.hiddenBoard = new String[maxRow + 2][maxColumn + 2];
        this.exitBoard = new Exit[maxRow][maxColumn];
        this.exits = exits;
        this.iD = iD;
    }

    /**
     * Creates the game board and the hidden String 2D
     * array with fixed rows and columns
     * @param height height of screen
     * @param width width of screen
     */
    public void createBoard(double height, double width) {
        gridPane.setGridLinesVisible(true);
        for (int i = 0; i < maxRow; i++) { //Makes 18 rows = Fixed number of rows

            RowConstraints rowConst = new RowConstraints(height / maxRow);
            gridPane.getRowConstraints().add(rowConst);
        }
        for (int i = 0; i < maxColumn; i++) { //Makes 18 columns = Fixed number of columns
            ColumnConstraints colConst = new ColumnConstraints(width / maxColumn);
            gridPane.getColumnConstraints().add(colConst);
        }
        setUpExitBoard();
    }

    //TODO:  I have no idea what the below method does. Can someone clarify thr javadoc? -Josh
    /**
     * Sets up exit board.
     */
    private void setUpExitBoard() {
        for (int i = 0; i < this.exits.length; i++) {
            switch (this.exits[i].getExitType(iD)) {
            case TOP :
                exitBoard[0][(maxColumn / 2) - 1] = exits[i];
                exitBoard[0][maxColumn / 2] = exits[i];
                exitBoard[0][(maxColumn / 2) + 1] = exits[i];
                break;
            case BOTTOM:
                exitBoard[maxRow - 1][(maxColumn / 2) - 1] = exits[i];
                exitBoard[maxRow - 1][maxColumn / 2] = exits[i];
                exitBoard[maxRow - 1][(maxColumn / 2) + 1] = exits[i];
                break;
            case RIGHT:
                exitBoard[(maxRow / 2) - 1][maxColumn - 1] = exits[i];
                exitBoard[(maxRow / 2)][maxColumn - 1] = exits[i];
                exitBoard[(maxRow / 2) + 1][maxColumn - 1] = exits[i];
                break;
            case LEFT:
                exitBoard[(maxRow / 2) - 1][0] = exits[i];
                exitBoard[(maxRow / 2)][0] = exits[i];
                exitBoard[(maxRow / 2) + 1][0] = exits[i];
                break;
            default:
            }
        }
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
        if (row < 0
                || row > maxRow - 1
                || column < 0
                || column > maxColumn - 1) { //If blocked by wall
            return true;
        }
        row++;
        column++;
        //If blocked by node except door
        return hiddenBoard[row][column] != null;
    }

    /**
     * Sets object's location in the gridPane and the hidden
     * game board. This method has two parameters for row and
     * column to set objects that only occupy one place but
     * also bigger objects that occupy more than one row
     * and/or column.
     *
     * @param thing The object that is being placed in the gridPane
     * @param id The object being placed in the hidden game board
     * @param blockPlayer If the object should block the player
     * @param firstRow Starting vertical location
     * @param rowSpan The number of rows the node should span beyond 1
     * @param firstCol Starting horizontal location
     * @param colSpan The number of columns the node should span beyond 1
     * @return boolean to indicate successful addition of object
     */
    public boolean addObject(Node thing, String id, boolean blockPlayer,
                          int firstRow, int rowSpan, int firstCol, int colSpan) {
        if (isBlocked(firstRow, firstCol)) {
            return false;
        }

        if (rowSpan == 0 && colSpan == 0) { //If thing occupies one spot
            thing.setId(id);
            gridPane.add(thing, firstCol, firstRow);
            if (blockPlayer) { //If object should block player
                hiddenBoard[firstRow + 1][firstCol + 1] = id;
            }
        } else { //If thing occupies more than one spot
            gridPane.add(thing, firstCol, firstRow, colSpan, rowSpan);
            if (blockPlayer) { //If object should block player
                for (int i = firstRow; i < (firstRow + rowSpan); i++) {
                    for (int j = firstCol; j < (firstCol + colSpan); j++) {
                        hiddenBoard[i + 1][j + 1] = id;
                    }
                }
            }
        }
        return true;
    }

    /**
     *  Removes object from gridpane using their id. Removes object's id from hidden board.
     * @param id id of the object being removed
     * @param row row location of object
     * @param rowSpan how many rows the object should span
     * @param col column location of object
     * @param colSpan how many columns the object should span
     * @return true if removed, false otherwise
     */
    public boolean removeObject(String id, int row, int rowSpan, int col, int colSpan) {
        for (Node node : this.gridPane.getChildren()) {
            if (node != null
                    && node.getId() != null
                    && node.getId().equals(id)) {
                if (rowSpan == 0 && colSpan == 0) {
                    this.hiddenBoard[row + 1][col + 1] = null;
                } else {
                    for (int i = row; i < (row + rowSpan); i++) {
                        for (int j = col; j < (col + colSpan); j++) {
                            hiddenBoard[i + 1][j + 1] = null;
                        }
                    }
                }
                return this.gridPane.getChildren().remove(node);
            }
        }
        return false;
    }

    /**
     *
     * @param row row location of potential monster
     * @param col column location of potential monster
     * @return monster's id at position, null if no monster exists there
     */
    public String getMonster(int row, int col) {
        if (hiddenBoard[row + 1][col + 1] != null) {
            if (hiddenBoard[row + 1][col + 1].substring(0, 7).equals("monster")) {
                return hiddenBoard[row + 1][col + 1];
            }
        }
        return null;
    }

    // need to fix this method
    //    public boolean removeObject(String id, int x, int y, int rowSpan, int colSpan) {
    //        for (Node node : this.gridPane.getChildren()) {
    //            if (node != null
    //                    && node.getId() != null
    //                    && node.getId().equals(id)) {
    ////                this.hiddenBoard[y + 1][x + 1] = null;
    //                for (int i = y; i < (y + rowSpan); i++) {
    //                    for (int j = x; j < (x + colSpan); j++) {
    //                        hiddenBoard[i + 1][j + 1] = null;
    //                    }
    //                }
    //                return this.gridPane.getChildren().remove(node);
    //            }
    //        }
    //        return false;
    //    }

    /**
     *
     * @return the gridPane to be used in the initial game
     * screen and level classes.
     */
    public GridPane getGridPane() {
        return gridPane;
    }

    //TODO: I'm also not sure about this method. Could someone clarify the javadoc? -Josh
    /**
     *
     * @param player the player
     * @param gameModel the gameModel
     * @return
     */
    public Exit onExit(Player player, GameModel gameModel) {
        int[] playerCoordinates = player.getPlayerPosition();
        Exit exit = exitBoard[playerCoordinates[1]][playerCoordinates[0]];

        switch (exit.getExitType(gameModel.getState())) {
        case TOP:
            player.getPlayerMovement().setyPosition(maxRow - 1);
            break;
        case BOTTOM:
            player.getPlayerMovement().setyPosition(0);
            break;
        case LEFT:
            player.getPlayerMovement().setxPosition(maxColumn - 1);
            break;
        case RIGHT:
            player.getPlayerMovement().setxPosition(0);
            break;
        default:
        }
        return exit;
    }

    //TODO: This one too.
    /**
     *
     * @param player the player
     * @return the new exit?
     */
    public Exit onExit(Player player) {
        int[] playerCoordinates = player.getPlayerPosition();
        Exit exit = exitBoard[playerCoordinates[1]][playerCoordinates[0]];
        return exit;
    }

}
