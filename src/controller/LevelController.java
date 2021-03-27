package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Board;
import model.GameModel;
import model.LevelSetup;
import model.Player;
import model.Exit;
import model.PlayerHealth;
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

    //TODO clarify what is going on here
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
//                if (!hero.getCurrentSide().equals("Up")) {
//                    hero.setCurrentSide("Up");
//                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition() - 1,
                        hero.getPlayerMovement().getXPosition())) {
                    if (!hero.getCurrentSide().equals("Up")) {
                        hero.setCurrentSide("Up");
                    }
                    moveHeroBy(hero, 0, -1, board);
                } else {
//                    System.out.println("up up up");
//                    moveHeroBy(hero, 0, 0, board);
//                    switchHeroSide(hero, board);
                }
                break;
            case DOWN:
//                if (!hero.getCurrentSide().equals("Down")) {
//                    hero.setCurrentSide("Down");
//                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition() + 1,
                        hero.getPlayerMovement().getXPosition())) {
                    if (!hero.getCurrentSide().equals("Down")) {
                        hero.setCurrentSide("Down");
                    }
                    moveHeroBy(hero, 0, 1, board);
                } else {
//                    moveHeroBy(hero, 0, 0, board);
//                    switchHeroSide(hero, board);
                }
                break;
            case LEFT:
//                if (!hero.getCurrentSide().equals("Left")) {
//                    hero.setCurrentSide("Left");
//                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition(),
                        hero.getPlayerMovement().getXPosition() - 1)) {
                    if (!hero.getCurrentSide().equals("Left")) {
                        hero.setCurrentSide("Left");
                    }
                    moveHeroBy(hero, -1, 0, board);
                } else {
//                    moveHeroBy(hero, 0, 0, board);
//                    switchHeroSide(hero, board);
                }
                break;
            case RIGHT:
//                if (!hero.getCurrentSide().equals("Right")) {
//                    hero.setCurrentSide("Right");
//                }
                if (!board.isBlocked(
                        hero.getPlayerMovement().getYPosition(),
                        hero.getPlayerMovement().getXPosition() + 1)) {
                    if (!hero.getCurrentSide().equals("Right")) {
                        hero.setCurrentSide("Right");
                    }
                    moveHeroBy(hero, 1, 0, board);
                } else {
//                    moveHeroBy(hero, 0, 0, board);
//                    switchHeroSide(hero, board);
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

//    /**
//     *  switches hero side when not actually moving position
//     * @param hero current player
//     * @param board current board
//     */
//    private void switchHeroSide(Player hero, Board board){
//        board.removeObject(
//                "player",
//                hero.getPlayerMovement().getXPosition(),
//                hero.getPlayerMovement().getYPosition());
//        boolean worked = board.addObject(hero.getPlayerImage(),
//                "player", false,
//                hero.getPlayerMovement().getYPosition(), 0,
//                hero.getPlayerMovement().getXPosition(), 0);
//    }

    private void handleCombat(PlayerHealth playerHealth) { //}, PlayerMoney playerMoney) {
        if (playerHealth.getPlayerHealthLevel() == 0) {
            loseScreen();
        }
    }

    private void updateLevelScreen() {
        currentScene = levelSetup.getGameScreen().updateScene();
        currentBoard = levelSetup.getGameScreen().getBoard();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }


}
