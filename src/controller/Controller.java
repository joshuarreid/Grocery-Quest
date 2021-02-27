package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import model.GameModel;
import view.GameScreen;
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

        Button easyButton = screen.getEasyButton();
        Button mediumButton = screen.getMediumButton();
        Button hardButton = screen.getHardButton();
        Button startButton = screen.getStartButton();
        Button wipeCrossbowButton = screen.getWipeCrossbowButton();
        Button disinfectantSprayButton = screen.getDisinfectantSprayButton();
        Button thermometerSwordButton = screen.getThermometerSwordButton();
        TextField nameField = screen.getNameField();
        easyButton.setOnAction( e -> difficultyLevel = 1);
        mediumButton.setOnAction( e -> difficultyLevel = 2);
        hardButton.setOnAction( e -> difficultyLevel = 3);

        wipeCrossbowButton.setOnAction( e -> {
//            System.out.println("weapon: wipe crossbow ");
            weaponChoice = "wipe crossbow";
        });
        disinfectantSprayButton.setOnAction( e -> {
//            System.out.println("weapon: disinfectant spray ");
            weaponChoice = "disinfectant spray";
        });
        thermometerSwordButton.setOnAction( e -> {
//            System.out.println("weapon: thermometer sword ");
            weaponChoice = "thermometer sword";
        });
        
        startButton.setOnAction(e -> {
            System.out.println(nameField.getText());
            goToGameScreen();
        });

//        nameField.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                boolean validName = false;
//                while (validName == false) {
//                    if (event.getCode() == KeyCode.ENTER) {
//                        String name = nameField.getText();
//                        if (name == null || name.trim().isEmpty()) {
//                            nameField.setPromptText("Invalid Name");
//                        } else {
//                            validName = true;
//                        }
//                    }
//                }
//                System.out.print("launch initial game screen");
//            }
//        });

        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();

    }

    private void goToGameScreen() {
        GameScreen screen = new GameScreen(width, height);

        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
