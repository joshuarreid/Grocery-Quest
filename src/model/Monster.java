package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Monster {
    private int health;
    private MonsterType monsterType;
    private ImageView MonsterImage;
    private String currentSide;
    private ImageView healthBar;
    private MonsterHealth monsterHealth;
    private int healthHitChange;

    public Monster(MonsterType monsterType, String currentSide, int healthHitChange) {
        this.health = 5;
        this.monsterType = monsterType;
        this.currentSide = currentSide;
        this.healthHitChange = healthHitChange;
        this.monsterHealth = new MonsterHealth(10, this.healthHitChange, 150);

    }

    public ImageView weaponHit(int weaponHit) {
        return monsterHealth.hit(weaponHit);
    }
}
