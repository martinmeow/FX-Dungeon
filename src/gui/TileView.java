package gui;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.tiles.Tile;

public class TileView extends ImageView implements InvalidationListener {

	private Tile tile;

	public TileView(Tile tile) {
		this.tile = tile;
		String imagePath = ("img/tiles/" + tile.getClass().getSimpleName() + ".png").toLowerCase();
		this.setImage(new Image(imagePath));
		this.setFitHeight(64);
		this.setFitWidth(64);
		tile.addListener(this);
		tile.addListenerY(this);
	}

	public TileView(Tile tile, Rectangle rectangle) {

	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public static void createRandomTile(GridPane gridPane, int x, int y) {
		Color paint = new Color(Math.random(), Math.random(), Math.random(), 1);
		Rectangle r = new Rectangle(64, 64, paint);
		gridPane.add(r, x, y);
	}

	@Override
	public void invalidated(Observable observable) {
		GridPane.setColumnIndex(this, tile.getX());
		GridPane.setRowIndex(this, tile.getY());
	}
}
