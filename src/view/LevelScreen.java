package view;

import javafx.scene.Node;
import model.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The LevelScreen Class
 *
 * The LevelScreen Class is responsible for placing and updating
 * all objects on the Level Screen.
 */
public abstract class LevelScreen {
    private int width;
    private int height;
    private ImageView coinBar;
    private ImageView healthBar;
    private Player hero;
    protected Board board;
    private String background;
    private Exit[] exits;
    private String iD;
    private Scene gameScene;
    private ArrayList<Monster> monsters;
    private Inventory inventory;


    protected static final Font DOGICA_FONT = Font.loadFont(
            "file:resources/dogica/TTF/dogicapixel.ttf", 15);

    /**
     * Initial Game Screen Constructor
     *
     * @param width width of window
     * @param height height of window
     * @param hero player
     * @param lr level randomizer
     * @param exits exits on level
     * @param iD level name
     * @param monsters ArrayList of Monsters on the level
     */
    public LevelScreen(int width, int height, Player hero,
                       LevelRandomizer lr, Exit[] exits, String iD, ArrayList<Monster> monsters) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.exits = exits;
        this.board = new Board(19, 19, this.exits, iD);
        this.background = lr.getLayout();
        this.iD = iD;
        this.monsters = monsters;
        //Set up inventory
        inventory = new Inventory(12, 1);
        inventory.createInventory(height, 100);
        GridPane inventoryGridPane = inventory.getGridPane();
        board.createBoard(this.height, this.width);
        //Set up gridPane
        GridPane boardGridPane = board.getGridPane();
        ImageView borderExitImage = new ImageView(
                new Image("file:resources/pngs/FrameAll.png"));
        switch (exits.length) {
        case 1:
            if (exits[0].getExitType(this.iD).equals(ExitType.LEFT)) {
                borderExitImage = new ImageView(
                    new Image("file:resources/pngs/FrameLeft.png"));
            } else {
                borderExitImage = new ImageView(
                    new Image("file:resources/pngs/FrameRight.png"));
            }
            break;
        case 2:
            borderExitImage = new ImageView(
                    new Image("file:resources/pngs/FrameUpDown.png"));
            break;
        default:
        }

        borderExitImage.setFitWidth(width + 4);
        borderExitImage.setFitHeight(height + 4);
        boardGridPane.setStyle("-fx-background-color: " + background);

        inventoryGridPane.setStyle("-fx-background-image:url" + "(file:resources/pngs/InventoryBar-01.png");

        StackPane pane = new StackPane(boardGridPane, borderExitImage);
        HBox hBox = new HBox(pane, inventoryGridPane);
        gameScene = new Scene(hBox, width, height);
    }

    /**
     *
     * @return the current board
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     *
     * @return the current inventory
     */
    public Inventory getInventory() { return inventory; }

    /**
     *
     * @return the current scene
     */
    public Scene getScene() {
        loadCoinHealthBar();
        loadMainCharacter();
        loadInventory();
        loadMonsters();
        loadObjects();
        return gameScene;
    }

    /**
     *
     * @return the monsters list
     */
    public ArrayList<Monster> getMonstersList() {
        return monsters;
    }

    /**
     * Updates the scene
     *
     * @param monster the monster the player is attacking
     * @return the updated scene
     */
    public Scene updateScene(Monster monster) {
        loadCoinHealthBar();
        loadInventory();
        updateMonster(monster);
        return gameScene;
    }

    /**
     * Loads the inventory
     */
    private void loadInventory() {
        if (hero.getInventoryList().size() > 0) {
            List<Node> imgViewList = new LinkedList<>();
            Node node;
            for (String id : hero.getInventoryList()) {
                node = inventory.removeObject(id);
                if (node != null) {
                    imgViewList.add(node);
                }
            }
            int row = 0;
            for (String id: hero.getInventoryList()) {
                inventory.addObject(imgViewList.get(row), id, row, 1);
                row++;
            }
        }
    }

    /**
     * loads hero's health and money bar
     */
    private void loadCoinHealthBar() {
        healthBar = hero.getHealthBar();
        coinBar = hero.getMoneyBar();
        board.removeObject("health", 1, 1,  1, 1);
        board.removeObject("money", 1, 1, 0, 1);
        board.addObject(healthBar, "health", false, 0, 1, 1, 5);
        board.addObject(coinBar, "money", false, 1, 1, 1, 5);
    }

    /**
     * Adds hero to the board
     */
    private void loadMainCharacter() {
        board.addObject(hero.getPlayerImage(),
                "player", false,
                hero.getPlayerMovement().getYPosition(), 1,
                hero.getPlayerMovement().getXPosition(), 1);
    }

    /**
     * Adds monsters to the board
     */
    private void loadMonsters() {

        monsters.forEach(monster -> {
            if (monster.getMonsterType() != MonsterType.COVIDBOSSLARGE) {
                board.removeObject(monster.getId(), monster.getRow(), 1, monster.getCol(), 1);
                board.addObject(monster.getMonsterAndHealth(),
                        monster.getId(), true,
                        monster.getRow(), 1,
                        monster.getCol(), 1);
            } else {
                board.removeObject(monster.getId(), monster.getRow(), 3, monster.getCol(), 5);
                board.addObject(monster.getMonsterAndHealth(),
                        monster.getId(), true,
                        monster.getRow(), 3,
                        monster.getCol(), 5);
            }
        });
    }

    /**
     * Updates the monster's imageview when the monster has lost
     * health and/or removes the monster from the board if the
     * monster has died
     *
     * @param monster the monster the player is attacking
     */
    private void updateMonster(Monster monster) {
        if (monster.getMonsterType() != MonsterType.COVIDBOSSLARGE) { //If regular enemy
            board.removeObject(monster.getId(), monster.getRow(), 1, monster.getCol(), 1);
            //If health > 0, add updated imageview
            if (monster.getMonsterHealth().getHealthLevel() > 0) {
                board.addObject(monster.getMonsterAndHealth(),
                        monster.getId(), true,
                        monster.getRow(), 1,
                        monster.getCol(), 1);
            }
        } else { //If boss
            board.removeObject(monster.getId(), monster.getRow(), 3, monster.getCol(), 5);
            //If health > 0, add updated imageview
            if (monster.getMonsterHealth().getHealthLevel() > 0) {
                board.addObject(monster.getMonsterAndHealth(),
                        monster.getId(), true,
                        monster.getRow(), 3,
                        monster.getCol(), 5);
            }
        }
    }

    /**
     * Loads in all other objects
     */
    abstract void loadObjects();
}
