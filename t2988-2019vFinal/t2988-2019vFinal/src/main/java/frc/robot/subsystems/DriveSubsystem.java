/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
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
/*  public void setDrive(DifferentialDrive m_drive) {
    this.m_drive = m_drive;
  }
*/
 /* public DifferentialDrive getDrive() {
    return m_drive;
  }
*/
  public DriveSubsystem() {
    Talon m_Left = new Talon(RobotMap.LEFT_MOTOR);
    Talon m_Right = new Talon(RobotMap.RIGHT_MOTOR);

    //setDrive(new DifferentialDrive(m_Left, m_Right));
    m_drive = new DifferentialDrive(m_Left, m_Right);
  }


  public void drive(double ly, double ry, double lx, double rx, double lt, double rt) {
		// if bot does not drive, then comment out and call drive type wanted..

		// uses drive type specified
		switch (RobotMap.DRIVE_TYPE) {
		case TANK:
			m_drive.tankDrive(ry, ly); // right stick y, left stick y
			break;
		case ARCADE:
			m_drive.arcadeDrive(rx, ly); // right stick x, left stick y
			break;
		case SINGLE_ARCADE:
			m_drive.arcadeDrive(rx, ry); // left stick x, left stick y
			break;
		case SINGLE_TWIST_ARCADE:
			m_drive.arcadeDrive(rt, -ry); // left stick twist, left stick y

    }
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
