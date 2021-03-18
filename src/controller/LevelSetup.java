package controller;

import model.ExitType;
import view.*;

public class LevelSetup {
    private LevelRandomizer levelRandomizer;

    //Exit bridges: screen1_screen2
    Exit intialGameScreen_weaponsScreen;
    Exit intialGameScreen_trainingScreen;
    Exit intialGameScreen_exitGame;
    Exit initialGameScreen_level1;

    Exit level1_level2;
    Exit level2_level3;
    Exit level3_level4;

    Exit level4_level5;
    Exit level5_level6;
    Exit level6_level7;
    Exit level7_level8;
    Exit level8_bossScreen;
    Exit bossScreen_vaccineScreen;
    Exit vaccineScreen_winScreen;

    // Arrays storing Exits for each screen
    Exit[] initialGameScreenExits;
    Exit[] levelOneScreenExits;
    Exit[] levelTwoScreenExits;
    Exit[] levelThreeScreenExits;
    Exit[] levelFourScreenExits;
    Exit[] levelFiveScreenExits;
    Exit[] levelSixScreenExits;
    Exit[] levelSevenScreenExits;
    Exit[] levelEightScreenExits;
    Exit[] weaponsScreenExits;
    Exit[] trainingScreenExits;
    Exit[] bossScreenExits;
    Exit[] vaccineScreenExits;

    //screens
    private LevelScreen gameScreen;
    private LevelScreen levelOne;
    private LevelScreen levelTwo;
    private LevelScreen levelThree;
    private LevelScreen levelFour;
    private LevelScreen levelFive;
    private LevelScreen levelSix;
    private LevelScreen levelSeven;
    private LevelScreen levelEight;
    private LevelScreen weaponsScreen;
    private LevelScreen trainingScreen;
    private LevelScreen bossScreen;
    private LevelScreen vaccineScreen;


    public LevelSetup(int width, int height, Player hero){

        this.levelRandomizer = new LevelRandomizer();

        //initialize all exits
        initialGameScreen_level1 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Game Screen", "Level 1");
        intialGameScreen_weaponsScreen = new Exit(ExitType.LEFT, ExitType.RIGHT,"Game Screen", "Weapons Screen");
        intialGameScreen_trainingScreen = new Exit(ExitType.RIGHT, ExitType.LEFT,"Game Screen", "Training Screen");
        intialGameScreen_exitGame = new Exit(ExitType.BOTTOM, ExitType.TOP,"Game Screen", "Exit Game");
        level1_level2 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 1", "Level 2");
        level2_level3 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 2", "Level 3");
        level3_level4 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 3", "Level 4");
        level4_level5 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 4", "Level 5");
        level5_level6 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 5", "Level 6");
        level6_level7 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 6", "Level 7");
        level7_level8 = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 7", "Level 8");
        level8_bossScreen = new Exit(ExitType.TOP, ExitType.BOTTOM,"Level 8", "Boss Screen");
        bossScreen_vaccineScreen = new Exit(ExitType.TOP, ExitType.BOTTOM,"Boss Screen", "Vaccine Screen");
        vaccineScreen_winScreen = new Exit(ExitType.TOP, ExitType.BOTTOM,"Vaccine Screen", "Win Screen");
        //initialize all exit arrays
        initialGameScreenExits = new Exit[]{
                initialGameScreen_level1,
                intialGameScreen_weaponsScreen,
                intialGameScreen_trainingScreen,
                intialGameScreen_exitGame};
        levelOneScreenExits = new Exit[]{initialGameScreen_level1, level1_level2};
        levelTwoScreenExits = new Exit[]{level1_level2, level2_level3};
        levelThreeScreenExits = new Exit[]{level2_level3, level3_level4};
        levelFourScreenExits = new Exit[]{level3_level4, level4_level5};
        levelFiveScreenExits = new Exit[]{level4_level5, level5_level6};
        levelSixScreenExits = new Exit[]{level5_level6, level6_level7};
        levelSevenScreenExits = new Exit[]{level6_level7, level7_level8};
        levelEightScreenExits = new Exit[]{level7_level8, level8_bossScreen};
        weaponsScreenExits = new Exit[]{intialGameScreen_weaponsScreen};
        trainingScreenExits = new Exit[]{intialGameScreen_trainingScreen};
        bossScreenExits = new Exit[]{level8_bossScreen, bossScreen_vaccineScreen};
        vaccineScreenExits = new Exit[]{bossScreen_vaccineScreen, vaccineScreen_winScreen};


        //initialize all screens
        gameScreen = new GameScreen(width, height, hero, levelRandomizer, initialGameScreenExits);
        levelOne = new LevelOneScreen(width, height, hero, levelRandomizer, levelOneScreenExits);
        levelTwo = new LevelTwoScreen(width, height, hero, levelRandomizer, levelTwoScreenExits);
        levelThree = new LevelThreeScreen(width, height, hero, levelRandomizer, levelThreeScreenExits);
        levelFour = new LevelFourScreen(width, height, hero, levelRandomizer, levelFourScreenExits);
        levelFive = new LevelFiveScreen(width, height, hero, levelRandomizer, levelFiveScreenExits);
        levelSix = new LevelSixScreen(width, height, hero, levelRandomizer, levelSixScreenExits);
        levelSeven = new LevelSevenScreen(width, height, hero, levelRandomizer, levelSevenScreenExits);
        levelEight = new LevelEightScreen(width, height, hero, levelRandomizer, levelEightScreenExits);
        weaponsScreen = new WeaponsScreen(width, height, hero, levelRandomizer, weaponsScreenExits);
        trainingScreen = new TrainingScreen(width, height, hero, levelRandomizer,trainingScreenExits);
        bossScreen = new BossScreen(width, height, hero, levelRandomizer,bossScreenExits);
        vaccineScreen = new VaccineScreen(width, height, hero, levelRandomizer,vaccineScreenExits);
    }

    public LevelScreen getGameScreen() {
        return gameScreen;
    }

    public LevelScreen getLevelOne() {
        return levelOne;
    }

    public LevelScreen getLevelTwo() {
        return levelTwo;
    }

    public LevelScreen getLevelThree() {
        return levelThree;
    }

    public LevelScreen getLevelFour() {
        return levelFour;
    }

    public LevelScreen getLevelFive() {
        return levelFive;
    }

    public LevelScreen getLevelSix() {
        return levelSix;
    }

    public LevelScreen getLevelSeven() {
        return levelSeven;
    }

    public LevelScreen getLevelEight() {
        return levelEight;
    }

    public LevelScreen getWeaponsScreen() {
        return weaponsScreen;
    }

    public LevelScreen getTrainingScreen() {
        return trainingScreen;
    }

    public LevelScreen getBossScreen() {
        return bossScreen;
    }

    public LevelScreen getVaccineScreen() {
        return vaccineScreen;
    }
}