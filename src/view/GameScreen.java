package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GameScreen {
    private int width;
    private int height;

    private static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 20);

    public GameScreen(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public Scene getScene() {
        Label practice = new Label("This is where the inital game screen goes :)");
        practice.setFont(DOGICA_FONT);
        practice.setWrapText(true);
        VBox base = new VBox(10);
        base.getChildren().addAll(practice);
        base.setAlignment(Pos.CENTER);
        Scene gameScene = new Scene(base, width,height);
        return gameScene;
    }
}
