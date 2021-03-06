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

}
