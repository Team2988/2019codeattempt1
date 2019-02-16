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
   public static int LEFT_MOTOR = 1;
   public static int RIGHT_MOTOR = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
    public static final DriveType DRIVE_TYPE = DriveType.SINGLE_TWIST_ARCADE;

    //The limiting values for the motors
    //Joystick dead zones
    public static final double DEAD_ZONE = 0.05;
    //Values for slowing down the motors
    public static final double TWIST_RATE = .8;


  public static final int LEFT_STICK = 0;
  public static final int RIGHT_STICK = 1;

  public static int P_LIFT = 2;
  public static int P_LIFT2 = 3;
  public static int P_LOTUSLAUNCH = 4;
  public static int P_LOTUSLAUNCH2 = 5;
  public static int P_LIFTBACK = 0;
  public static int P_LIFTBACK2 = 1;
  public static int P_LOTUSLIFTER = 6;
  public static int P_LOTUSLIFTER2 = 7;
  
}
