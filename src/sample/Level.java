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
    private ArrayList<Integer> mobList;


    /**
     *
     * @param level the current level
     */
    public Level(int level) {
        this.levelNumber =  level;

        if (level == 1) {
            this.numberOfMobs = 10;
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
