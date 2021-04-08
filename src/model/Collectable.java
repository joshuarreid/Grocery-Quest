package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Collectable {
    private ImageView image;
    private String id;
    private int row;
    private int col;
    protected int quantity;
    private boolean collected; //false == on board, true == in inventory

    public Collectable(String id, int row, int col, boolean collected, int quantity) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.quantity = quantity;
        this.collected = collected;
        this.image = new ImageView(new Image("file:resources/pngs/"
                + id.substring(0, id.indexOf("_")) + ".png"));
        this.image.setFitWidth(35);
        this.image.setFitHeight(35);
        this.image.setId(id);
    }

    abstract void action(Player hero);

    public ImageView getImage() {
        return image;
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
