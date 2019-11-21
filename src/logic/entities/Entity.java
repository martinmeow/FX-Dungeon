package logic.entities;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public abstract class Entity implements Observable{
	private IntegerProperty x = new SimpleIntegerProperty();
	private IntegerProperty y = new SimpleIntegerProperty();
	int max;

	public Entity(int max, int x, int y) {
		this.max = max;
		this.x.set(x);
		this.y.set(y);
		
	}
	
	public int getX() {
		return this.x.get();
	}
	
	public void setX(int x) {
		if(x >= 0 && x < max)
			this.x.set(x);
	}
	
	public int getY() {
		return this.y.get();
	}
	
	public void setY(int y) {
		if(y >= 0 && y < max)
			this.y.set(y);
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
