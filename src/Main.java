
import gui.DungeonView;
import javafx.application.*;
import javafx.stage.*;

public class Main extends Application{
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		new DungeonView(primaryStage).showView();
	}
}
