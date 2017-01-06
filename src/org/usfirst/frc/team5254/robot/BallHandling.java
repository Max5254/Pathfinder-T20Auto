package org.usfirst.frc.team5254.robot;
import org.usfirst.frc.team5254.robot.OperatorControls;

import edu.wpi.first.wpilibj.Timer;

public class BallHandling extends Pathfinder {
	
	//Calls timers for arm and shooter
	
	public static Timer shotTimer = new Timer();
	public static Timer armTimer = new Timer();

	//Shooter states

		private enum ShooterState {
			IDLE,
			INTAKEIN,
			INTAKEOUT,
			READYTOSHOOT,
			SHOOT;
		} 
		
		ShooterState state;
		
		public BallHandling() {
			
			state = ShooterState.IDLE;
			shotTimer.start();
			armTimer.start();
		}
		
		public void ballHandling() {
			
			//Robot states
			
			System.out.println(state);
			switch (state) { 
			
			//Idle - Everything is off/stopped
			
			case IDLE:
				
				//Check when to stop arm from falling
				
				System.out.println(shooter.pdp.getCurrent(10));
				if (shooter.pdp.getCurrent(10) >= 20 && armTimer.get() >= 0.3) {
					shooter.shooterArmStop();
				}
					
				//Basic conditions
				
				intake.intakeOff();
				shooter.flywheelStop();
				shooter.shooterRetract();
				shooter.holderClose();
				
				//Change to INTAKEIN state
				
				if (OperatorControls.operator.getButtonA()) {
					state = ShooterState.INTAKEIN;
				}
				
				//Change to INTAKEOUT state
				
				if (OperatorControls.operator.getButtonX()) {
					state = ShooterState.INTAKEOUT;
				}
				
				//Change to READYTOSHOOT state
				
				if (OperatorControls.operator.getButtonY()) {
					state = ShooterState.READYTOSHOOT;
					shooter.shooterArmUp();
					armTimer.reset();
				}
				
				//Change to IDLE state and reset
				
				if (OperatorControls.operator.getButtonB()) {
					System.out.println("Resetting...");
					state = ShooterState.IDLE;
					shooter.shooterArmDown();
					armTimer.reset();
				}
				
				break;
				
				//Intake In - Intake and flywheels spin in. Arm can be either up or down
			
			case INTAKEIN:
				
				//Basic conditions
				
				intake.intakeIn();
				shooter.flywheelIn();
				shooter.shooterRetract();
				shooter.holderOpen();
				
				//Change to IDLE state if a ball is in the box
				
				if (shooter.leftBallIn() || shooter.rightBallIn()) {
					state = ShooterState.IDLE;
				}
				
				//Change to INTAKEOUT state
				
				if (OperatorControls.operator.getButtonX()) {
					state = ShooterState.INTAKEOUT;
				}
				
				//Change to IDLE state
				
				if (OperatorControls.operator.getButtonB()) {
					state = ShooterState.IDLE;
					shooter.shooterArmDown();
					armTimer.reset();
				}
				
				//Change to READYTOSHOOT state
				
				if (OperatorControls.operator.getButtonY()) {
					state = ShooterState.READYTOSHOOT;
					shooter.shooterArmUp();
					armTimer.reset();
				}
				
				break;
				
				//Intake Out - Intake and flywheels spin out. Arm can be either up or down
			
			case INTAKEOUT:
				
				//Basic conditions
				
				intake.intakeOut();
				shooter.flywheelOut(2000);
				shooter.shooterRetract();
				shooter.holderClose();
				
				//Change to SHOOT state
				
				if (DriverControls.driver.getRT() || DriverControls.driver.getLT()) {
					state = ShooterState.SHOOT;
					shotTimer.reset();
				}
				
				//Change to IDLE state
				
				if (OperatorControls.operator.getButtonB()) {
					state = ShooterState.IDLE;
					shooter.shooterArmDown();
					armTimer.reset();
				}
				
				//Change to INTAKEIN state
				
				if (OperatorControls.operator.getButtonA()) {
					state = ShooterState.INTAKEIN;
				}
				
				//Change to READYTOSHOOT state
				
				if (OperatorControls.operator.getButtonY()) {
					state = ShooterState.READYTOSHOOT;
					shooter.shooterArmUp();
					armTimer.reset();
				}
				
				break;
				
				//Ready to Shoot - Arm is up and flywheels spin out
			
			case READYTOSHOOT:
				
				//Check when to stop the arm from rising to shoot position
				
				System.out.println(shooter.pdp.getCurrent(10));
				if (shooter.pdp.getCurrent(10) >= 20 && armTimer.get() >= 0.3) {
					shooter.shooterArmStop();
				}
				
				//Basic conditions
				
				intake.intakeOff();
				shooter.flywheelOut(5000);
				shooter.holderClose();
				
				//Change to SHOOT state
				
				if (DriverControls.driver.getRT() || DriverControls.driver.getLT()) {
					shooter.holderOpen();
					shotTimer.reset();
					state = ShooterState.SHOOT;
				}
				
				//Change to IDLE state
				
				if (OperatorControls.operator.getButtonB()) {
					state = ShooterState.IDLE;
					shooter.shooterArmDown();
					armTimer.reset();
				}
				
			break;
			
				//Shoot - Arm is up and flywheels spin out. Holder pistons open, shooter extends, flywheels stop and arm goes down. Returns to IDLE
			
			case SHOOT:
					
				//Basic conditions
				
				shooter.holderOpen();
				
				//Print value of shotTimer
				
				System.out.println(shotTimer.get());
				
				//Shoot and then change to IDLE state
				
				if (shotTimer.get() > 0.8) {
					state = ShooterState.IDLE;
					shooter.shooterArmDown();
				} else if (shotTimer.get() > 0.2){
					shooter.shooterExtend();
				} else {
					shooter.shooterRetract();
				}
				
				break;
			}
		}
}
