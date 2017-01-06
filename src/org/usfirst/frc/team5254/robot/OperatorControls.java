package org.usfirst.frc.team5254.robot;

import org.usfirst.frc.team5254.robot.Team5254Libraries.xBox360;


public class OperatorControls extends Pathfinder {

	// Opens a new xBox360 controller
	public static xBox360 operator = new xBox360(Constants.OPERATOR_JOYSTICK_PORT);

	public OperatorControls() {
	}
	
	 
	public void operatorControls() {
		
		if (operator.getBack()) {    // button Back: holder open
			shooter.holderClose();
		} else {
			shooter.holderOpen();
		}


		//System.out.println(state);
		intake.toggleIntake(operator.getStart());
		
	}
}