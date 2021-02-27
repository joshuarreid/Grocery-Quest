package view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class ConfigurationScreeenUI {
    private int width;
    private int height;
    private TextField nameField;
    private Button easyButton;
    private Button mediumButton;
    private Button hardButton;
    private Button thermometerSword;
    private Button disinfectantSpray;
    private Button wipeCrossbow;


    public ConfigurationScreeenUI(int width, int height) {
        this.width = width;
        this.height = height;
        this.nameField = new TextField();
        this.easyButton = new Button("easy");
        this.mediumButton = new Button("medium");
        this.hardButton = new Button("hard");
        this.thermometerSword = new Button();
        this.disinfectantSpray = new Button();
        this.wipeCrossbow = new Button();
    }

    public Scene getScene() {
        //Setting up "ENTER YOUR NAME" Graphic
        Image nameImage = new Image("/resources/images/name.png");
        ImageView nameImageView = new ImageView(nameImage);
        nameImageView.setFitWidth(500);
        nameImageView.setPreserveRatio(true);

        //Setting up TextField below "ENTER YOUR NAME" Graphic
        this.nameField = new TextField();
        this.nameField.setMaxWidth(430);
        this.nameField.setPrefHeight(30);
        this.nameField.setStyle("-fx-background-radius: 10 10 10 10");
        this.nameField.setStyle("-fx-background-color: #ebd6b4");

        //StackPane to place TextField over the UI Graphic
        StackPane namePane = new StackPane();
        namePane.getChildren().addAll(nameImageView, this.nameField);
        Font dogicaFont = Font.loadFont("file:src/resources/fonts/dogica/TTF/dogicapixel.ttf", 20);

        //setting up "CHOOSE DIFFICULTY LEVEL" graphic
        Label chooseDifficultyLevel = new Label("Choose Difficulty Level");
        chooseDifficultyLevel.setFont(Font.loadFont("file:src/resources/fonts/dogica/TTF/dogicapixelbold.ttf", 23));
        chooseDifficultyLevel.setAlignment(Pos.CENTER);
        chooseDifficultyLevel.setPrefWidth(500);

        //setting up easy difficulty button
        this.easyButton.setFont(dogicaFont);
        this.easyButton.setStyle("-fx-background-color: #ebd6b4");

        //setting up medium difficulty button
        this.mediumButton.setFont(dogicaFont);
        this.mediumButton.setStyle("-fx-background-color: #ebd6b4");

        //setting up hard difficulty button
        this.hardButton.setFont(dogicaFont);
        this.hardButton.setStyle("-fx-background-color: #ebd6b4");

        //Hbox to hold the level difficulty buttons
        HBox difficultyHBox = new HBox(80);
        difficultyHBox.getChildren().addAll(this.easyButton, this.mediumButton, this.hardButton);
        difficultyHBox.setAlignment(Pos.CENTER);

        //Vertical box to hold the level difficulty label and buttons
        VBox difficultyVBox = new VBox(10);
        difficultyVBox.setAlignment(Pos.CENTER);
        difficultyVBox.getChildren().addAll(chooseDifficultyLevel, difficultyHBox);

        //setting up "SELECT YOUR WEAPON" title
        Label weaponLabel = new Label("Select Your Weapon");
        weaponLabel.setFont(Font.loadFont("file:src/resources/fonts/dogica/TTF/dogicapixelbold.ttf", 23));
        weaponLabel.setPrefWidth(500);
        weaponLabel.setAlignment(Pos.CENTER);

        //setting up wipeCrossbow weapon button
        ImageView weapon1 = new ImageView(new Image("/resources/images/weapon1.png"));
        weapon1.setFitWidth(140);
        weapon1.setPreserveRatio(true);
        this.wipeCrossbow.setGraphic(weapon1);
        this.wipeCrossbow.setStyle("-fx-background-color: #ebd6b4");

        //setting up disinfectantSpray weapon button
        ImageView weapon2 = new ImageView(new Image("/resources/images/weapon2.png"));
        weapon2.setFitWidth(140);
        weapon2.setPreserveRatio(true);
        this.disinfectantSpray.setGraphic(weapon2);
        this.disinfectantSpray.setStyle("-fx-background-color: #ebd6b4");

        //setting up thermometerSword weapon button
        ImageView weapon3 = new ImageView(new Image("/resources/images/weapon3.png"));
        weapon3.setFitWidth(140);
        weapon3.setPreserveRatio(true);
        this.thermometerSword.setGraphic(weapon3);
        this.thermometerSword.setStyle("-fx-background-color: #ebd6b4");

        //Hbox to hold the weapon buttons
        HBox weaponHBox = new HBox(15);
        weaponHBox.setAlignment(Pos.CENTER);
        weaponHBox.getChildren().addAll(wipeCrossbow, disinfectantSpray, thermometerSword);
        weaponHBox.setStyle("-fx-background-color: #ebd6b4");

        //Vbox pane to hold the weapon title and buttons
        VBox weaponVBox = new VBox(20);
        weaponVBox.setAlignment(Pos.CENTER);
        weaponVBox.getChildren().addAll(weaponLabel, weaponHBox);

        //base holds all the previously created panes
        VBox base = new VBox(25);
        base.getChildren().addAll(namePane, difficultyVBox, weaponVBox);
        base.setStyle("-fx-background-color: #ebd6b4");

        //Creating the scene
        Scene scene = new Scene(base, this.width, this.height);
        return scene;
    }

    //TODO delete method once getScene is functional
    public void setupConfigUI(Stage stage) {
        //setting up graphic for name field
        Image nameImage = new Image("/resources/images/name.png");
        ImageView nameImageView = new ImageView(nameImage);
        nameImageView.setFitWidth(500);
        nameImageView.setPreserveRatio(true);
        //setting up the name field
        TextField nameField = new TextField();
        nameField.setMaxWidth(430);
        nameField.setPrefHeight(30);
        nameField.setStyle("-fx-background-radius: 10 10 10 10");
        nameField.setStyle("-fx-background-color: #ebd6b4");
        //Stack pane to impose name field over the graphic
        StackPane namePane = new StackPane();
        namePane.getChildren().addAll(nameImageView, nameField);
        Font dogicaFont = Font.loadFont("file:src/resources/fonts/dogica/TTF/dogicapixel.ttf", 20);

        //setting up level difficulty label
        Label levelLabel = new Label("Choose Difficulty Level");
        levelLabel.setFont(Font.loadFont("file:src/resources/fonts/dogica/TTF/dogicapixelbold.ttf", 23));
        levelLabel.setAlignment(Pos.CENTER);
        levelLabel.setPrefWidth(500);
        //setting up easy difficulty button
        Button btEasy = new Button("easy");
        btEasy.setFont(dogicaFont);
        btEasy.setStyle("-fx-background-color: #ebd6b4");
        //setting up medium difficulty button
        Button btMedium = new Button("medium");
        btMedium.setFont(dogicaFont);
        btMedium.setStyle("-fx-background-color: #ebd6b4");
        //setting up hard difficulty label
        Button btHard = new Button("hard");
        btHard.setFont(dogicaFont);
        btHard.setStyle("-fx-background-color: #ebd6b4");
        //Horizontal box to hold the level difficulty buttons
        HBox levelButtonBox = new HBox(80);
        levelButtonBox.getChildren().addAll(btEasy, btMedium, btHard);
        levelButtonBox.setAlignment(Pos.CENTER);
        //Vertical box to hold the level difficulty label and buttons
        VBox levelBox = new VBox(10);
        levelBox.setAlignment(Pos.CENTER);
        levelBox.getChildren().addAll(levelLabel, levelButtonBox);

        //setting up weapon title
        Label weaponLabel = new Label("Select Your Weapon");
        weaponLabel.setFont(Font.loadFont("file:src/resources/fonts/dogica/TTF/dogicapixelbold.ttf", 23));
        weaponLabel.setPrefWidth(500);
        weaponLabel.setAlignment(Pos.CENTER);
        //setting up wipeCrossbow weapon button
        Button wipeCrossbow = new Button();
        ImageView weapon1 = new ImageView(new Image("/resources/images/weapon1.png"));
        weapon1.setFitWidth(140);
        weapon1.setPreserveRatio(true);
        wipeCrossbow.setGraphic(weapon1);
        wipeCrossbow.setStyle("-fx-background-color: #ebd6b4");
        //setting up disinfectantSpray weapon button
        Button disinfectantSpray = new Button();
        ImageView weapon2 = new ImageView(new Image("/resources/images/weapon2.png"));
        weapon2.setFitWidth(140);
        weapon2.setPreserveRatio(true);
        disinfectantSpray.setGraphic(weapon2);
        disinfectantSpray.setStyle("-fx-background-color: #ebd6b4");
        //setting up thermometerSword weapon button
        Button thermometerSword = new Button();
        ImageView weapon3 = new ImageView(new Image("/resources/images/weapon3.png"));
        weapon3.setFitWidth(140);
        weapon3.setPreserveRatio(true);
        thermometerSword.setGraphic(weapon3);
        thermometerSword.setStyle("-fx-background-color: #ebd6b4");
        //Horizontal box pane to hold the weapon buttons
        HBox weaponListBox = new HBox(15);
        weaponListBox.setAlignment(Pos.CENTER);
        weaponListBox.getChildren().addAll(wipeCrossbow, disinfectantSpray, thermometerSword);
        weaponListBox.setStyle("-fx-background-color: #ebd6b4");
        //Vertical box pane to hold the weapon title and buttons
        VBox weaponBox = new VBox(20);
        weaponBox.setAlignment(Pos.CENTER);
        weaponBox.getChildren().addAll(weaponLabel, weaponListBox);

        //base holds all the other panes and goes into the cofig scene
        VBox base = new VBox(25);
        base.getChildren().addAll(namePane, levelBox, weaponBox);
        base.setStyle("-fx-background-color: #ebd6b4");

        Scene configScene = new Scene(base);
        int stageEdgeLength = 600;
        stage.setHeight(stageEdgeLength);
        stage.setWidth(stageEdgeLength);
        stage.setScene(configScene);
        stage.setTitle("Config Screen Demo");
        stage.show();
    }

    public TextField getNameField() {
        return nameField;
    }

    public Button getEasyButton() {
        return easyButton;
    }

    public Button getMediumButton() {
        return mediumButton;
    }

    public Button getHardButton() {
        return hardButton;
    }

    public Button getThermometerSword() {
        return thermometerSword;
    }

    public Button getDisinfectantSpray() {
        return disinfectantSpray;
    }

    public Button getWipeCrossbow() {
        return wipeCrossbow;
    }
}
