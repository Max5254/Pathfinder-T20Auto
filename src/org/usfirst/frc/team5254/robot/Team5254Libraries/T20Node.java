package org.usfirst.frc.team5254.robot.Team5254Libraries;

public interface T20Node extends T20Command{

	@Override void execute();

	@Override boolean isFinished();
	
	@Override T20Command copy();
	
	void addChild(T20Command child);
}

