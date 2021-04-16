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
    private Collectable[][] itemBoard;
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
        this.hiddenBoard = new String[maxRow][maxColumn];
        this.itemBoard = new Collectable[maxRow][maxColumn];
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
        gridPane.setGridLinesVisible(false);
        for (int i = 0; i < maxRow; i++) { //Makes 18 rows = Fixed number of rows

            RowConstraints rowConst = new RowConstraints(600.0 / maxRow);
            gridPane.getRowConstraints().add(rowConst);
        }
        for (int i = 0; i < maxColumn; i++) { //Makes 18 columns = Fixed number of columns
            ColumnConstraints colConst = new ColumnConstraints(600.0 / maxColumn);
            gridPane.getColumnConstraints().add(colConst);
        }
        setUpExitBoard();
    }

    /**
     * Sets up exit board:
     * There is a board that keeps track of the locations of the exits.
     * This method goes through the exit array and places them in the correct spot.
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
     * @return true if spot ahead is blocked, false otherwise
     */
    public boolean isBlocked(int row, int column) {
        if (row < 0
                || row > maxRow - 1
                || column < 0
                || column > maxColumn - 1) { //If blocked by wall
            return true;
        }
        //If blocked by node except door
        return hiddenBoard[row][column] != null;
    }

    /**
     * Determines whether an item exists on the specified spot
     *
     * @param row row
     * @param col column
     * @return true if an item exists, false otherwise
     */
    public boolean hasItem(int row, int col) {
        return itemBoard[row][col] != null;
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

        if (rowSpan == 1 && colSpan == 1) { //If thing occupies one spot
            thing.setId(id);
            gridPane.add(thing, firstCol, firstRow);
            if (blockPlayer) { //If object should block player
                hiddenBoard[firstRow][firstCol] = id;
            }
        } else { //If thing occupies more than one spot
            thing.setId(id);
            gridPane.add(thing, firstCol, firstRow, colSpan, rowSpan);
            if (blockPlayer) { //If object should block player
                for (int i = firstRow; i < (firstRow + rowSpan); i++) {
                    for (int j = firstCol; j < (firstCol + colSpan); j++) {
                        hiddenBoard[i][j] = id;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Adds only collectables to the gridpane
     *
     * @param collectable collectable to be added
     * @return true when added
     */
    public boolean addCollectable(Collectable collectable) {
        int row = collectable.getRow();
        int col = collectable.getCol();
        String collectableId = collectable.getId();
        Node imgView = collectable.getImage();
        imgView.setId(collectableId);
        itemBoard[row][col] = collectable;
        gridPane.add(imgView, col, row);
        return true;
    }

    /**
     * Removes object from gridpane using their id. Removes object's id from hidden board.
     *
     * @param id id of the object being removed
     * @param row row location of object
     * @param rowSpan how many rows the object should span
     * @param col column location of object
     * @param colSpan how many columns the object should span
     * @return true if removed, false otherwise
     */
    public boolean removeObject(String id, int row, int rowSpan, int col, int colSpan) {
        for (Node node : this.gridPane.getChildren()) {
            //Checks valid node on gridPane
            if (node != null && node.getId() != null && node.getId().equals(id)) {
                if (rowSpan == 1 && colSpan == 1) {
                    if (id.substring(0, 4).equals("item")) {
                        itemBoard[row][col] = null;
                    } else {
                        this.hiddenBoard[row][col] = null;
                    }
                } else {
                    for (int i = row; i < (row + rowSpan); i++) {
                        for (int j = col; j < (col + colSpan); j++) {
                            hiddenBoard[i][j] = null;
                        }
                    }
                }
                return this.gridPane.getChildren().remove(node);
            }
        }
        return false;
    }

    /**
     * Only removes collectables from the gridpane
     *
     * @param collectable collectable to be removed
     * @return true if removed, false otherwise
     */
    public boolean removeCollectable(Collectable collectable) {
        for (Node node : this.gridPane.getChildren()) {
            //Checks valid node on gridPane
            if (node != null && node.getId() != null && node.getId().equals(collectable.getId())) {
                itemBoard[collectable.getRow()][collectable.getCol()] = null;
                return this.gridPane.getChildren().remove(node);
            }
        }
        return false;
    }

    /**
     * Tries to get the monster at specific index
     *
     * @param row row location of potential monster
     * @param col column location of potential monster
     * @return monster's id at position, null if no monster exists there
     */
    public String getMonster(int row, int col) {
        //If checking outside the board
        if (row >= maxRow || row < 0 || col >= maxColumn || col < 0) {
            return null;
        }
        //If detect a node
        if (hiddenBoard[row][col] != null) {
            //Check node if monster
            if (hiddenBoard[row][col].substring(0, 7).equals("monster")) {
                return hiddenBoard[row][col];
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

    public Collectable[][] getItemBoard() {
        return itemBoard;
    }

    /**
     *
     * @param row row
     * @param col column
     * @return the item at the postion
     */
    public Collectable getItem(int row, int col) {
        Collectable item = itemBoard[row][col];
        itemBoard[row][col] = null;
        return item;
    }

    /**
     * Method that returns the exit the player is currently on
     * and modifies the player's position according to the exit it is going through
     * Note: this method can only be use after knowing the player is for sure on an exit, so
     *       only use after using onExit(Player player) to check
     *
     * @param player the player
     * @param gameModel the gameModel
     * @return exit player is on
     */
    public Exit onExit(Player player, GameModel gameModel) {
        int[] playerCoordinates = player.getPlayerPosition();
        Exit exit = exitBoard[playerCoordinates[1]][playerCoordinates[0]];

        switch (exit.getExitType(gameModel.getState())) {
        case TOP:
            player.getPlayerMovement().setYPosition(maxRow - 1);
            break;
        case BOTTOM:
            player.getPlayerMovement().setYPosition(0);
            break;
        case LEFT:
            player.getPlayerMovement().setXPosition(maxColumn - 1);
            break;
        case RIGHT:
            player.getPlayerMovement().setXPosition(0);
            break;
        default:
        }
        return exit;
    }

    /**
     * Method used to get the exit the player is on
     *
     * @param player the player
     * @return the exit the player is on or null if not on exit
     */
    public Exit onExit(Player player) {
        int[] playerCoordinates = player.getPlayerPosition();
        Exit exit = exitBoard[playerCoordinates[1]][playerCoordinates[0]];
        return exit;
    }
}
