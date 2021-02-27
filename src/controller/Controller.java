package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import model.GameModel;
import view.StartScreen;
import view.ConfigurationScreen;

public class Controller extends Application {
    private Stage mainWindow;
    private GameModel gameModel;
    private int difficultyLevel;
    private String weaponChoice;
    private final int width = 600;
    private final int height = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainWindow = primaryStage;
        mainWindow.setTitle("Grocery Quest");
        gameModel = new GameModel();
        initStartScreen();
    }

    private void initStartScreen() {
        StartScreen screen = new StartScreen(width, height);
        Button startButton = screen.getStartButton();
        startButton.setOnAction(e -> goToConfigurationScreen());
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private void goToConfigurationScreen() {
        ConfigurationScreen screen = new ConfigurationScreen(width, height);
        TextField nameField = screen.getNameField();
        Button easyButton = screen.getEasyButton();
        Button mediumButton = screen.getMediumButton();
        Button hardButton = screen.getHardButton();
        Button thermometerSword = screen.getThermometerSword();
        Button disinfectantSpray = screen.getDisinfectantSpray();
        Button wipeCrossBow = screen.getWipeCrossbow();

        easyButton.setOnAction(event -> {
            difficultyLevel = 1;
        });

        mediumButton.setOnAction(event -> {
            difficultyLevel = 2;
        });

        hardButton.setOnAction(event -> {
            difficultyLevel = 3;
        });

        thermometerSword.setOnAction(event -> {
            weaponChoice = "thermometer sword";
        });

        disinfectantSpray.setOnAction(event -> {
            weaponChoice = "disinfectant spray";
        });

        wipeCrossBow.setOnAction(event -> {
            weaponChoice = "wipe crossbow";
        });


        Scene scene = screen.getScene();
        mainWindow.setScene(scene);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
