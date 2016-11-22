package org.usfirst.frc.team5254.robot;

import org.usfirst.frc.team5254.robot.Team5254Libraries.xBox360;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriverControls extends Pathfinder {

	// Opens a new xBox360 controller
	private xBox360 driver = new xBox360(Constants.DRIVER_JOYSTICK_PORT);
	
	//Variables for publishing shot numbers to dashboard 
	boolean lastButton = false;
	int numHigh = 0;
	int numLow = 0;

	public DriverControls() {
	}

	public void driverControls() {

		// drivetrain motors
		// Split stick arcade drive
		if (driver.getRightStickClick() || driver.getBack()) {
			drivetrain.drive(driver.getThrottle(), 0.5 * driver.getTurn()); // slow turn
		} else {
			drivetrain.drive(driver.getThrottle(), driver.getTurn());
		}

		// shifting
		// Default to low gear, if Right or Left Bumper is hit shift high
		if (driver.getLB() || driver.getRB())
			drivetrain.shiftLow();
		else
			drivetrain.shiftHigh();

		
		// Right Trigger does highGoal, Left Trigger does lowGoal
		if (driver.getRT()) {
			shooter.highGoal();
		} else if (driver.getLT()) {
			shooter.lowGoal();
		} else {
			shooter.noShot();
		}
		
		
		//Code to report how many shots we take in a match 
		if (driver.getRT() && !lastButton){ //Each time button is hit increment numLong
			numHigh++;
		}
		if (driver.getLT() && !lastButton){ //Each time button is hit increment numShort
			numLow++;
		}
		
		lastButton = driver.getRT() || driver.getLT(); 
		
		//Publish values to dashboard
		SmartDashboard.putNumber("lowGoal", numLow);
		SmartDashboard.putNumber("highGoal", numHigh);


	}
}
