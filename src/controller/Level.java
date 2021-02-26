package sample;
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
    private int levelNumber;
    private int numberOfMobs;
    private boolean storeAvailable;
    private ArrayList<AntiMasker> mobList;



    /**
     *
     * @param level the current level
     */
    public Level(int level) {
        if (level <= 0 || level > 8) {
            throw new IllegalArgumentException("Level must be between 1 and 8");
        }
        this.levelNumber =  level;

        //The level number determines the number of AntiMaskers
        if (level <= 2) {
            this.numberOfMobs = level * 2;
        } else if (level > 2) {
            this.numberOfMobs = (level + 10) / 2;
        }

        /*Adds AntiMaskers to mobList which will
          be used for spawning in spawnMob()
         */
        for (int i = 0; i < numberOfMobs; i++) {
            mobList.add(new AntiMasker()); //TODO initiate AntiMasker object
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


}
