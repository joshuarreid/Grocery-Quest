package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

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
    /*
    inventory needs to be stored in player since player an object that's passed through each level and therefore does
    not need for inventory to be created again and again in each level.
     */
    private List<String> inventoryList;

    /**
     * The Player Constructor
     *
     * @param health the amount of health the player has
     * @param money the amount of currency the player has
     * @param name The chosen name for the player
     * @param weaponInUse the chosen weapon for the player
     * @param difficultyLevel the chosen difficulty for the player
     */
    public Player(int health, int money, String name,
                  String weaponInUse, int difficultyLevel, List<String> inventoryList) {
        this.weaponInUse = weaponInUse;
        this.currentSide = "right";
        this.health = health;
        this.money = money;
        this.name = name;
        this.playerMovement = new PlayerMovement(9, 17);
        setWeaponInUse(weaponInUse, currentSide);
        this.inventoryList = inventoryList;

        playerHealth = new PlayerHealth(difficultyLevel, 150);
        playerMoney = new PlayerMoney(difficultyLevel, 150);
    }

    /**
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return playerMovement object
     */
    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }

    /**
     *
     * @return the player's position as an array
     */
    public int[] getPlayerPosition() {
        int[] coordinates = new int[]{
                playerMovement.getXPosition(),
                playerMovement.getYPosition()
        };
        return coordinates;
    }

    /**
     *
     * @return the player's inventory list
     */
    public List<String> getInventoryList() {
        return inventoryList;
    }

    //TODO: Possible implementation for picking up multiple of the same item
    /**
     * Player picks up the item and adds the item to inventory list
     *
     * @param id the id of the item to pick up
     * @return true if added, false otherwise
     */
    public boolean pickUpItem(String id) {
        return inventoryList.add(id);
    }

    //TODO: If player can pick up multiple of the same item, then need to subtract from total number
    /**
     * Player uses item, and the item is removed from the inventory
     *
     * @param id the id of the item to use
     * @return true if removed, false otherwise
     */
    public boolean useItem(String id) {
        return inventoryList.remove(id);
    }

    /**
     *
     * @return the player's current healthbar imageview
     */
    public ImageView getHealthBar() {
        return playerHealth.getCurrentHealthBar();
    }

    /**
     *
     * @return playerHealth object
     */
    public PlayerHealth getPlayerHealth() {
        return playerHealth;
    }

    /**
     *
     * @return the player's current moneyBar imageview
     */
    public ImageView getMoneyBar() {
        return playerMoney.getCurrentMoneyBar();
    }

    /**
     *
     * @return the player's weapon
     */
    public String getWeaponInUse() {
        return weaponInUse;
    }

    /**
     *
     * @return the player's imageview
     */
    public ImageView getPlayerImage() {
        return playerImage;
    }

    /**
     *
     * @return the direction in which the player is facing
     */
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

    /**
     *
     * @param givenName name to set
     */
    public void setName(String givenName) {
        if ((givenName == null) || (givenName.isEmpty()) || (isWhiteSpaceOnly(givenName))) {
            throw new IllegalArgumentException("Name cannot be null, empty or whitespace only");
        }
    }

    /**
     *
     * @param currentSide direction the player should face
     */
    public void setCurrentSide(String currentSide) {
        this.currentSide = currentSide;
        setWeaponInUse(weaponInUse, currentSide);
    }

    /**
     *
     * @param weaponInUse weapon the player must use
     * @param side direction the player should face
     */
    public void setWeaponInUse(String weaponInUse, String side) {
        this.playerImage = new ImageView(
                new Image("file:resources/pngs/" + weaponInUse + "Grandma" + side + ".png"));
        playerImage.setFitWidth(35);
        playerImage.setFitHeight(35);
        playerImage.setId("player");
    }

    /**
     * Private utility method to check if a string is all whitespace
     *
     * @param str string to check
     * @return true if string is whitespace, otherwise false
     */
    private boolean isWhiteSpaceOnly(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
