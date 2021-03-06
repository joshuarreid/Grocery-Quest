import controller.Controller;
import controller.LevelController;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import model.HandSanitizer;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;

public class PotionTest extends ApplicationTest {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }


    @Test
    /**
     *
     * Testing that the health potion adds to player's health when
     * consumed (Soup)
     *
     */
    public void testHealthPotion1() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Health Potion");
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
        LevelController.getHero().getPlayerHealth().removeHealth(1);
        int health = LevelController.getHero().getPlayerHealth().getHealthLevel();
        press(KeyCode.C).release(KeyCode.C);
        press(KeyCode.X).release(KeyCode.X);
        assertNotEquals(health, LevelController.getHero().getPlayerHealth().getHealthLevel());
    }

    @Test
    /**
     *
     * Testing that the health potion adds to player's health when
     * consumed (ToiletPaper)
     *
     */
    public void testHealthPotion2() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Health Potion");
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

        press(KeyCode.SPACE).release(KeyCode.SPACE);
        LevelController.getHero().getPlayerHealth().removeHealth(1);
        int health = LevelController.getHero().getPlayerHealth().getHealthLevel();
        press(KeyCode.C).release(KeyCode.C);
        press(KeyCode.C).release(KeyCode.C);
        press(KeyCode.X).release(KeyCode.X);
        assertNotEquals(health, LevelController.getHero().getPlayerHealth().getHealthLevel());
    }

    @Test
    /**
     *
     * Testing that the attack potion adds to player's weapon's attack when
     * consumed
     *
     */
    public void testAttackPotion() {
        clickOn("#startButton");
        clickOn("#nameField").write("Testing Attack Potion");
        clickOn("#thermometerSwordButton");
        clickOn("#hardButton");
        clickOn("#readyButton");
        assertEquals("Game Screen", controller.getState());

        //creating hand sanitizer object
        HandSanitizer potion = new HandSanitizer(
                "HandSanitizer_1",
                0,
                0,
                true,
                1
        );

        //added hand sanitizer to inventory
        LevelController.getHero().getInventoryList().add(potion);


        int weaponDamage = LevelController.getHero().getWeapon().getDamage();
        press(KeyCode.C).release(KeyCode.C);
        press(KeyCode.X).release(KeyCode.X);
        assertNotEquals(weaponDamage, LevelController.getHero().getWeapon().getDamage());
    }




}