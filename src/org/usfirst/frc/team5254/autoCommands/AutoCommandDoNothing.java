package org.usfirst.frc.team5254.autoCommands;

import org.usfirst.frc.team5254.robot.Team5254Libraries.T20Command;

public class AutoCommandDoNothing implements T20Command {
	private boolean isFinished, isStarted;

	public AutoCommandDoNothing() {
		this.isFinished = false;
		this.isStarted = false;
	}

	@Override
	public void execute() {
		if (isFinished) {
			return;
		}

		if (!isStarted) {
			System.out.println("<Literally Doing NOTHING>");
			isStarted = !isStarted;
		}
		System.out.println("</Literally Doing NOTHING>");
		this.isFinished = true;
	}

	@Override
	public boolean isFinished() {
		return isFinished;
	}

	@Override
	public T20Command copy() {
		return new AutoCommandDoNothing();
	}

}
