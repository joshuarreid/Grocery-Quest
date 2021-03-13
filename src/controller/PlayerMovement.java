package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayerMovement {
    private int xPosition; //current x or col position
    private int yPosition; //current y or row position

    /**
     * Constructor for player movement
     *
     * @param x intial x or col location
     * @param y inital y or row location
     */
    public PlayerMovement(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    /**
     * Moves a Player's location on a given board depending on arrow key events
     *
     * @param mainWindow main Stage
     * @param scene current Scene
     * @param hero current Player
     * @param board current Board
     */
    public void moveCharacter(Stage mainWindow, Scene scene, Player hero, Board board) {

        mainWindow.setScene(scene);
        mainWindow.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleKeys(scene, hero, board);
            }
        };
        timer.start();
    }

    /**
     * Method that handles arrow key events and their indicated player movement.
     * Also updates the side the player is facing
     *
     * @param scene current Scene
     * @param hero current Player
     * @param board current Board
     */
    private void handleKeys(Scene scene, Player hero, Board board) {
        scene.setOnKeyPressed( event -> {
            switch (event.getCode()) {
                case UP:
                    if(!board.isBlocked(yPosition - 1, xPosition)) {
                        moveHeroBy(hero, 0, -1, board);
                    }
                    break;
                case DOWN:
                    if(!board.isBlocked(yPosition + 1, xPosition)) {
                        moveHeroBy(hero, 0, 1, board);
                    }
                    break;
                case LEFT:
                    if(!board.isBlocked(yPosition, xPosition - 1)) {
                        if (!hero.getCurrentSide().equals("Left")) {
                            hero.setCurrentSide("Left");
                        }
                        moveHeroBy(hero, -1, 0, board);
                    }
                    break;
                case RIGHT:
                    if(!board.isBlocked(yPosition, xPosition + 1)) {
                        if (!hero.getCurrentSide().equals("Right")) {
                            hero.setCurrentSide("Right");
                        }
                        moveHeroBy(hero, 1, 0, board);
                    }
                    break;
            }
        });
    }

    /**
     * Calculates position change of the player
     *
     * @param hero current Player
     * @param dx position change in x direction
     * @param dy position change in y direction
     * @param board current Board
     */
    private void moveHeroBy(Player hero, int dx, int dy, Board board) {
        if (dx == 0 && dy == 0) return;
        int x = xPosition + dx;
        int y = yPosition + dy;
        moveHeroTo(hero, x, y, board);
    }

    /**
     * Updates player location by:
     * 1. removing player from current location
     * 2. adding player to new location
     * 3. if adding player to new location is successful,
     *    current location is updated
     *
     * @param hero current Player
     * @param x tentative new x or col location
     * @param y tentative new y or row location
     * @param board current Board
     */
    private void moveHeroTo(Player hero, int x, int y, Board board){
        System.out.println(board.removeObject("player", xPosition, yPosition));
        boolean worked = board.addObject(hero.getPlayerImage(),
                "player", false, y, 0, x, 0);
        if (worked) {
            xPosition = x;
            yPosition = y;
        }
    }
}
