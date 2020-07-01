package model.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.dao.VehicleDao;
import model.entities.Vehicle;
import model.entities.VehicleType;

public class VehicleDaoJDBC implements VehicleDao {

	private Connection conn;

	public VehicleDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vehicle obj) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO vehicle " + "(license_plate, vehicle_type, start_date, owner_name) "
					+ "VALUES (?, ?, ?, ?)");
			ps.setString(1, obj.getLicensePlate());
			ps.setString(2, obj.getType().toString());
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
			ps.setString(4, obj.getOwnerName());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected == 0)
				throw new DbException("Unexpected error! No rows affected.");
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public void updateEndDate(String licensePlate) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"UPDATE vehicle " +
					"SET end_date = ? " +
					"WHERE license_plate = ?"
			);
			ps.setTimestamp(1, new Timestamp(new Date().getTime()));
			ps.setString(2, licensePlate);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}

	}

	@Override
	public List<Vehicle> findAll() {
		List<Vehicle> vehicles = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM vehicle ORDER BY license_plate");
			rs = ps.executeQuery();

			while (rs.next()) {
				Vehicle obj = new Vehicle();
				obj.setLicensePlate(rs.getString("license_plate"));
				obj.setType(VehicleType.valueOf(rs.getString("vehicle_type")));
				obj.setStartDate(rs.getTimestamp("start_date"));
				Date endDate = rs.getTimestamp("end_date");
				if (endDate != null) {
					obj.setEndDate(endDate);
				}
				obj.setOwnerName(rs.getString("owner_name"));
				obj.setPaidOut(rs.getBoolean("paid_out"));
				vehicles.add(obj);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}

		return vehicles;
	}

	@Override
	public Vehicle findByLicensePlate(String licensePlate) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM vehicle WHERE license_plate = ?");
			st.setString(1, licensePlate);
			rs = st.executeQuery();
			if (rs.next()) {
				Vehicle obj = new Vehicle();
				obj.setLicensePlate(rs.getString("license_plate"));
				obj.setType(VehicleType.valueOf(rs.getString("vehicle_type")));
				obj.setStartDate(rs.getTimestamp("start_date"));
				Date endDate = rs.getTimestamp("end_date");
				if (endDate != null) {
					obj.setEndDate(endDate);
				}
				obj.setOwnerName(rs.getString("owner_name"));
				obj.setPaidOut(rs.getBoolean("paid_out"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void updatePayOut(String licensePlate, boolean payOut) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("UPDATE vehicle " + "SET paid_out = ? " + "WHERE license_plate = ?");
			ps.setBoolean(1, payOut);
			ps.setString(2, licensePlate);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}

	}
}
