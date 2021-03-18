package controller;

import model.ExitType;
import view.GameScreen;
import view.LevelOneScreen;
import view.LevelScreen;

public class LevelSetup {
    private LevelRandomizer levelRandomizer;
//    Exit intialGameScreen_weapon = new Exit();
//    Exit intialGameScreen_training = new Exit();
//    Exit intialGameScreen_exitGame = new Exit();
    Exit initialGameScreen_level1;

//    Exit level1_level2 = new Exit();
//    Exit level2_level3 = new Exit();
//    Exit level3_level4 = new Exit();

//    Exit level4_level5 = new Exit();
//    Exit level5_level6 = new Exit();
//    Exit level6_level7 = new Exit();
//    Exit level7_level8 = new Exit();
//    Exit level8_endRoom = new Exit();
//    Exit endRoom_WinScreen = new Exit();

    Exit[] initialGameScreenExits;

    private GameScreen gameScreen;
    private LevelScreen levelOne;
    public LevelSetup(int width, int height, Player hero){
        this.levelRandomizer = new LevelRandomizer();
        initialGameScreen_level1= new Exit(ExitType.TOP, ExitType.BOTTOM,"initial game screen", "level one");

        initialGameScreenExits = new Exit[]{initialGameScreen_level1};
        gameScreen = new GameScreen(width, height, hero, 1, initialGameScreenExits);
        Exit[] LevelOneExits = []{

        };
        levelOne = new LevelOneScreen(width, height, hero, 2, levelRandomizer);
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public LevelScreen getLevelOne() {
        return levelOne;
    }
}
