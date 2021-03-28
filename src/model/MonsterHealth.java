package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The MonsterHealth Class
 *
 * The MonsterHealth Class keeps tracks of the health of the
 * monster internally and visually.
 */
public class MonsterHealth {
    private int healthLevel; //current health level
    private int healthHitChange;
    private final double barWidth;
    private final ImageView[] HEALTHBARS = {
            new ImageView(new Image("file:resources/pngs/EnemyHealthBar0.png")),
            new ImageView(new Image("file:resources/pngs/EnemyHealthBar1.png")),
            new ImageView(new Image("file:resources/pngs/EnemyHealthBar2.png")),
            new ImageView(new Image("file:resources/pngs/EnemyHealthBar3.png")),
            new ImageView(new Image("file:resources/pngs/EnemyHealthBar4.png"))
    };

    /**
     * MonsterHealth Constructor
     *
     * @param healthLevel the health of the monster
     * @param healthHitChange how much the monster should take damage
     * @param width width of the health bar
     */
    public MonsterHealth(int healthLevel, int healthHitChange, double width) {
        this.healthLevel = healthLevel;
        this.healthHitChange = healthHitChange;
        this.barWidth = width;
    }

    /**
     * Decreases the health of the monster internally and
     * visually
     *
     * @param weaponHit damage that the monster should incur
     * @return the updated "dcreased" health bar imageview
     */
    public ImageView removeHealth(int weaponHit) {
        int change = weaponHit * healthHitChange;
        if (healthLevel < change) {
            this.healthLevel = 0;
        } else {
            this.healthLevel -= change;
        }
        return barSettings(HEALTHBARS[healthLevel]);
    }

    /**
     * Increases the health of the monster internally and
     * visually
     *
     * @param amount the amount to increase by
     * @return the updated "increased" health bar imageview
     */
    public ImageView addHealth(int amount) {
        int newHealth = this.healthLevel + amount;
        if (newHealth > 10) {
            this.healthLevel = 10;
        }
        return barSettings(HEALTHBARS[healthLevel]);
    }

    /**
     *
     * @return the current health bar imageview
     */
    public ImageView getCurrentHealthBar() {
        return barSettings(HEALTHBARS[healthLevel]);
    }

    /**
     *
     * @return the health level
     */
    public int getHealthLevel() { return healthLevel; }

    /**
     * Sets some attributes to the health bar
     *
     * @param bar the bar to modify
     * @return bar
     */
    private ImageView barSettings(ImageView bar) {
        bar.setFitWidth(barWidth);
        bar.setPreserveRatio(true);
        bar.setId("health");
        return bar;
    }
}
