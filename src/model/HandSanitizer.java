package model;

public class HandSanitizer extends Potion{
    public HandSanitizer(String id, int row, int col, boolean collected, int quantity, int powerIncrease) {
        super(id, row, col, collected, quantity, 0);
    }

    @Override
    public void action(Player player) {

    }
}
