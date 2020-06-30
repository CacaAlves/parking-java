package controller;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entities.Vehicle;
import model.entities.VehicleTypes;
import view.ParkingManager;
import view.ViewFactory;

public class MainWindowController extends BaseController {

	public MainWindowController(ParkingManager parkingManager, ViewFactory viewFactory, String fxmlName) {
		super(parkingManager, viewFactory, fxmlName);
	}

	@FXML
	private TableView<Vehicle> parkingTableView;

	@FXML
	private TableColumn<Vehicle, String> plateCol;

	@FXML
	private TableColumn<Vehicle, VehicleTypes> vehicleCol;

	@FXML
	private TableColumn<Vehicle, Date> startDateCol;

	@FXML
	private TableColumn<Vehicle, Date> endDateCol;

	@FXML
	private TableColumn<Vehicle, String> ownerNameCol;

	@FXML
	void newVehicleBtnOnAction() {
		viewFactory.showVehicleRegistrationWindow();
	}

}
