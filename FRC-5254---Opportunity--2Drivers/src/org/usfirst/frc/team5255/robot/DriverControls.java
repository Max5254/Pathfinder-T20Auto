package org.usfirst.frc.team5255.robot;

import org.usfirst.frc.team5255.robot.Team5254Libraries.xBox360;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriverControls extends Opportunity {

	// Opens a new xBox360 controller
	private xBox360 driver = new xBox360(Constants.DRIVER_JOYSTICK_PORT);
	
	//Variables for publishing shot numbers to dashboard 
	boolean lastButton = false;
	int numLong = 0;
	int numShort = 0;

	public DriverControls() {
	}

	public void driverControls() {

		// drivetrain motors
		// Split stick arcade drive
		if (driver.getRightStickClick() || driver.getBack()) {
			drivetrain.drive(driver.getThrottle(), 0.5 * driver.getTurn()); // slow turn
			flashlight.lightOn();
		} else {
			drivetrain.drive(driver.getThrottle(), driver.getTurn());
			flashlight.lightOff();
		}

		// shifting
		// Default to low gear, if Right or Left Bumper is hit shift high
		if (driver.getLB() || driver.getRB())
			drivetrain.shiftLow();
		else
			drivetrain.shiftHigh();

		// catapult
		// Right Trigger does long shot, Left Trigger does short shot
		if (driver.getRT()) {
			catapult.longShot();
		} else if (driver.getLT()) {
			catapult.shortShot();
		} else {
			catapult.noShot();
		}
		
		
		//Code to report how many shots we take in a match 
		if (driver.getRT() && !lastButton){ //Each time button is hit increment numLong
			numLong++;
		}
		if (driver.getLT() && !lastButton){ //Each time button is hit increment numShort
			numShort++;
		}
		
		lastButton = driver.getRT() || driver.getLT(); 
		
		//Publish values to dashboard
		SmartDashboard.putNumber("shortShot", numShort);
		SmartDashboard.putNumber("longShot", numLong);


	}
}
