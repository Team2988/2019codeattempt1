/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.subsystems.DriveSubsystem;

//---Hey! This is Will! I created this command so that we can drive in segments, for distance or time-//
//---I hope that makes sense, we need it if we want to make any commands that run semi-autonomously---//
//---I am commenting out all of the distance parts of the code.  There are no encoders, so we can't---//
//---use them for this year.--------------------------------------------------------------------------//

public class KarlsSequentialDrive extends Command {

    private DriveSubsystem driveSubSystem;
	  private double x, y;					// motor values for AutoDrive
	  private double time;
	//  private int distance;
		
  /**
	 * 
	 * @param x    the forward motor value
	 * @param y    the turn motor value
	 * @param time seconds to run command
	 * @return
	 */
  //this will make it run with time instead of distance if we need
	public KarlsSequentialDrive(double x, double y, double time) {
		//this(x, y);
		this.time = time;
	}



  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
			setTimeout(time);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveSubSystem.sequentialDrive(x, y);
  }

 
  /**
	* Stops when time limit is reached or within 3 inches if applicable.
	*/
  @Override
  protected boolean isFinished() {
    return false;
	}
	
    // Called once after isFinished returns true
  @Override
  protected void end() {
    driveSubSystem.sequentialDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
	}
}
