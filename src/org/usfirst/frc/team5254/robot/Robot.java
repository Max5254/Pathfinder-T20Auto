package org.usfirst.frc.team5254.robot;

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

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		System.out.println("AutoPer");
		Pathfinder.autoModes.executeTestTree();
		}
	

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */
	public void teleopInit() {
		System.out.println("teleopInit");
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		//System.out.println("teleopPeriodic");
		Pathfinder.driver.driverControls();
		Pathfinder.operator.operatorControls();
		//System.out.println("tele");
	}
		public void shooterPeriodic() {
	}

	public void delay(double d) {
		// TODO Auto-generated method stub

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

}
