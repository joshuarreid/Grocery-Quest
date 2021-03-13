package controller;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayerMovement {
    private int xPosition;
    private int yPosition;
    boolean goNorth, goSouth, goEast, goWest;
    private Board board;

    public PlayerMovement(Board board) {
        this.xPosition = 8;
        this.yPosition = 15;
        this.board = board;
    }
    public void moveCharacter(Stage mainWindow, Scene scene, Player hero) {

        scene.setOnKeyPressed( event -> {
            switch (event.getCode()) {
//                case UP:    goNorth = true; break;
//                case DOWN:  goSouth = true; break;
//                case LEFT:  goWest  = true; break;
//                case RIGHT: goEast  = true; break;
                case UP:    moveHeroBy(hero, 0, -1); break;
                case DOWN:  moveHeroBy(hero, 0, 1); break;
                case LEFT:  moveHeroBy(hero, 1, 0); break;
                case RIGHT: moveHeroBy(hero, -1, 0); break;
            }
        });

//        scene.setOnKeyReleased(event -> {
//            switch (event.getCode()) {
//                case UP:    goNorth = false; break;
//                case DOWN:  goSouth = false; break;
//                case LEFT:  goWest  = false; break;
//                case RIGHT: goEast  = false; break;
//            }
//        });
        mainWindow.setScene(scene);
        mainWindow.show();

//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                int dx = 0, dy = 0;
//
//                if (goNorth) dy -= 1;
//                if (goSouth) dy += 1;
//                if (goEast)  dx += 1;
//                if (goWest)  dx -= 1;
//
//                moveHeroBy(hero, dx, dy);
//            }
//        };
//        timer.start();
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
//            int dx = 0, dy = 0;
//
//                if (goNorth) dy -= 1;
//                if (goSouth) dy += 1;
//                if (goEast)  dx += 1;
//                if (goWest)  dx -= 1;
//
//                moveHeroBy(hero, dx, dy);
//        }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
    }

    private void moveHeroBy(Player hero, int dx, int dy) {
        if (dx == 0 && dy == 0) return;
        int x = xPosition + dx;
        int y = yPosition + dy;
        moveHeroTo(hero, x, y);
    }

    private void moveHeroTo(Player hero, int x, int y){
        System.out.println(board.removeObject("player", xPosition, yPosition));
        boolean worked = board.addObject(hero.getPlayerImage(), "player", false, y, 0, x, 0);
        if (worked) {
            xPosition = x;
            yPosition = y;
        }
    }
}
