package controller;//Basic player class

class Player {
    private int health;
    private int money;
    private final String name; //name cannot be changed later
    private String weaponInUse; //weapon info as a string for now

    //constructor
    public Player(int health, int money, String name, String weaponInUse) {
        this.weaponInUse = weaponInUse;
        this.health = health;
        this.money = money;
        this.name = name;
    }

    //getters for all attributes
    public String getName() { return name; }

    public int getHealth() { return health; }

    public int getMoney() { return money; }

    public String getWeaponInUse() { return weaponInUse; }

    //setters for all attributes
    public void setHealth(int newHealth) {
        if ((newHealth < 0) || (newHealth > 100)) {
            throw new IllegalArgumentException("Health values can only between 0 and 100, inclusive");
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
