package subsystems;

import org.usfirst.frc.team1.robot.Constants;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake{
	
	private DoubleSolenoid intakePiston = new DoubleSolenoid(Constants.INTAKE_PISTON_EXTEND,Constants.INTAKE_PISTON_RETRACT);
	Talon intakeMotor = new Talon(Constants.INTAKE_MOTOR);
	static final Value down = DoubleSolenoid.Value.kForward;
	
	public Intake(){
	}
	
	public void toggleIntake() {
		Value currentValue = intakePiston.get();	
		intakePiston.set(currentValue);
	}
	
	public void intakeIn() {
		intakeMotor.set(1);
	}
	
	public void intakeOut() {
		intakeMotor.set(-1);
	}
	
	public void intakeStop() {
		intakeMotor.set(0);
	}
	
	public boolean intakeDown(){
		return (down == intakePiston.get());
	}

	
}