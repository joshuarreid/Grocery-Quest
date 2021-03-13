package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**The Player Class
 *
 * The Player class is responsible for creating a Player object
 * and holding his/her attributes
 *
 * Health - the amount of health the player has
 * Money - the amount of currency the player has
 * Name - The chosen name for the player
 * WeaponInUse - the chosen weapon for the player
 */
public class Player {
    private int health;
    private int money;
    private ImageView healthBar;
    private ImageView moneyBar;
    private final String name; //name cannot be changed later
    private String weaponInUse; //weapon info as a string for now
    private ImageView playerImage;
//    private PlayerMovement playerMovement;

    /**The Player Constructor
     *
     * @param health the amount of health the player has
     * @param money the amount of currency the player has
     * @param name The chosen name for the player
     * @param weaponInUse the chosen weapon for the player
     */
    public Player(int health, int money, String name,
                  String weaponInUse,Board board, int difficultyLevel) {
        this.weaponInUse = weaponInUse;
        this.health = health;
        this.money = money;
        this.name = name;
//        this.playerMovement = new PlayerMovement(board);
        switch (weaponInUse) {
            case "wipe crossbow":
                playerImage = new ImageView(new Image("file:resources/pngs/CrossbowGrandmaRight.png"));
                break;
            case "disinfectant spray":
                playerImage = new ImageView(new Image("file:resources/pngs/SprayGrandmaRight.png"));
                break;
            case "thermometer sword":
                playerImage = new ImageView(new Image("file:resources/pngs/SwordGrandmaRight.png"));
                break;
            default:
                break;
        }
        playerImage.setFitWidth(60);
        playerImage.setFitHeight(60);
        playerImage.setId("player");

        //Sets the coin and health bars
        switch (difficultyLevel) {
            case 1: //Easy: 4(full) hearts + 4 magic coins
                healthBar = new ImageView(new Image("file:resources/pngs/GQHealthMoneyBars-09.png"));
                moneyBar = new ImageView((new Image("file:resources/pngs/GQHealthMoneyBars-10.png")));
                break;
            case 2: //Medium: 2 hearts + 2 magic coins
                healthBar = new ImageView(new Image("file:resources/pngs/GQHealthMoneyBars-05.png"));
                moneyBar = new ImageView((new Image("file:resources/pngs/GQHealthMoneyBars-06.png")));
                break;
            case 3: //Hard: 1 heart + 1 magic coin
                healthBar = new ImageView(new Image("file:resources/pngs/GQHealthMoneyBars-03.png"));
                moneyBar = new ImageView((new Image("file:resources/pngs/GQHealthMoneyBars-04.png")));
                break;
            default:
        }
        //Basically CSS
        moneyBar.setFitWidth(225);
        moneyBar.setFitHeight(37.5);
        healthBar.setFitWidth(225);
        healthBar.setFitHeight(37.5);
    }

//    public Player() {
//        this(100,
//                100,
//                "player",
//                "wipe crossbow",
//                new Board(18,18, false),
//                1 );
//    }

    //getters for all attributes
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public ImageView getHealthBar() {
        return healthBar;
    }

    public ImageView getMoneyBar() {
        return moneyBar;
    }

    public String getWeaponInUse() {
        return weaponInUse;
    }

    public ImageView getPlayerImage(){
        return playerImage;
    }

    //setters for all attributes
    public void setHealth(int newHealth) {
        if ((newHealth < 0) || (newHealth > 100)) {
            throw new IllegalArgumentException("Health values can only between 0 "
                    + "and 100, inclusive");
        }
        health = newHealth;
    }

    public void setMoney(int newMoney) {
        if (newMoney < 0) {
            throw new IllegalArgumentException("Money values can be negative");
        }
        money = newMoney;
    }

    public void setName(String givenName) {
        if ((givenName == null) || (givenName.isEmpty()) || (isWhiteSpaceOnly(givenName))) {
            throw new IllegalArgumentException("Name cannot be null, empty or whitespace only");
        }
    }

    public void changeWeapon(String weaponInUse){
        switch (weaponInUse) {
            case "wipe crossbow":
                this.playerImage = new ImageView(new Image("file:resources/pngs/CrossbowGrandmaRight.png"));
                break;
            case "disinfectant spray":
                this.playerImage = new ImageView(new Image("file:resources/pngs/SprayGrandmaRight.png"));
                break;
            case "thermometer sword":
                this.playerImage = new ImageView(new Image("file:resources/pngs/SwordGrandmaRight.png"));
                break;
            default:
                break;
        }
    }
    //private utility method to check if a string is all whitespace
    private boolean isWhiteSpaceOnly(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
