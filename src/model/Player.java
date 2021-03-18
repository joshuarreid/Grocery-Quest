package model;

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
    private ImageView healthBar;   // current player health bar
    private ImageView moneyBar;    // current player money bar
    private final String name;     // name cannot be changed later
    private String weaponInUse;    // weapon info as a string for now
    private ImageView playerImage; // current player imageview
    private String currentSide;    // side player is facing
    private PlayerMovement playerMovement;
    private PlayerMoney playerMoney;
    private PlayerHealth playerHealth;
    /**The Player Constructor
     *
     * @param health the amount of health the player has
     * @param money the amount of currency the player has
     * @param name The chosen name for the player
     * @param weaponInUse the chosen weapon for the player
     * @param difficultyLevel the chosen difficulty for the player
     */
    public Player(int health, int money, String name,
                  String weaponInUse, int difficultyLevel) {
        this.weaponInUse = weaponInUse;
        this.currentSide = "Right";
        this.health = health;
        this.money = money;
        this.name = name;
        this.playerMovement = new PlayerMovement(9, 17);
        setWeaponInUse(weaponInUse, currentSide);

        playerHealth = new PlayerHealth(difficultyLevel, 150);
        playerMoney = new PlayerMoney(difficultyLevel, 150);
    }

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

    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }

    public int[] getPlayerPosition() {
        int[] coordinates = new int[]{
                playerMovement.getXPosition(),
                playerMovement.getYPosition()
        };
        return coordinates;
    }

    public ImageView getHealthBar() {
        return playerHealth.getCurrentHealthBar();
    }

    public ImageView getMoneyBar() {
        return playerMoney.getCurrentMoneyBar();
    }

    public String getWeaponInUse() {
        return weaponInUse;
    }

    public ImageView getPlayerImage() {
        return playerImage;
    }

    public String getCurrentSide() {
        return currentSide;
    }

    //setters for all attributes
    //    public void setHealth(int newHealth) {
    //        if ((newHealth < 0) || (newHealth > 100)) {
    //            throw new IllegalArgumentException("Health values can only between 0 "
    //                    + "and 100, inclusive");
    //        }
    //        health = newHealth;
    //    }
    //
    //    public void setMoney(int newMoney) {
    //        if (newMoney < 0) {
    //            throw new IllegalArgumentException("Money values can be negative");
    //        }
    //        money = newMoney;
    //    }

    public void setName(String givenName) {
        if ((givenName == null) || (givenName.isEmpty()) || (isWhiteSpaceOnly(givenName))) {
            throw new IllegalArgumentException("Name cannot be null, empty or whitespace only");
        }
    }

    public void setCurrentSide(String currentSide) {
        this.currentSide = currentSide;
        setWeaponInUse(weaponInUse, currentSide);
    }

    public void setWeaponInUse(String weaponInUse, String side) {
        this.playerImage = new ImageView(
                new Image("file:resources/pngs/" + weaponInUse + "Grandma" + side + ".png"));
        playerImage.setFitWidth(35);
        playerImage.setFitHeight(35);
        playerImage.setId("player");
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
