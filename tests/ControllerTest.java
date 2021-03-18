import controller.Controller;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;
import model.PlayerMovement;



public class ControllerTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }
    @Test
    public void testPlay() {
        clickOn("#startButton");
        assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing all buttons and the TextField
     */
    public void testConfigScreen() {
        assertEquals("Start Screen", controller.getState());
        clickOn("#startButton");
        assertEquals("Configuration Screen", controller.getState());
        clickOn("#nameField").write("Testing TextField");
        clickOn("#easyButton");
        clickOn("#mediumButton");
        clickOn("#hardButton");
        clickOn("#thermometerSwordButton");
        clickOn("#disinfectantSprayButton");
        clickOn("#wipeCrossbowButton");
        clickOn("#readyButton");
    }

    @Test
    /**
     * Testing no input for name
     */
    public void testConfigScreen1() {
        clickOn("#startButton");
        assertEquals("Configuration Screen", controller.getState());
        clickOn("#easyButton");
        clickOn("#thermometerSwordButton");
        clickOn("#readyButton");
        assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing no input for weapon choice
     */
    public void testConfigScreen2() {
        clickOn("#startButton");
        assertEquals("Configuration Screen", controller.getState());
        clickOn("#nameField").write("Testing No Weapon");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing no input for difficulty
     */
    public void testConfigScreen3() {
        clickOn("#startButton");
        assertEquals("Configuration Screen", controller.getState());
        clickOn("#nameField").write("Testing No Difficulty");
        clickOn("#thermometerSwordButton");
        clickOn("#readyButton");
        assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing invalid name
     */
    public void testConfigScreen4() {
        clickOn("#startButton");
        assertEquals("Configuration Screen", controller.getState());
        clickOn("#nameField").write("      ");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        assertEquals("Configuration Screen", controller.getState());
    }


    @Test
    /**
     * Testing moving player
     *
     */
    public void testPlayerMovement1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Player Movement");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //Saving initial position of player
        int initYPosition = PlayerMovement.getYPosition();
        int initXPosition = PlayerMovement.getXPosition();

        //Moving player up twice
        press(KeyCode.UP).release(KeyCode.UP);
        press(KeyCode.UP).release(KeyCode.UP);
        assertEquals(initYPosition, PlayerMovement.getYPosition() + 2);
        assertEquals(initXPosition, PlayerMovement.getXPosition());
        initYPosition = PlayerMovement.getYPosition();
        initXPosition = PlayerMovement.getXPosition();

        //Moving player to the left twice
        press(KeyCode.LEFT).release(KeyCode.LEFT);
        press(KeyCode.LEFT).release(KeyCode.LEFT);
        assertEquals(initYPosition, PlayerMovement.getYPosition());
        assertEquals(initXPosition, PlayerMovement.getXPosition() + 2);

        //Moving player to the right twice
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        assertEquals(initYPosition, PlayerMovement.getYPosition());
        assertEquals(initXPosition, PlayerMovement.getXPosition());

        //Moving player down twice
        press(KeyCode.DOWN).release(KeyCode.DOWN);
        press(KeyCode.DOWN).release(KeyCode.DOWN);
        assertEquals(initYPosition, PlayerMovement.getYPosition() - 2);
        assertEquals(initXPosition, PlayerMovement.getXPosition());
    }

    @Test
    /**
     * Testing collisions of player and objects
     *
     */
    public void testPlayerMovement2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Object Collision");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());


        //Moving player to a blocked location
        press(KeyCode.UP).release(KeyCode.UP);
        press(KeyCode.UP).release(KeyCode.UP);
        press(KeyCode.UP).release(KeyCode.UP);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);

        //Saving position of player before collision
        int initYPosition = PlayerMovement.getYPosition();
        int initXPosition = PlayerMovement.getXPosition();

        //Testing if location did not change after collision
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        assertEquals(initYPosition, PlayerMovement.getYPosition());
        assertEquals(initXPosition, PlayerMovement.getXPosition());
    }

    @Test
    /**
     * Testing collisions of player and walls
     *
     */
    public void testPlayerMovement3() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Wall Collision");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());


        //Moving player to a wall
        press(KeyCode.UP).release(KeyCode.UP);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);


        //Saving position of player before collision
        int initYPosition = PlayerMovement.getYPosition();
        int initXPosition = PlayerMovement.getXPosition();

        //Testing if location did not change after collision
        press(KeyCode.RIGHT).release(KeyCode.RIGHT);
        assertEquals(initYPosition, PlayerMovement.getYPosition());
        assertEquals(initXPosition, PlayerMovement.getXPosition());
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
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

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
        while(stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        stepCounter = 1;
        while(stepCounter <= 10) {
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
        while(stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        stepCounter = 1;
        while(stepCounter <= 10) {
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
        assertEquals("Game Screen", controller.getState());

        //Moving player to bottom exit
        int stepCounter = 1;
        while(stepCounter <= 3) {
            press(KeyCode.DOWN).release(KeyCode.DOWN);
            stepCounter++;
        }


        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Inside", controller.getState());
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

        //Moving player to first exit
        int stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());

        //Moving player to second exit
        stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
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

        //Moving player to first exit
        int stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());

        //Moving player to second exit
        stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 2", controller.getState());

        //Moving player to third exit
        stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
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
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());

        //Moving back
        stepCounter = 1;
        while(stepCounter <= 3) {
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

        //Moving player to first exit
        int stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());

        //Moving player to second exit
        stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 2", controller.getState());

        //Moving back
        stepCounter = 1;
        while(stepCounter <= 3) {
            press(KeyCode.DOWN).release(KeyCode.DOWN);
            stepCounter++;
        }
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

        //Moving player to first exit
        int stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 1", controller.getState());

        //Moving player to second exit
        stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 2", controller.getState());

        //Moving player to third exit
        stepCounter = 1;
        while(stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 3", controller.getState());

        //Moving back
        stepCounter = 1;
        while(stepCounter <= 3) {
            press(KeyCode.DOWN).release(KeyCode.DOWN);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals("Level 2", controller.getState());
    }
}
