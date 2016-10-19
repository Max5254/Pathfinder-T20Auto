package subsystems;

import org.usfirst.frc.team1.robot.Constants;
import org.usfirst.frc.team1.robot.Opportunity;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Catapult extends Opportunity {

	//Open two lower single solenoids (aka super jank huge solenoids)
	private Solenoid lowerLeft = new Solenoid(Constants.CATAPULT_LOWER_LEFT);
	private Solenoid lowerRight = new Solenoid(Constants.CATAPULT_LOWER_RIGHT);
	//Open top double solenoid 
	private DoubleSolenoid top = new DoubleSolenoid(Constants.CATAPULT_TOP_1 , Constants.CATAPULT_TOP_2);

	
	public Catapult() {
	}

	//Outer works shot: Fire all 3 solenoids
	public void longShot() {
		if (Opportunity.intake.intakeDown()) {
			lowerLeft.set(true);
			lowerRight.set(true);
			top.set(DoubleSolenoid.Value.kForward);
		}
	}

	//148 shot: Fire lower 2 soleniods 
	public void shortShot() {
		if (Opportunity.intake.intakeDown()) {
			lowerLeft.set(true);
			lowerRight.set(true);
			top.set(DoubleSolenoid.Value.kReverse);
		}
	}

	//Nothing: fire no solenoids
	public void noShot() {
		lowerLeft.set(false);
		lowerRight.set(false);
		top.set(DoubleSolenoid.Value.kReverse);
	}

}