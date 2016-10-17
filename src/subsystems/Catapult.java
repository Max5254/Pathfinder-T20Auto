package subsystems;

import org.usfirst.frc.team1.robot.Constants;
import org.usfirst.frc.team1.robot.Opportunity;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Catapult{
	
	private Solenoid lowerLeft = new Solenoid(Constants.CATAPULT_LOWER_LEFT);
	private Solenoid lowerRight = new Solenoid(Constants.CATAPULT_LOWER_RIGHT);
	private Solenoid top = new Solenoid(Constants.CATAPULT_TOP);
	
	public Catapult(){
	}
	
	public void longShot() {	
		lowerLeft.set(true);
		lowerRight.set(true);
		top.set(true);
	}
	
	public void shortShot() {
		lowerLeft.set(true);
		lowerRight.set(true);
		top.set(false);
	}
	
	public void offShot() {
		lowerLeft.set(false);
		lowerRight.set(false);
		top.set(false);
	}
	
}