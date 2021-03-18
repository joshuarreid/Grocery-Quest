package model;

public class GameModel {
    private String state;
    public GameModel() {
        this.state = "None";
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}

/*
 * LEGEND:
 * StartScreen = "Start Screen"
 * ConfigurationScreen = "Configuration Screen"
 *
 * GameScreen = "Game Screen"
 * WeaponsScreen = "Weapons Screen"
 * TrainingScreen = "Training Screen"
 *
 * LevelOneScreen = "Level 1"
 * LevelTwoScreen =  "Level 2"
 * LevelThreeScreen = "Level 3"
 * LevelFourScreen = "Level 4"
 * LevelFiveScreen = "Level 5"
 * LevelSixScreen = "Level 6"
 * LevelSevenScreen = "Level 7"
 * LevelEightScreen = "Level 8"
 * LevelOneScreen = "Level 9"
 *
 * WonScreen = "Won Screen"
 * LoseScreen = "Lose Screen"
 *
 */
