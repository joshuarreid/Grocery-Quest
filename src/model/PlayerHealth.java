package model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerHealth {
    private int healthLevel; //current health level
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

    public PlayerHealth(int difficultyLevel, double width) {
        this.healthLevel = 10;
        this.healthHitChange = difficultyLevel;
        this.barWidth = width;
    }

    public ImageView removeHealth(int power) {
        int change = power * healthHitChange;
        if (healthLevel < change) {
            this.healthLevel = 0;
        } else {
            this.healthLevel -= change;
        }
        return barSettings(HEALTHBARS[healthLevel]);
    }

    public ImageView addHealth(int amount) {
        int newHealth = this.healthLevel + amount;
        if (newHealth > 10) {
            this.healthLevel = 10;
        }
        return barSettings(HEALTHBARS[healthLevel]);
    }

    public ImageView getCurrentHealthBar() {
        return barSettings(HEALTHBARS[healthLevel]);
    }

    public int getPlayerHealthLevel() { return healthLevel; }

    private ImageView barSettings(ImageView bar) {
        bar.setFitWidth(barWidth);
        bar.setPreserveRatio(true);
        bar.setId("health");
        return bar;
    }


    //possible methods
    //public void healthBoast(Potion potion);

}
