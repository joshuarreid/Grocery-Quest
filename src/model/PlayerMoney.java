package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    public PlayerMoney(int difficultyLevel, double width) {
        this.moneyLevel = 10;
        this.moneyHitChange = difficultyLevel;
        this.barWidth = width;
    }

    public ImageView hit(int power) {
        int change = power * moneyHitChange;
        if (moneyLevel < change) {
            this.moneyLevel = 0;
        } else {
            this.moneyLevel -= change;
        }
        return barSettings(MONEYBARS[moneyLevel]);
    }

    public ImageView addMoney(int amount) {
        int newHealth = this.moneyLevel + amount;
        if (newHealth > 10) {
            this.moneyLevel = 10;
        }
        return barSettings(MONEYBARS[moneyLevel]);
    }

    public ImageView getCurrentMoneyBar() {
        return barSettings(MONEYBARS[moneyLevel]);
    }

    private ImageView barSettings(ImageView bar) {
        bar.setFitWidth(barWidth);
        bar.setPreserveRatio(true);
        bar.setId("money");
        return bar;
    }

    //possible methods
    //public void healthBoast(Potion potion);
}
