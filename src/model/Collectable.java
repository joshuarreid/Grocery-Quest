package model;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

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
    private Node moreThanOne;

    protected static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 15);
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

    public Node getImage() {
        if(this.quantity > 1) {
            return moreThanOne;
        } else {
            return imageView;
        }
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
        if(quantity > 1) {
            Label quantityLabel = new Label("" + quantity);
            quantityLabel.setFont(DOGICA_FONT);
            quantityLabel.setAlignment(Pos.CENTER);

            moreThanOne = new StackPane(this.imageView,quantityLabel);
        }
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
