package org.usfirst.frc.team5254.robot;

import org.usfirst.frc.team5254.robot.Team5254Libraries.xBox360;
import org.usfirst.frc.team5254.robot.DriverControls;

import edu.wpi.first.wpilibj.Timer;


public class OperatorControls extends Pathfinder {

	// Opens a new xBox360 controller
	private Timer shotTimer = new Timer();
	private Timer armTimer = new Timer();
	private xBox360 operator = new xBox360(Constants.OPERATOR_JOYSTICK_PORT);
	private enum ShooterState {
		IDLE,
		INTAKEIN,
		INTAKEOUT,
		READYTOSHOOT,
		SHOOT;
	} 
	
	ShooterState state;
	public OperatorControls() {
		 state = ShooterState.IDLE;
		shotTimer.start();

	}
	
	 
	
	public void operatorControls() {
		
		/*if (operator.getBack()) {    // button Back = holder open
			shooter.holderClose();
		} else {
			shooter.holderOpen();
		}*/


		//System.out.println(state);
		intake.toggleIntake(operator.getStart());
		
		System.out.println(state);
		switch (state) { 
		case IDLE: //Idle
			armTimer.start();
			System.out.println(shooter.pdp.getCurrent(10));
			if (shooter.pdp.getCurrent(10) >= 20 && armTimer.get() >= 0.4) {
				shooter.armMotor.set(0.0);
				System.out.println("Over Current");
			}
			
			intake.intakeOff();
			shooter.flywheelStop();
			shooter.shooterRetract();
			shooter.holderClose();
			if (operator.getButtonA()) {
				state = ShooterState.INTAKEIN;
			}
			if (operator.getButtonX()) {
				state = ShooterState.INTAKEOUT;
			}
			if (operator.getButtonY()) {
				state = ShooterState.READYTOSHOOT;
				shooter.armMotor.set(-1.0);
				armTimer.reset();
			}
			if (operator.getButtonB()) {
				System.out.println("Resetting...");
				state = ShooterState.IDLE;
				shooter.armMotor.set(1);
				armTimer.reset();
			}
			break;
		case INTAKEIN:
			//Arm(Bottom)
			intake.intakeIn();
			shooter.flywheelIn();
			shooter.shooterRetract();
			shooter.holderOpen();
			if (shooter.leftBallIn() || shooter.rightBallIn()) {
				state = ShooterState.IDLE;
			}
			if (operator.getButtonX()) {
				state = ShooterState.INTAKEOUT;
			}
			if (operator.getButtonB()) {
				state = ShooterState.IDLE;
				shooter.armMotor.set(1.0);
				armTimer.reset();
			}
			if (operator.getButtonY()) {
				state = ShooterState.READYTOSHOOT;
				shooter.armMotor.set(-1.0);
				armTimer.reset();
			}
			break;
		case INTAKEOUT:
			//Arm(Bottom)
			intake.intakeOut();
			shooter.flywheelOut(2000);
			shooter.shooterRetract();
			shooter.holderClose();
			if (DriverControls.driver.getRT() || DriverControls.driver.getLT()) {
				state = ShooterState.SHOOT;
				shotTimer.reset();
			}
			if (operator.getButtonB()) {
				state = ShooterState.IDLE;
				shooter.armMotor.set(1.0);
				armTimer.reset();
			}
			if (operator.getButtonA()) {
				state = ShooterState.INTAKEIN;
			}
			if (operator.getButtonY()) {
				state = ShooterState.READYTOSHOOT;
				shooter.armMotor.set(-1.0);
				armTimer.reset();
			}
			break;
		case READYTOSHOOT:
			System.out.println(shooter.pdp.getCurrent(10));
			if (shooter.pdp.getCurrent(10) >= 20 && armTimer.get() >= 0.4) {
				shooter.armMotor.set(0.0);
			}
			intake.intakeOff();
			shooter.flywheelOut(5000);
			shooter.holderClose();
			if (DriverControls.driver.getRT() || DriverControls.driver.getLT()) {
				shooter.holderOpen();
				shotTimer.reset();
				state = ShooterState.SHOOT;
			}
			if (operator.getButtonB()) {
				state = ShooterState.IDLE;
				shooter.armMotor.set(1.0);
				armTimer.reset();
			}
		break;		
		case SHOOT:
			shooter.holderOpen();
			System.out.println(shotTimer.get());
			if (shotTimer.get() > 0.8) {
				state = ShooterState.IDLE;
				shooter.armMotor.set(1.0);
			} else if (shotTimer.get() > 0.2){
				shooter.shooterExtend();
			} else {
				shooter.shooterRetract();
			}
			break;
		}	
	}
}