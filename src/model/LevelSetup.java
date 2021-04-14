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

    // item arraysLists
    private ArrayList<Collectable> levelOneItems;
    private ArrayList<Collectable> levelTwoItems;
    private ArrayList<Collectable> levelThreeItems;
    private ArrayList<Collectable> levelFourItems;
    private ArrayList<Collectable> levelFiveItems;
    private ArrayList<Collectable> levelSixItems;
    private ArrayList<Collectable> levelSevenItems;
    private ArrayList<Collectable> levelEightItems;
    private ArrayList<Collectable> bossItems;

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
        initializeExits();

        //Initialize all exit arrays
        initializeExitArrays();

        // initialize monster arrays
        initializeMonsterArrayLists();

        // initialize all items
        initializeItemArrayLists();

        //initialize all screens
        gameScreen = new GameScreen(width, height, hero,
                levelRandomizer, initialGameScreenExits, new ArrayList<Monster>(), new ArrayList<Collectable>());
        levelOne = new LevelOneScreen(width, height, hero,
                levelRandomizer, levelOneScreenExits, levelOneMonsters, levelOneItems);
        levelTwo = new LevelTwoScreen(width, height, hero,
                levelRandomizer, levelTwoScreenExits, levelTwoMonsters, levelTwoItems);
        levelThree =
                new LevelThreeScreen(width, height, hero,
                        levelRandomizer, levelThreeScreenExits, levelThreeMonsters, levelThreeItems);
        levelFour = new LevelFourScreen(width, height, hero,
                levelRandomizer, levelFourScreenExits, levelFourMonsters, levelFourItems);
        levelFive = new LevelFiveScreen(width, height, hero,
                levelRandomizer, levelFiveScreenExits, levelFiveMonsters, levelFiveItems);
        levelSix = new LevelSixScreen(width, height, hero,
                levelRandomizer, levelSixScreenExits, levelSixMonsters, levelSixItems);
        levelSeven =
                new LevelSevenScreen(width, height, hero,
                        levelRandomizer, levelSevenScreenExits, levelSevenMonsters, levelSevenItems);
        levelEight =
                new LevelEightScreen(width, height, hero,
                        levelRandomizer, levelEightScreenExits, levelEightMonsters, levelEightItems);
        weaponsScreen =
                new WeaponsScreen(width, height, hero,
                        levelRandomizer, weaponsScreenExits, new ArrayList<Monster>(), new ArrayList<Collectable>());
        trainingScreen =
                new TrainingScreen(width, height, hero,
                        levelRandomizer, trainingScreenExits, new ArrayList<Monster>(), new ArrayList<Collectable>());
        bossScreen =
                new BossScreen(width, height, hero,
                        levelRandomizer, bossScreenExits, bossMonsters, bossItems);
        vaccineScreen =
                new VaccineScreen(width, height, hero,
                        levelRandomizer, vaccineScreenExits, new ArrayList<Monster>(), new ArrayList<Collectable>());
    }

    private void initializeExits() {
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
    }

    private void initializeExitArrays() {
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
    }

    private void initializeMonsterArrayLists() {
        initializeMonsterLevelOneArrayLists();
        initializeMonsterLevelTwoArrayLists();
        initializeMonsterLevelThreeArrayLists();
        initializeMonsterLevelFourArrayLists();
        initializeMonsterLevelFiveArrayLists();
        initializeMonsterLevelSixArrayLists();
        initializeMonsterLevelSevenArrayLists();
        initializeMonsterLevelEightArrayLists();
        initializeMonsterLevelBossArrayLists();

    }

    private void initializeMonsterLevelOneArrayLists() {
        levelOneMonsters = new ArrayList<Monster>();
        levelOneMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 9, 9,
                        "monster1", "Level 1"));
        levelOneMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 11, 15,
                        "monster2", "Level 1"));
        levelOneMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 4, 4,
                        "monster3", "Level 1"));
    }

    private void initializeMonsterLevelTwoArrayLists() {
        levelTwoMonsters = new ArrayList<Monster>();
        levelTwoMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 7, 5,
                        "monster1", "Level 2"));
        levelTwoMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 11, 8,
                        "monster2", "Level 2"));
        levelTwoMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 4,
                        "monster3", "Level 2"));
        levelTwoMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 16, 16,
                        "monster4", "Level 2"));
    }

    private void initializeMonsterLevelThreeArrayLists() {
        levelThreeMonsters = new ArrayList<Monster>();
        levelThreeMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 2, 8,
                        "monster1", "Level 3"));
        levelThreeMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 8, 8,
                        "monster2", "Level 3"));
        levelThreeMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 8, 9,
                        "monster3", "Level 3"));
        levelThreeMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 11, 16,
                        "monster4", "Level 3"));
        levelThreeMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 4,
                        "monster5", "Level 3"));
    }

    private void initializeMonsterLevelFourArrayLists() {
        levelFourMonsters = new ArrayList<Monster>();
        levelFourMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 4, 4,
                        "monster1", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 2, 9,
                        "monster2",  "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 9, 9,
                        "monster3", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 3, 14,
                        "monster4", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 6,
                        "monster5", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 11, 13,
                        "monster6", "Level 4"));
    }

    private void initializeMonsterLevelFiveArrayLists() {
        levelFiveMonsters = new ArrayList<Monster>();
        levelFiveMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 9, 12,
                        "monster1", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 14, 6,
                        "monster2", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 10, 12,
                        "monster3", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 7, 9,
                        "monster4", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 17, 16,
                        "monster5", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 4, 4,
                        "monster6", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 4, 12,
                        "monster7", "Level 5"));
    }

    private void initializeMonsterLevelSixArrayLists() {
        levelSixMonsters = new ArrayList<Monster>();
        levelSixMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 9, 5,
                        "monster1", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 14, 9,
                        "monster2", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 6, 10,
                        "monster3", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 10, 10,
                        "monster4", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 16,
                        "monster5", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 4, 2,
                        "monster6", "Level 6"));
    }

    private void initializeMonsterLevelSevenArrayLists() {
        levelSevenMonsters = new ArrayList<Monster>();
        levelSevenMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 9, 9,
                        "monster1", "Level 7"));
        levelSevenMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 10, 5,
                        "monster2", "Level 7"));
        levelSevenMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 6, 5,
                        "monster3", "Level 7"));
        levelSevenMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 2, 8,
                        "monster4", "Level 7"));
        levelSevenMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 5, 17,
                        "monster5", "Level 7"));
        levelSevenMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 10, 13,
                        "monster6", "Level 7"));
    }

    private void initializeMonsterLevelEightArrayLists() {
        levelEightMonsters = new ArrayList<Monster>();
        levelEightMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 9,
                        "monster1", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 12, 4,
                        "monster2", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 9, 11,
                        "monster3", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 6, 15,
                        "monster4", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 3, 6,
                        "monster5", "Level 8"));
    }

    private void initializeMonsterLevelBossArrayLists() {
        bossMonsters = new ArrayList<Monster>();
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSLARGE, "Down",
                        1, 3, 8,
                        "monster1", "Boss Screen"));
        bossMonsters.add(

                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 4, 6,
                        "monster2", "Boss Screen"));
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 2, 16,
                        "monster3", "Boss Screen"));
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 13, 9,
                        "monster4", "Boss Screen"));
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 9, 3,
                        "monster5", "Boss Screen"));
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 10, 3,
                        "monster6", "Boss Screen"));
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 7, 7,
                        "monster7", "Boss Screen"));
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 16, 2,
                        "monster8", "Boss Screen"));
        bossMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 5, 15,
                        "monster9", "Boss Screen"));
    }

    private void initializeItemArrayLists() {
        initializeItemLevelOneArrayLists();
        initializeItemLevelTwoArrayLists();
        initializeItemLevelThreeArrayLists();
        initializeItemLevelFourArrayLists();
        initializeItemLevelFiveArrayLists();
        initializeItemLevelSixArrayLists();
        initializeItemLevelSevenArrayLists();
        initializeItemLevelEightArrayLists();
        initializeItemBossArrayLists();
    }

    private void initializeItemLevelOneArrayLists() {
        levelOneItems = new ArrayList<Collectable>();
        // examples for claudia to use
        //potions
        levelOneItems.add(new N95("N95Mask_1", 10, 10, false, 1, 10));
        levelOneItems.add(new N95("N95Mask_2", 10, 12, false, 1, 10));
        levelOneItems.add(new Potion("CannedSoup_1", 10, 11, false, 1, 2));
        levelOneItems.add(new Potion("CannedSoup_2", 11, 11, false, 1, 2));
        levelOneItems.add(new Potion("ToiletPaper_1", 12, 11, false, 1, 3));
        levelOneItems.add(new Potion("ToiletPaper_2", 13, 11, false, 1, 3));
        levelOneItems.add(new Potion("HandSanitizer_1", 14, 8, false, 1, 4));
        levelOneItems.add(new Potion("HandSanitizer_2", 15, 8, false, 1, 4));

        //weapons
        levelOneItems.add(new Weapon("DisinfectantSpray_1", 12, 10, false));
        levelOneItems.add(new Weapon("FireDisinfectantSpray_1", 13, 10, false));
        levelOneItems.add(new Weapon("WipeCrossBow_1", 14, 6, false));
        levelOneItems.add(new Weapon("FireWipeCrossBow_1", 15, 6, false));
        levelOneItems.add(new Weapon("ThermometerSword_1", 14, 7, false));
        levelOneItems.add(new Weapon("FireThermometerSword_1", 15, 7, false));

    }

    private void initializeItemLevelTwoArrayLists() {
        levelTwoItems = new ArrayList<Collectable>();
    }

    private void initializeItemLevelThreeArrayLists() {
        levelThreeItems = new ArrayList<Collectable>();
    }

    private void initializeItemLevelFourArrayLists() {
        levelFourItems = new ArrayList<Collectable>();
    }

    private void initializeItemLevelFiveArrayLists() {
        levelFiveItems = new ArrayList<Collectable>();
    }

    private void initializeItemLevelSixArrayLists() {
        levelSixItems = new ArrayList<Collectable>();
    }

    private void initializeItemLevelSevenArrayLists() {
        levelSevenItems = new ArrayList<Collectable>();
    }

    private void initializeItemLevelEightArrayLists() {
        levelEightItems = new ArrayList<Collectable>();
    }

    private void initializeItemBossArrayLists() {
        bossItems = new ArrayList<Collectable>();
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
