import model.Level;
//import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for Level.java
 */
public class LevelTest {
    private Level level;

    //(expected = IllegalArgumentException.class)
    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            Level level0 = new Level(0, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Level level9 = new Level(9, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Level difficulty5 = new Level(1, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Level difficulty0 = new Level(1, 0);
        });
    }

    @Test
    public void testLevelOne() {
        level = new Level(1, 1);
        assertEquals(level.getLevelNumber(), 1);
        assertEquals(level.isStoreAvailable(), true);
        assertEquals(level.getNumberOfMobs(), 2);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelTwo() {
        level = new Level(2, 1);
        assertEquals(level.getLevelNumber(), 2);
        assertEquals(level.isStoreAvailable(), true);
        assertEquals(level.getNumberOfMobs(), 4);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelThree() {
        level = new Level(3, 1);
        assertEquals(level.getLevelNumber(), 3);
        assertEquals(level.isStoreAvailable(), false);
        assertEquals(level.getNumberOfMobs(), 7);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelFour() {
        level = new Level(4, 1);
        assertEquals(level.getLevelNumber(), 4);
        assertEquals(level.isStoreAvailable(), true);
        assertEquals(level.getNumberOfMobs(), 7);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelFive() {
        level = new Level(5, 1);
        assertEquals(level.getLevelNumber(), 5);
        assertEquals(level.isStoreAvailable(), false);
        assertEquals(level.getNumberOfMobs(), 8);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelSix() {
        level = new Level(6, 1);
        assertEquals(level.getLevelNumber(), 6);
        assertEquals(level.isStoreAvailable(), true);
        assertEquals(level.getNumberOfMobs(), 8);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelSeven() {
        level = new Level(7, 1);
        assertEquals(level.getLevelNumber(), 7);
        assertEquals(level.isStoreAvailable(), true);
        assertEquals(level.getNumberOfMobs(), 9);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelEight() {
        level = new Level(8, 1);
        assertEquals(level.getLevelNumber(), 8);
        assertEquals(level.isStoreAvailable(), false);
        assertEquals(level.getNumberOfMobs(), 2);
        assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

}
