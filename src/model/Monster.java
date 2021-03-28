package model;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * The Monster Class
 *
 * The Monster class is responsible for creating a Monster object
 * and holding its attributes
 */
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

    /**
     * The Monster Constructor
     *
     * @param monsterType the type of monster
     * @param currentSide the direction in which the monster is facing
     * @param healthHitChange how much the health should decrease when attacked
     * @param row the row position
     * @param col the column position
     * @param iD the id
     */
    public Monster(MonsterType monsterType, String currentSide, int healthHitChange, int row, int col, String iD) {
        this.health = 5;
        this.monsterType = monsterType;
        this.currentSide = currentSide;
        this.healthHitChange = healthHitChange;
        this.monsterHealth = new MonsterHealth(4, this.healthHitChange, 30);
        this.row = row;
        this.col = col;
        this.id = iD;

        switch (monsterType) {
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
            this.monsterImage = new ImageView(new Image("file:resources/pngs/Trump" + currentSide + ".png"));
            break;
        default:
        }

        if (monsterType != MonsterType.COVIDBOSSLARGE) {
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

    /**
     * Decreases the monter's health when attacked
     *
     * @param weaponHit damage of wepon
     * @return updated "decreased" health bar imageview
     */
    public ImageView weaponHit(int weaponHit) {
        return monsterHealth.removeHealth(weaponHit);
    }

    /**
     *
     * @return id of monster
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     * @return row location of monster
     */
    public int getRow() {
        return this.row;
    }

    /**
     *
     * @return column location of monster
     */
    public int getCol() {
        return this.col;
    }

    /**
     *
     * @return imageview of monster
     */
    public ImageView getMonsterImage() {
        return this.monsterImage;
    }

    /**
     *
     * @return type of monster
     */
    public MonsterType getMonsterType() {
        return this.monsterType;
    }

    /**
     *
     * @return VBox that contains the updated health bar imageview
     */
    public VBox getMonsterAndHealth() {
        monsterAndHealth = new VBox();
        monsterAndHealth.getChildren().addAll(monsterHealth.getCurrentHealthBar(), monsterImage);
        monsterAndHealth.setId(id);
        monsterAndHealth.setAlignment(Pos.CENTER);
        return monsterAndHealth;
    }

    /**
     *
     * @return monster's health bar object
     */
    public ImageView getHealthBar() {
        return monsterHealth.getCurrentHealthBar();
    }

    /**
     *
     * @return monster's health
     */
    public MonsterHealth getMonsterHealth() {
        return monsterHealth;
    }

}
