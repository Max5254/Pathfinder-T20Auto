package org.usfirst.frc.team5254.autoCommands;

import org.usfirst.frc.team5254.robot.Pathfinder;
import org.usfirst.frc.team5254.robot.Team5254Libraries.T20Command;

public class AutoCommandIntakeDown extends Pathfinder implements T20Command {
	private boolean isFinished, isStarted;

	public AutoCommandIntakeDown() {
		this.isFinished = false;
		this.isStarted = false;
	}

	@Override
	public void execute() {
		if (isFinished) {
			return;
		}

		if (!isStarted) {
			System.out.println("<Tomahawks Are Moving Up>");
			isStarted = !isStarted;
		}
		System.out.println("</Tomahawks Are Moving Up>");
		
		if(intake.intakeUp()) {
			intake.toggleIntake(true);
		} else {
			intake.toggleIntake(false);
		}
		
		if (isStarted) {
			this.isFinished = true;
		}
	}

	@Override
	public boolean isFinished() {
		return isFinished;
	}

	@Override
	public T20Command copy() {
		return new AutoCommandIntakeDown();
	}

}
