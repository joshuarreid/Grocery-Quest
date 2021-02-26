import controller.Level;
import org.junit.Assert;
import org.junit.Test;


/**
 * Tests for Level.java
 */
public class LevelTest {
    private Level level;


    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        Level level0 = new Level(0, 1);
        Level level9 = new Level(9, 1);
        Level difficulty5 = new Level(1, 5);
        Level difficulty0 = new Level(1, 0);
    }

    @Test
    public void testLevelOne() {
        level = new Level(1, 1);
        Assert.assertEquals(level.getLevelNumber(), 1);
        Assert.assertEquals(level.isStoreAvailable(), true);
        Assert.assertEquals(level.getNumberOfMobs(), 2);
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelTwo() {
        level = new Level(2, 1);
        Assert.assertEquals(level.getLevelNumber(), 2);
        Assert.assertEquals(level.isStoreAvailable(), true);
        Assert.assertEquals(level.getNumberOfMobs(), 4);
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelThree() {
        level = new Level(3, 1);
        Assert.assertEquals(level.getLevelNumber(), 3);
        Assert.assertEquals(level.isStoreAvailable(), false);
        Assert.assertEquals(level.getNumberOfMobs(), 7);
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelFour() {
        level = new Level(4, 1);
        Assert.assertEquals(level.getLevelNumber(), 4);
        Assert.assertEquals(level.isStoreAvailable(), true);
        Assert.assertEquals(level.getNumberOfMobs(), 7);
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelFive() {
        level = new Level(5, 1);
        Assert.assertEquals(level.getLevelNumber(), 5);
        Assert.assertEquals(level.isStoreAvailable(), false);
        Assert.assertEquals(level.getNumberOfMobs(), 8);
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelSix() {
        level = new Level(6, 1);
        Assert.assertEquals(level.getLevelNumber(), 6);
        Assert.assertEquals(level.isStoreAvailable(), true);
        Assert.assertEquals(level.getNumberOfMobs(),8 );
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelSeven() {
        level = new Level(7, 1);
        Assert.assertEquals(level.getLevelNumber(), 7);
        Assert.assertEquals(level.isStoreAvailable(), true);
        Assert.assertEquals(level.getNumberOfMobs(),9);
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

    @Test
    public void testLevelEight() {
        level = new Level(8, 1);
        Assert.assertEquals(level.getLevelNumber(), 8);
        Assert.assertEquals(level.isStoreAvailable(), false);
        Assert.assertEquals(level.getNumberOfMobs(),2);
        Assert.assertEquals(level.getMobList().size(), level.getNumberOfMobs());
    }

}
