package controller;

import view.ParkingManager;
import view.ViewFactory;

public class VehicleRegistrationWindowController extends BaseController{

	public VehicleRegistrationWindowController(ParkingManager parkingManager, ViewFactory viewFactory,
			String fxmlName) {
		super(parkingManager, viewFactory, fxmlName);
	}

}
