package org.usfirst.frc.team1.robot;

import subsystems.Catapult;
import subsystems.Drivetrain;
import subsystems.Intake;

public class Opportunity {

	public Opportunity() {

	}

	// Subsystems
	protected static Drivetrain drivetrain = new Drivetrain(); // Done
	protected static Intake intake = new Intake(); // Done
	protected static Catapult catapult = new Catapult(); // Done

	// Human Controls
	protected static DriverControls driver = new DriverControls(); // Done
}