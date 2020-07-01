package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.VehicleType;
import model.services.VehicleServices;
import view.ParkingManager;
import view.ViewFactory;

public class VehicleRegistrationWindowController extends BaseController implements Initializable {

	public VehicleRegistrationWindowController(ParkingManager parkingManager, ViewFactory viewFactory,
			String fxmlName) {
		super(parkingManager, viewFactory, fxmlName);
	}

	@FXML
	private TextField licensePlateTextField;

	@FXML
	private ChoiceBox<VehicleType> vehicleTypeChoiceBox;

	@FXML
	private TextField ownerNameTextField;

	@FXML
	void cancelBtnOnAction() {
		Stage stage = (Stage) licensePlateTextField.getParent().getScene().getWindow();
		viewFactory.closeStage(stage);
	}

	@FXML
	void saveBtnOnAction() {
		VehicleServices.insertVehicle(licensePlateTextField.getText(),
				(vehicleTypeChoiceBox.getSelectionModel().getSelectedItem()), ownerNameTextField.getText());
		parkingManager.setUpRows();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		setUpVehicleTypeChoiceBox();

	}

	private void setUpVehicleTypeChoiceBox() {
		ObservableList<VehicleType> vehicleTypeList = FXCollections.observableArrayList(VehicleType.values());
		if (vehicleTypeList != null) {
			vehicleTypeChoiceBox.setItems(vehicleTypeList);
			vehicleTypeChoiceBox.setValue(vehicleTypeList.get(0));
		}
	}

}
