import controller.Controller;
import controller.LevelController;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import model.Level;
import model.Statistics;
import org.omg.CORBA.TIMEOUT;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class challengeTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    /**
     * Testing Entrance to challenge room 1
     *
     */
    public void testChallengeEntrance1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Challenge Entrance");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        completeLevelTwo();

        //Moving to challenge room Entrance
        int stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Challenge 1", controller.getState());
    }

    @Test
    /**
     * Testing accept button to challenge room
     *
     */
    public void testAcceptChallenge() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Challenge Acceptance");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        completeLevelTwo();

        //Moving to challenge room Entrance
        int stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        clickOn("#acceptButton");
        assertEquals("Challenge 1", controller.getState());

    }

    @Test
    /**
     * Testing decline button to challenge room
     *
     */
    public void testDeclineChallenge() throws InterruptedException {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Challenge Decline");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        completeLevelTwo();

        //Moving to challenge room Entrance
        int stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        clickOn("#declineButton");
        assertEquals("Level 3", controller.getState());
    }

    @Test
    /**
     * Testing an attempt to exit the challenge room without completion
     * of the challenge
     *
     */
    public void testChallengeExit1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Challenge Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        completeLevelTwo();

        //Moving to challenge room Entrance
        int stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        clickOn("#acceptButton");
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Challenge 1", controller.getState());
    }

    @Test
    /**
     * Testing exit to challenge room after completing
     * the challenge
     *
     */
    public void testChallengeExit2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Challenge Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        completeLevelTwo();

        //Moving to challenge room Entrance
        int stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        clickOn("#acceptButton");

        completeChallenge1();
        assertEquals(controller.getState(), "Level 3");
    }

    @Test
    /**
     * Testing going back to challenge room after already
     * completing it
     *
     */
    public void testChallengeReEntry() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Challenge Reentry");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        completeLevelTwo();

        //Moving to challenge room Entrance
        int stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        clickOn("#acceptButton");

        completeChallenge1();
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals(controller.getState(), "Challenge 1");
    }


    /**
     *  Completes level 1
     */
    public void completeLevelOne() {
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


        //Attacking first Monster
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        //moving to second monster
        press(KeyCode.DOWN).release(KeyCode.DOWN);

        stepCounter = 1;
        while (stepCounter <= 5) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter += 1;
        }
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 13) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter += 1;
        }

        stepCounter = 1;
        while (stepCounter <= 7) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter += 1;
        }

        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);

        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 5) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter += 1;
        }
        stepCounter = 1;
        while (stepCounter <= 6) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter += 1;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);

    }

    /**
     * Completes level 2
     *
     */
    public void completeLevelTwo() {
        int stepCounter = 1;
        while (stepCounter <= 2) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        stepCounter = 1;
        while (stepCounter <= 7) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }

        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 11) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }

        press(KeyCode.UP).release(KeyCode.UP);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 4) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 2) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
    }

    /**
     * Completes first challenge room
     *
     */
    public void completeChallenge1() {
        int stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        press(KeyCode.LEFT).release(KeyCode.LEFT);
        stepCounter = 1;
        while (stepCounter <= 7) {
            press(KeyCode.DOWN).release(KeyCode.DOWN);
            stepCounter++;
        }
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        press(KeyCode.UP).release(KeyCode.UP);
        stepCounter = 1;
        while (stepCounter <= 7) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }

        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }

        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 6) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 4) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }

        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);
        press(KeyCode.Z).release(KeyCode.Z);

        stepCounter = 1;
        while (stepCounter <= 12) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 6) {
            press(KeyCode.DOWN).release(KeyCode.DOWN);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);

    }
}


