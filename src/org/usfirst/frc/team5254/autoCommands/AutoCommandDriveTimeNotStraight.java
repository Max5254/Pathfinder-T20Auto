package org.usfirst.frc.team5254.autoCommands;

import org.usfirst.frc.team5254.robot.Pathfinder;
import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.Team5254Libraries.T20Command;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import subsystems.Drivetrain;

public class AutoCommandDriveTimeNotStraight extends Pathfinder  implements T20Command {
	private boolean isFinished, isStarted;
	private double speed, time;
	private Timer driveTimer = new Timer();

	public AutoCommandDriveTimeNotStraight(double speed, double time) {
		this.isFinished = false;
		this.isStarted = false;
		this.time = time;
		this.speed = speed;
	}

	@Override
	public void execute() {
		if (isFinished) {
			return;
		}

		if (!isStarted) {
			System.out.println("<Drive Straight At Speed: " + this.speed + " For Time: " + this.time + ">");
			isStarted = !isStarted;
			driveTimer.start();
		}
		if (driveTimer.get() < this.time) {
			drivetrain.drive(this.speed, 0);
		} else if (driveTimer.get() > this.time) {
			drivetrain.drive(0, 0);
			System.out.println("</Drive Straight At Speed: " + this.speed + " For Time: " + this.time + ">");
			this.isFinished = true;
		}
	}

	@Override
	public boolean isFinished() {
		return isFinished;
	}

	@Override
	public T20Command copy() {
		return new AutoCommandDriveTimeNotStraight(this.speed, this.time);
	}

}
