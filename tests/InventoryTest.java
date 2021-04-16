import controller.Controller;
import controller.LevelController;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import model.HandSanitizer;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;

public class InventoryTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    /**
     *
     * Testing that the player spawns with an inventory containing
     * the players weapon (Thermometer Sword)
     *
     */
    public void testInitialInventory1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing initial inventory");
        clickOn("#thermometerSwordButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        assertEquals(LevelController.getHero()
                .getInventoryList().get(0).getId(), "ThermometerSword_1");
        assertEquals(LevelController.getHero()
                .getInventoryList().size(), 1);
    }

    @Test
    /**
     *
     * Testing that the player spawns with an inventory containing
     * the players weapon (Disinfectant Spray)
     *
     */
    public void testInitialInventory2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing initial inventory");
        clickOn("#disinfectantSprayButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());
        assertEquals(LevelController.getHero()
                .getInventoryList().get(0).getId(), "DisinfectantSpray_1");
        assertEquals(LevelController.getHero()
                .getInventoryList().size(), 1);
    }

    @Test
    /**
     *
     * Testing that the player spawns with an inventory containing
     * the players weapon (wipe Crossbow)
     *
     */
    public void testInitialInventory3() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing initial inventory");
        clickOn("#wipeCrossbowButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        assertEquals(LevelController.getHero().getInventoryList().get(0).getId(), "WipeCrossbow_1");
        assertEquals(LevelController.getHero().getInventoryList().size(), 1);
    }


    @Test
    /**
     *
     * Testing that the player can pick up items and add them to inventory
     *
     */
    public void testAddToInventory1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing add to inventory");
        clickOn("#thermometerSwordButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 2) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }

        assertEquals(LevelController.getHero().getInventoryList().size(), 1);
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals(LevelController.getHero().getInventoryList().size(), 2);
        assertEquals(LevelController.getHero().getInventoryList().get(1).getId(), "CannedSoup_1");
    }

    @Test
    /**
     *
     * Testing that the player can pick up items and add them to inventory
     * (multiple items)
     *
     */
    public void testAddToInventory2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing add to inventory");
        clickOn("#thermometerSwordButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 2) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        stepCounter = 1;
        while (stepCounter <= 9) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 3) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }


        assertEquals(LevelController.getHero().getInventoryList().size(), 2);
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        assertEquals(LevelController.getHero().getInventoryList().size(), 3);
        assertEquals(LevelController.getHero().getInventoryList().get(2).getId(), "ToiletPaper_1");
    }

    @Test
    /**
     *
     * Testing that same items stack in inventory
     *
     */
    public void testAddToInventory3() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing add to inventory");
        clickOn("#thermometerSwordButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        HandSanitizer potion = new HandSanitizer(
                "HandSanitizer_1",
                0,
                0,
                true,
                1
        );

        LevelController.getHero().getInventoryList().add(potion);
        LevelController.getHero().getInventoryList().add(potion);
        assertEquals(LevelController.getHero().getInventoryList().size(), 3);
    }


    @Test
    /**
     *
     * Testing that the player can consume/remove items from
     * inventory
     *
     */
    public void testRemoveFromInventory() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing remove from inventory");
        clickOn("#thermometerSwordButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        int stepCounter = 1;
        while (stepCounter <= 18) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        press(KeyCode.SPACE).release(KeyCode.SPACE);
        stepCounter = 1;
        while (stepCounter <= 8) {
            press(KeyCode.UP).release(KeyCode.UP);
            stepCounter++;
        }
        stepCounter = 1;
        while (stepCounter <= 2) {
            press(KeyCode.RIGHT).release(KeyCode.RIGHT);
            stepCounter++;
        }


        press(KeyCode.SPACE).release(KeyCode.SPACE);
        press(KeyCode.C).release(KeyCode.C);
        press(KeyCode.X).release(KeyCode.X);
        assertEquals(LevelController.getHero().getInventoryList().size(), 1);
    }





}