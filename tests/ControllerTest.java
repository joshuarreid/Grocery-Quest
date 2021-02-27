import controller.Controller;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;


public class ControllerTest extends ApplicationTest {
    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        controller = new Controller();
        controller.start(primaryStage);
    }
    @Test
    public void testPlay() {
        clickOn("#startButton");
        Assert.assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing all buttons and the TextField
     */
    public void testConfigScreen() {
        clickOn("#startButton");
        Assert.assertEquals("Configuration Screen", controller.getState());
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
        Assert.assertEquals("Configuration Screen", controller.getState());
        clickOn("#easyButton");
        clickOn("#thermometerSwordButton");
        clickOn("#readyButton");
        Assert.assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        Assert.assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing no input for weapon choice
     */
    public void testConfigScreen2() {
        clickOn("#startButton");
        Assert.assertEquals("Configuration Screen", controller.getState());
        clickOn("#nameField").write("Josh");
        clickOn("#easyButton");
        clickOn("#readyButton");
        Assert.assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        Assert.assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing no input for difficulty
     */
    public void testConfigScreen3() {
        clickOn("#startButton");
        Assert.assertEquals("Configuration Screen", controller.getState());
        clickOn("#nameField").write("Josh");
        clickOn("#thermometerSwordButton");
        clickOn("#readyButton");
        Assert.assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        Assert.assertEquals("Configuration Screen", controller.getState());
    }

    @Test
    /**
     * Testing invalid name
     */
    public void testConfigScreen4() {
        clickOn("#startButton");
        Assert.assertEquals("Configuration Screen", controller.getState());
        clickOn("#nameField").write("      ");
        clickOn("#thermometerSwordButton");
        clickOn("#easyButton");
        clickOn("#readyButton");
        Assert.assertEquals("Error Screen", controller.getState());
        clickOn("OK");
        Assert.assertEquals("Configuration Screen", controller.getState());
    }

}
