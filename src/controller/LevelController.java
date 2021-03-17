package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GameModel;

public class LevelController {
    private Stage mainWindow;
    private GameModel gameModel;
    private int difficultyLevel;
    private String weaponChoice;
    private final int width = 600;
    private final int height = 600;
    private Player hero;
    private int currentDeterminant;
    LevelSetup levelSetup;

    public LevelController(Stage mainWindow, GameModel gameModel, int difficultyLevel, String weaponChoice, Player hero) {
        this.mainWindow = mainWindow;
        this.gameModel = gameModel;
        this.difficultyLevel = difficultyLevel;
        this.weaponChoice = weaponChoice;
        this.hero = hero;
        this.currentDeterminant = 1;
        this.levelSetup = new LevelSetup(width, height, hero);
    }

    public void initialGameScreen() {
        gameModel.setState("Game Screen");
        Scene scene = levelSetup.getGameScreen().getScene();
        hero.getPlayerMovement().moveCharacter(mainWindow, scene, hero, levelSetup.getGameScreen().getBoard());
    }


}
