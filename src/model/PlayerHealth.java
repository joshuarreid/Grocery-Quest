package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The PlayerHealth Class
 *
 * The PlayerHealth Class is responsible for keeping track of the
 * health of the player internally and visually.
 *
 * healthLevel - the player's current health level
 * healthHitChange - how much the health should decrease depending on the difficulty of the level
 * barWidth - the width of the healthbar
 * HEALTHBARS - all the imageviews of the healthbar from empty to full
 */
public class PlayerHealth {
    private int healthLevel;
    private int healthHitChange;
    private final double barWidth;
    private static final ImageView[] HEALTHBARS = {
        new ImageView(new Image("file:resources/pngs/HealthBar0.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar1.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar2.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar3.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar4.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar5.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar6.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar7.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar8.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar9.png")),
        new ImageView(new Image("file:resources/pngs/HealthBar10.png"))};

    /**
     * PlayerHealth Constructor
     *
     * @param difficultyLevel the difficulty level
     * @param width the width of the bar
     */
    public PlayerHealth(int difficultyLevel, double width) {
        this.healthLevel = 10;
        this.healthHitChange = difficultyLevel;
        this.barWidth = width;
    }

    /**
     * Decreases the health of the player internally and
     * visually
     *
     * @param power damage that the player should incur
     * @return the updated "dcreased" imageview
     */
    public ImageView removeHealth(int power) {
        int change = power * healthHitChange;
        if (healthLevel < change) {
            this.healthLevel = 0;
        } else {
            this.healthLevel -= change;
        }
        return barSettings(HEALTHBARS[healthLevel]);
    }

    /**
     * Increases the health of the player internally and
     * visually
     *
     * @param amount the amount to increase by
     * @return the updated "increased" imageview
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
    public int getPlayerHealthLevel() { return healthLevel; }

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


    //possible methods
    //public void healthBoast(Potion potion);

}
