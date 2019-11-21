package gui;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import logic.entities.Entity;

public abstract class EntityView extends ImageView implements InvalidationListener{

	private Entity entity;
	public EntityView(Entity entity, Image image) {
		this.entity = entity;
		this.setImage(image);
		this.setFitHeight(64);
		this.setFitWidth(64);
		entity.addListener(this);
		entity.addListenerY(this);
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	@Override
	public void invalidated(Observable observable) {
		GridPane.setColumnIndex(this, entity.getX());
		GridPane.setRowIndex(this, entity.getY());
	}
}
