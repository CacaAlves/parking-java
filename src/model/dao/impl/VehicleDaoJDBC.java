package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.VehicleDao;
import model.entities.Vehicle;

public class VehicleDaoJDBC implements VehicleDao{
	
	private Connection conn;
	
	public VehicleDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vehicle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vehicle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehicle findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
