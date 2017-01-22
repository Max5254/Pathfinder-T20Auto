package org.usfirst.frc.team5254.robot.Team5254Libraries;

public interface T20Command {
	
	void execute();
	
	boolean isFinished();
	
	T20Command copy();
}