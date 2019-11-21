package gui;

import javafx.scene.layout.GridPane;
import logic.Room;

public class RoomView extends GridPane{

//	private Room room;

	public RoomView(Room room){
//		this.room = room;
	}
	
	public void add(EntityView entity) {
		super.add(entity, entity.getEntity().getX(), entity.getEntity().getY());
	}
	
	public void add(TileView tile) {
		super.add(tile, tile.getTile().getX(), tile.getTile().getY());
	}
}
