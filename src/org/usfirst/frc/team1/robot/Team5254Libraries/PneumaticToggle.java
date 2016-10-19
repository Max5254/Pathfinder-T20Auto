package org.usfirst.frc.team1.robot.Team5254Libraries;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * 
 * @author Max Westwater
 * @version 0.1
 */

public class PneumaticToggle {

	boolean lastValue;
	DoubleSolenoid doubleSolenoid;
	Solenoid solenoid;

	// constructor for using double solenoid
	public PneumaticToggle(DoubleSolenoid doubleSolenoid) {
		this.doubleSolenoid = doubleSolenoid;
	}

	// constructor for using single solenoid
	public PneumaticToggle(Solenoid solenoid) {
		this.solenoid = solenoid;
	}

	/**
	 * 
	 * @param input
	 *            boolean input to toggle solenoid
	 * @param doubleSolenoid
	 *            the object of the double solenoid you'd like to toggle
	 */
	public void DoubleToggle(boolean input) {

		if (!lastValue && input && DoubleSolenoid.Value.kForward == doubleSolenoid.get()) {
			doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
		if (!lastValue && input && DoubleSolenoid.Value.kReverse == doubleSolenoid.get()) {
			doubleSolenoid.set(DoubleSolenoid.Value.kForward);
		}

		lastValue = input;
	}

	/**
	 * 
	 * @param input
	 *            boolean input to toggle solenoid
	 * @param solenoid
	 *            the object of the single solenoid you'd like to toggle
	 */
	public void SingleToggle(boolean input) {

		if (!lastValue && input && solenoid.get()) {
			solenoid.set(false);
		}
		if (!lastValue && input && !solenoid.get()) {
			solenoid.set(true);
		}

		lastValue = input;
	}

	/**
	 * 
	 * @param input1
	 *            Button to set double solenoid to Forward
	 * @param input2
	 *            Button to set double solenoid to Reverse
	 */
	public void DoubleToggle(boolean input1, boolean input2) {

		if (input1) {
			doubleSolenoid.set(DoubleSolenoid.Value.kForward);
		}
		if (input2) {
			doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
		}

	}

	/**
	 * 
	 * @param input1
	 *            Button to set single solenoid to true
	 * @param input2
	 *            Button to set single solenoid to false
	 */
	public void SingleToggle(boolean input1, boolean input2) {

		if (input1) {
			solenoid.set(true);
		}
		if (input2) {
			solenoid.set(false);
		}

	}

}