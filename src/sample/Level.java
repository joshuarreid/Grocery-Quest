package sample;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class Level {
    private int levelNumber;
    private int numberOfMobs;
    private boolean storeAvailable;
    private ArrayList<Integer> mobList;



    public Level(int level) {
        this.levelNumber =  level;

        if (level == 1) {
            this.numberOfMobs = 10;
        }

    }

    public static void spawnMob(Pane pane, int lane, int spawnLocation) {

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
