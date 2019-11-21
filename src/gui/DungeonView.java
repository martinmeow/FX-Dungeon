package gui;

import javafx.collections.ObservableList;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.entities.*;
import logic.tiles.*;
import logic.*;

public class DungeonView extends Stage {
	final int SIZE = 11;
	private Controller controller;
	private Player player;
	private Room room;
	ObservableList<Item>inventory = FXCollections.observableArrayList();

	public DungeonView(Stage primaryStage) {
		this.initOwner(primaryStage);
		this.setTitle("FX-Dungeon");
		this.player = new Player(SIZE, 5, 5);
		this.room = new Room(SIZE);
		controller = new Controller(this, player, room);
	}

	public void showView() {
		ListView<Item> inventoryView = new ListView<Item>(inventory);
		RoomView gridPane = new RoomView(room);
		BorderPane root = new BorderPane();
		root.setRight(inventoryView);
		root.setCenter(gridPane);
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem randomSword = new MenuItem("Add Item");
		randomSword.setOnAction(event -> inventory.add(Item.random()));
		randomSword.setAccelerator(KeyCombination.keyCombination("n"));
		randomSword.setGraphic(new ImageView("img/items/apple.png"));
		fileMenu.getItems().add(randomSword);
		
		menuBar.getMenus().add(fileMenu);
		root.setTop(menuBar);
		Scene dungeon = new Scene(root);
		dungeon.setOnKeyPressed(event -> controller.keyPressed(event));
		PlayerView playerImage = new PlayerView(player);
		for (int i = 0; i < SIZE; i++) {
			Wall wallTop = new Wall(i, 0);
			room.setTile(wallTop, i, 0);
			TileView wallViewTop = new TileView(wallTop);
			gridPane.add(wallViewTop);

			Wall wallBot = new Wall(i, SIZE - 1);
			room.setTile(wallBot, i, SIZE - 1);
			TileView wallViewBot = new TileView(wallBot);
			gridPane.add(wallViewBot);
		}

		Door door = new Door(5, 0);
		room.setTile(door, 5, 0);
		gridPane.add(new TileView(door));

		Door door2 = new Door(5, SIZE - 1);
		room.setTile(door2, 5, SIZE - 1);
		gridPane.add(new TileView(door2));

		for (int i = 1; i < SIZE - 1; i++) {
			Wall wallLeft = new Wall(0, i);
			room.setTile(wallLeft, 0, i);
			TileView wallViewLeft = new TileView(wallLeft);
			gridPane.add(wallViewLeft);

			Wall wallRight = new Wall(SIZE - 1, i);
			room.setTile(wallRight, SIZE - 1, i);
			TileView wallViewRight = new TileView(wallRight);
			gridPane.add(wallViewRight);
		}

		for (int i = 1; i < SIZE - 1; i++) {
			for (int j = 1; j < SIZE - 1; j++) {
				TileView.createRandomTile(gridPane, i, j);
			}
		}

		Shop shop = new Shop(5, 7);
		room.setTile(shop, 5, 7);
		TileView shopview = new TileView(shop);
		gridPane.setGridLinesVisible(true);
		gridPane.add(playerImage, 5, 5);
		gridPane.add(shopview, 5, 7);
		this.setScene(dungeon);
		this.show();
	}

}
