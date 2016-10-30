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
	
	
	int autoMode;
	private Timer driveTimer = new Timer();

	double lowBarTime = 5;
	double lowBarSpeed = -0.5;
	
	double bumpTime = 3;
	double bumpSpeed = -0.75;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
	}

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	public void autonomousInit() {
		autoMode = (int) SmartDashboard.getNumber("autoSelection", 0);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		//Shift into low gear
		Opportunity.drivetrain.shiftLow();
		//Start timer
		driveTimer.start();
		
		switch (autoMode) {
		case 1: // Put bump auto code here
			if (driveTimer.get() < bumpTime) {
				Opportunity.drivetrain.drive(bumpSpeed , 0);
			} else if (driveTimer.get() > bumpTime) {
				Opportunity.drivetrain.drive(0, 0);
			}
			break;
		
		case 2: // Put low bar auto code here
			//Put intake down
			//TODO: Does this work? 
			Opportunity.intake.toggleIntake(false, true); 
			
			//Drive
			if (driveTimer.get() < lowBarTime) {
				Opportunity.drivetrain.drive(lowBarTime , 0);
			} else if (driveTimer.get() > lowBarTime) {
				Opportunity.drivetrain.drive(0, 0);
			}
			//Put intake up
			Opportunity.intake.toggleIntake(false, true);
			break;
		
		case 0:
		default: // Put default (Do Nothing) auto code here
			Opportunity.drivetrain.drive(0, 0);
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
