package model;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.LinkedList;
import java.util.List;

/**The Inventory Class
 *
 * Represents the Inventory - what items/weapons the player holds
 */
public class Inventory {
    private final int maxRow;
    private final int maxColumn;
    private List<String> hiddenInventory;
    private GridPane gridPane;

    /**
     * Inventory Constructor
     *
     * @param row Number of vertical lines
     * @param column Number of horizontal locations
     */
    public Inventory(int row, int column) {
        maxRow = row;
        maxColumn = column;
        this.gridPane = new GridPane();
        hiddenInventory = new LinkedList<>();
    }

    /**
     * Creates the inventory
     *
     * @param height height of screen
     * @param width width of screen
     */
    public void createInventory(double height, double width) {
        gridPane.setGridLinesVisible(true);
        for (int i = 0; i < maxRow; i++) { //Makes 18 rows = Fixed number of rows
            RowConstraints rowConst = new RowConstraints(height / maxRow);
            gridPane.getRowConstraints().add(rowConst);
        }
        for (int i = 0; i < maxColumn; i++) { //Makes 18 columns = Fixed number of columns
            ColumnConstraints colConst = new ColumnConstraints(width / maxColumn);
            gridPane.getColumnConstraints().add(colConst);
        }
    }



    /**
     * Adds object to Inventory gridPane
     *
     * @param thing The object that is being placed in the gridPane
     * @param id The object being placed in the hidden game board
     * @param row Starting vertical location
     * @param col Starting horizontal location
     //@return boolean to indicate successful addition of object
     */
    public void addObject(Node thing, String id, int row, int col) {
        thing.setId(id);
        gridPane.add(thing, col, row);
        gridPane.setHalignment(thing, HPos.CENTER);
        gridPane.setValignment(thing, VPos.CENTER);
        hiddenInventory.add(id);
    }

    /**
     * Removes object from gridpane using their id. Removes object's id from hidden inventory.
     *
     * @param id id of the object being removed
     * @return removed node, null otherwise
     */
    public String removeObject(String id) {
        for (Node node : this.gridPane.getChildren()) {
            //Checks valid node on gridPane
            if (node != null && node.getId() != null && node.getId().equals(id)) {
                int index = hiddenInventory.indexOf(id);
                if (index >= 0) { //If to-be removed object's id is found, remove it
                    hiddenInventory.remove(index);
                    gridPane.getChildren().remove(node);
                    return node.getId();
                } else { //If to-be removed object's id is NOT found, return null
                    return null;
                }
            }
        }
        return null;
    }

    /**
     *
     * @return the gridPane to be used in the initial game
     * screen and level classes.
     */
    public GridPane getGridPane() {
        return gridPane;
    }
}
