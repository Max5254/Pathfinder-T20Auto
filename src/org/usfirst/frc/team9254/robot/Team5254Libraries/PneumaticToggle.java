package org.usfirst.frc.team9254.robot.Team5254Libraries;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * 
 * @author Max Westwater
 * @version 0.2
 */

public class PneumaticToggle {

	boolean lastValue;
	DoubleSolenoid doubleSolenoid;
	Solenoid solenoid;
	boolean doubleSol;

	// constructor for using double solenoid
	public PneumaticToggle(int chanel1, int chanel2) {
		doubleSolenoid = new DoubleSolenoid(chanel1, chanel2);
		doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
		doubleSol = true;
	}

	// constructor for using single solenoid
	public PneumaticToggle(int chanel1) {
		solenoid = new Solenoid(chanel1);
		doubleSol = false;
	}

	/**
	 * 
	 * @param input
	 *            boolean input to toggle solenoid
	 */
	public void Toggle(boolean input) {
		if (doubleSol) {
			if (!lastValue && input && DoubleSolenoid.Value.kForward == doubleSolenoid.get()) {
				doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
			}
			if (!lastValue && input && DoubleSolenoid.Value.kReverse == doubleSolenoid.get()) {
				doubleSolenoid.set(DoubleSolenoid.Value.kForward);
			}

			lastValue = input;
		} else {
			if (!lastValue && input && solenoid.get()) {
				solenoid.set(true);
			}
			if (!lastValue && input && solenoid.get()) {
				solenoid.set(false);
			}

			lastValue = input;

		}
	}

	/**
	 * 
	 * @param input1
	 *            Button to set solenoid to true
	 * @param input2
	 *            Button to set solenoid to false
	 */
	public void Toggle(boolean input1, boolean input2) {
		if (doubleSol) {
			if (input1) {
				doubleSolenoid.set(DoubleSolenoid.Value.kForward);
			}
			if (input2) {
				doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
			}
		} else {
			if (input1) {
				solenoid.set(true);
			}
			if (input2) {
				solenoid.set(false);
			}
		}
	}

}