package controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class PlayerMovement {
    private int xPosition;
    private int yPosition;
    boolean running, goNorth, goSouth, goEast, goWest;
    private Board board;

    public PlayerMovement(Board board) {
        this.xPosition = 8;
        this.yPosition = 15;
        this.board = board;
    }
    public Scene moveCharacter(Scene scene, Player hero, Board board) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goNorth = true; break;
                    case DOWN:  goSouth = true; break;
                    case LEFT:  goWest  = true; break;
                    case RIGHT: goEast  = true; break;
                    case SHIFT: running = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goNorth = false; break;
                    case DOWN:  goSouth = false; break;
                    case LEFT:  goWest  = false; break;
                    case RIGHT: goEast  = false; break;
                    case SHIFT: running = false; break;
                }
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goNorth) dy -= 1;
                if (goSouth) dy += 1;
                if (goEast)  dx += 1;
                if (goWest)  dx -= 1;
                if (running) { dx *= 3; dy *= 3; }

                moveHeroBy(hero, dx, dy);
            }
        };
        timer.start();
        return scene;
    };

    private void moveHeroBy(Player hero, int dx, int dy) {
        if (dx == 0 && dy == 0) return;
        int x = xPosition + dx;
        int y = yPosition + dy;
        moveHeroTo(hero, x, y);
    }

    private void moveHeroTo(Player hero, int x, int y){
        board.getGridPane().getChildren().remove(hero.getPlayerImage());
        boolean worked = board.addObject(hero.getPlayerImage(), "player", false, y, 0, x, 0);
        if (worked) {
            xPosition = x;
            yPosition = y;
        }
    }
};
