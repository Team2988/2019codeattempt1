/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  public static int LEFT_MOTOR = 2;
  public static int RIGHT_MOTOR = 1;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static final DriveType DRIVE_TYPE = DriveType.SINGLE_TWIST_ARCADE;

  //The limiting values for the motors
  //Joystick dead zones
  //default deadzone was 0.05
  public static final double DEAD_ZONE = 0.1;
  //Values for slowing down the motors
  public static final double TWIST_RATE = .75;
  public static final double STRAIGHT = .9;
  public static final double STICK_LIMIT = .3;
  public static final double STICK_MULTIPLIER = .5;


//  public static final int LEFT_STICK = 1;
  public static final int RIGHT_STICK = 0;
  
  //Solenoid ports- They require two
  public static int P_LIFT = 2;
  public static int P_LIFT2 = 3;
  public static int P_LOTUSLAUNCH = 6;
  public static int P_LOTUSLAUNCH2 = 7;
  public static int P_BACKLIFT = 0;
  public static int P_BACKLIFT2 = 1;
  public static int P_LOTUSLIFT = 4;
  public static int P_LOTUSLIFT2 = 5;

  //sensor ports
  public static int ULTRA_L = 0;
}
