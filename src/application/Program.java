package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ParkingManager;
import view.ViewFactory;

public class Program extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		ViewFactory viewFactory = new ViewFactory(new ParkingManager());
		viewFactory.showMainWindow();
		
	}
}
