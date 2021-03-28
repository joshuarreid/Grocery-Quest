package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.*;
import view.LevelScreen;
import view.WinScreen;
import view.LoseScreen;

public class LevelController {
    private Stage mainWindow;
    private GameModel gameModel;
    private int difficultyLevel;
    private String weaponChoice;
    private final int width = 600;
    private final int height = 600;
    private Player hero;
    private int currentDeterminant;
    private LevelSetup levelSetup;
    private Scene currentScene;
    private Board currentBoard;
    private LevelScreen currentLevelScreen;
    private AnimationTimer timer;

    /**
     * Level Controller constructor
     *
     * @param mainWindow main stage
     * @param gameModel current gameModel
     * @param difficultyLevel current difficulty level
     * @param weaponChoice current weapon choice
     * @param hero current Player
     */
    public LevelController(Stage mainWindow, GameModel gameModel, int difficultyLevel,
                           String weaponChoice, Player hero) {
        this.mainWindow = mainWindow;
        this.gameModel = gameModel;
        this.difficultyLevel = difficultyLevel;
        this.weaponChoice = weaponChoice;
        this.hero = hero;
        this.currentDeterminant = 1;
        this.levelSetup = new LevelSetup(width, height, hero);
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleKeys(currentScene, hero, currentBoard);
                handleCombat(hero.getPlayerHealth());
            }
        };
    }

    //TODO: make initial game screen specifically for replaying game after lose screen, redirect to config screen

    /**
     * Method displays initial game screen
     */
    public void initialGameScreen() {
        timer.stop();
        gameModel.setState("Game Screen");
        currentScene = levelSetup.getGameScreen().getScene();
        currentBoard = levelSetup.getGameScreen().getBoard();
        currentLevelScreen = levelSetup.getGameScreen();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays level one screen
     */
    public void levelOneScreen() {
        timer.stop();
        gameModel.setState("Level 1");
        currentScene = levelSetup.getLevelOne().getScene();
        currentBoard = levelSetup.getLevelOne().getBoard();
        currentLevelScreen = levelSetup.getLevelOne();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);

    }

    /**
     * Method displays level two screen
     */
    public void levelTwoScreen() {
        timer.stop();
        gameModel.setState("Level 2");
        currentScene = levelSetup.getLevelTwo().getScene();
        currentBoard = levelSetup.getLevelTwo().getBoard();
        currentLevelScreen = levelSetup.getLevelTwo();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays level three screen
     */
    public void levelThreeScreen() {
        timer.stop();
        gameModel.setState("Level 3");
        currentScene = levelSetup.getLevelThree().getScene();
        currentBoard = levelSetup.getLevelThree().getBoard();
        currentLevelScreen = levelSetup.getLevelThree();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays level four screen
     */
    public void levelFourScreen() {
        timer.stop();
        gameModel.setState("Level 4");
        currentScene = levelSetup.getLevelFour().getScene();
        currentBoard = levelSetup.getLevelFour().getBoard();
        currentLevelScreen = levelSetup.getLevelFour();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays level five screen
     */
    public void levelFiveScreen() {
        timer.stop();
        gameModel.setState("Level 5");
        currentScene = levelSetup.getLevelFive().getScene();
        currentBoard = levelSetup.getLevelFive().getBoard();
        currentLevelScreen = levelSetup.getLevelFive();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays level six screen
     */
    public void levelSixScreen() {
        timer.stop();
        gameModel.setState("Level 6");
        currentScene = levelSetup.getLevelSix().getScene();
        currentBoard = levelSetup.getLevelSix().getBoard();
        currentLevelScreen = levelSetup.getLevelSix();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays level seven screen
     */
    public void levelSevenScreen() {
        timer.stop();
        gameModel.setState("Level 7");
        currentScene = levelSetup.getLevelSeven().getScene();
        currentBoard = levelSetup.getLevelSeven().getBoard();
        currentLevelScreen = levelSetup.getLevelSeven();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays level eight screen
     */
    public void levelEightScreen() {
        timer.stop();
        gameModel.setState("Level 8");
        currentScene = levelSetup.getLevelEight().getScene();
        currentBoard = levelSetup.getLevelEight().getBoard();
        currentLevelScreen = levelSetup.getLevelEight();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays weapons screen
     */
    public void weaponsScreen() {
        timer.stop();
        gameModel.setState("Weapons Screen");
        currentScene = levelSetup.getWeaponsScreen().getScene();
        currentBoard = levelSetup.getWeaponsScreen().getBoard();
        currentLevelScreen = levelSetup.getWeaponsScreen();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays training screen
     */
    public void trainingScreen() {
        timer.stop();
        gameModel.setState("Training Screen");
        currentScene = levelSetup.getTrainingScreen().getScene();
        currentBoard = levelSetup.getTrainingScreen().getBoard();
        currentLevelScreen = levelSetup.getTrainingScreen();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays boss screen
     */
    public void bossScreen() {
        timer.stop();
        gameModel.setState("Boss Screen");
        currentScene = levelSetup.getBossScreen().getScene();
        currentBoard = levelSetup.getBossScreen().getBoard();
        currentLevelScreen = levelSetup.getBossScreen();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method displays vaccine screen
     */
    public void vaccineScreen() {
        timer.stop();
        gameModel.setState("Vaccine Screen");
        currentScene = levelSetup.getVaccineScreen().getScene();
        currentBoard = levelSetup.getVaccineScreen().getBoard();
        currentLevelScreen = levelSetup.getVaccineScreen();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * This method launches and provides event handling for
     * the Win Screen
     */
    private void winScreen() {
        timer.stop();
        gameModel.setState("Win Screen");
        WinScreen screen = new WinScreen(width, height);
        Button replayButton = screen.getReplayButton();
        replayButton.setOnAction(e -> {
            initialGameScreen();
        });
        Button exitButton = screen.getExitButton();
        exitButton.setOnAction(e -> {
            System.exit(0);
        });
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
    }

    /**
     * This method launches and provides event handling for
     * the Lose Screen
     */
    private void loseScreen() {
        timer.stop();
        gameModel.setState("Lose Screen");
        LoseScreen screen = new LoseScreen(width, height);
        Button replayButton = screen.getReplayButton();
        replayButton.setOnAction(e -> {
            initialGameScreen();
        });
        Button exitButton = screen.getExitButton();
        exitButton.setOnAction(e -> {
            System.exit(0);
        });
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
    }

    //TODO clarify what is going on here. New entry: Is this a joke? It exits the game. -Josh
    /**
     * Method exits game
     */
    private void exitGame() {
        timer.stop();
        gameModel.setState("Lose Screen");
        System.exit(0);
    }

    /**
     * launches the appropriate next screen based of of exit and current state
     * @param exit exit that is being used
     */
    private void getNextLevel(Exit exit) {
        switch (exit.getAdjacentState(gameModel)) {
        case "Game Screen":
            initialGameScreen();
            break;
        case "Level 1":
            levelOneScreen();
            break;
        case "Level 2":
            levelTwoScreen();
            break;
        case "Level 3":
            levelThreeScreen();
            break;
        case "Level 4":
            levelFourScreen();
            break;
        case "Level 5":
            levelFiveScreen();
            break;
        case "Level 6":
            levelSixScreen();
            break;
        case "Level 7":
            levelSevenScreen();
            break;
        case "Level 8":
            levelEightScreen();
            break;
        case "Weapons Screen":
            weaponsScreen();
            break;
        case "Training Screen":
            trainingScreen();
            break;
        case "Boss Screen":
            bossScreen();
            break;
        case "Vaccine Screen":
            vaccineScreen();
            break;
        case "Win Screen":
            winScreen();
            break;
        case "Exit Game":
            exitGame();
            break;

        default:
        }
    }


    //Player movement ----------------------------------------------------------------------
    /**
     * Moves a Player's location on a given board depending on arrow key events
     *
     * @param mainWindow main Stage
     * @param scene current Scene
     * @param hero current Player
     * @param board current Board
     */
    public void moveCharacter(Stage mainWindow, Scene scene, Player hero, Board board) {
        System.out.println(gameModel.getState());
        mainWindow.setScene(scene);
        timer.start();

    }

    /**
     * Method that handles arrow key events and their indicated player movement.
     * Also updates the side the player is facing
     *
     * @param scene current Scene
     * @param hero current Player
     * @param board current Board
     */
    private void handleKeys(Scene scene, Player hero, Board board) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
            case SPACE:
                if (board.onExit(hero) != null && board.onExit(hero).getIsOpen() == true) {
                    getNextLevel(board.onExit(hero, gameModel));
                }
                break;
            case UP:
                if (!hero.getCurrentSide().equals("up")) {
                    hero.setCurrentSide("up");
                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition() - 1,
                        hero.getPlayerMovement().getXPosition())) {
                    moveHeroBy(hero, 0, -1, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case DOWN:
                if (!hero.getCurrentSide().equals("down")) {
                    hero.setCurrentSide("down");
                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition() + 1,
                        hero.getPlayerMovement().getXPosition())) {
                    moveHeroBy(hero, 0, 1, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case LEFT:
                if (!hero.getCurrentSide().equals("left")) {
                    hero.setCurrentSide("left");
                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition(),
                        hero.getPlayerMovement().getXPosition() - 1)) {
                    moveHeroBy(hero, -1, 0, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case RIGHT:
                if (!hero.getCurrentSide().equals("right")) {
                    hero.setCurrentSide("right");
                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition(),
                        hero.getPlayerMovement().getXPosition() + 1)) {
                    moveHeroBy(hero, 1, 0, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case Z:
                String monsterId = checkMonster(board, hero);
                System.out.println("Hello world");
                if (monsterId != null) {
                    int length = currentLevelScreen.getMonstersList().size();
                    for (int i = 0; i < length; i++) {
                        Monster monster = currentLevelScreen.getMonstersList().get(i);
                        if (monsterId.equals(monster.getId())) {
                            System.out.println("Before: " + monster.getMonsterHealth().getHealthLevel());
                            monster.getMonsterHealth().removeHealth(1);
                            System.out.println("After: " + monster.getMonsterHealth().getHealthLevel());
                            updateLevelScreen();
                            break;
                        }
                    }
                    //obtain Monster array
                    //search for monster using loop
                    //deal damage to that monster
                    //board.getMonster(monsterId).removeHealth(weaponPower);
                    //currentLevelScreen.
                }
                break;
            default:
            }
        });
    }

    /**
     * Calculates position change of the player
     *
     * @param hero current Player
     * @param dx position change in x direction
     * @param dy position change in y direction
     * @param board current Board
     */
    private void moveHeroBy(Player hero, int dx, int dy, Board board) {
        if (dx == 0 && dy == 0) {
            return;
        }
        int x = hero.getPlayerMovement().getXPosition() + dx;
        int y = hero.getPlayerMovement().getYPosition() + dy;
        moveHeroTo(hero, x, y, board);
    }

    /**
     * Updates player location by:
     * 1. removing player from current location
     * 2. adding player to new location
     * 3. if adding player to new location is successful,
     *    current location is updated
     *
     * @param hero current Player
     * @param x tentative new x or col location
     * @param y tentative new y or row location
     * @param board current Board
     */
    private void moveHeroTo(Player hero, int x, int y, Board board) {
        board.removeObject(
                "player",
                hero.getPlayerMovement().getXPosition(),
                hero.getPlayerMovement().getYPosition());
        boolean worked = board.addObject(hero.getPlayerImage(),
                "player", false, y, 0, x, 0);
        if (worked) {
            hero.getPlayerMovement().setxPosition(x);
            hero.getPlayerMovement().setyPosition(y);
        }
    }

    /**
     *  switches hero side when not actually moving position
     * @param hero current player
     * @param board current board
     */
    private void switchHeroSide(Player hero, Board board){
        board.removeObject(
                "player",
                hero.getPlayerMovement().getXPosition(),
                hero.getPlayerMovement().getYPosition());
        boolean worked = board.addObject(hero.getPlayerImage(),
                "player", false,
                hero.getPlayerMovement().getYPosition(), 0,
                hero.getPlayerMovement().getXPosition(), 0);
    }

    private void handleCombat(PlayerHealth playerHealth) { //}, PlayerMoney playerMoney) {
        if (playerHealth.getPlayerHealthLevel() == 0) {
            loseScreen();
        }
    }

    private String checkMonster(Board board, Player hero) {
        String monsterId = null;
        int row = hero.getPlayerPosition()[1];
        int col = hero.getPlayerPosition()[0];
        if (hero.getCurrentSide().equals("up")) {
            monsterId = board.getMonster(row - 1, col);
        } else if (hero.getCurrentSide().equals("right")) {
            monsterId = board.getMonster(row, col + 1);
        } else if (hero.getCurrentSide().equals("down")) {
            monsterId = board.getMonster(row + 1, col);
        } else if (hero.getCurrentSide().equals("left")) {
            monsterId = board.getMonster(row, col - 1);
        }
        return monsterId;
    }

    private void updateLevelScreen() {
        currentLevelScreen.updateScene();
        currentBoard = currentLevelScreen.getBoard();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }


}
