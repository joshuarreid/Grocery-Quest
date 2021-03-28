package model;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Monster {
    private int health;
    private MonsterType monsterType;
    private ImageView monsterImage;
    private String currentSide;
    private ImageView healthBar; // potentially dont need
    private MonsterHealth monsterHealth;
    private int healthHitChange;
    private int row;
    private int col;
    private String id;
    private VBox monsterAndHealth;

    public Monster(MonsterType monsterType, String currentSide, int healthHitChange, int row, int col, String iD) {
        this.health = 5;
        this.monsterType = monsterType;
        this.currentSide = currentSide;
        this.healthHitChange = healthHitChange;
        this.monsterHealth = new MonsterHealth(4, this.healthHitChange, 30);
        this.row = row;
        this.col = col;
        this.id = iD;

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
                this.monsterImage = new ImageView(new Image("file:resources/pngs/CovidBossLarge.png"));
                break;
            case COVIDBOSSSMALL:
                this.monsterImage = new ImageView(new Image("file:resources/pngs/CovidBossSmall.png"));
                break;
            case TRUMP:
                //resources/pngs/TrumpDown.png
                this.monsterImage = new ImageView(new Image("file:resources/pngs/Trump"+ currentSide +".png"));
                break;
            default:
        }

        if(monsterType != MonsterType.COVIDBOSSLARGE) {
            this.monsterImage.setId(iD);
            this.monsterImage.setFitWidth(30);
            this.monsterImage.setFitHeight(30);
        } else {
            this.monsterImage.setId(iD);
            this.monsterImage.setFitWidth(140);
            this.monsterImage.setFitHeight(105);

        }

        monsterAndHealth = new VBox();
        monsterAndHealth.getChildren().addAll(monsterHealth.getCurrentHealthBar(), monsterImage);
        monsterAndHealth.setId(id);
        monsterAndHealth.setAlignment(Pos.CENTER);

    }

    public ImageView weaponHit(int weaponHit) {
        return monsterHealth.removeHealth(weaponHit);
    }

    public String getId() {
        return this.id;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public ImageView getMonsterImage() {
        return this.monsterImage;
    }

    public MonsterType getMonsterType() {
        return this.monsterType;
    }

    public VBox getMonsterAndHealth() {
        return monsterAndHealth;
    }

    public ImageView getHealthBar() {
        return monsterHealth.getCurrentHealthBar();
    }

    public MonsterHealth getMonsterHealth() {
        return monsterHealth;
    }

}
