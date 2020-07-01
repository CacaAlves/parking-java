package view;

import java.io.IOException;

import controller.BaseController;
import controller.MainWindowController;
import controller.VehicleRegistrationWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
	
	private ParkingManager parkingManager;

	public ViewFactory(ParkingManager parkingManager) {
		this.parkingManager = parkingManager;
	}
	
	public void showMainWindow() {
		BaseController controller = new MainWindowController(parkingManager, this, "MainWindow.fxml");
		Stage stage = initializeStage(controller);
		 stage.setMaximized(true);
		
	}

	private Stage initializeStage(BaseController controller) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
		fxmlLoader.setController(controller);
		Parent parent;
		try {
			parent = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		return stage;
	}

	public void closeStage(Stage stage) {
		stage.close();
	}

	public void showVehicleRegistrationWindow() {
		BaseController controller = new VehicleRegistrationWindowController(parkingManager, this, 
				"VehicleRegistrationWindow.fxml");
		initializeStage(controller);
	}
}
