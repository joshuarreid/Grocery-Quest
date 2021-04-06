package view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import model.Board;
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
                       LevelRandomizer lr, Exit[] exits, String iD, ArrayList<Monster> monsters) {
        this.width = 600;
        this.height = height;
        this.hero = hero;
        this.exits = exits;
        this.board = new Board(19, 19, this.exits, iD);
        this.background = lr.getLayout();
        this.iD = iD;
        this.monsters = monsters;


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

        borderExitImage.setFitWidth(width + 4);
        borderExitImage.setFitHeight(height + 4);
        boardGridPane.setStyle("-fx-background-color: " + background);

        //****DON'T DELETE THIS: NEEDED IN CASE WE WANT A BACKGROUND IMAGE FOR INVENTORY*****
        //inventoryGridPane.setStyle("-fx-background-image: url('" + "file:resources/pngs/InventoryBar-01.png" + "');"
        //        + "-fx-background-size: 90 600;"); //width height
        inventoryGridPane.setStyle("-fx-background-color: tan");

        StackPane inventoryPane = new StackPane(inventoryGridPane);

        StackPane pane = new StackPane(boardGridPane); //, borderExitImage);
        HBox hBox = new HBox(pane, inventoryPane);
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
     * @return the current scene
     */
    public Scene getScene() {
        loadCoinHealthBar();
        loadMainCharacter();
        loadInventory(false);
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
            for (String id : hero.getInventoryList()) {
                String nodeId = inventory.removeObject(id);
                if (nodeId == null) {
                    nodeId = id;
                }
                System.out.println("nodeId: " + nodeId);
                if (nodeId != null) {
                    if (update) {
                        int row = 0;
                        int col = 0;
                        for (int i = 0; i < 19; i++) { //Looking for row and column of picked up item
                            for (int j = 0; j < 19; j++) {
                                if (board.getItemBoard()[i][j] != null && board.getItemBoard()[i][j].equals(nodeId)) {
                                    System.out.println("nodeId: " + nodeId);
                                    row = i;
                                    col = j;
                                }
                            }
                        }
                        board.removeObject(nodeId, row, 1, col, 1);
                        System.out.println("Object was removed");
                    }
                    if (nodeId.substring(0, 4).equals("item")) {
                        System.out.println("I got trimmed!!");
                        nodeId = nodeId.substring(0, nodeId.indexOf('_'));
                    }
                    System.out.println("Added back to imgeView list");
                    ImageView tempImgView = new ImageView(new Image("file:resources/pngs/" + nodeId + ".png"));
                    tempImgView.setFitWidth(30);
                    tempImgView.setFitHeight(30);
                    imgViewList.add(tempImgView);
                }
            }
            int row = 0;
            for (String id: hero.getInventoryList()) {
                System.out.println("Added to inventory");
                inventory.addObject(imgViewList.get(row), id, row, 0);
                row++;
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
     * Loads in all other objects
     */
    abstract void loadObjects();
}
