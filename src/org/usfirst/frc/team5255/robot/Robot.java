package org.usfirst.frc.team5255.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	// Variables for auto modes
	int autoMode;
	private Timer driveTimer = new Timer();

	// TODO: find best values for these
	double lowBarTime = 5; // Time to drive for low bar (Seconds)
	double lowBarSpeed = -0.5; // Speed to drive (negative = away from intake)
	double bumpTime = 10; // Time to drive for bump (Seconds)
	double bumpSpeed = -0.75; // Speed to drive (negative = away from intake)

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		System.out.println("Init");
	}

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	public void autonomousInit() {
		System.out.println("AutoInit");
		// Read value for selection of auto mode from dashboard
		autoMode = (int) SmartDashboard.getNumber("autoSelection", 0); // Default value is 0 (Do Nothing)
									
		// rest timer
		driveTimer.reset();
		// Start timer
		driveTimer.start();
		//// Shift into low gear
		Opportunity.drivetrain.shiftLow();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		//System.out.println("AutoPer");
		//autoMode = 1;  //TODO: Do you need to hard code this? 
		switch (autoMode) {
		case 1: // Bump
			//System.out.println(driveTimer.get());
			if (driveTimer.get() < bumpTime) {
				Opportunity.drivetrain.drive(bumpSpeed, 0);
			} else if (driveTimer.get() > bumpTime) {
				Opportunity.drivetrain.drive(0, 0);
				// stop timer
				driveTimer.stop();
			}
			break;
		case 2: // Low Bar
			// Put intake down
			// TODO: Is this backwards?
			Opportunity.intake.toggleIntake(false, true);
			// Drive
			if (driveTimer.get() < lowBarTime) {
				Opportunity.drivetrain.drive(lowBarSpeed, 0);
			} else if (driveTimer.get() > lowBarTime) {
				Opportunity.drivetrain.drive(0, 0);
				// stop timer
				driveTimer.stop();
			}
			// Put intake up
			Opportunity.intake.toggleIntake(true, false);
			break;
		case 0:
		default: // Do Nothing
			Opportunity.drivetrain.drive(0, 0);
			// stop timer
			driveTimer.stop();
			break;

		}
	}

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Opportunity.driver.driverControls();
		Opportunity.operator.OperatorControls();
		//System.out.println("tele");
	}

	private void delay(double d) {
		// TODO Auto-generated method stub

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

}
