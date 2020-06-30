package model.entities;

import java.util.Date;

public class Vehicle {
	private String licensePlate;
	private VehicleTypes type;
	private Date startDate;
	private Date endDate;
	private String ownerName;
	
	public Vehicle() {}
	
	public Vehicle(String licensePlate, VehicleTypes type, Date startDate, Date endDate, String ownerName) {
		super();
		this.licensePlate = licensePlate;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.ownerName = ownerName;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public VehicleTypes getType() {
		return type;
	}
	public void setType(VehicleTypes type) {
		this.type = type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
}
