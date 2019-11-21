package logic.tiles;

import logic.entities.Entity;

public class Shop extends Tile {

	public Shop(int x, int y) {
		super(x, y);
	}
	
	@Override
	public String toString() {
		return super.toString() + ": Shop";
	}

	@Override
	public String event(Entity entity) {
		return "*shop scene*\nHi, kauf was :-)";
	}

}
