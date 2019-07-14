package logic;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tile {

	private IntegerProperty x = new SimpleIntegerProperty();
	private IntegerProperty y = new SimpleIntegerProperty();

	public Tile(int x, int y) {
		this.x.set(x);
		this.y.set(y);
	}

	public int getX() {
		return this.x.get();
	}

	public void setX(int x) {
		this.x.set(x);
	}

	public int getY() {
		return this.y.get();
	}

	public void setY(int y) {
		this.y.set(y);
	}
	
	public abstract String event(Entity entity);
	
	@Override
	public String toString() {
		return this.getX() + " " + this.getY();
	}

	public void addListener(InvalidationListener listener) {
		x.addListener(listener);
	}

	public void removeListener(InvalidationListener listener) {
		x.removeListener(listener);
	}

	public void addListenerY(InvalidationListener listener) {
		y.addListener(listener);
	}

	public void removeListenerY(InvalidationListener listener) {
		y.removeListener(listener);
	}
}