package controller;

import view.ParkingManager;
import view.ViewFactory;

public class BaseController {

	protected ParkingManager parkingManager;
	protected ViewFactory viewFactory;
	protected String fxmlName;

	public BaseController(ParkingManager parkingManager, ViewFactory viewFactory, String fxmlName) {
		this.parkingManager = parkingManager;
		this.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
	}
	
	public String getFxmlName() {
		return fxmlName;
	}

}
