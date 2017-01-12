package subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

import org.usfirst.frc.team5254.robot.Constants;
import org.usfirst.frc.team5254.robot.Pathfinder;

public class Shooter extends Pathfinder {
	
	Solenoid shooter = new Solenoid(Constants.SHOOTER);
	Solenoid holder = new Solenoid(Constants.BALL_HOLDER_PISTON);
	CANTalon flywheelLeft = new CANTalon(Constants.LEFT_SHOOTER);
	CANTalon flywheelRight = new CANTalon(Constants.RIGHT_SHOOTER);
	DigitalInput leftBallSensor = new DigitalInput(Constants.LEFT_BALL_SENSOR);
	DigitalInput rightBallSensor = new DigitalInput(Constants.RIGHT_BALL_SENSOR);
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
	public Victor armMotor = new Victor(Constants.PDP_ARM);
	
	
	public Shooter() {
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		flywheelLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		flywheelLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		flywheelLeft.configPeakOutputVoltage(0.0f,-12.0f);
		flywheelLeft.reverseSensor(false);
		flywheelLeft.reverseOutput(false);
		flywheelLeft.setF(0.025);
		flywheelLeft.setPID(0.11, 0.0, 0.0);
		
		flywheelRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		flywheelRight.set(Constants.LEFT_SHOOTER);
		flywheelRight.reverseOutput(false);
		
		
	}
	public boolean leftBallIn() { //Sense when balls are in on the left sensor
		return !leftBallSensor.get();
		}
	
	public boolean rightBallIn() { //Sense when balls are in on the right sensor
		return !rightBallSensor.get();
	}
							
	public void noShot() { //When we arent't shooting
		holder.set(false);
		shooter.set(false);
		}
	public void shooterExtend(){ //Shooter extends
		shooter.set(true);
	}
	public void shooterRetract(){ //Shooter retracts
		shooter.set(false);
	}
	public void holderOpen(){ //Holders open
		holder.set(false);
	}
	
	public void holderClose(){ //Holders open
		holder.set(true);
	}
	public void flywheelOut(int RPM){ //Flywheels out
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		flywheelLeft.configPeakOutputVoltage(0.0f,-12.0f);
		flywheelLeft.set(-RPM);
		//System.out.println(RPM + " - " + -flywheelLeft.getEncVelocity());
		//System.out.println(pdp.getCurrent(2));
	}
	public void flywheelIn(){ //Flywheels in
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		flywheelLeft.configPeakOutputVoltage(+12.0f,0.0f);
		flywheelLeft.set(1);
	}	
	public void flywheelStop(){ //Flywheels stop
		flywheelLeft.set(0);
	}
	public void shooterArmUp(){ //Shooter arm starts moving up
		armMotor.set(-1.0);
	}
	public void shooterArmDown(){ //Shooter arm starts moving down
		armMotor.set(1.0);
	}
	public void shooterArmStop(){ //Shooter arm stop
		armMotor.set(0.0);
	}
}