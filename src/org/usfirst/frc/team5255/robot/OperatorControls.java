package org.usfirst.frc.team5255.robot;

import org.usfirst.frc.team5255.robot.Team5254Libraries.xBox360;

import edu.wpi.first.wpilibj.DigitalInput;

public class OperatorControls extends Opportunity {

	// Opens a new xBox360 controller
	private xBox360 operator = new xBox360(Constants.OPERATOR_JOYSTICK_PORT);
	
	private DigitalInput limitSwitch = new DigitalInput(Constants.CATAPULT_LIMIT_SWITCH);
	boolean lastHit = false;

	public OperatorControls() {
	}

	public void OperatorControls() {
		
		// intake
		// Y button toggles intake to either up or down
		intake.toggleIntake(operator.getLT(),operator.getRT());

		// Changes the wheel direction
		if (operator.getButtonA()) // button A = intake in
			intake.intakeIn();
		if (operator.getButtonB() || (!limitSwitch.get() && lastHit)) // Button B or limit switch intake off
			//TODO: Weird issue with robot not fireing? 11/5
			intake.intakeOff();
		if (operator.getButtonX()) // button C = intake out
			intake.intakeOut();

		lastHit = limitSwitch.get();
		//System.out.println(lastHit);
	}
}
