/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Add your docs here.
 */

public class SensorSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    AnalogInput ai  = new AnalogInput(RobotMap.ULTRA_L);
//    double scaleFactor = 0.0098;
    //To get the distance you multiply the analog voltage by the sensitivity or scale factor 
    //(typically in inches/V or inches/mV).
    //~9.8 mV/inch
    //sampling rate = 20 hertz
    public double SensorDistance(){
        double distance = ai.getAverageVoltage();// / scaleFactor;
        return distance;
    }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
