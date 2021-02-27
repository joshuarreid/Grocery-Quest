import controller.Controller;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;

import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.testfx.matcher.base.NodeMatchers;

public class ControllerTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }
    @Test
    public void testPlay() {
        System.out.println(controller.getState());
        clickOn("#startButton");
        System.out.println(controller.getState());
        assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing all buttons and the TextField
     */
    public void testConfigScreen() {
        clickOn("#startButton");
        assertEquals("Configuration Screen", controller.getState());
        clickOn("#easyButton");
        clickOn("#mediumButton");
        clickOn("#hardButton");
        clickOn("#thermometerSwordButton");
        clickOn("#disinfectantSprayButton");
        clickOn("#wipeCrossbowButton");
        clickOn("#nameField").write("Testing TextField");
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
        clickOn("#nameField").write("Josh");
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
        clickOn("#nameField").write("Josh");
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

}
