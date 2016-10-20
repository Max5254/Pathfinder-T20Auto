package subsystems;

import org.usfirst.frc.team1.robot.Constants;
import edu.wpi.first.wpilibj.Relay;

/** RELAY Options-
 * kOff - Turns both relay outputs off
 * kForward - Sets the relay to forward (M+ @ 12V, M- @ GND)
 * kReverse - Sets the relay to reverse (M+ @ GND, M- @ 12V)
 * KOn - Sets both relay outputs on (M+ @ 12V, M- @ 12V).
 */

public class Flashlight {

	Relay flashlight = new Relay(Constants.FLASHLIGHT_PORT);

	//Default flashlight to off
	public Flashlight() {
		flashlight.set(Relay.Value.kReverse);
	}

	// turn light on
	public void lightOn() {
		flashlight.set(Relay.Value.kForward);
	}

	// turn light off
	public void lightOff() {
		flashlight.set(Relay.Value.kReverse);
	}

}