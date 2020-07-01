package view;

import java.util.List;
import java.util.stream.Collectors;


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
		vehicles = VehicleServices.getAll().
				stream().
				filter(obj -> !obj.getPaidOut()).
				collect(Collectors.toList());
		
		vehicles.forEach(obj -> {
			if (obj.getEndDate() != null) {
				String bill = String.format("R$ %.2f", VehicleServices.getBill(obj));
				obj.setBill(bill);
			}
			else {
				obj.setBill(null);
			}
		});
		
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
