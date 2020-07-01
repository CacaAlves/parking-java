package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.entities.Vehicle;
import model.entities.VehicleType;
import model.services.VehicleServices;
import view.ParkingManager;
import view.ViewFactory;

public class MainWindowController extends BaseController implements Initializable {
	
	private MenuItem endParking = new MenuItem("end parking");
	private MenuItem payUp = new MenuItem("pay up");
	
	public MainWindowController(ParkingManager parkingManager, ViewFactory viewFactory, String fxmlName) {
		super(parkingManager, viewFactory, fxmlName);
	}

	@FXML
	private TableView<Vehicle> parkingTableView;

	@FXML
	private TableColumn<Vehicle, String> plateCol;

	@FXML
	private TableColumn<Vehicle, VehicleType> vehicleCol;

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

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		setUpParkingTableView();
		setUpContextMenus();
		setUpRowSelection();
		setUpRows();
	}



	private void setUpParkingTableView() {
		plateCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
		vehicleCol.setCellValueFactory(new PropertyValueFactory<Vehicle, VehicleType>("type"));
		startDateCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Date>("startDate"));
		endDateCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Date>("endDate"));
		ownerNameCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("ownerName"));
		
		parkingTableView.setContextMenu(new ContextMenu(payUp, endParking));
	}

	private void setUpContextMenus() {
		payUp.setOnAction(e -> {
			VehicleServices.payUp(parkingManager.getSelectedVehicle().getLicensePlate());
			setUpRows();
		});
		
		endParking.setOnAction(e -> {
			VehicleServices.endParking(parkingManager.getSelectedVehicle().getLicensePlate());
			setUpRows();
		});
	}
	private void setUpRowSelection() {
		parkingTableView.setOnMouseClicked(e -> {
			Vehicle vehicle = parkingTableView.getSelectionModel().getSelectedItem();
			if (vehicle != null) {
				parkingManager.setSelectedVehicle(vehicle);
			}
		});
	}
	
	private void setUpRows() {
		parkingManager.setParkingTableView(parkingTableView);
		parkingManager.setUpRows();
	}
	
}
