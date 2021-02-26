package controller;
import controller.AntiMasker;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

/**The Level Class
 *
 * levelNumber - what the current level is Ex. Level 1
 * numberOfMobs - The number of mobs that the current level has
 * storeAvailable - Whether the current level has a store available to the player
 * mobList - holds the mobs of the current level
 */
public class Level {
    private int difficulty;
    private int levelNumber;
    private int numberOfMobs;
    private boolean storeAvailable;
    private ArrayList<AntiMasker> mobList;




    /**
     *
     * @param level the current level
     */
    public Level(int level, int difficulty) {
        if (level <= 0 || level > 8) {
            throw new IllegalArgumentException("Level must be between 1 and 8");
        }
        if (difficulty < 1 || difficulty > 3) {
            throw new IllegalArgumentException("Difficulty must be between 1 and 3");
        }

        this.levelNumber =  level;
        this.difficulty = difficulty;


        //The level number determines the number of AntiMaskers
        if (level <= 2) {
            this.numberOfMobs = difficulty * level * 2;
        } else if (level > 2 && level < 8) {
            this.numberOfMobs = difficulty * ((level + 11) / 2);
        } else {
            this.numberOfMobs = difficulty * 2;
        }

        if (level == 8) {
            this.storeAvailable = false;
        } else if (level % 2 == 0 || level == 1 || level == 7) {
            this.storeAvailable = true;
        }

        /*
        Adds AntiMaskers to mobList which will
        be used for spawning in spawnMob()
         */
        mobList = new ArrayList<>(numberOfMobs);
        for (int i = 0; i < numberOfMobs; i++) {
            mobList.add(new AntiMasker());
        }

    }

    /**
     * Method spawns mobs into the level
     *
     * @param pane idk.. still reading the Plants V Zombie example
     * @param spawnLocation Coordinates to spawn the mob
     */
    public static void spawnMob(Pane pane, int spawnLocation) {
        return;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getNumberOfMobs() {
        return numberOfMobs;
    }

    public boolean isStoreAvailable() {
        return storeAvailable;
    }

    public ArrayList<AntiMasker> getMobList() {
        return mobList;
    }


}
