package subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team5254.robot.Constants;


public class Drivetrain{
	
	//Solenoid for shifting and ports for the drive motors
	private Solenoid shiftingPiston = new Solenoid(Constants.SHIFTING_PISTON); 
	private RobotDrive myRobot = new RobotDrive(2, 3, 0, 1); //Front Left, Rear Left, Front Right, Rear Right
	
	public Drivetrain() {
	}
	
	//Split stick arcade drive
	public void drive(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle,Turn);
	}
	
	//Shift to high gear
	public void shiftHigh() {
		shiftingPiston.set(true);
	}	
	
	//Shift to low gear
	public void shiftLow() {
		shiftingPiston.set(false);
	}
}