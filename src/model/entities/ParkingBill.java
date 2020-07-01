package model.entities;

public class ParkingBill {
	private Vehicle vehicle;
	private Double bill;
	private long parkedHours;
	
	public ParkingBill(Vehicle vehicle) {
		this.vehicle = vehicle;
		setUpParkedHours();
		generateBill();
	}
	
	private void setUpParkedHours() {
		parkedHours = ((vehicle.getEndDate().getTime()) - (vehicle.getStartDate().getTime()));
		if (parkedHours >= 3600000) {
			parkedHours = parkedHours / 1000 / 60 / 60;
		}
		else {
			parkedHours = 1;
		}
	}

	private void generateBill() {
		Double hourlyRate = null;
		switch (vehicle.getType()) {
		case CAR:
			hourlyRate = 5.0;
			break;
		case MOTORCYCLE:
			hourlyRate = 3.0;
			break;
		case TRUCK:
			hourlyRate = 15.0;
			break;
		case BICYCLE:
			hourlyRate = 1.5;
			break;
		default:
			break;
		}
		setBill(hourlyRate * parkedHours);
		
	}

	public Double getBill() {
		return this.bill;
	}
	
	private void setBill(Double bill) {
		this.bill = bill;
	}
	
}
