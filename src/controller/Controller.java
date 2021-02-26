package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.GameModel;
import view.StartScreen;
import view.ConfigurationScreen;

public class Controller extends Application {
    private Stage mainWindow;
    private GameModel gameModel;
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
        /// *** Needs to change
        Button decrButton = screen.getDecrButton();
        decrButton.setOnAction(e -> {
            gameModel.decrementState();
            screen.updateLabel(gameModel.getState());
        });
        Button incrButton = screen.getIncrButton();
        incrButton.setOnAction(e -> {
            gameModel.incrementState();
            screen.updateLabel(gameModel.getState());
        });
        /// *** stop changes

        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
