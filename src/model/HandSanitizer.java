package model;

public class HandSanitizer extends Potion {
    private int weaponPowerIncrease;
    public HandSanitizer(String id, int row, int col, boolean collected, int quantity) {
        super(id, row, col, collected, quantity, 0);
        this.weaponPowerIncrease = 1;
    }

    @Override
    public void action(Player player) {
        super.setQuantity(super.getQuantity() - 1);
        player.getWeapon().setDamage(player.getWeapon().getDamage() + this.weaponPowerIncrease);
    }
}
