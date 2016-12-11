package subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon;

import org.usfirst.frc.team5254.robot.Constants;
import org.usfirst.frc.team5254.robot.Pathfinder;

public class Shooter extends Pathfinder {

	private Solenoid shooter = new Solenoid(Constants.SHOOTER);
	private Solenoid holder = new Solenoid(Constants.BALL_HOLDER_PISTON);
	CANTalon shooterMotorLeft = new CANTalon(Constants.LEFT_SHOOTER);
	CANTalon shooterMotorRight = new CANTalon(Constants.RIGHT_SHOOTER);
	
	public Shooter() {
	}

	//Outer works shot: Open holder then fire shooter
	public void highGoal() {
		if (Pathfinder.intake.intakeDown()) {
			holder.set(false);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shooter.set(true);
		}
	}

	//148 shot: Open holder then fire shooter
	public void lowGoal() {
		if (Pathfinder.intake.intakeUp()) {
			holder.set(false);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shooter.set(true);
		}
	}

    //Nothing: don't fire
	public void noShot() {
		holder.set(true);
		shooter.set(false);
		}
	public void shooterExtend(){
		shooter.set(true);
	}

    // Holder
	public void holderOpen(){
		holder.set(true);
	}
	public void holderClose(){
		holder.set(false);
	}

    // Flywheel
	public void flywheelOut(){
		shooterMotorLeft.set(1.0);
		shooterMotorRight.set(1.0);
	}
	public void flywheelIn(){
		shooterMotorLeft.set(-1.0);
		shooterMotorRight.set(-1.0);
	}
	public void flywheelStop(){
		shooterMotorLeft.set(0.0);
		shooterMotorRight.set(0.0);
	}
}
