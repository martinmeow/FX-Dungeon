package gui;

import javafx.scene.image.Image;
import logic.Player;

public class PlayerView extends EntityView {
	public PlayerView(Player player) {
		super(player, new Image("img/player.png"));
	}
}
