package model;

public class Potion extends Collectable {
    private int hp;

    public Potion(String id, int row, int col, boolean collected, int quantity, int hp) {
        super(id, row, col, collected, quantity);
        this.hp = hp;
    }

    /**
     * Potions add health to Players
     * @param hero the Player using the item
     */
    @Override
    void action(Player hero) { // consume
        if (this.quantity > 0) {
            this.quantity--;
            hero.getPlayerHealth().addHealth(this.hp);
        }
    }
}
