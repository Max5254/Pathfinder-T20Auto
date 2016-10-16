package org.usfirst.frc.team1.robot;

import org.usfirst.frc.team1.robot.Team5254Libraries.xBox360;

public class DriverControls extends Opportunity {

	private xBox360 driver = new xBox360(Constants.DRIVER_JOYSTICK_PORT);

	public DriverControls() {
	}

	public void driverControls() {
		
		//drivetrain motors
		drivetrain.drive(driver.getThrottle(), driver.getTurn());
		
		//shifting
		if (driver.getLB() || driver.getRB())
			drivetrain.shiftHigh();
		else
			drivetrain.shiftLow();

		
		//catapult
		if (driver.getRT()) {
			catapult.longShot();
		} else if (driver.getLT()) {
			catapult.shortShot();
		} else {
			catapult.offShot();
		}
		
		
		//intake
		if(driver.getButtonA()){
			intake.toggleIntake();
		}
	}

}
