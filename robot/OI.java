/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.BackLifter;
import frc.robot.commands.CompressorControl;
import frc.robot.commands.Lifter;
import frc.robot.commands.LotusLauncher;
import frc.robot.commands.LotusLifter;
//import frc.robot.commands.PlatformCommand;
//import frc.robot.commands.SensorTest;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
    public class OI {
    //  public Joystick leftStick = new Joystick(RobotMap.LEFT_STICK);
      public Joystick rightStick = new Joystick(RobotMap.RIGHT_STICK);
    
      Button lotusLaunch = new JoystickButton(rightStick, 1);
      Button lifter = new JoystickButton(rightStick, 9);
      Button backLifter = new JoystickButton(rightStick, 11);
      Button lotusLifter = new JoystickButton(rightStick, 2);
      Button compressor = new JoystickButton(rightStick, 6);
      //Button Platform = new JoystickButton(rightStick, 5);
      //Button SensorTest = new JoystickButton(rightStick, 12);
    
      public OI(){
        lotusLaunch.toggleWhenPressed(new LotusLauncher());
        lotusLifter.toggleWhenPressed(new LotusLifter());
        backLifter.toggleWhenPressed(new BackLifter());
        lifter.toggleWhenPressed(new Lifter());
        compressor.toggleWhenPressed(new CompressorControl());
        //Platform.whenPressed(new PlatformCommand());
        //SensorTest.whileHeld(new SensorTest());
      }
    
      public boolean joystickIsPluggedIn(){
        return rightStick.getThrottle() != 0;
      }
    
    }
