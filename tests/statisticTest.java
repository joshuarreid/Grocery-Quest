import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import model.Statistics;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;

public class statisticTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    /**
     * Tests to see if after killing a monster, the stat class
     * adds the kill to the counter
     *
     */
    public void testMonsterCount1() {
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

        assertEquals(Statistics.getAntimaskers(), 1);
    }

    @Test
    /**
     * Tests to see if adding items to inventory increments
     * the item counter
     *
     */
    public void testItemCount1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Item Count");
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


        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals(Statistics.getItems(), 1);
    }

    @Test
    /**
     * Tests to see if using items in inventory doesn't
     * affect item counter
     *
     */
    public void testItemCount2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Item Count");
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


        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        press(KeyCode.C).release(KeyCode.C);
        press(KeyCode.X).release(KeyCode.X);
        assertEquals(Statistics.getItems(), 1);
    }

    @Test
    /**
     * Tests to see if timer is properly running
     *
     */
    public void testTimer() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Timer");
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

        assertNotNull(Statistics.getTimeElapsed());
    }
}

