package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Potion extends Collectable {
    private int hp;

    public Potion(String id, int row, int col, boolean collected, int quantity, int hp) {
        super(id, row, col, collected, quantity);
        this.hp = hp;
    }

    @Override
    void action(Player hero) { // consume
        if(this.quantity > 0) {
            this.quantity--;
            hero.getPlayerHealth().addHealth(this.hp);
        }
    }
}
