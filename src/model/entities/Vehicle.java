package model.entities;

import java.util.Date;

public class Vehicle {
	private String licensePlate;
	private VehicleType type;
	private Date startDate;
	private Date endDate;
	private String ownerName;
	
	public Vehicle() {}
	
	public Vehicle(String licensePlate, VehicleType type, Date startDate, Date endDate, String ownerName) {
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
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
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

	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", type=" + type + ", startDate=" + startDate + ", endDate="
				+ endDate + ", ownerName=" + ownerName + "]";
	}

	
	
}
