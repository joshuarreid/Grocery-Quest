package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.GameModel;
import view.FirstScreen;
import view.SecondScreen;


public class Controller extends Application {
    private Stage mainWindow;
    private GameModel gameModel;
    private final int width = 500;
    private final int height = 500;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainWindow = primaryStage;
        mainWindow.setTitle("TestFX Tutorial");
        gameModel = new GameModel();
        initFirstScreen();
    }

    private void initFirstScreen() {
        FirstScreen screen = new FirstScreen(width, height);
        Button quitButton = screen.getQuitButton();
        quitButton.setOnAction(e -> mainWindow.close());
        Button playButton = screen.getPlayButton();
        playButton.setOnAction(e -> goToSecondScreen());

        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private void goToSecondScreen() {
        SecondScreen screen = new SecondScreen(width, height);
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

        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
