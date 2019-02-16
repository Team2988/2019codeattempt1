/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.subsystems.DriveSubsystem;

import frc.robot.OI;
import frc.robot.commands.DriveCommand;

public class CommandBase {
    private static OI oi;
    private static DriveSubsystem drive;
    //private static PneumaticSubsystem pneumatics;

    private static DriveCommand driveCommand;


    public CommandBase() {
        oi = new OI();
        drive = new DriveSubsystem();

        driveCommand = new DriveCommand();
    }


    public static OI oiGetter() {
        return oi;
    }

    public static Joystick leftStickGetter() {
        return oi.leftStick;
    }

    public static Joystick rightStickGetter() {
        return oi.rightStick;
    }

    public static DriveSubsystem getDriveSubsystem() {
        return drive;
    }

    //public static PneumaticSubsystem getPneumaticSubsystem(){
    //    return pneumatics;
    //}

    public static DriveCommand getDriveCommand() {
        return driveCommand;
    }

}