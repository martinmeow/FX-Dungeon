package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Player;
import logic.Room;
import logic.Shop;

public class DungeonView extends Stage {
	final int SIZE = 10;
	private Controller controller;
	private Player player;
	private Room room;
	public DungeonView(Stage primaryStage) {
		this.initOwner(primaryStage);
		this.setTitle("FX-Dungeon");
		this.player = new Player(SIZE, 0, 0);
		this.room = new Room(SIZE);
		controller = new Controller(this, player, room);
	}
	
	public void showView() {
		RoomView gridPane = new RoomView(room);
		Scene dungeon = new Scene(gridPane);
		dungeon.setOnKeyPressed(event -> controller.keyPressed(event));
		PlayerView playerImage = new PlayerView(player);
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				TileView.createRandomTile(gridPane, i, j);
			}
		}
		
		Shop shop = new Shop(5, 7);
		room.setTile(shop, 5, 7);
		ShopView shopview = new ShopView(shop);
		gridPane.setGridLinesVisible(true);
		gridPane.add(playerImage, 0, 0);
		gridPane.add(shopview, 5, 7);
		this.setScene(dungeon);
		this.show();
	}

}
