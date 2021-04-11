package model;

public class Weapon extends Collectable{
    private int damage;
    public Weapon(String id, int row, int col, boolean collected, int quantity) {
        super(id, row, col, collected, quantity);
        if(id.contains("Fire")) { //super weapons contain Fire
            this.damage = 2;
        } else {
            this.damage = 1;
        }
    }
    /* NOTE TO JOSH JOSH: idk if we should refactor the player class and that player attacking
       implementation to include this class.
    */
    /**
     * Weapons attack monsters
     * @param hero the Player using the item
     */
    @Override
    void action(Player hero) {
        System.out.print("use weapon");
    }
}
