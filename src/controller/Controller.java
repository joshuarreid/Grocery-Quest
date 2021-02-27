package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


import model.GameModel;
import view.GameScreen;
import view.StartScreen;
import view.ConfigurationScreen;

import java.awt.*;


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
        Button readyButton = screen.getReadyButton();
        Button wipeCrossbowButton = screen.getWipeCrossbowButton();
        Button disinfectantSprayButton = screen.getDisinfectantSprayButton();
        Button thermometerSwordButton = screen.getThermometerSwordButton();
        TextField nameField = screen.getNameField();

        easyButton.setOnAction( e -> {
            difficultyLevel = 1;
            easyButton.setEffect(new DropShadow(2.0, Color.BLACK));
            mediumButton.setEffect(null);
            hardButton.setEffect(null);
        });
        mediumButton.setOnAction( e -> {
            difficultyLevel = 2;
            mediumButton.setEffect(new DropShadow(2.0, Color.BLACK));
            easyButton.setEffect(null);
            hardButton.setEffect(null);
        });
        hardButton.setOnAction( e -> {
            difficultyLevel = 3;
            hardButton.setEffect(new DropShadow(2.0, Color.BLACK));
            easyButton.setEffect(null);
            mediumButton.setEffect(null);
        });

        wipeCrossbowButton.setOnAction( e -> {
            weaponChoice = "wipe crossbow";
            wipeCrossbowButton.setEffect(new DropShadow(2.0, Color.BLACK));
            disinfectantSprayButton.setEffect(null);
            thermometerSwordButton.setEffect(null);
        });
        disinfectantSprayButton.setOnAction( e -> {
            weaponChoice = "disinfectant spray";
            disinfectantSprayButton.setEffect(new DropShadow(2.0, Color.BLACK));
            wipeCrossbowButton.setEffect(null);
            thermometerSwordButton.setEffect(null);
        });
        thermometerSwordButton.setOnAction( e -> {
            weaponChoice = "thermometer sword";
            thermometerSwordButton.setEffect(new DropShadow(2.0, Color.BLACK));
            wipeCrossbowButton.setEffect(null);
            disinfectantSprayButton.setEffect(null);
        });

        //If player presses enter on the textfield
        nameField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER){
                String name = nameField.getText();
                if (name == null || name.trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.getDialogPane().setPrefSize(width, height);
                    a.setTitle("Error");
                    a.setContentText("Invalid Name");
                    a.showAndWait();
                    nameField.clear();
                } else if (difficultyLevel == 0 || weaponChoice == null) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.getDialogPane().setPrefSize(width, height);
                    a.setTitle("Error");
                    a.setContentText("You Must Choose a Weapon and Difficulty Level");
                    a.showAndWait();
                } else {
                    //Level levelOne = new Level(1, difficultyLevel);
                    //Launch Initial game screen
                    System.out.println("VALID!");
                }
            }
        });

        readyButton.setOnAction(e -> {
            System.out.println(nameField.getText());
            goToGameScreen();
        });

        //TODO implement readyButton 

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
