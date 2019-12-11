/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.CommandBase;
import frc.robot.RobotMap;

public class DriveCommand extends Command {
  private DriveSubsystem drive;
  public Joystick lStick, rStick;
  public boolean done;
  
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //lStick = CommandBase.leftStickGetter();
    rStick = CommandBase.rightStickGetter();
    drive = CommandBase.getDriveSubsystem();
    requires(drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    done = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  double  rStickY, rStickX, rTwist;

  rStickY = -rStick.getY();//RobotMap.STRAIGHT * rStick.getY(); // right motor for tank

  rStickX = rStick.getX(); // for omni drive strafe and arcade rotation

  // if stick does not have twist it returns -1
  rTwist =  -rStick.getTwist();//RobotMap.TWIST_RATE * rStick.getTwist();

        // dead zones for joy sticks
        rStickX = (Math.abs(rStickX) < RobotMap.DEAD_ZONE) ? 0 : rStickX;
        rStickY = (Math.abs(rStickY) < RobotMap.DEAD_ZONE) ? 0 : rStickY;

    
// drive command that uses drive type specified in RobotMap

drive.drive(rTwist, rStickX, rStickY);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
