package gui;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import logic.Room;

public class RoomView extends GridPane{

//	private Room room;

	public RoomView(Room room){
//		this.room = room;
	}
	
	@Override
	public void add(Node child, int columnIndex, int rowIndex) {
		super.add(child, columnIndex, rowIndex);
	}
}
