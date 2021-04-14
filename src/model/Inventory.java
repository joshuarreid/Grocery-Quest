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
    private List<Collectable> hiddenInventory;
    private GridPane gridPane;
    int currentItem; // row

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
        this.currentItem = 0;
    }

    /**
     * Creates the inventory
     *
     * @param height height of screen
     * @param width width of screen
     */
    public void createInventory(double height, double width) {
//        gridPane.setGridLinesVisible(true);
        for (int i = 0; i < maxRow; i++) { //Makes 18 rows = Fixed number of rows
            RowConstraints rowConst = new RowConstraints(601.0 / maxRow);
            gridPane.getRowConstraints().add(rowConst);
        }
        for (int i = 0; i < maxColumn; i++) { //Makes 18 columns = Fixed number of columns
            ColumnConstraints colConst = new ColumnConstraints(50.0/ maxColumn);
            gridPane.getColumnConstraints().add(colConst);
        }
    }



    /**
     * Adds object to Inventory gridPane
     *
     * @param collectable The object being placed in the hidden game board
     * @param row Starting vertical location
     * @param col Starting horizontal location
     //@return boolean to indicate successful addition of object
     */
    public void addObject(Collectable collectable, int row, int col) {
        collectable.getImage().setId(collectable.getId());
        gridPane.add(collectable.getImage(), col, row);
        gridPane.setHalignment(collectable.getImage(), HPos.CENTER);
        gridPane.setValignment(collectable.getImage(), VPos.CENTER);
        hiddenInventory.add(collectable);
    }

    /**
     * Removes object from gridpane using their id. Removes object's id from hidden inventory.
     *
     * @param collectable object being removed
     * @return true if removed, false otherwie
     */
    public boolean removeObject(Collectable collectable) {
        for (Node node : this.gridPane.getChildren()) {
            //Checks valid node on gridPane
            if (node != null && node.getId() != null && node.getId().equals(collectable.getId())) {
                //*****TODO: Any way to make this more efficient? Getting the index of a certain object by searching by attributes in an object list
                int count = 0;
                int index = 0;
                for (Collectable value: hiddenInventory) {
                    if (value.getId().equals(collectable.getId())) {
                        index = count;
                        break;
                    }
                    count++;
                }
                //*********************************
                if (index >= 0) { //If to-be removed object's id is found, remove it
                    hiddenInventory.remove(index);
                    gridPane.getChildren().remove(node);
                    return true;
                }
            }
        }
        return false;
    }

// trying this out
    public void clearInventory() {
        for (Node node : this.gridPane.getChildren()) {
            //Checks valid node on gridPane
            if (node != null) {
                int count = 0;
                int index = 0;
                for (Collectable value: hiddenInventory) {
                    if (value.getId().equals(node.getId())) {
                        index = count;
                        break;
                    }
                    count++;
                }
                //*********************************
                if (index >= 0) { //If to-be removed object's id is found, remove it
                    hiddenInventory.remove(index);
                    gridPane.getChildren().remove(node);
                }
            }
        }
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
