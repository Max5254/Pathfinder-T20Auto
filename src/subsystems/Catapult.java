package subsystems;

import org.usfirst.frc.team5255.robot.Constants;
import org.usfirst.frc.team5255.robot.Opportunity;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Catapult extends Opportunity {

	//Open two lower single solenoids (aka super jank huge solenoids)
	private Solenoid bottom = new Solenoid(Constants.CATAPULT_BOTTOM);
	private Solenoid top = new Solenoid(Constants.CATAPULT_TOP);

	
	public Catapult() {
	}

	//Outer works shot: Fire all 3 solenoids
	public void longShot() {
		if (Opportunity.intake.intakeDown()) {
			bottom.set(true);
			top.set(true);
		}
	}

	//148 shot: Fire lower 2 soleniods 
	public void shortShot() {
		if (Opportunity.intake.intakeDown()) {
			bottom.set(true);
			top.set(false);
		}
	}

	//Nothing: fire no solenoids
	public void noShot() {
		bottom.set(false);
		top.set(false);
		}

}