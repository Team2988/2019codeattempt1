/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */

public class DriveSubsystem extends Subsystem {
  private double lastRT;
  private double lastRY;
  private double lastRX;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DifferentialDrive m_drive;

  /**
   * Instantiates the driving motors with the encoders for both wheels.
   */
    
   /**
   * @return the drive
   */

    /**
   * @param drive the drive to set
   */
 // public void setDrive(DifferentialDrive m_drive) {
  //  this.m_drive = m_drive;
  //}

 /* public DifferentialDrive getDrive() {
    return m_drive;
  }
*/
  public DriveSubsystem() {
    Spark m_Left = new Spark(RobotMap.LEFT_MOTOR);
    Spark m_Right = new Spark(RobotMap.RIGHT_MOTOR);
    //maybe we could do something with this to limit the voltage/amperage to the Sparks
    //m_Left.setBounds(max, deadbandMax, center, deadbandMin, min);

    //setDrive(new DifferentialDrive(m_Left, m_Right));
    m_drive = new DifferentialDrive(m_Left, m_Right);
    //m_drive.setMaxOutput(maxOutput);
    lastRT = 0;
    lastRY = 0;
    lastRX = 0;
  }


  public void drive(double ry, double rx, double rt) {
    // if bot does not drive, then comment out and call drive type wanted..
    double rYChange = ry - lastRY;
    double rTChange = rt - lastRT;
    double rXChange = rx - lastRX;
    if(Math.abs(rYChange) > RobotMap.STICK_LIMIT){
        lastRY = RobotMap.STICK_MULTIPLIER * Math.signum(rYChange);
    }else{
      lastRY = ry;
    }

    if(Math.abs(rTChange) > RobotMap.STICK_LIMIT){
      lastRT = RobotMap.STICK_MULTIPLIER * Math.signum(rTChange);
    }else{
      lastRT = rt;
    }

    if(Math.abs(rXChange) > RobotMap.STICK_LIMIT){
      lastRX = RobotMap.STICK_MULTIPLIER * Math.signum(rTChange);
    }else{
      lastRX = rx;
    }

		// uses drive type specified
		switch (RobotMap.DRIVE_TYPE) {
/*		case TANK:
			m_drive.tankDrive(ry, ly); // right stick y, left stick y
			break;
		case ARCADE:
			m_drive.arcadeDrive(rx, ly); // right stick x, left stick y
      break;
      */
		case SINGLE_ARCADE:
			m_drive.arcadeDrive(lastRX, lastRY); // right stick x, left stick y
			break;
		case SINGLE_TWIST_ARCADE:
			m_drive.arcadeDrive(lastRT, -lastRY); // right stick twist, left stick y

    }
  }

  //this gives the drive type for any sequential driving
  public void sequentialDrive(double x, double y) {
		m_drive.arcadeDrive(x, y);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
