/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
//import frc.robot.Robot;
//import frc.robot.subsystems.DriveSubsystem;

public class PlatformCommand extends CommandGroup {
  //these are the subsystem requirements
  //private DriveSubsystem driveSubsystem;

  public PlatformCommand() {
//    requires(Robot.pnuematicsubsystem);
    //requires(driveSubsystem);
    //ERROR  1  Unhandled exception: java.lang.IllegalArgumentException: Subsystem must not be null.
    // frc.robot.commands.PlatformCommand.<init>(PlatformCommand.java:20) 
    //remember that  sequential drive is (double turn, double forward, double time)
    //if(LotusLifter.lotus_lifted = true){
    //  addSequential(new LotusLifter());
    //}
    addSequential(new BackLifter());
    addSequential(new KarlsSequentialDrive(-.5,0,1));
    addSequential(new BackLifter());
    //An additional KarlSequence could be needed here but Connor said it wasn't necessary to move once
    //the back is on
    addSequential(new Lifter());
    addSequential(new KarlsSequentialDrive(-.5,0,1));
    addSequential(new Lifter());
    addSequential(new KarlsSequentialDrive(-.5,0,1));

    //addSequential(new KarlsSequentialDrive(0,-1,1));

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
