package gui;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import logic.*;

public class Controller {
	private Player player;
	private Room room;
//	private Stage primaryStage;

	public Controller(Stage primaryStage, Player player, Room room) {
//		this.primaryStage = primaryStage;
		this.player = player;
		this.room = room;
	}
	
	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getCode()) {
		case W:
		case UP:
			move(player, 0, -1);
			break;
		case A:
		case LEFT:
			move(player, -1, 0);
			break;
		case S:
		case DOWN:
			move(player, 0, 1);
			break;
		case D:
		case RIGHT:
			move(player, 1, 0);
			break;

		default:
			break;
		}
	}
	
	private void move(Entity entity, int x, int y) {
		entity.setX(entity.getX() + x);
		entity.setY(entity.getY() + y);
		Tile target = room.getTile(entity.getX(), entity.getY());
		if(target != null)
			System.out.println(room.getTile(entity.getX(), entity.getY()).event(entity));
	}
}
