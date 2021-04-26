import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;
import model.PlayerMovement;



public class ExitTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }


    @Test
    /**
     * Testing initial game screens top exit
     *
     */
    public void testInitialExit1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Top Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first exit
        int stepCounter = 1;


        //Saving position of player before Exit
        int initYPosition = PlayerMovement.getYPosition();
        int initXPosition = PlayerMovement.getXPosition();

        //Asserting the GameState changed and player has new position
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());
        assertNotEquals(initYPosition, PlayerMovement.getYPosition());
        assertEquals(initXPosition, PlayerMovement.getXPosition());
    }



    @Test
    /**
     *
     * Testing initial game screens right exit
     *
     */
    public void testInitialExit2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Right Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to right exit
        int stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        stepCounter = 1;
        while (stepCounter <= 10) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }

        //Saving position of player before Exit
        int initYPosition = PlayerMovement.getYPosition();
        int initXPosition = PlayerMovement.getXPosition();

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Training Screen", controller.getState());
        assertEquals(initYPosition, PlayerMovement.getYPosition());
        assertNotEquals(initXPosition, PlayerMovement.getXPosition());
    }

    @Test
    /**
     *
     * Testing initial game screens left exit
     *
     */
    public void testInitialExit3() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Left Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to right exit
        int stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        stepCounter = 1;
        while (stepCounter <= 10) {
            press(KeyCode.LEFT).release(KeyCode.LEFT);
            stepCounter++;
        }

        //Saving position of player before Exit
        int initYPosition = PlayerMovement.getYPosition();
        int initXPosition = PlayerMovement.getXPosition();

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Weapons Screen", controller.getState());
        assertEquals(initYPosition, PlayerMovement.getYPosition());
        assertNotEquals(initXPosition, PlayerMovement.getXPosition());
    }

    @Test
    /**
     * Testing initial game screens Bottom exit
     *
     */
    public void testInitialExit4() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Bottom Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");


        //Moving player to bottom exit
        int stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.DOWN).release(KeyCode.DOWN);
            stepCounter++;
        }
        assertEquals("Game Screen", controller.getState());
        press(KeyCode.SPACE).release(KeyCode.SPACE);

    }


    @Test
    /**
     * Testing top exit on Level 2
     *
     */
    public void testLevel2Exit() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Second Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        assertEquals("Level 2", controller.getState());
    }

    @Test
    /**
     * Testing top exit on Level 3
     *
     */
    public void testLevel3Exit() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Third Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

       completeLevelOne();
       completeLevelTwo();
        assertEquals("Level 3", controller.getState());
    }

    @Test
    /**
     * Testing revisiting exit on Level 1
     *
     */
    public void testRevisitLevel1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Third Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Moving player to first exit
        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());

        //Moving back
        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.DOWN).release(KeyCode.DOWN);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Game Screen", controller.getState());
    }

    @Test
    /**
     * Testing revisiting exit on Level 2
     *
     */
    public void testRevisitLevel2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Third Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        completeLevelOne();
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());
    }

    @Test
    /**
     * Testing revisiting exit on Level 3
     *
     */
    public void testRevisitLevel3() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Third Exit");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

       completeLevelOne();
       completeLevelTwo();
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 2", controller.getState());
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

}