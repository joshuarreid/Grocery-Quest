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
    private Exit level3FirstChallenge; //*****************************************************************************
    private Exit level4Level5;
    private Exit level5Level6;
    private Exit level5SecondChallenge; //*****************************************************************************
    private Exit level6Level7;
    private Exit level7Level8;
    private Exit level7ThirdChallenge; //*****************************************************************************
    private Exit level8BossScreen;
    private Exit bossScreenVaccineScreen;
    private Exit vaccineScreenWinScreen;

    // Arrays storing Exits for each screen
    private Exit[] initialGameScreenExits;
    private Exit[] levelOneScreenExits;
    private Exit[] levelTwoScreenExits;
    private Exit[] levelThreeScreenExits;
    private Exit[] firstChallengeScreenExits; //************************************************************************
    private Exit[] levelFourScreenExits;
    private Exit[] levelFiveScreenExits;
    private Exit[] secondChallengeScreenExits; //************************************************************************
    private Exit[] levelSixScreenExits;
    private Exit[] levelSevenScreenExits;
    private Exit[] thirdChallengeScreenExits; //************************************************************************
    private Exit[] levelEightScreenExits;
    private Exit[] weaponsScreenExits;
    private Exit[] trainingScreenExits;
    private Exit[] bossScreenExits;
    private Exit[] vaccineScreenExits;

    // Monster arrayslists
    private ArrayList<Monster> trainingMonsters;
    private ArrayList<Monster> levelOneMonsters;
    private ArrayList<Monster> levelTwoMonsters;
    private ArrayList<Monster> levelThreeMonsters;
    private ArrayList<Monster> firstChallengeMonsters; //************************************************************
    private ArrayList<Monster> levelFourMonsters;
    private ArrayList<Monster> levelFiveMonsters;
    private ArrayList<Monster> secondChallengeMonsters; //************************************************************
    private ArrayList<Monster> levelSixMonsters;
    private ArrayList<Monster> levelSevenMonsters;
    private ArrayList<Monster> thirdChallengeMonsters; //************************************************************
    private ArrayList<Monster> levelEightMonsters;
    private ArrayList<Monster> bossMonsters;

    // item arraysLists
    private ArrayList<Collectable> weaponsItems;
    private ArrayList<Collectable> levelOneItems;
    private ArrayList<Collectable> levelTwoItems;
    private ArrayList<Collectable> levelThreeItems;
    private ArrayList<Collectable> firstChallengeItems; //***********************************************************8
    private ArrayList<Collectable> levelFourItems;
    private ArrayList<Collectable> levelFiveItems;
    private ArrayList<Collectable> secondChallengeItems; //***********************************************************8
    private ArrayList<Collectable> levelSixItems;
    private ArrayList<Collectable> levelSevenItems;
    private ArrayList<Collectable> thirdChallengeItems; //***********************************************************8
    private ArrayList<Collectable> levelEightItems;
    private ArrayList<Collectable> bossItems;
    private ArrayList<Collectable> vaccineItems;

    //screens
    private LevelScreen gameScreen;
    private LevelScreen levelOne;
    private LevelScreen levelTwo;
    private LevelScreen levelThree;
    private ChallengeScreen firstChallenge; //***********************************************************************
    private LevelScreen levelFour;
    private LevelScreen levelFive;
    private ChallengeScreen secondChallenge; //***********************************************************************
    private LevelScreen levelSix;
    private LevelScreen levelSeven;
    private ChallengeScreen thirdChallenge; //***********************************************************************
    private LevelScreen levelEight;
    private LevelScreen weaponsScreen;
    private LevelScreen trainingScreen;
    private LevelScreen bossScreen;
    private LevelScreen vaccineScreen;

    //player
    private Player hero;
    /**
     * The LevelSetup Constructor
     *
     * @param width the width of the stage
     * @param height the height of the stage
     * @param hero the hero to use
     */
    public LevelSetup(int width, int height, Player hero) {
        this.hero = hero;
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
        gameScreen = new GameScreen(hero,
                levelRandomizer, initialGameScreenExits,
                new ArrayList<Monster>(), new ArrayList<Collectable>());

        levelOne = new LevelOneScreen(hero,
                levelRandomizer, levelOneScreenExits,
                levelOneMonsters, levelOneItems);
        levelTwo = new LevelTwoScreen(hero,
                levelRandomizer, levelTwoScreenExits,
                levelTwoMonsters, levelTwoItems);
        levelThree =
                new LevelThreeScreen(hero,
                        levelRandomizer, levelThreeScreenExits,
                        levelThreeMonsters, levelThreeItems);
        firstChallenge = new ChallengeScreenFirst(hero,
                levelRandomizer, firstChallengeScreenExits,
                firstChallengeMonsters, firstChallengeItems); //*********************************************************
        levelFour = new LevelFourScreen(hero,
                levelRandomizer, levelFourScreenExits,
                levelFourMonsters, levelFourItems);
        levelFive = new LevelFiveScreen(hero,
                levelRandomizer, levelFiveScreenExits,
                levelFiveMonsters, levelFiveItems);
        secondChallenge = new ChallengeScreenSecond(hero,
                levelRandomizer, secondChallengeScreenExits,
                secondChallengeMonsters, secondChallengeItems); //*********************************************************
        levelSix = new LevelSixScreen(hero,
                levelRandomizer, levelSixScreenExits,
                levelSixMonsters, levelSixItems);
        levelSeven =
                new LevelSevenScreen(hero,
                        levelRandomizer, levelSevenScreenExits,
                        levelSevenMonsters, levelSevenItems);
        thirdChallenge = new ChallengeScreenThird(hero,
                levelRandomizer, thirdChallengeScreenExits,
                thirdChallengeMonsters, thirdChallengeItems); //*********************************************************
        levelEight =
                new LevelEightScreen(hero,
                        levelRandomizer, levelEightScreenExits,
                        levelEightMonsters, levelEightItems);
        weaponsScreen =
                new WeaponsScreen(hero,
                        levelRandomizer, weaponsScreenExits,
                        new ArrayList<Monster>(), weaponsItems);
        trainingScreen =
                new TrainingScreen(hero,
                        levelRandomizer, trainingScreenExits,
                        trainingMonsters, new ArrayList<Collectable>());
        bossScreen =
                new BossScreen(hero,
                        levelRandomizer, bossScreenExits,
                        bossMonsters, bossItems);
        vaccineScreen =
                new VaccineScreen(hero,
                        levelRandomizer, vaccineScreenExits,
                        new ArrayList<Monster>(), vaccineItems);
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

        //******** can set these to true when adding layouts - for claudia :)
        level1Level2 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 1", "Level 2", true);
        level2Level3 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 2", "Level 3", true);
        level3Level4 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 3", "Level 4", true);
        level4Level5 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 4", "Level 5", true);
        level5Level6 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 5", "Level 6", true);
        level6Level7 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 6", "Level 7", true);
        level7Level8 = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 7", "Level 8", true);
        level8BossScreen = new Exit(ExitType.TOP, ExitType.BOTTOM, "Level 8", "Boss Screen", true);
        bossScreenVaccineScreen =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Boss Screen", "Vaccine Screen", true);

        vaccineScreenWinScreen =
                new Exit(ExitType.TOP, ExitType.BOTTOM, "Vaccine Screen", "Win Screen", true);
        //*********

        level3FirstChallenge = new Exit(ExitType.LEFT, ExitType.RIGHT, "Level 3", "Challenge 1", true); //***************
        level5SecondChallenge = new Exit(ExitType.RIGHT, ExitType.LEFT, "Level 5", "Challenge 2", true); //***************
        level7ThirdChallenge = new Exit(ExitType.LEFT, ExitType.RIGHT, "Level 7", "Challenge 3", true); //***************
    }

    private void initializeExitArrays() {
        initialGameScreenExits = new Exit[]{
            initialGameScreenLevel1,
            intialGameScreenWeaponsScreen,
            intialGameScreenTrainingScreen,
            intialGameScreenExitGame};

        firstChallengeScreenExits = new Exit[]{level3FirstChallenge}; //*******************************************
        secondChallengeScreenExits = new Exit[]{level5SecondChallenge}; //*******************************************
        thirdChallengeScreenExits = new Exit[]{level7ThirdChallenge}; //*******************************************

        levelOneScreenExits = new Exit[]{initialGameScreenLevel1, level1Level2};
        levelTwoScreenExits = new Exit[]{level1Level2, level2Level3};
        levelThreeScreenExits = new Exit[]{level2Level3, level3Level4, level3FirstChallenge};
        levelFourScreenExits = new Exit[]{level3Level4, level4Level5};
        levelFiveScreenExits = new Exit[]{level4Level5,  level5Level6, level5SecondChallenge};
        levelSixScreenExits = new Exit[]{level5Level6, level6Level7};
        levelSevenScreenExits = new Exit[]{level6Level7, level7Level8, level7ThirdChallenge};
        levelEightScreenExits = new Exit[]{level7Level8, level8BossScreen};
        weaponsScreenExits = new Exit[]{intialGameScreenWeaponsScreen};
        trainingScreenExits = new Exit[]{intialGameScreenTrainingScreen};
        bossScreenExits = new Exit[]{level8BossScreen, bossScreenVaccineScreen};
        vaccineScreenExits = new Exit[]{bossScreenVaccineScreen, vaccineScreenWinScreen};
    }

    private void initializeMonsterArrayLists() {
        initializeMonsterTrainingArrayLists();
        initializeMonsterLevelOneArrayLists();
        initializeMonsterLevelTwoArrayLists();
        initializeMonsterLevelThreeArrayLists();
        initializeMonsterLevelFourArrayLists();
        initializeMonsterLevelFiveArrayLists();
        initializeMonsterLevelSixArrayLists();
        initializeMonsterLevelSevenArrayLists();
        initializeMonsterLevelEightArrayLists();
        initializeMonsterLevelBossArrayLists();

        initializeMonsterFirstChallengeArrayLists(); //*****************************************************
        initializeMonsterSecondChallengeArrayLists(); //*****************************************************
        initializeMonsterThirdChallengeArrayLists(); //*****************************************************
    }

    private void initializeMonsterTrainingArrayLists() {
        trainingMonsters = new ArrayList<Monster>();
        trainingMonsters.add(new Monster(MonsterType.FAANTIMASKER, "Down", 1, 9, 7,
                "monster1", "Training"));
        //trainingMonsters.add(new Monster(MonsterType.SNEEZECLOUD, "Down", 1, 10, 7,
        //        "monster2", "Training"));
    }

    private void initializeMonsterLevelOneArrayLists() {
        levelOneMonsters = new ArrayList<Monster>();
        levelOneMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 9, 9,
                        "monster1", "Level 1"));
        levelOneMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Right",
                        1, 11, 15,
                        "monster2", "Level 1"));
        levelOneMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Up",
                        1, 4, 4,
                        "monster3", "Level 1"));
    }

    private void initializeMonsterLevelTwoArrayLists() {
        levelTwoMonsters = new ArrayList<Monster>();
        levelTwoMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Left",
                        1, 7, 5,
                        "monster1", "Level 2"));
        levelTwoMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 11, 8,
                        "monster2", "Level 2"));
        levelTwoMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Left",
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
                new Monster(MonsterType.MAANTIMASKER, "Right",
                        1, 8, 8,
                        "monster2", "Level 3"));
        levelThreeMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Left",
                        1, 8, 9,
                        "monster3", "Level 3"));
        levelThreeMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down", 1, 11,
                16, "monster4", "Level 3"));
        levelThreeMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 4,
                        "monster5", "Level 3"));
    }

    private void initializeMonsterLevelFourArrayLists() {
        levelFourMonsters = new ArrayList<Monster>();
        levelFourMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Up",
                        1, 4, 4,
                        "monster1", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Left",
                        1, 2, 9,
                        "monster2",  "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 9, 9,
                        "monster3", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Up",
                        1, 3, 14,
                        "monster4", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 6,
                        "monster5", "Level 4"));
        levelFourMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down", 1, 11,
                        13, "monster6", "Level 4"));
    }

    private void initializeMonsterLevelFiveArrayLists() {
        levelFiveMonsters = new ArrayList<Monster>();
        levelFiveMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Up",
                        1, 9, 12,
                        "monster1", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 14, 6,
                        "monster2", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Right",
                        1, 10, 12,
                        "monster3", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Left",
                        1, 7, 9,
                        "monster4", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Right",
                        1, 17, 16,
                        "monster5", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down", 1, 4,
                        4, "monster6", "Level 5"));
        levelFiveMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down", 1, 4,
                        12, "monster7", "Level 5"));
    }

    private void initializeMonsterLevelSixArrayLists() {
        levelSixMonsters = new ArrayList<Monster>();
        levelSixMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Left",
                        1, 9, 5,
                        "monster1", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 14, 9,
                        "monster2", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Up",
                        1, 6, 10,
                        "monster3", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down",
                        1, 10, 10,
                        "monster4", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Down",
                        1, 14, 16,
                        "monster5", "Level 6"));
        levelSixMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Right",
                        1, 4, 2,
                        "monster6", "Level 6"));
    }

    private void initializeMonsterLevelSevenArrayLists() {
        levelSevenMonsters = new ArrayList<Monster>();
        levelSevenMonsters.add(
                new Monster(MonsterType.FAANTIMASKER, "Right",
                        1, 9, 9,
                        "monster1", "Level 7"));
        levelSevenMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down",
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
                new Monster(MonsterType.SNEEZECLOUD, "Down",
                        1, 5, 17,
                        "monster5", "Level 7"));
        levelSevenMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Left",
                        1, 10, 13,
                        "monster6", "Level 7"));
    }

    private void initializeMonsterLevelEightArrayLists() {
        levelEightMonsters = new ArrayList<Monster>();
        levelEightMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 14, 9,
                        "monster1", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Up",
                        1, 12, 4,
                        "monster2", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 9, 11,
                        "monster3", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Down",
                        1, 6, 15,
                        "monster4", "Level 8"));
        levelEightMonsters.add(
                new Monster(MonsterType.MAANTIMASKER, "Right",
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

    private void initializeMonsterFirstChallengeArrayLists() { //**************************************************
        firstChallengeMonsters = new ArrayList<Monster>();
        firstChallengeMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down",
                        1, 5, 15,
                        "monster1", "Challenge 1"));
        firstChallengeMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down",
                        1, 14, 14,
                        "monster2", "Challenge 1"));
        firstChallengeMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down",
                        1, 3, 5,
                        "monster3", "Challenge 1"));
        firstChallengeMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down",
                        1, 9, 11,
                        "monster4", "Challenge 1"));
        firstChallengeMonsters.add(
                new Monster(MonsterType.SNEEZECLOUD, "Down",
                        1, 12, 6,
                        "monster5", "Challenge 1"));
    }
    private void initializeMonsterSecondChallengeArrayLists() { //**************************************************
        secondChallengeMonsters = new ArrayList<Monster>();
        secondChallengeMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 5, 10,
                        "monster1", "Challenge 2"));
        secondChallengeMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 11, 8,
                        "monster2", "Challenge 2"));
        secondChallengeMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 2, 3,
                        "monster3", "Challenge 2"));
        secondChallengeMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 9, 16,
                        "monster4", "Challenge 2"));
        secondChallengeMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 15, 12,
                        "monster5", "Challenge 2"));
        secondChallengeMonsters.add(
                new Monster(MonsterType.TRUMP, "Down",
                        1, 4, 6,
                        "monster6", "Challenge 2"));
    }

    private void initializeMonsterThirdChallengeArrayLists() { //**************************************************
        thirdChallengeMonsters = new ArrayList<Monster>();
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 2, 8,
                        "monster1", "Challenge 3"));
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 14, 9,
                        "monster2", "Challenge 3"));
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 8, 2,
                        "monster3", "Challenge 3"));
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 5, 10,
                        "monster4", "Challenge 3"));
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 5, 16,
                        "monster5", "Challenge 3"));
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 13, 16,
                        "monster6", "Challenge 3"));
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 15, 6,
                        "monster7", "Challenge 3"));
        thirdChallengeMonsters.add(
                new Monster(MonsterType.COVIDBOSSSMALL, "Down",
                        1, 2, 10,
                        "monster8", "Challenge 3"));
    }

    private void initializeItemArrayLists() {
        initializeWeaponsArrayLists();
        initializeItemLevelOneArrayLists();
        initializeItemLevelTwoArrayLists();
        initializeItemLevelThreeArrayLists();
        initializeItemLevelFourArrayLists();
        initializeItemLevelFiveArrayLists();
        initializeItemLevelSixArrayLists();
        initializeItemLevelSevenArrayLists();
        initializeItemLevelEightArrayLists();
        initializeItemBossArrayLists();
        initializeVaccineArrayLists();

        initializeItemFirstChallengeArrayLists();
        initializeItemSecondChallengeArrayLists();
        initializeItemThirdChallengeArrayLists();

    }

    private void initializeWeaponsArrayLists() {
        weaponsItems = new ArrayList<Collectable>();
        //System.out.println(hero.getWeaponInUse());
        switch (hero.getWeaponInUse()) {
        case "DisinfectantSpray":
            weaponsItems.add(new Weapon("WipeCrossbow_1", 6, 11, false));
            weaponsItems.add(new Weapon("ThermometerSword_1", 12, 11, false));
            break;
        case "WipeCrossbow":
            weaponsItems.add(new Weapon("DisinfectantSpray_1", 9, 11, false));
            weaponsItems.add(new Weapon("ThermometerSword_1", 12, 11, false));
            break;
        case "ThermometerSword":
            weaponsItems.add(new Weapon("DisinfectantSpray_1", 9, 11, false));
            weaponsItems.add(new Weapon("WipeCrossBow_1", 6, 11, false));
            break;
        default:
        }
    }

    private void initializeItemLevelOneArrayLists() {
        levelOneItems = new ArrayList<Collectable>();

        levelOneItems.add(new Potion("CannedSoup_1", 10, 11, false, 1, 1));
        levelOneItems.add(new Potion("ToiletPaper_1", 1, 14, false, 1, 2));

        //weapons
        //levelOneItems.add(new Weapon("DisinfectantSpray_1", 12, 10, false));
        //levelOneItems.add(new Weapon("FireDisinfectantSpray_1", 13, 10, false));
        //levelOneItems.add(new Weapon("WipeCrossBow_1", 14, 6, false));
        //levelOneItems.add(new Weapon("FireWipeCrossBow_1", 15, 6, false));
        //levelOneItems.add(new Weapon("ThermometerSword_1", 14, 7, false));
        //levelOneItems.add(new Weapon("FireThermometerSword_1", 15, 7, false));

    }

    private void initializeItemLevelTwoArrayLists() {
        levelTwoItems = new ArrayList<Collectable>();
        levelTwoItems.add(new Potion("CannedSoup_1", 15, 3, false, 1, 1));
        levelTwoItems.add(new Potion("ToiletPaper_1", 14, 6, false, 1, 2));
        levelTwoItems.add(new N95("N95Mask_1", 10, 10, false, 1, 10));
    }

    private void initializeItemLevelThreeArrayLists() {
        levelThreeItems = new ArrayList<Collectable>();

        levelThreeItems.add(new Potion("CannedSoup_1", 5, 3, false, 1, 1));
        levelThreeItems.add(new Potion("ToiletPaper_1", 0, 0, false, 1, 2));
    }

    private void initializeItemLevelFourArrayLists() {
        levelFourItems = new ArrayList<Collectable>();

        levelFourItems.add(new Potion("ToiletPaper_1", 3, 16, false, 1, 2));
        levelFourItems.add(new Potion("CannedSoup_1", 14, 5, false, 1, 1));
    }

    private void initializeItemLevelFiveArrayLists() {
        levelFiveItems = new ArrayList<Collectable>();

        levelFiveItems.add(new Potion("ToiletPaper_1", 8, 10, false, 1, 2));
        levelFiveItems.add(new Potion("ToiletPaper_1", 12, 5, false, 1, 2));
    }

    private void initializeItemLevelSixArrayLists() {
        levelSixItems = new ArrayList<Collectable>();

        levelSixItems.add(new HandSanitizer("HandSanitizer_1", 13, 2, false, 1));
        levelSixItems.add(new Potion("ToiletPaper_1", 5, 14, false, 1, 2));

    }

    private void initializeItemLevelSevenArrayLists() {
        levelSevenItems = new ArrayList<Collectable>();
        levelSevenItems.add(new N95("N95Mask_1", 5, 9, false, 1, 10));
        levelSevenItems.add(new Potion("ToiletPaper_1", 13, 6, false, 1, 2));
    }

    private void initializeItemLevelEightArrayLists() {
        levelEightItems = new ArrayList<Collectable>();
        levelEightItems.add(new HandSanitizer("HandSanitizer_1", 15, 14, false, 1));

    }

    private void initializeItemBossArrayLists() {

        bossItems = new ArrayList<Collectable>();
    }

    private void initializeVaccineArrayLists() {
        vaccineItems = new ArrayList<Collectable>();

        vaccineItems.add(new Potion("Vaccine_1", 9,9,false,1,10));
        vaccineItems.add(new Potion("Vaccine_2", 11,9,false,1,10));
    }

    private void initializeItemFirstChallengeArrayLists() {
        firstChallengeItems = new ArrayList<Collectable>();

        firstChallengeItems.add(new Weapon("FireWipeCrossBow_1", 1, 8, false));
        firstChallengeItems.add(new Potion("ToiletPaper_1", 13, 6, false, 1, 2));
    }

    private void initializeItemSecondChallengeArrayLists() {
        secondChallengeItems = new ArrayList<Collectable>();

        secondChallengeItems.add(new N95("N95Mask_1", 5, 9, false, 1, 10));
        secondChallengeItems.add(new Weapon("FireDisinfectantSpray_1", 4, 7, false));
    }

    private void initializeItemThirdChallengeArrayLists() {
        thirdChallengeItems = new ArrayList<Collectable>();

        thirdChallengeItems.add(new N95("N95Mask_1", 5, 9, false, 1, 10));
        thirdChallengeItems.add(new Potion("ToiletPaper_1", 13, 6, false, 1, 2));
        thirdChallengeItems.add(new Weapon("FireThermometerSword_1", 6,6,false));
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

    /**
     *
     * @return First Challenge Screen
     */
    public ChallengeScreen getFirstChallenge() { return firstChallenge; } //*******************************************

    /**
     *
     * @return Second Challenge Screen
     */
    public ChallengeScreen getSecondChallenge() { return secondChallenge; } //*******************************************

    /**
     *
     * @return Third Challenge Screen
     */
    public ChallengeScreen getThirdChallenge() { return thirdChallenge; } //*******************************************
}
