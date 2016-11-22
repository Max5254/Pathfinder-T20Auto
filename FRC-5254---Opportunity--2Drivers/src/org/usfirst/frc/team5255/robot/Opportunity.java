package org.usfirst.frc.team5255.robot;

import subsystems.Catapult;
import subsystems.Drivetrain;
import subsystems.Flashlight;
import subsystems.Intake;

public class Opportunity {

	public Opportunity() {

	}
	

	// Subsystems
	protected static Drivetrain drivetrain = new Drivetrain(); // Done
	protected static Intake intake = new Intake(); // Done
	protected static Catapult catapult = new Catapult(); // Done
	protected static Flashlight flashlight = new Flashlight(); //Done

	// Human Controls
	protected static DriverControls driver = new DriverControls(); // Done
	protected static OperatorControls operator = new OperatorControls(); // Done
}