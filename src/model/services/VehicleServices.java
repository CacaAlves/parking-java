package model.services;

import java.util.List;

import db.DB;
import model.dao.impl.VehicleDaoJDBC;
import model.entities.Vehicle;
import model.entities.VehicleType;

public class VehicleServices {
	
	private static VehicleDaoJDBC dao = new VehicleDaoJDBC(DB.getConnection());
	
	public static void insertVehicle(String licensePlate, VehicleType type, String ownerName) {
		Vehicle obj = new Vehicle();
		obj.setLicensePlate(licensePlate);
		obj.setType(type);
		obj.setOwnerName(ownerName);
		
		dao.insert(obj);
	}
	
	public static void endParking(String licensePlate) {
		dao.updateEndDate(licensePlate);
	}
	
	public static List<Vehicle> getAll() {
		return dao.findAll();
	}
	
	public static Vehicle getByLicensePlate(String licensePlate) {
		return dao.findByLicensePlate(licensePlate);
	}
	
	public static void payUp(String licensePlate) {
		dao.updatePayOut(licensePlate, true);
	}
}
