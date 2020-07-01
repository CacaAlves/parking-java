package view;

import java.util.List;

import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import model.entities.Vehicle;
import model.services.VehicleServices;

public class ParkingManager {
	private Vehicle selectedVehicle;
	private List<Vehicle> vehicles;
	private TableView<Vehicle> parkingTableView;
	
	public ParkingManager() {
		vehicles = VehicleServices.getAll();
	}
	
	public void setParkingTableView(TableView<Vehicle> parkingTableView) {
		this.parkingTableView = parkingTableView;
	}
	
	public void setUpRows() {
		parkingTableView.getItems().clear();
		for (Vehicle vehicle : vehicles) {
			TableRow<Vehicle> item = new TableRow<Vehicle>();
			item.setItem(vehicle);
			parkingTableView.getItems().add(vehicle);
		}
	}
	
	public void setSelectedVehicle(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}
	public Vehicle getSelectedVehicle() {
		return selectedVehicle;
	}
}
