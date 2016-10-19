package subsystems;

import org.usfirst.frc.team1.robot.Constants;
import org.usfirst.frc.team1.robot.Team5254Libraries.PneumaticToggle;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake{
	
	//creates a toggler object for intake 
	private PneumaticToggle intakeToggle = new PneumaticToggle(Constants.INTAKE_PISTON_EXTEND,Constants.INTAKE_PISTON_RETRACT);
	
	//Opens a talon motor controller for intake
	Talon intakeMotor = new Talon(Constants.INTAKE_MOTOR);
	
	//sets the variable for down to be used in intakeDown()
	static final Value down = DoubleSolenoid.Value.kForward;
	
	public Intake(){
	}
	
	//toggles intake up or down with button press of input
	public void toggleIntake(boolean input) {
		intakeToggle.Toggle(input);
	}

	//sets intake motor to full speed in
	public void intakeIn() {
		intakeMotor.set(1);
	}
	
	//sets intake motor to full speed out
	public void intakeOut() {
		intakeMotor.set(-1);
	}
	
	//turns intake motor off 
	public void intakeOff() {
		intakeMotor.set(0);
	}
	
	//returns if the intake is currently down (used for catauplt) 
	public boolean intakeDown(){
		//return (down == intakePiston.get());
		//TODO: Change this to actually work
		return true;
	}

	
}