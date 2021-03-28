package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    public MonsterHealth(int healthLevel, int healthHitChange, double width) {
        this.healthLevel = healthLevel;
        this.healthHitChange = healthHitChange;
        this.barWidth = width;
    }

    public ImageView hit(int weaponHit) {
        int change = weaponHit * healthHitChange;
        if (healthLevel < change) {
            this.healthLevel = 0;
        } else {
            this.healthLevel -= change;
        }
        return barSettings(HEALTHBARS[healthLevel]);
    }

    public ImageView getCurrentHealthBar() {
        return barSettings(HEALTHBARS[healthLevel]);
    }

    private ImageView barSettings(ImageView bar) {
        bar.setFitWidth(barWidth);
        bar.setPreserveRatio(true);
        bar.setId("health");
        return bar;
    }
}
