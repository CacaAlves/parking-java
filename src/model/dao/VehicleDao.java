package model.dao;

import java.util.List;

import model.entities.Vehicle;

public interface VehicleDao {
	
	void insert(Vehicle obj);
	void update(Vehicle obj);
	void deleteById(Integer id);
	Vehicle findById(Integer id);
	List<Vehicle> findAll();
}
