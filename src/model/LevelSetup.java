package model;

import view.*;

import java.util.ArrayList;

/**
 * The LevelSetup Class
 *
 * The LevelSetup Class sets up the entire levels and has getter
 * methods to return a certain level if needed.
 */
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

    // Monster arrayslists
    private ArrayList<Monster> levelOneMonsters;
    private ArrayList<Monster> levelTwoMonsters;
    private ArrayList<Monster> levelThreeMonsters;
    private ArrayList<Monster> levelFourMonsters;
    private ArrayList<Monster> levelFiveMonsters;
    private ArrayList<Monster> levelSixMonsters;
    private ArrayList<Monster> levelSevenMonsters;
    private ArrayList<Monster> levelEightMonsters;
    private ArrayList<Monster> bossMonsters;

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

    /**
     * The LevelSetup Constructor
     *
     * @param width the width of the stage
     * @param height the height of the stage
     * @param hero the hero to use
     */
    public LevelSetup(int width, int height, Player hero) {

        this.levelRandomizer = new LevelRandomizer();

        //initialize all exits
        initialGameScreenLevel1 =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Game Screen", "Level 1", true);
        intialGameScreenWeaponsScreen =
                new Exit(ExitType.LEFT, ExitType.RIGHT, "Game Screen", "Weapons Screen", true);
        intialGameScreenTrainingScreen =
                new Exit(ExitType.RIGHT, ExitType.LEFT, "Game Screen", "Training Screen", true);
        intialGameScreenExitGame =
                new Exit(ExitType.BOTTOM, ExitType.TOP, "Game Screen", "Exit Game", true);
        level1Level2 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 1", "Level 2", false);
        level2Level3 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 2", "Level 3", false);
        level3Level4 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 3", "Level 4", false);
        level4Level5 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 4", "Level 5", false);
        level5Level6 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 5", "Level 6", false);
        level6Level7 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 6", "Level 7", false);
        level7Level8 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 7", "Level 8", false);
        level8BossScreen = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 8", "Boss Screen", false);
        bossScreenVaccineScreen =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Boss Screen", "Vaccine Screen", false);
        vaccineScreenWinScreen =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Vaccine Screen", "Win Screen", true);

        //Initialize all exit arrays
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

        // initialize monster arrays
        levelOneMonsters = new ArrayList<Monster>();
        levelOneMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,9, 9,"monster1"));
        levelOneMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,11, 15,"monster2"));
        levelOneMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,4, 4,"monster3"));

        levelTwoMonsters = new ArrayList<Monster>();
        levelTwoMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,7, 5,"monster1"));
        levelTwoMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,11, 8,"monster2"));
        levelTwoMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,14, 4,"monster3"));
        levelTwoMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,16, 16,"monster4"));

        levelThreeMonsters = new ArrayList<Monster>();
        levelThreeMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,2, 8,"monster1"));
        levelThreeMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,8, 8,"monster2"));
        levelThreeMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,8, 9,"monster3"));
        levelThreeMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,11, 16,"monster4"));
        levelThreeMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,14, 4,"monster5"));

        levelFourMonsters = new ArrayList<Monster>();
        levelFourMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,4, 4,"monster1"));
        levelFourMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,2, 9,"monster2"));
        levelFourMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,9, 9,"monster3"));
        levelFourMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,3, 14,"monster4"));
        levelFourMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,14, 6,"monster5"));
        levelFourMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,11, 13,"monster6"));

        levelFiveMonsters = new ArrayList<Monster>();
        levelFiveMonsters.add(new Monster( MonsterType.TRUMP, "Down", 1,9, 12,"monster1"));
        levelFiveMonsters.add(new Monster( MonsterType.TRUMP, "Down", 1,14, 6,"monster2"));
        levelFiveMonsters.add(new Monster( MonsterType.TRUMP, "Down", 1,9, 12,"monster3"));
        levelFiveMonsters.add(new Monster( MonsterType.TRUMP, "Down", 1,7, 9,"monster4"));
        levelFiveMonsters.add(new Monster( MonsterType.TRUMP, "Down", 1,17, 16,"monster5"));
        levelFiveMonsters.add(new Monster( MonsterType.TRUMP, "Down", 1,4, 4,"monster6"));
        levelFiveMonsters.add(new Monster( MonsterType.TRUMP, "Down", 1,4, 12,"monster7"));

        levelSixMonsters = new ArrayList<Monster>();
        levelSixMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,9, 5,"monster1"));
        levelSixMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,14, 9,"monster2"));
        levelSixMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,6, 10,"monster3"));
        levelSixMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,10, 10,"monster4"));
        levelSixMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,14, 16,"monster5"));
        levelSixMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,4, 2,"monster6"));

        levelSevenMonsters = new ArrayList<Monster>();
        levelSevenMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,9, 9,"monster1"));
        levelSevenMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,10, 5,"monster2"));
        levelSevenMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,6, 5,"monster3"));
        levelSevenMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,2, 8,"monster4"));
        levelSevenMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,5, 17,"monster5"));
        levelSevenMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,10, 13,"monster6"));

        levelEightMonsters = new ArrayList<Monster>();
        levelEightMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,14, 9,"monster1"));
        levelEightMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,12, 4,"monster2"));
        levelEightMonsters.add(new Monster( MonsterType.FAANTIMASKER, "Down", 1,9, 11,"monster3"));
        levelEightMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,6, 15,"monster4"));
        levelEightMonsters.add(new Monster( MonsterType.MAANTIMASKER, "Down", 1,3, 6,"monster5"));

        bossMonsters = new ArrayList<Monster>();
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSLARGE, "Down", 1,3, 8,"monster1"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,4, 9,"monster2"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,2, 16,"monster3"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,13, 9,"monster4"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,9, 3,"monster5"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,10, 3,"monster6"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,7, 7,"monster7"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,16, 2,"monster8"));
        bossMonsters.add(new Monster( MonsterType.COVIDBOSSSMALL, "Down", 1,5, 12,"monster9"));

        //initialize all screens
        gameScreen = new GameScreen(width, height, hero, levelRandomizer, initialGameScreenExits, new ArrayList<Monster>());
        levelOne = new LevelOneScreen(width, height, hero, levelRandomizer, levelOneScreenExits, levelOneMonsters);
        levelTwo = new LevelTwoScreen(width, height, hero, levelRandomizer, levelTwoScreenExits, levelTwoMonsters);
        levelThree =
                new LevelThreeScreen(width, height, hero, levelRandomizer, levelThreeScreenExits, levelThreeMonsters);
        levelFour = new LevelFourScreen(width, height, hero, levelRandomizer, levelFourScreenExits, levelFourMonsters);
        levelFive = new LevelFiveScreen(width, height, hero, levelRandomizer, levelFiveScreenExits, levelFiveMonsters);
        levelSix = new LevelSixScreen(width, height, hero, levelRandomizer, levelSixScreenExits, levelSixMonsters);
        levelSeven =
                new LevelSevenScreen(width, height, hero, levelRandomizer, levelSevenScreenExits, levelSevenMonsters);
        levelEight =
                new LevelEightScreen(width, height, hero, levelRandomizer, levelEightScreenExits, levelEightMonsters);
        weaponsScreen =
                new WeaponsScreen(width, height, hero, levelRandomizer, weaponsScreenExits, new ArrayList<Monster>());
        trainingScreen =
                new TrainingScreen(width, height, hero, levelRandomizer, trainingScreenExits, new ArrayList<Monster>());
        bossScreen = new BossScreen(width, height, hero, levelRandomizer, bossScreenExits, bossMonsters);
        vaccineScreen = new VaccineScreen(width, height, hero, levelRandomizer, vaccineScreenExits, new ArrayList<Monster>());
    }

    /**
     *
     * @return Initial Game Screen
     */
    public LevelScreen getGameScreen() {
        return gameScreen;
    }

    /**
     *
     * @return Level One Screen
     */
    public LevelScreen getLevelOne() {
        return levelOne;
    }

    /**
     *
     * @return Level Two Screen
     */
    public LevelScreen getLevelTwo() {
        return levelTwo;
    }

    /**
     *
     * @return Level Three Screen
     */
    public LevelScreen getLevelThree() {
        return levelThree;
    }

    /**
     *
     * @return Level Four Screen
     */
    public LevelScreen getLevelFour() {
        return levelFour;
    }

    /**
     *
     * @return Level Five Screen
     */
    public LevelScreen getLevelFive() {
        return levelFive;
    }

    /**
     *
     * @return Level Six Screen
     */
    public LevelScreen getLevelSix() {
        return levelSix;
    }

    /**
     *
     * @return Level Seven Screen
     */
    public LevelScreen getLevelSeven() {
        return levelSeven;
    }

    /**
     *
     * @return Level Eight Screen
     */
    public LevelScreen getLevelEight() {
        return levelEight;
    }

    /**
     *
     * @return Weapon Screen
     */
    public LevelScreen getWeaponsScreen() {
        return weaponsScreen;
    }

    /**
     *
     * @return Training Screen
     */
    public LevelScreen getTrainingScreen() {
        return trainingScreen;
    }

    /**
     *
     * @return Boss Screen
     */
    public LevelScreen getBossScreen() {
        return bossScreen;
    }

    /**
     *
     * @return Vaccine Screen
     */
    public LevelScreen getVaccineScreen() {
        return vaccineScreen;
    }
}
