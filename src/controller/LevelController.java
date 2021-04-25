package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import model.*;
import view.LevelScreen;
import view.WinScreen;
import view.LoseScreen;

import java.io.File;


/**
 * The LevelController Class
 * 
 * The LevelController Class is responsible for all actions that occur
 * on each level the player is on. This ranges from moving the player 
 * to player combat.  
 */
public class LevelController {
    private Stage mainWindow;
    private GameModel gameModel;
    private int difficultyLevel;
    private String weaponChoice;
    private final int width = 650;
    private final int height = 600;
    private static Player hero;
    private int currentDeterminant;
    private LevelSetup levelSetup;
    private Scene currentScene;
    private static Board currentBoard;
    private static LevelScreen currentLevelScreen;
    private AnimationTimer timer;
    private int currentSelectedItem;
    private ItemRandomizer itemRandomizer;

    private  MediaPlayer mediaPlayer;
    private double volume;

    private boolean gameScreenInitialEntrance;
    private boolean levelOneInitialEntrance;
    private boolean levelTwoInitialEntrance;
    private boolean levelThreeInitialEntrance;
    private boolean levelFourInitialEntrance;
    private boolean levelFiveInitialEntrance;
    private boolean levelSixInitialEntrance;
    private boolean levelSevenInitialEntrance;
    private boolean levelEightInitialEntrance;
    private boolean bossInitialEntrance;
    private boolean vaccineInitialEntrance;
    private boolean trainingInitialEntrance;
    private boolean weaponsInitialEntrance;

    private boolean firstChallengeInitialEntrance;
    private boolean secondChallengeInitialEntrance;
    private boolean thirdChallengeInitialEntrance;
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
                           String weaponChoice, Player hero, MediaPlayer mediaPlayer, Double volume) {
        this.mainWindow = mainWindow;
        this.gameModel = gameModel;
        this.difficultyLevel = difficultyLevel;
        this.weaponChoice = weaponChoice;
        this.hero = hero;
        this.currentDeterminant = 1;
        this.levelSetup = new LevelSetup(width, height, hero);
        this.currentSelectedItem = 0;
        this.itemRandomizer = new ItemRandomizer();

        gameScreenInitialEntrance = true;
        levelOneInitialEntrance = true;
        levelTwoInitialEntrance = true;
        levelThreeInitialEntrance = true;
        levelFourInitialEntrance = true;
        levelFiveInitialEntrance = true;
        levelSixInitialEntrance = true;
        levelSevenInitialEntrance = true;
        levelEightInitialEntrance = true;
        bossInitialEntrance = true;
        vaccineInitialEntrance = true;
        trainingInitialEntrance = true;
        weaponsInitialEntrance = true;

        firstChallengeInitialEntrance = true;
        secondChallengeInitialEntrance = true;
        thirdChallengeInitialEntrance = true;

        this.mediaPlayer = mediaPlayer;
        this.volume = volume;
        mediaPlayer.setVolume(volume);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleKeys(currentScene, hero, currentBoard);
                handleCombat(hero.getPlayerHealth());
            }
        };
    }

    /**
     * Displays Initial Game Screen
     */
    public void initialGameScreen() {
        timer.stop();
        gameModel.setState("Game Screen");
        currentScene = levelSetup.getGameScreen().getScene(gameScreenInitialEntrance);
        currentBoard = levelSetup.getGameScreen().getBoard();
        currentLevelScreen = levelSetup.getGameScreen();
        gameScreenInitialEntrance = (gameScreenInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Level One Screen
     */
    public void levelOneScreen() {
        timer.stop();

        mediaPlayer.stop();
        Media media = new Media(new File("resources/music/option1.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();

        gameModel.setState("Level 1");
        currentScene = levelSetup.getLevelOne().getScene(levelOneInitialEntrance);
        currentBoard = levelSetup.getLevelOne().getBoard();
        currentLevelScreen = levelSetup.getLevelOne();
        levelOneInitialEntrance = (levelOneInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);

    }

    /**
     * Displays Level Two Screen
     */
    public void levelTwoScreen() {
        timer.stop();
        gameModel.setState("Level 2");
        currentScene = levelSetup.getLevelTwo().getScene(levelTwoInitialEntrance);
        currentBoard = levelSetup.getLevelTwo().getBoard();
        currentLevelScreen = levelSetup.getLevelTwo();
        levelTwoInitialEntrance = (levelTwoInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Level Three Screen
     */
    public void levelThreeScreen() {
        timer.stop();
        gameModel.setState("Level 3");
        currentScene = levelSetup.getLevelThree().getScene(levelThreeInitialEntrance);
        currentBoard = levelSetup.getLevelThree().getBoard();
        currentLevelScreen = levelSetup.getLevelThree();
        levelThreeInitialEntrance = (levelThreeInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Level Four Screen
     */
    public void levelFourScreen() {
        timer.stop();
        gameModel.setState("Level 4");
        currentScene = levelSetup.getLevelFour().getScene(levelFourInitialEntrance);
        currentBoard = levelSetup.getLevelFour().getBoard();
        currentLevelScreen = levelSetup.getLevelFour();
        levelFourInitialEntrance = (levelFourInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Level Five Screen
     */
    public void levelFiveScreen() {
        timer.stop();

        mediaPlayer.stop();
        Media media = new Media(new File("resources/music/option2.mp3").toURI().toString());
        mediaPlayer.setVolume(volume);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        gameModel.setState("Level 5");
        currentScene = levelSetup.getLevelFive().getScene(levelFiveInitialEntrance);
        currentBoard = levelSetup.getLevelFive().getBoard();
        currentLevelScreen = levelSetup.getLevelFive();
        levelFiveInitialEntrance = (levelFiveInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Level Six Screen
     */
    public void levelSixScreen() {
        timer.stop();
        gameModel.setState("Level 6");
        currentScene = levelSetup.getLevelSix().getScene(levelSixInitialEntrance);
        currentBoard = levelSetup.getLevelSix().getBoard();
        currentLevelScreen = levelSetup.getLevelSix();
        levelSixInitialEntrance = (levelSixInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Level Seven Screen
     */
    public void levelSevenScreen() {
        timer.stop();
        gameModel.setState("Level 7");
        currentScene = levelSetup.getLevelSeven().getScene(levelSevenInitialEntrance);
        currentBoard = levelSetup.getLevelSeven().getBoard();
        currentLevelScreen = levelSetup.getLevelSeven();
        levelSevenInitialEntrance = (levelSevenInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Level Eight Screen
     */
    public void levelEightScreen() {
        timer.stop();
        gameModel.setState("Level 8");
        currentScene = levelSetup.getLevelEight().getScene(levelEightInitialEntrance);
        currentBoard = levelSetup.getLevelEight().getBoard();
        currentLevelScreen = levelSetup.getLevelEight();
        levelEightInitialEntrance = (levelEightInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Weapons Screen
     */
    public void weaponsScreen() {
        timer.stop();
        gameModel.setState("Weapons Screen");
        currentScene = levelSetup.getWeaponsScreen().getScene(weaponsInitialEntrance);
        currentBoard = levelSetup.getWeaponsScreen().getBoard();
        currentLevelScreen = levelSetup.getWeaponsScreen();
        weaponsInitialEntrance = (weaponsInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Training Screen
     */
    public void trainingScreen() {
        timer.stop();
        gameModel.setState("Training Screen");
        currentScene = levelSetup.getTrainingScreen().getScene(trainingInitialEntrance);
        currentBoard = levelSetup.getTrainingScreen().getBoard();
        currentLevelScreen = levelSetup.getTrainingScreen();
        trainingInitialEntrance = (trainingInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Boss Screen
     */
    public void bossScreen() {
        timer.stop();
        gameModel.setState("Boss Screen");
        currentScene = levelSetup.getBossScreen().getScene(bossInitialEntrance);
        currentBoard = levelSetup.getBossScreen().getBoard();
        currentLevelScreen = levelSetup.getBossScreen();
        bossInitialEntrance = (bossInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Displays Vaccine Screen
     */
    public void vaccineScreen() {
        timer.stop();
        gameModel.setState("Vaccine Screen");
        currentScene = levelSetup.getVaccineScreen().getScene(vaccineInitialEntrance);
        currentBoard = levelSetup.getVaccineScreen().getBoard();
        currentLevelScreen = levelSetup.getVaccineScreen();
        vaccineInitialEntrance = (vaccineInitialEntrance ? false : false);
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Launches and provides event handling for the Win Screen
     */
    private void winScreen() {
        timer.stop();

        mediaPlayer.stop();
        Media media = new Media(new File("resources/music/win.mp3").toURI().toString());
        mediaPlayer.setVolume(volume);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        gameModel.setState("Win Screen");
        WinScreen screen = new WinScreen(width, height);
        Button replayButton = screen.getReplayButton();
        replayButton.setOnAction(e -> {
            try {
                mediaPlayer.stop();
                Controller newGame = new Controller();
                newGame.start(mainWindow);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button exitButton = screen.getExitButton();
        exitButton.setOnAction(e -> {
            System.exit(0);
        });
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
    }

    /**
     * Launches and provides event handling for the Lose Screen
     */
    private void loseScreen() {
        timer.stop();
        mediaPlayer.stop();
        Media media = new Media(new File("resources/music/ending.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();

        gameModel.setState("Lose Screen");
        LoseScreen screen = new LoseScreen(width, height);
        Button replayButton = screen.getReplayButton();
        replayButton.setOnAction(e -> {
            try {
                mediaPlayer.stop();
                Controller newGame = new Controller();
                newGame.start(mainWindow);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button exitButton = screen.getExitButton();
        exitButton.setOnAction(e -> {
            System.exit(0);
        });

        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
    }

    /**
     * Exits game on game screen
     */
    private void exitGame() {
        System.exit(0);
    }

    /**
     * Displays first challenge screen
     */
    public void firstChallengeScreen() {
        timer.stop();
        gameModel.setState("Challenge 1");
        currentScene = levelSetup.getFirstChallenge().getScene(firstChallengeInitialEntrance);
        if(levelSetup.getFirstChallenge().getState().compareTo("question") == 0){
            Button yes = levelSetup.getFirstChallenge().getAcceptButton();
            Button no = levelSetup.getFirstChallenge().getDeclineButton();
            yes.setOnAction(e -> {
                firstChallengeInitialEntrance = false;
                levelSetup.getFirstChallenge().setState("room");
                levelSetup.getFirstChallenge().getExit().setIsOpen(false);
                firstChallengeScreen();
            });
            mainWindow.setScene(currentScene);
            mainWindow.show();
            no.setOnAction(e -> {
                currentBoard.removeObject(
                        "player",
                        hero.getPlayerMovement().getYPosition(), 1,
                        hero.getPlayerMovement().getXPosition(), 1);
                currentBoard.onExit(hero, levelSetup.getFirstChallenge().getExit(),gameModel);
                levelThreeScreen();
            });
        } else {
            currentBoard = levelSetup.getFirstChallenge().getBoard();
            currentLevelScreen = levelSetup.getFirstChallenge();
            moveCharacter(mainWindow, currentScene, hero, currentBoard);
        }
    }

    /**
     * Displays first challenge screen
     */
    public void secondChallengeScreen() {
        timer.stop();
        gameModel.setState("Challenge 2");
        currentScene = levelSetup.getSecondChallenge().getScene(secondChallengeInitialEntrance);
        if(levelSetup.getSecondChallenge().getState().compareTo("question") == 0){
            Button yes = levelSetup.getSecondChallenge().getAcceptButton();
            Button no = levelSetup.getSecondChallenge().getDeclineButton();
            yes.setOnAction(e -> {
                secondChallengeInitialEntrance = false;
                levelSetup.getSecondChallenge().setState("room");
                levelSetup.getSecondChallenge().getExit().setIsOpen(false);
                secondChallengeScreen();
            });
            mainWindow.setScene(currentScene);
            mainWindow.show();
            no.setOnAction(e -> {
                currentBoard.removeObject(
                        "player",
                        hero.getPlayerMovement().getYPosition(), 1,
                        hero.getPlayerMovement().getXPosition(), 1);
                currentBoard.onExit(hero, levelSetup.getSecondChallenge().getExit(),gameModel);
                levelFiveScreen();
            });
        } else {
            currentBoard = levelSetup.getSecondChallenge().getBoard();
            currentLevelScreen = levelSetup.getSecondChallenge();
            moveCharacter(mainWindow, currentScene, hero, currentBoard);
        }
    }

    /**
     * Displays first challenge screen
     */
    public void thirdChallengeScreen() {
        timer.stop();
        gameModel.setState("Challenge 3");
        currentScene = levelSetup.getThirdChallenge().getScene(thirdChallengeInitialEntrance);
        if(levelSetup.getThirdChallenge().getState().compareTo("question") == 0){
            Button yes = levelSetup.getThirdChallenge().getAcceptButton();
            Button no = levelSetup.getThirdChallenge().getDeclineButton();
            yes.setOnAction(e -> {
                thirdChallengeInitialEntrance = false;
                levelSetup.getThirdChallenge().setState("room");
                levelSetup.getThirdChallenge().getExit().setIsOpen(false);
                thirdChallengeScreen();
            });
            mainWindow.setScene(currentScene);
            mainWindow.show();
            no.setOnAction(e -> {
                currentBoard.removeObject(
                        "player",
                        hero.getPlayerMovement().getYPosition(), 1,
                        hero.getPlayerMovement().getXPosition(), 1);
                currentBoard.onExit(hero, levelSetup.getThirdChallenge().getExit(),gameModel);
                levelSevenScreen();
            });
        } else {
            currentBoard = levelSetup.getThirdChallenge().getBoard();
            currentLevelScreen = levelSetup.getThirdChallenge();
            moveCharacter(mainWindow, currentScene, hero, currentBoard);
        }
    }

    /**
     * launches the appropriate next screen based of of exit and current state
     *
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
        case "Challenge 1":
            firstChallengeScreen();
            break;
        case "Challenge 2":
            secondChallengeScreen();
            break;
        case "Challenge 3":
            thirdChallengeScreen();
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
        mainWindow.setScene(scene);
        mainWindow.show();
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
            int deltaY = 0;
            int deltaX = 0;
            boolean[] randomItemChance = {false, false, true, true, true};
            int prob = (int) Math.round(Math.random() * (randomItemChance.length - 1));
            switch (event.getCode()) {
            case SPACE: //Go to next or previous level or pick up item
                if (board.onExit(hero) != null
                        && currentLevelScreen.getMonstersList().size() == 0) {
                    board.onExit(hero).setIsOpen(true);
                }
                if (board.onExit(hero) != null && board.onExit(hero).getIsOpen()) {
                    getNextLevel(board.onExit(hero, gameModel));
                }
                deltaY = hero.getPlayerMovement().getYPosition();
                deltaX = hero.getPlayerMovement().getXPosition();
                if (board.hasItem(deltaY, deltaX)) {
                    Collectable currItem = board.getItem(deltaY, deltaX);
                    hero.pickUpItem(currItem);
                    currItem.setCollected(true);
                    updateLevelScreen(true, null);
                }
                break;
            case UP: //Move up
                if (!hero.getCurrentSide().equals("up")) {
                    hero.setCurrentSide("up");
                }
                deltaY = hero.getPlayerMovement().getYPosition() - 1;
                deltaX = hero.getPlayerMovement().getXPosition();
                if (!board.isBlocked(deltaY, deltaX)) {
                    moveHeroBy(hero, 0, -1, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case DOWN: //Move down
                if (!hero.getCurrentSide().equals("down")) {
                    hero.setCurrentSide("down");
                }
                deltaY = hero.getPlayerMovement().getYPosition() + 1;
                deltaX = hero.getPlayerMovement().getXPosition();
                if (!board.isBlocked(deltaY, deltaX)) {
                    moveHeroBy(hero, 0, 1, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case LEFT: //Move left
                if (!hero.getCurrentSide().equals("left")) {
                    hero.setCurrentSide("left");
                }
                deltaY = hero.getPlayerMovement().getYPosition();
                deltaX = hero.getPlayerMovement().getXPosition() - 1;
                if (!board.isBlocked(deltaY, deltaX)) {
                    moveHeroBy(hero, -1, 0, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case RIGHT: //Move right
                if (!hero.getCurrentSide().equals("right")) {
                    hero.setCurrentSide("right");
                }
                deltaY = hero.getPlayerMovement().getYPosition();
                deltaX = hero.getPlayerMovement().getXPosition() + 1;
                if (!board.isBlocked(deltaY, deltaX)) {
                    moveHeroBy(hero, 1, 0, board);
                } else {
                    switchHeroSide(hero, board);
                }
                break;
            case Z: //Attack
                //Obtain id of monster
                String monsterId = checkMonster(board, hero);
                //If monster exists in front of the player
                if (monsterId != null) {
                    int length = currentLevelScreen.getMonstersList().size();
                    //Look for monster object using id in ArrayList
                    for (int i = 0; i < length; i++) {
                        Monster monster = currentLevelScreen.getMonstersList().get(i);
                        //If found
                        if (monsterId.equals(monster.getId())) {
                            //Deal damage to monster
                            monster.getMonsterHealth().removeHealth(hero.getWeapon().getDamage());
                            //If monster has no health
                            if (monster.getMonsterHealth().getHealthLevel() == 0) {
                                //Remove it from game
                                currentLevelScreen.getMonstersList().remove(i);
                                if (randomItemChance[prob]) {
                                    currentLevelScreen.getItems().add(
                                            itemRandomizer.randomItem(
                                                    monster.getRow(), monster.getCol())
                                    );
                                    prob = (int) Math.round(Math.random()
                                            * (randomItemChance.length - 1));
                                }
                            }
                            hero.getPlayerHealth().removeHealth(monster.getAttackDamage());
                            //System.out.println(hero.getPlayerHealth().getHealthLevel());
                            updateLevelScreen(false, monster); //Update all objects visually
                            break;
                        } //if
                    } //for

                } //if

                break;
            case X: //Use item
                hero.getInventoryList().get(currentSelectedItem).action(hero);
                if (hero.getInventoryList().get(currentSelectedItem).getQuantity() == 0) {
                    currentLevelScreen.getInventory()
                            .removeObject(hero.getInventoryList().get(currentSelectedItem));
                    hero.getInventoryList().remove(currentSelectedItem);
                    currentSelectedItem = (currentSelectedItem - 1)
                            % hero.getInventoryList().size();
                    hero.getInventoryList().get(currentSelectedItem).changeSelected(true);
                }
                switchHeroSide(hero, board);
                updateLevelScreen(false, null);
                break;
            case C: //next item
                hero.getInventoryList().get(currentSelectedItem).changeSelected(false);
                currentSelectedItem = (currentSelectedItem + 1) % hero.getInventoryList().size();
                hero.getInventoryList().get(currentSelectedItem).changeSelected(true);
                updateLevelScreen(false, null);
                break;
            default:
            } //switch
        }); //scene.setOnKeyPressed
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
                hero.getPlayerMovement().getYPosition(), 1,
                hero.getPlayerMovement().getXPosition(), 1);
        boolean worked = board.addObject(hero.getPlayerImage(),
                "player", false, y, 1, x, 1);
        if (worked) {
            hero.getPlayerMovement().setXPosition(x);
            hero.getPlayerMovement().setYPosition(y);
        }
    }

    /**
     * Switches hero side when not actually moving position
     *
     * @param hero current player
     * @param board current board
     */
    private void switchHeroSide(Player hero, Board board) {
        board.removeObject(
                "player",
                hero.getPlayerMovement().getYPosition(), 1,
                hero.getPlayerMovement().getXPosition(), 1);
        boolean worked = board.addObject(hero.getPlayerImage(),
                "player", false,
                hero.getPlayerMovement().getYPosition(), 1,
                hero.getPlayerMovement().getXPosition(), 1);
    }

    /**
     * Checks if the player has no health, in which case, the
     * player has lost the game
     *
     * @param playerHealth the current playerHealth object
     */
    private void handleCombat(PlayerHealth playerHealth) {
        if (playerHealth.getHealthLevel() == 0) {
            loseScreen();
        }
    }

    /**
     * Checks if there is a monster in front of the player
     *
     * @param board the current board
     * @param hero the hero
     * @return the monsterId of the monster in front of the player
     */
    private static String checkMonster(Board board, Player hero) {
        String monsterId = null;
        int row = hero.getPlayerPosition()[1]; //hero's row position
        int col = hero.getPlayerPosition()[0]; //hero's column position
        if (hero.getCurrentSide().equals("up")) { //Check up
            monsterId = board.getMonster(row - 1, col);
        } else if (hero.getCurrentSide().equals("right")) { //Check right
            monsterId = board.getMonster(row, col + 1);
        } else if (hero.getCurrentSide().equals("down")) { //Check down
            monsterId = board.getMonster(row + 1, col);
        } else if (hero.getCurrentSide().equals("left")) { //Check left
            monsterId = board.getMonster(row, col - 1);
        }
        return monsterId;
    }

    /**
     * Updates the current level screen if something needs to
     * change visually
     *
     * @param update if inventory needs to be updated
     * @param monster the monster the player is attacking
     */
    private void updateLevelScreen(boolean update, Monster monster) {
        timer.stop();
        if (monster != null) {
            currentLevelScreen.updateScene(update, monster);
        } else {
            currentLevelScreen.updateScene(update);
        }
        currentBoard = currentLevelScreen.getBoard();
        moveCharacter(mainWindow, currentScene, hero, currentBoard);
    }

    /**
     * Method used in MonsterTest.
     *
     * @return the nearby monster
     */
    public static Monster getNearbyMonster() {
        String monsterId = checkMonster(currentBoard, hero); //Obtain id of monster
        if (monsterId != null) { //If monster exists in front of the player
            int length = currentLevelScreen.getMonstersList().size();
            for (int i = 0; i < length; i++) { //Look for monster object using id in ArrayList
                Monster monster = currentLevelScreen.getMonstersList().get(i);
                if (monsterId.equals(monster.getId())) { //If found
                    return monster;
                }
            }
        }
        return null;
    }

    /**
     * Method used in MonsterTest.
     *
     * @return the hero
     */
    public static Player getHero() {
        return hero;
    }





}
