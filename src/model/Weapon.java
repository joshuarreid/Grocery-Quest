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

    @Override
    void action(Player hero) {
        System.out.print("use weapon");
    }
}
