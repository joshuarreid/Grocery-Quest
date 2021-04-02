package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The PlayerMoney Class
 *
 * The PlayerMoney Class keeps track of the player's money
 * internally and visually.
 */
public class PlayerMoney {
    private int moneyLevel;
    private int moneyHitChange;
    private final double barWidth;
    private static final ImageView[] MONEYBARS = {
        new ImageView(new Image("file:resources/pngs/MoneyBar0.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar1.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar2.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar3.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar4.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar5.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar6.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar7.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar8.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar9.png")),
        new ImageView(new Image("file:resources/pngs/MoneyBar10.png"))};

    /**
     * PlayerMoney Constructor
     *
     * @param difficultyLevel difficulty of the level
     * @param width width of the bar
     */
    public PlayerMoney(int difficultyLevel, double width) {
        this.moneyLevel = 10;
        this.moneyHitChange = difficultyLevel;
        this.barWidth = width;
    }

    /**
     * Decreases the money of the player internally and
     * visually.
     *
     * @param power damage that the player should incur
     * @return the updated "decreased" money bar imageview
     */
    public ImageView removeMoney(int power) {
        int change = power * moneyHitChange;
        if (moneyLevel < change) {
            this.moneyLevel = 0;
        } else {
            this.moneyLevel -= change;
        }
        return barSettings(MONEYBARS[moneyLevel]);
    }

    /**
     * Increases the money of the player internally and
     * visually
     *
     * @param amount the amount to increase by
     * @return the updated "increased" money bar imageview
     */
    public ImageView addMoney(int amount) {
        int newHealth = this.moneyLevel + amount;
        if (newHealth > 10) {
            this.moneyLevel = 10;
        }
        return barSettings(MONEYBARS[moneyLevel]);
    }

    /**
     *
     * @return the current money bar imageview
     */
    public ImageView getCurrentMoneyBar() {
        return barSettings(MONEYBARS[moneyLevel]);
    }

    /**
     * Sets some attributes to the money bar
     *
     * @param bar the bar to modify
     * @return bar
     */
    private ImageView barSettings(ImageView bar) {
        bar.setFitWidth(barWidth);
        bar.setPreserveRatio(true);
        bar.setId("money");
        return bar;
    }

    //possible methods
    //public void healthBoast(Potion potion);
}
