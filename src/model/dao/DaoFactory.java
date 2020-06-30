package model.dao;

import db.DB;
import model.dao.impl.VehicleDaoJDBC;

public class DaoFactory {
	
	public static VehicleDaoJDBC CreateVehicleDao() {
		return new VehicleDaoJDBC(DB.getConnection());
	}
}
