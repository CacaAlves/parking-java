package model.entities;

import java.util.Date;

public class Vehicle {
	private String licensePlate;
	private VehicleType type;
	private Date startDate;
	private Date endDate;
	private String ownerName;
	private boolean paidOut;
	private String bill;
	
	public Vehicle() {}

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
	
	public boolean getPaidOut() {
		return paidOut;
	}
	
	public void setPaidOut(boolean paidOut) {
		this.paidOut = paidOut;
	}
	
	public String getBill() {
		return bill;
	}
	
	public void setBill(String bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", type=" + type + ", startDate=" + startDate + ", endDate="
				+ endDate + ", ownerName=" + ownerName + "]";
	}

	
	
}
