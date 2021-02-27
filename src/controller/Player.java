package controller;

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
class Player {
    private int health;
    private int money;
    private final String name; //name cannot be changed later
    private String weaponInUse; //weapon info as a string for now


    /**The Player Constructor
     *
     * @param health the amount of health the player has
     * @param money the amount of currency the player has
     * @param name The chosen name for the player
     * @param weaponInUse the chosen weapon for the player
     */
    public Player(int health, int money, String name, String weaponInUse) {
        this.weaponInUse = weaponInUse;
        this.health = health;
        this.money = money;
        this.name = name;
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

    public String getWeaponInUse() {
        return weaponInUse;
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
