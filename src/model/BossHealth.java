package model;

import javafx.scene.image.ImageView;

public class BossHealth extends MonsterHealth{
    /**
     * MonsterHealth Constructor
     *
     * @param healthLevel     the health of the monster
     * @param healthHitChange how much the monster should take damage
     * @param width           width of the health bar
     */
    public BossHealth(int healthLevel, int healthHitChange, double width) {
        super(healthLevel, healthHitChange, width);
    }

    @Override
    public ImageView removeHealth(int weaponHit) {
        int change = weaponHit * healthHitChange;
        if (healthLevel < change) {
            this.healthLevel = 0;
        } else {
            this.healthLevel -= change;
        }
        return barSettings(healthBARS[(int) Math.ceil(((double) healthLevel) / 6)]);
    }

    @Override
    public ImageView getCurrentHealthBar() {
        return barSettings(healthBARS[(int) Math.ceil(((double) healthLevel) / 6)]);
    }
}
