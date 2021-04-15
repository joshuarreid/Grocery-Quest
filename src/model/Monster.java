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
    private boolean[] attackProbabilty;
    private int maxDamage;
    private boolean doIAttack;

    /**
     * The Monster Constructor
     *
     * @param monsterType the type of monster
     * @param currentSide the direction in which the monster is facing
     * @param healthHitChange how much the health should decrease when attacked
     * @param row the row position
     * @param col the column position
     * @param iD the id
     * @param level id of level monster is being placed in
     */
    public Monster(MonsterType monsterType, String currentSide, int healthHitChange,
                   int row, int col, String iD, String level) {
        this.health = 5;
        this.monsterType = monsterType;
        this.currentSide = currentSide;
        this.healthHitChange = healthHitChange;
        this.monsterHealth = new MonsterHealth(4, this.healthHitChange, 30);
        this.row = row;
        this.col = col;
        this.id = iD;
        this.doIAttack = false;

        this.attackProbabilty =
                new boolean[]{false, false, false, false, false, false, false, false, false, false};

        switch (level) {
        case "Training Screen":
            this.attackProbabilty[9] = true;
            this.maxDamage = 0;
            break;
        case"Level 1":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case "Level 2":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case"Level 3":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case "Level 4":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case "Level 5":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case"Level 6":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case "Level 7":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case"Level 8":
            this.attackProbabilty[9] = true;
            this.maxDamage = 1;
            break;
        case"Boss Screen":
            if (this.monsterType == MonsterType.COVIDBOSSLARGE) {
                this.attackProbabilty[9] = true;
                this.maxDamage = 1;
            } else {
                this.attackProbabilty[9] = true;
                this.maxDamage = 1;
            }
            break;
        default:
            this.maxDamage = 0;
        }

        switch (monsterType) {
        case FAANTIMASKER:
            this.monsterImage = new ImageView(
                    new Image("file:resources/pngs/FAntimasker" + currentSide + ".png"));
            break;
        case MAANTIMASKER:
            this.monsterImage = new ImageView(
                    new Image("file:resources/pngs/MAntimasker" + currentSide + ".png"));
            break;
        case COVIDBOSSLARGE:
            this.monsterImage = new ImageView(
                    new Image("file:resources/pngs/CovidBossLarge.png"));
            this.maxDamage++;
            break;
        case COVIDBOSSSMALL:
            this.monsterImage = new ImageView(
                    new Image("file:resources/pngs/CovidBossSmall.png"));
            break;
        case TRUMP:
            this.monsterImage = new ImageView(
                    new Image("file:resources/pngs/Trump" + currentSide + ".png"));
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

    public int getAttackDamage() {
        int prob = (int) Math.round(Math.random() * (9));
        System.out.println("index: " + prob);
        doIAttack = attackProbabilty[prob];
        if (!doIAttack) {
            return 0;
        } else {
            int num =  (int) Math.round(Math.random() * ((maxDamage)));
            System.out.println("not just a num: " + num);
            return num;
        }
    }

    public void setDoIAttack(boolean doIAttack) {
        this.doIAttack = doIAttack;
    }
}
