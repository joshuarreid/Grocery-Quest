import controller.Controller;
import controller.LevelController;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import model.Monster;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;
import model.PlayerMovement;

import java.util.concurrent.TimeUnit;


public class MonsterTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    /**
     * Testing ability to retreat
     *
     */
    public void testRetreat() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Retreat");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        //Returning to previous room
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        TimeUnit.SECONDS.sleep(1);
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Game Screen", controller.getState());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    /**
     * Testing Exit locks
     *
     */
    public void testExitLocks() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Exit Lock");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);

        //Moving to top exit
        stepCounter = 1;
        while (stepCounter <= 7) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        stepCounter = 1;
        while (stepCounter <= 11) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    /**
     * Testing Monster Spawn
     *
     */
    public void testMonsterSpawn()  {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Monster Spawn");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        //Moving player to monster
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        assertNotNull(LevelController.getNearbyMonster());
    }

    @Test
    /**
     * Testing Attacking a Monster
     *
     */
    public void testAttackingMonster() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Attack");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        //Moving player to monster
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        //Getting monsters health
        Monster monster = LevelController.getNearbyMonster();
        int monsterHealth = monster.getMonsterHealth().getHealthLevel();

        //Attacking Monster
        press(KeyCode.Z).release(KeyCode.Z);
        assertTrue(monsterHealth > monster.getMonsterHealth().getHealthLevel());
        TimeUnit.SECONDS.sleep(1);

    }

    @Test
    /**
     * Testing Monster's HP Bar
     *
     */
    public void testMonsterHPBar() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing HP Bar");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        //Moving player to monster
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        //Getting monsters health
        Monster monster = LevelController.getNearbyMonster();
        ImageView healthBar = monster.getHealthBar();

        //Attacking Monster
        press(KeyCode.Z).release(KeyCode.Z);
        assertNotEquals(healthBar, monster.getHealthBar());
        TimeUnit.SECONDS.sleep(1);

    }

    @Test
    /**
     * Testing Monster Attack
     *
     */
    public void testMonsterAttack() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Player Death");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        //Moving player to monster
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        //Awaiting Implementation of Monster Attack
    }



    @Test
    /**
     * Testing that monster disappears after death
     *
     */
    public void testMonsterDeath() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Monster Death");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        //Moving player to monster
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }


        //Attacking Monster
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        assertNull(LevelController.getNearbyMonster());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    /**
     * Testing Player Death
     *
     */
    public void testPlayerDeath() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Player Death");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first Level
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        //Moving player to monster
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        TimeUnit.SECONDS.sleep(1);
        LevelController.getHero().getPlayerHealth().setHealthLevel(0);
        TimeUnit.SECONDS.sleep(2);
        assertNotEquals("Game Screen", controller.getState());
    }
}