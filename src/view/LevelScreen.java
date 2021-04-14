package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import model.Board;
import model.Collectable;
import model.Exit;
import model.ExitType;
import model.Inventory;
import model.LevelRandomizer;
import model.Monster;
import model.MonsterType;
import model.Player;

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
    protected Player hero;
    protected Board board;
    private String background;
    private Exit[] exits;
    private String iD;
    private Scene gameScene;
    private ArrayList<Monster> monsters;
    private ArrayList<Collectable> items;
    protected Inventory inventory;


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
                       LevelRandomizer lr, Exit[] exits, String iD,
                       ArrayList<Monster> monsters, ArrayList<Collectable> items) {
        this.width = 600;
        this.height = height;
        this.hero = hero;
        this.exits = exits;
        this.board = new Board(19, 19, this.exits, iD);
        this.background = lr.getLayout();
        this.iD = iD;
        this.monsters = monsters;
        this.items = items;

        //Set up inventory
        inventory = new Inventory(12, 1);
        inventory.createInventory(height, 50);
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

        borderExitImage.setFitWidth(width - 40);
        borderExitImage.setFitHeight(height + 10);
        boardGridPane.setStyle("-fx-background-color: " + background);
        ImageView whiteGrid = new ImageView(
                new Image("file:resources/pngs/WhiteGrid.png"));
        whiteGrid.setFitWidth(width - 40);
        whiteGrid.setFitHeight(height + 10);
        //****DON'T DELETE THIS: NEEDED IN CASE WE WANT A BACKGROUND IMAGE FOR INVENTORY*****
        //inventoryGridPane.setStyle("-fx-background-image: url('" + "file:resources/pngs/InventoryBar-01.png" + "');"
        //        + "-fx-background-size: 90 600;"); //width height
        inventoryGridPane.setStyle("-fx-background-color: tan");
        ImageView borderInventory = new ImageView(
                new Image("file:resources/pngs/InventoryOutline.png"));
        borderInventory.setFitWidth(50);
        borderInventory.setFitHeight(height + 10);

        StackPane inventoryPane = new StackPane(inventoryGridPane, borderInventory);
        StackPane pane = new StackPane(boardGridPane,borderExitImage); //, borderExitImage);
        HBox hBox = new HBox(pane, inventoryPane);
        gameScene = new Scene(hBox, 660, 610);
    }

    /**
     *
     * @return the current board
     */
    public Board getBoard() {
        return this.board;
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     *
     * @return the current scene
     */
    public Scene getScene() {
        loadCoinHealthBar();
        loadMainCharacter();
        loadInventory(false);
        loadMonsters();
        loadItems();
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
     * Updates the scene. Has boolean parameters to avoid loading stuff
     * that doesn't need to be loaded again.
     *
     * @param update if inventory needs to be updated
     * @param monster the monster the player is attacking
     * @return the updated scene
     */
    public Scene updateScene(boolean update, Monster monster) {
        loadCoinHealthBar();
        loadInventory(update);
        updateMonster(monster);
        loadItems();
        return gameScene;
    }

    /**
     * Updates the scene. Has boolean parameters to avoid loading stuff
     * that doesn't need to be loaded again.
     *
     * @param update if inventory needs to be updated
     * @return the updated scene
     */
    public Scene updateScene(boolean update) {
        loadCoinHealthBar();
        loadInventory(update);
        loadItems();
        return gameScene;
    }

    /**
     * Loads the inventory
     *
     * @param update if inventory needs to be updated
     */
    private void loadInventory(boolean update) {
        if (hero.getInventoryList().size() > 0) { //If inventory is not empty
            System.out.println("Hero's inventory size: " + hero.getInventoryList().size());
            List<ImageView> imgViewList = new LinkedList<>(); //Used to store imageViews of items

            //Used to update the visual inventory if an object is used. First, it's removed from the
            //inventory. A string is returned in order to obtain the imageview to add it back into
            //the inventory. The item is then removed from the board. The string is combined with a
            //filepath to convert it back into an imageview. This imageview is added back into
            //the inventory.
            boolean condition = false;
//            inventory.clearInventory();
            for (Collectable collectable: hero.getInventoryList()) {
                condition = inventory.removeObject(collectable);
                if (update) {
                    condition = board.removeCollectable(collectable);
//                    System.out.println("Object was removed from  board, condition: " + condition);
                }
            }
            int i = 0;
            for (Collectable collectable: hero.getInventoryList()) {
//                System.out.println("Added to inventory, condition: " + condition);
                inventory.addObject(collectable, i, 0);
                i++;
            }
        }
    }

    /**
     * loads hero's health and money bar
     *
     */
    private void loadCoinHealthBar() {
        healthBar = hero.getHealthBar();
        coinBar = hero.getMoneyBar();
        board.removeObject("health", 1, 1, 1, 1);
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
        if (monster != null) {
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
    }

    /**
     * Load items
     */
    private void loadItems() {
        items.forEach((item) -> {
            board.removeCollectable(item);
            if(!item.isCollected()) {
                board.addCollectable(item);
            }
        });
    }

    /**
     * Loads in all other objects
     */
    abstract void loadObjects();
}
