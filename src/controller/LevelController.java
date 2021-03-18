package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.GameModel;
import view.LevelScreen;

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
    private Scene currentScene;
    private Board currentBoard;
    private AnimationTimer timer;

    public LevelController(Stage mainWindow, GameModel gameModel, int difficultyLevel, String weaponChoice, Player hero) {
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
            }
        };
    }

    public void initialGameScreen() {
        timer.stop();
        gameModel.setState("Game Screen");
        currentScene = levelSetup.getGameScreen().getScene();
        currentBoard = levelSetup.getGameScreen().getBoard();
//        Scene scene = levelSetup.getGameScreen().getScene();
//        scene.setOnKeyPressed(event -> {
//            System.out.println("space pressed");
//            if (event.getCode() == KeyCode.SPACE) {
//                if (levelSetup.getGameScreen().getBoard().onExit(hero) != null) {
//                    getNextLevel(levelSetup.getGameScreen().getBoard().onExit(hero));
//                }
//            }
//
//        });
//        hero.getPlayerMovement().moveCharacter(mainWindow, currentScene, hero, currentBoard);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    public void levelOneScreen() {
        timer.stop();
        gameModel.setState("Level 1");
        currentScene = levelSetup.getLevelOne().getScene();
        currentBoard = levelSetup.getLevelOne().getBoard();
//        Scene scene = levelSetup.getLevelOne().getScene();
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.SPACE) {
//                if (levelSetup.getLevelOne().getBoard().onExit(hero) != null) {
//                    getNextLevel(levelSetup.getLevelOne().getBoard().onExit(hero));
//                }
//            }
//
//        });
//        hero.getPlayerMovement().moveCharacter(mainWindow, scene, hero, levelSetup.getGameScreen().getBoard());
        moveCharacter(mainWindow, currentScene, hero, currentBoard);

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







    ///// Player movement
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
//        mainWindow.show();

//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                handleKeys(scene, hero, board);
//            }
//        };
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
                    System.out.println("spacey boi");
                    if (board.onExit(hero) != null) {
                        getNextLevel(board.onExit(hero));
                    }
                    break;
                case UP:
                    if (!board.isBlocked(hero.getPlayerMovement().getYPosition() - 1, hero.getPlayerMovement().getXPosition())) {
                        if (!hero.getCurrentSide().equals("Up")) {
                            hero.setCurrentSide("Up");
                        }
                        moveHeroBy(hero, 0, -1, board);
                    }
                    break;
                case DOWN:
                    if (!board.isBlocked(hero.getPlayerMovement().getYPosition() + 1, hero.getPlayerMovement().getXPosition())) {
                        if (!hero.getCurrentSide().equals("Down")) {
                            hero.setCurrentSide("Down");
                        }
                        moveHeroBy(hero, 0, 1, board);
                    }
                    break;
                case LEFT:
                    if (!board.isBlocked(hero.getPlayerMovement().getYPosition(), hero.getPlayerMovement().getXPosition() - 1)) {
                        if (!hero.getCurrentSide().equals("Left")) {
                            hero.setCurrentSide("Left");
                        }
                        moveHeroBy(hero, -1, 0, board);
                    }
                    break;
                case RIGHT:
                    if (!board.isBlocked(hero.getPlayerMovement().getYPosition(), hero.getPlayerMovement().getXPosition() + 1)) {
                        if (!hero.getCurrentSide().equals("Right")) {
                            hero.setCurrentSide("Right");
                        }
                        moveHeroBy(hero, 1, 0, board);
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
        System.out.println(board.removeObject("player", hero.getPlayerMovement().getXPosition(), hero.getPlayerMovement().getYPosition()));
        boolean worked = board.addObject(hero.getPlayerImage(),
                "player", false, y, 0, x, 0);
        if (worked) {
//            xPosition = x;
//            yPosition = y;
            hero.getPlayerMovement().setxPosition(x);
            hero.getPlayerMovement().setyPosition(y);
        }
    }


}
