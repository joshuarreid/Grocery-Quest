package model;

import view.*;

public class LevelSetup {
    private LevelRandomizer levelRandomizer;

    //Exit bridges: screen1_screen2
    private Exit intialGameScreenWeaponsScreen;
    private Exit intialGameScreenTrainingScreen;
    private Exit intialGameScreenExitGame;
    private Exit initialGameScreenLevel1;

    private Exit level1Level2;
    private Exit level2Level3;
    private Exit level3Level4;

    private Exit level4Level5;
    private Exit level5Level6;
    private Exit level6Level7;
    private Exit level7Level8;
    private Exit level8BossScreen;
    private Exit bossScreenVaccineScreen;
    private Exit vaccineScreenWinScreen;

    // Arrays storing Exits for each screen
    private Exit[] initialGameScreenExits;
    private Exit[] levelOneScreenExits;
    private Exit[] levelTwoScreenExits;
    private Exit[] levelThreeScreenExits;
    private Exit[] levelFourScreenExits;
    private Exit[] levelFiveScreenExits;
    private Exit[] levelSixScreenExits;
    private Exit[] levelSevenScreenExits;
    private Exit[] levelEightScreenExits;
    private Exit[] weaponsScreenExits;
    private Exit[] trainingScreenExits;
    private Exit[] bossScreenExits;
    private Exit[] vaccineScreenExits;

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


    public LevelSetup(int width, int height, Player hero) {

        this.levelRandomizer = new LevelRandomizer();

        //initialize all exits
        initialGameScreenLevel1 =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Game Screen", "Level 1");
        intialGameScreenWeaponsScreen =
                new Exit(ExitType.LEFT, ExitType.RIGHT, "Game Screen", "Weapons Screen");
        intialGameScreenTrainingScreen =
                new Exit(ExitType.RIGHT, ExitType.LEFT, "Game Screen", "Training Screen");
        intialGameScreenExitGame =
                new Exit(ExitType.BOTTOM, ExitType.TOP, "Game Screen", "Exit Game");
        level1Level2 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 1", "Level 2");
        level2Level3 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 2", "Level 3");
        level3Level4 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 3", "Level 4");
        level4Level5 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 4", "Level 5");
        level5Level6 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 5", "Level 6");
        level6Level7 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 6", "Level 7");
        level7Level8 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 7", "Level 8");
        level8BossScreen = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 8", "Boss Screen");
        bossScreenVaccineScreen =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Boss Screen", "Vaccine Screen");
        vaccineScreenWinScreen =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Vaccine Screen", "Win Screen");
        //initialize all exit arrays
        initialGameScreenExits = new Exit[]{
            initialGameScreenLevel1,
            intialGameScreenWeaponsScreen,
            intialGameScreenTrainingScreen,
            intialGameScreenExitGame};
        levelOneScreenExits = new Exit[]{initialGameScreenLevel1, level1Level2};
        levelTwoScreenExits = new Exit[]{level1Level2, level2Level3};
        levelThreeScreenExits = new Exit[]{level2Level3, level3Level4};
        levelFourScreenExits = new Exit[]{level3Level4, level4Level5};
        levelFiveScreenExits = new Exit[]{level4Level5,  level5Level6};
        levelSixScreenExits = new Exit[]{level5Level6, level6Level7};
        levelSevenScreenExits = new Exit[]{level6Level7, level7Level8};
        levelEightScreenExits = new Exit[]{level7Level8, level8BossScreen};
        weaponsScreenExits = new Exit[]{intialGameScreenWeaponsScreen};
        trainingScreenExits = new Exit[]{intialGameScreenTrainingScreen};
        bossScreenExits = new Exit[]{level8BossScreen, bossScreenVaccineScreen};
        vaccineScreenExits = new Exit[]{bossScreenVaccineScreen, vaccineScreenWinScreen};


        //initialize all screens
        gameScreen = new GameScreen(width, height, hero, levelRandomizer, initialGameScreenExits);
        levelOne = new LevelOneScreen(width, height, hero, levelRandomizer, levelOneScreenExits);
        levelTwo = new LevelTwoScreen(width, height, hero, levelRandomizer, levelTwoScreenExits);
        levelThree =
                new LevelThreeScreen(width, height, hero, levelRandomizer, levelThreeScreenExits);
        levelFour = new LevelFourScreen(width, height, hero, levelRandomizer, levelFourScreenExits);
        levelFive = new LevelFiveScreen(width, height, hero, levelRandomizer, levelFiveScreenExits);
        levelSix = new LevelSixScreen(width, height, hero, levelRandomizer, levelSixScreenExits);
        levelSeven =
                new LevelSevenScreen(width, height, hero, levelRandomizer, levelSevenScreenExits);
        levelEight =
                new LevelEightScreen(width, height, hero, levelRandomizer, levelEightScreenExits);
        weaponsScreen =
                new WeaponsScreen(width, height, hero, levelRandomizer, weaponsScreenExits);
        trainingScreen =
                new TrainingScreen(width, height, hero, levelRandomizer, trainingScreenExits);
        bossScreen = new BossScreen(width, height, hero, levelRandomizer, bossScreenExits);
        vaccineScreen = new VaccineScreen(width, height, hero, levelRandomizer, vaccineScreenExits);
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