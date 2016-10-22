package org.usfirst.frc.team6254.robot;

import org.usfirst.frc.team6254.robot.Team5254Libraries.xBox360;

public class OperatorControls extends Opportunity {

	// Opens a new xBox360 controller
	private xBox360 driver = new xBox360(Constants.OPERATOR_JOYSTICK_PORT);

	public OperatorControls() {
	}

	public void OperatorControls() {
		
		// intake
		// Y button toggles intake to either up or down
		intake.toggleIntake(driver.getLT(),driver.getRT());

		// Changes the wheel direction
		if (driver.getButtonA()) // button A = intake in
			intake.intakeIn();
		if (driver.getButtonB()) // button B = intake off
			intake.intakeOff();
		if (driver.getButtonX()) // button C = intake out
			intake.intakeOut();

	}
}
