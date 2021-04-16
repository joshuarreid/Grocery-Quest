package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
    private final String name;     // name cannot be changed later
    private ImageView playerImage; // current player imageview
    private String currentSide;    // side player is facing
    private PlayerMovement playerMovement;
    private PlayerMoney playerMoney;
    private PlayerHealth playerHealth;
    private Weapon weapon;
    private String weaponInUse;    // weapon info as a string for now
    /*
    inventory needs to be stored in player since player an object that's passed through each level
    and therefore does not need for inventory to be created again and again in each level.
     */
    private List<Collectable> inventoryList;

    /**
     * The Player Constructor
     *
     * @param name The chosen name for the player
     * @param weaponInUse the chosen weapon for the player
     * @param difficultyLevel the chosen difficulty for the player
     * @param inventoryList Player's item inventory
     */
    public Player(String name,
                  String weaponInUse, int difficultyLevel, List<Collectable> inventoryList) {
        this.weaponInUse = weaponInUse;
        this.currentSide = "right";
        this.name = name;
        this.playerMovement = new PlayerMovement(9, 17);
        this.inventoryList = inventoryList;
        this.weapon = new Weapon(this.weaponInUse + "_1", 0, 0, true);
        this.weapon.changeSelected(true);
        setWeaponInUse(this.weapon);
        this.pickUpItem(this.weapon);
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
    public List<Collectable> getInventoryList() {
        return inventoryList;
    }

    //to-do: Possible implementation for picking up multiple of the same item
    /**
     * Player picks up the item and adds the item to inventory list
     *
     * @param collectable the id of the item to pick up
     * @return true if added, false otherwise
     */
    public boolean pickUpItem(Collectable collectable) {
        String currItem = collectable.getId().substring(0, collectable.getId().indexOf("_"));
        AtomicBoolean inList = new AtomicBoolean(false);
        inventoryList.forEach((item) -> {
            String itemID = item.getId().substring(0, item.getId().indexOf("_"));
            if (itemID.compareTo(currItem) == 0) {
                item.setQuantity(item.getQuantity() + 1);
                inList.set(true);
            }
        });

        if (!inList.get()) {
            return inventoryList.add(collectable);
        } else {
            return inList.get();
        }
    }

    //to-do: If player can pick up multiple of the same item,
    //       then need to subtract from total number
    /**
     * Player uses item, and the item is removed from the inventory
     *
     * @param collectable the id of the item to use
     * @return true if removed, false otherwise
     */
    public boolean useItem(Collectable collectable) {
        return inventoryList.remove(collectable);
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
        setWeaponInUse(weapon);
    }

    /**
     *
     * @param weapon weapon the player must use
     */
    public void setWeaponInUse(Weapon weapon) {
        this.weapon = weapon;
        this.weaponInUse = weapon.getId().substring(0, weapon.getId().indexOf("_"));
        this.playerImage = new ImageView(
                new Image("file:resources/pngs/"
                        + this.weaponInUse
                        + "Grandma"
                        + this.currentSide
                        + ".png"));
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

    public Weapon getWeapon() {
        return this.weapon;
    }
}
