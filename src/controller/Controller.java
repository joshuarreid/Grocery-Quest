package controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import model.GameModel;
import model.Level;
import model.Player;
import model.PlayerHealth;
import view.*;


/**The Controller Class
 *
 * The Controller class is responsible for creating the stage,
 * switching between scenes and providing event handling for the
 * controls of each scene
 *
 * mainWindow - the main window that launches each scene
 * gameModel - GameModel object responsible for keeping current state of game
 * difficultyLevel - the difficulty level the player chooses
 * weaponChoice - the weapon the player chooses
 * width - the width of the Stage/mainWindow
 * height - the height of the Stage/mainWindow
 */
public class Controller extends Application {
    private Stage mainWindow;
    private GameModel gameModel;
    private int difficultyLevel;
    private String weaponChoice;
    private final int width = 600;
    private final int height = 600;
    private Player hero;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        mainWindow.setTitle("Grocery Quest");
        mainWindow.setResizable(false);
        gameModel = new GameModel();
        initStartScreen();
    }

    /**
     * This method launches and provides event handling for
     * the Start Screen
     */
    private void initStartScreen() {
        gameModel.setState("Start Screen");
        StartScreen screen = new StartScreen(width, height);
        Button startButton = screen.getStartButton();
        startButton.setOnAction(e -> {
            goToConfigurationScreen();
        });
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     * This method launches and provides event handling for
     * the Player Configuration Screen
     */
    private void goToConfigurationScreen() {
        gameModel.setState("Configuration Screen");
        ConfigurationScreen screen = new ConfigurationScreen(width, height);
        Button easyButton = screen.getEasyButton();
        Button mediumButton = screen.getMediumButton();
        Button hardButton = screen.getHardButton();
        Button readyButton = screen.getReadyButton();
        Button wipeCrossbowButton = screen.getWipeCrossbowButton();
        Button disinfectantSprayButton = screen.getDisinfectantSprayButton();
        Button thermometerSwordButton = screen.getThermometerSwordButton();
        TextField nameField = screen.getNameField();

        //If player clicks the easy difficulty button
        easyButton.setOnAction(e -> {
            difficultyLevel = 1;
            easyButton.setEffect(new DropShadow(2.0, Color.BLACK));
            mediumButton.setEffect(null);
            hardButton.setEffect(null);
        });

        //If player clicks the medium difficulty button
        mediumButton.setOnAction(e -> {
            difficultyLevel = 2;
            mediumButton.setEffect(new DropShadow(2.0, Color.BLACK));
            easyButton.setEffect(null);
            hardButton.setEffect(null);
        });

        //If player clicks the hard difficulty button
        hardButton.setOnAction(e -> {
            difficultyLevel = 3;
            hardButton.setEffect(new DropShadow(2.0, Color.BLACK));
            easyButton.setEffect(null);
            mediumButton.setEffect(null);
        });

        //If player clicks the wipe crossbow button
        wipeCrossbowButton.setOnAction(e -> {
            weaponChoice = "crossbow";
            wipeCrossbowButton.setEffect(new DropShadow(2.0, Color.BLACK));
            disinfectantSprayButton.setEffect(null);
            thermometerSwordButton.setEffect(null);
        });

        //If player clicks the disinfectant spray button
        disinfectantSprayButton.setOnAction(e -> {
            weaponChoice = "spray";
            disinfectantSprayButton.setEffect(new DropShadow(2.0, Color.BLACK));
            wipeCrossbowButton.setEffect(null);
            thermometerSwordButton.setEffect(null);
        });

        //If player clicks the thermometer sword button
        thermometerSwordButton.setOnAction(e -> {
            weaponChoice = "sword";
            thermometerSwordButton.setEffect(new DropShadow(2.0, Color.BLACK));
            wipeCrossbowButton.setEffect(null);
            disinfectantSprayButton.setEffect(null);
        });

        /*
        If player presses enter key on the ENTER YOUR NAME textfield
        this action event ensures the player selected a difficulty
        level and weapon. It also ensures the name is not blank or
        just whitespaces. If correct, it launches the game.
         */
        nameField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String name = nameField.getText();
                if (name == null || name.trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.getDialogPane().setPrefSize(width, height);
                    a.setTitle("Error");
                    a.setContentText("Invalid Name");
                    gameModel.setState("Error Screen");
                    a.showAndWait();
                    nameField.clear();
                    gameModel.setState("Configuration Screen");
                } else if (difficultyLevel == 0 || weaponChoice == null) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.getDialogPane().setPrefSize(width, height);
                    a.setTitle("Error");
                    a.setContentText("You Must Choose a Weapon and Difficulty Level");
                    gameModel.setState("Error Screen");
                    a.showAndWait();
                    gameModel.setState("Configuration Screen");
                } else {
                    Level levelOne = new Level(1, difficultyLevel);
                    hero = new Player(100, 0, name, weaponChoice, difficultyLevel);
                    goToGameScreen();
                    System.out.println("VALID!"); //Delete after previous lines implemented
                }
            }
        });

        /*
        If player clicks on the ready button
        this action event ensures the player selected a difficulty
        level and weapon. It also ensures the name is not blank or
        just whitespaces. If correct, it launches the game.
         */
        readyButton.setOnAction(e -> {
            String name = nameField.getText();
            if (name == null || name.trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.getDialogPane().setPrefSize(width, height);
                a.setTitle("Error");
                a.setContentText("Invalid Name");
                gameModel.setState("Error Screen");
                a.showAndWait();
                nameField.clear();
                gameModel.setState("Configuration Screen");
            } else if (difficultyLevel == 0 || weaponChoice == null) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.getDialogPane().setPrefSize(width, height);
                a.setTitle("Error");
                a.setContentText("You Must Choose a Weapon and Difficulty Level");
                gameModel.setState("Error Screen");
                a.showAndWait();
                gameModel.setState("Configuration Screen");
            } else {
                Level levelOne = new Level(1, difficultyLevel);
                hero = new Player(100, 0, name, weaponChoice, difficultyLevel);
                goToGameScreen();
            }
        });
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
    }

    /**
     * This method launches and provides event handling for
     * the Game Screen
     */
    private void goToGameScreen() {
        LevelController lc = new LevelController(
                mainWindow,
                gameModel,
                difficultyLevel,
                weaponChoice,
                hero);
        lc.initialGameScreen();
    }

    
    public String getState() {
        return gameModel.getState();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
