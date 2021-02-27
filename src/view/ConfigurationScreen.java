package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ConfigurationScreen {
    private int width;
    private int height;
    private Button easyButton;
    private Button mediumButton;
    private Button hardButton;
    private Button wipeCrossbowButton;
    private Button disinfectantSprayButton;
    private Button thermometerSwordButton;
    private TextField nameField;
    private Label enterYourName;
    private Label chooseDifficultyLevel;
    private Label selectYourWeapon;


    public ConfigurationScreen(int width, int height) {
        this.width = width;
        this.height = height;
        this.easyButton = new Button("easy");
        this.mediumButton = new Button("medium");
        this.hardButton = new Button("hard");
        this.wipeCrossbowButton = new Button();
        this.disinfectantSprayButton = new Button();
        this.thermometerSwordButton = new Button();
        this.nameField = new TextField();
        this.enterYourName = new Label("Enter Your Name");
        this.chooseDifficultyLevel = new Label("Choose Difficulty Level");
        this.selectYourWeapon = new Label("Select Your Weapon");
    }

    public Scene getScene() {
        Font dogicaFont = Font.loadFont("file:resources/dogica/TTF/dogicapixel.ttf", 20);
        Font dogicaFontBold = Font.loadFont( "file:resources/dogica/TTF/dogicapixelbold.ttf", 23);
        //***** Enter Your Name ******
        //setting up "Enter Your Name" Label
        enterYourName.setFont(dogicaFontBold);
        //setting up graphic for name field
        ImageView nameTextFeildImgView = new ImageView(new Image("file:resources/pngs/nameTextBox.png"));
        nameTextFeildImgView.setFitWidth(400);
        nameTextFeildImgView.setPreserveRatio(true);
        //setting up the name field
        nameField.setFont(dogicaFont);
        nameField.setMaxWidth(380);
        nameField.setPrefHeight(50);
        nameField.setStyle("-fx-background-radius: 10 10 10 10");
        nameField.setStyle("-fx-background-color: #ebd6b4");
        //Stack pane to impose name field over the graphic
        StackPane nameFeildPane = new StackPane();
        nameFeildPane.getChildren().addAll(nameTextFeildImgView, nameField);
        //Vertical box to hold label and name feild
        VBox namePane = new VBox(15);
        namePane.setAlignment(Pos.CENTER);

        namePane.getChildren().addAll(enterYourName, nameFeildPane);

        //***** Choose Difficulty Level *****
        //setting up level difficulty label
        chooseDifficultyLevel.setFont(dogicaFontBold);
        chooseDifficultyLevel.setAlignment(Pos.CENTER);
        chooseDifficultyLevel.setPrefWidth(500);
        //setting up easy difficulty button
        easyButton.setFont(dogicaFont);
        easyButton.setStyle("-fx-background-color: #ebd6b4");
        //setting up medium difficulty button
        mediumButton.setFont(dogicaFont);
        mediumButton.setStyle("-fx-background-color: #ebd6b4");
        //setting up hard difficulty label
        hardButton.setFont(dogicaFont);
        hardButton.setStyle("-fx-background-color: #ebd6b4");
        //Horizontal box to hold the level difficulty buttons
        HBox levelButtonBox = new HBox(75);
        levelButtonBox.getChildren().addAll(easyButton, mediumButton, hardButton);
        levelButtonBox.setAlignment(Pos.CENTER);
        //Vertical box to hold the level difficulty label and buttons
        VBox levelBox = new VBox(25);
//        levelBox.setPadding(new Insets(10,0,10,0));
        levelBox.setAlignment(Pos.CENTER);
        levelBox.getChildren().addAll(chooseDifficultyLevel, levelButtonBox);

        //***** Select Your Weapon *****
        //setting up weapon title
        selectYourWeapon.setFont(dogicaFontBold);
        //setting up wipeCrossbow weapon button
        ImageView wipeCrossbow = new ImageView(new Image("file:resources/pngs/Grocery Quest Screens-08.png"));
        wipeCrossbow.setFitWidth(140);
        wipeCrossbow.setPreserveRatio(true);
        wipeCrossbowButton.setGraphic(wipeCrossbow);
        wipeCrossbowButton.setStyle("-fx-background-color: #ebd6b4");
        //setting up disinfectantSpray weapon button
        ImageView disinfectantSpray = new ImageView(new Image("file:resources/pngs/Grocery Quest Screens-10.png"));
        disinfectantSpray.setFitWidth(140);
        disinfectantSpray.setPreserveRatio(true);
        disinfectantSprayButton.setGraphic(disinfectantSpray);
        disinfectantSprayButton.setStyle("-fx-background-color: #ebd6b4");
        //setting up thermometerSword weapon button
        ImageView thermometerSword = new ImageView(new Image("file:resources/pngs/Grocery Quest Screens-11.png"));
        thermometerSword.setFitWidth(140);
        thermometerSword.setPreserveRatio(true);
        thermometerSwordButton.setGraphic(thermometerSword);
        thermometerSwordButton.setStyle("-fx-background-color: #ebd6b4");
        //Horizontal box pane to hold the weapon buttons
        HBox weaponListBox = new HBox(15);
        weaponListBox.setAlignment(Pos.CENTER);
        weaponListBox.getChildren().addAll(wipeCrossbowButton, disinfectantSprayButton, thermometerSwordButton);
        weaponListBox.setStyle("-fx-background-color: #ebd6b4");
        //Vertical box pane to hold the weapon title and buttons
        VBox weaponBox = new VBox(18);
        weaponBox.setAlignment(Pos.CENTER);
        weaponBox.getChildren().addAll(selectYourWeapon, weaponListBox);

        //base holds all the other panes and goes into the cofig scene
        VBox base = new VBox(25);
        base.setPadding(new Insets(50,0,50,0));

        base.getChildren().addAll(namePane,levelBox,weaponBox);
        base.setStyle("-fx-background-color: #ebd6b4");

        Scene configurationScene = new Scene(base, width,height);

        return configurationScene;
    }

    public Button getEasyButton() {
        return easyButton;
    }

    public Button getMediumButton() {
        return mediumButton;
    }

    public Button getHardButton() { return hardButton; }

    public Button getWipeCrossbowButton() { return wipeCrossbowButton; }

    public Button getDisinfectantSprayButton() { return disinfectantSprayButton; }

    public Button getThermometerSwordButton() { return thermometerSwordButton; }

    public TextField getNameField() { return nameField;}

}
