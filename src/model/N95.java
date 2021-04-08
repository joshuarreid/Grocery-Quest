package model;

public class N95 extends Potion{

    public N95(String id, int row, int col, boolean collected, int quantity, int hp) {
        super(id, row, col, collected, quantity, hp);
    }

    @Override
    void action(Player hero) {
        hero.getPlayerHealth().addHealthProtection(10);
    }
}
