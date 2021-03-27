package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Monster {
    private int health;
    private MonsterType monsterType;
    private ImageView monsterImage;
    private String currentSide;
    private ImageView healthBar; // potentially dont need
    private MonsterHealth monsterHealth;
    private int healthHitChange;
    private int x;
    private int y;

    public Monster(MonsterType monsterType, String currentSide, int healthHitChange, int x, int y) {
        this.health = 5;
        this.monsterType = monsterType;
        this.currentSide = currentSide;
        this.healthHitChange = healthHitChange;
        this.monsterHealth = new MonsterHealth(10, this.healthHitChange, 50);
        this.x = x;
        this.y = y;

        switch(monsterType) {
            case FAANTIMASKER:
                // resources/pngs/FAntimaskerDown.png
                this.monsterImage = new ImageView(new Image("file:resources/pngs/FAntimasker" + currentSide + ".png"));
                break;
            case MAANTIMASKER:
                //resources/pngs/MAntimaskerDown.png
                this.monsterImage = new ImageView(new Image("file:resources/pngs/MAntimasker" + currentSide + ".png"));
                break;
            case COVIDBOSSLARGE:
                this.monsterImage = new ImageView(new Image("resources/pngs/CovidBossLarge.png"));
                break;
            case COVIDBOSSSMALL:
                this.monsterImage = new ImageView(new Image("resources/pngs/CovidBossSmall.png"));
                break;
            case TRUMP:
                //resources/pngs/TrumpDown.png
                this.monsterImage = new ImageView(new Image("resources/pngs/Trump"+ currentSide +".png"));
                break;
            default:
        }

    }

    public ImageView weaponHit(int weaponHit) {
        return monsterHealth.hit(weaponHit);
    }
}
