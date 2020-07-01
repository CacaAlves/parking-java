package model.dao;

import java.util.List;

import model.entities.Vehicle;

public interface VehicleDao {
	
	void insert(Vehicle obj);
	void updateEndDate(String licensePlate);
	void updatePayOut(String licensePlate, boolean payOut);
	Vehicle findByLicensePlate(String licensePlate);
	List<Vehicle> findAll();
}
