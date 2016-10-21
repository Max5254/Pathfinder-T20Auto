package org.usfirst.frc.team9254.robot.Team5254Libraries;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Max's epic utility for taking data from xBox360 controllers 
 * 
 * @author Max Westwater
 * @version 1.0
 */
public class xBox360 {

	//tolerance required for the trigger to read a boolean true
	static final double triggerTolerance = 0.25;
	
	//Axis' for split stick arcade drive
	static final int throttleAxis = 1;
	static final int turnAxis = 4;

	
	private Joystick stick;

	public xBox360(int jsIndex) {
		stick = new Joystick(jsIndex);
	}

	// drive axis'
	public double getThrottle() {
			return stick.getRawAxis(throttleAxis);
	}

	public double getTurn() {
			return stick.getRawAxis(turnAxis);
	}

	// buttons
	public boolean getButtonA() {
		return stick.getRawButton(1);
	}

	public boolean getButtonB() {
		return stick.getRawButton(2);
	}

	public boolean getButtonX() {
		return stick.getRawButton(3);
	}

	public boolean getButtonY() {
		return stick.getRawButton(4);
	}

	public boolean getLB() {
		return stick.getRawButton(5);
	}

	public boolean getRB() {
		return stick.getRawButton(6);
	}

	public boolean getBack() {
		return stick.getRawButton(7);
	}

	public boolean getStart() {
		return stick.getRawButton(8);
	}

	public boolean getLeftStickClick() {
		return stick.getRawButton(9);
	}

	public boolean getRightStickClick() {
		return stick.getRawButton(10);
	}

	// triggers
	public boolean getLT() {
		return (triggerTolerance <= stick.getRawAxis(2));
	}

	public boolean getRT() {
		return (triggerTolerance <= stick.getRawAxis(3));
	}

	// POV
	public boolean getPOVRight() {
		return (90 == stick.getPOV());
	}

	public boolean getPOVLeft() {
		return (270 == stick.getPOV());
	}

	public boolean getPOVUp() {
		return (0 == stick.getPOV());
	}

	public boolean getPOVDown() {
		return (180 == stick.getPOV());
	}

}