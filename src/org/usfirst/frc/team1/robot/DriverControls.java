package org.usfirst.frc.team1.robot;

import edu.wpi.first.wpilibj.Joystick;

public class DriverControls extends Opportunity {

	private Joystick stick = new Joystick(0);

	public DriverControls() {
	}

	public void driverControls() {
		
		//drivetrain motors
		drivetrain.drive(stick.getRawAxis(1), stick.getRawAxis(4));
		
		//shifting
		if (stick.getRawButton(5)) {
			drivetrain.shiftHigh();
		}

		if (stick.getRawButton(6)) {
			drivetrain.shiftLow();
		}

		
		//catapult
		if (stick.getRawButton(1)) {
			catapult.longShot();
		} else if (stick.getRawButton(2)) {
			catapult.shortShot();
		} else {
			catapult.offShot();
		}
		
		
		//intake
		if(stick.getRawButton(3)){
			intake.toggleIntake();
		}
	}

}
