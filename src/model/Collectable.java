package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class for items that have the ability to be collected by player
 */
public abstract class Collectable {
    private ImageView imageView;
    private String id;
    private int row;
    private int col;
    // whenever on board this quantity can only be 1,
    // but in inventory, quantity can be more than one
    protected int quantity;
    private boolean collected; //false == on board, true == in inventory

    public Collectable(String id, int row, int col, boolean collected, int quantity) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.quantity = quantity;
        this.collected = collected;
        this.imageView = new ImageView(new Image("file:resources/pngs/"
                + id.substring(0, id.indexOf("_")) + ".png"));
        this.imageView.setFitWidth(30);
        this.imageView.setFitHeight(30);
        this.imageView.setId(id);
    }

    /**
     *  Every collectable has an action that is done when used
     * @param hero the Player using the item
     */
    abstract void action(Player hero);

    public ImageView getImage() {
        return imageView;
    }

    public String getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
