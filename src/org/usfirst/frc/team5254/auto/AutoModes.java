package org.usfirst.frc.team5254.auto;

import org.usfirst.frc.team5254.autoCommands.*;
import org.usfirst.frc.team5254.robot.Pathfinder;
import org.usfirst.frc.team5254.robot.Team5254Libraries.T20Command;
import org.usfirst.frc.team5254.robot.Team5254Libraries.T20Node;
import org.usfirst.frc.team5254.robot.Team5254Libraries.T20ParallelNode;
import org.usfirst.frc.team5254.robot.Team5254Libraries.T20SeriesNode;

public class AutoModes extends Pathfinder {

	private T20Node testTree;

	/**
	 * Drives at 50% speed for 5 seconds
	 * 
	 * @return a drive only auto
	 */

	public void createTestTree() {
		testTree = new T20SeriesNode();
		testTree.addChild(new AutoCommandIntakeDown());
		testTree.addChild(new AutoCommandDriveTimeNotStraight(0.5, 5));

	}

	/**
	 * Drives at 50% speed for 5 seconds
	 * 
	 * @return a drive only auto
	 */

	public void executeTestTree() {
		testTree.execute();
	}


}
