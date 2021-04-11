package model;

public class N95 extends Potion{

    public N95(String id, int row, int col, boolean collected, int quantity, int hp) {
        super(id, row, col, collected, quantity, hp);
    }

    /**
     *  N95  is a special potion that temporarily increases the health
     *  capabilities of a Player to beyond 10
     *
     *  for instance: a Player with 5 health uses an N95,
     *  that player's health is now at 15.
     *
     * @param hero the Player using the item
     */
    @Override
    void action(Player hero) {
        hero.getPlayerHealth().addHealthProtection(10);
    }
}
