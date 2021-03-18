package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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
        scene.setOnKeyPressed(event -> {
            System.out.println("space pressed");
            if (event.getCode() == KeyCode.SPACE) {
                if (levelSetup.getGameScreen().getBoard().onExit(hero) != null) {
                    getNextLevel(levelSetup.getGameScreen().getBoard().onExit(hero));
                }
            }

        });
        hero.getPlayerMovement().moveCharacter(mainWindow, scene, hero, levelSetup.getGameScreen().getBoard());
    }

    public void levelOneScreen() {
        gameModel.setState("Level 1");
        Scene scene = levelSetup.getLevelOne().getScene();
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                if (levelSetup.getLevelOne().getBoard().onExit(hero) != null) {
                    getNextLevel(levelSetup.getLevelOne().getBoard().onExit(hero));
                }
            }

        });
        hero.getPlayerMovement().moveCharacter(mainWindow, scene, hero, levelSetup.getGameScreen().getBoard());

    }

    private void getNextLevel(Exit exit) {
        switch(exit.getAdjacentState(gameModel)) {
            case "Game Screen":
                initialGameScreen();
                break;

            case "Level 1":
                levelOneScreen();
                break;

            default:
        }
    }


}
