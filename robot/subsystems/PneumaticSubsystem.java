/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Compressor;

/**
 * Add your docs here.
 */
public class PneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DoubleSolenoid p_lift = new DoubleSolenoid(RobotMap.P_LIFT, RobotMap.P_LIFT2);
  public DoubleSolenoid p_backLift = new DoubleSolenoid(RobotMap.P_BACKLIFT, RobotMap.P_BACKLIFT2);
  public DoubleSolenoid p_lotusLaunch = new DoubleSolenoid(RobotMap.P_LOTUSLAUNCH, RobotMap.P_LOTUSLAUNCH2);
  public DoubleSolenoid p_lotusLift = new DoubleSolenoid(RobotMap.P_LOTUSLIFT, RobotMap.P_LOTUSLIFT2);
  public Compressor p_AirBoi = new Compressor();


  public void Lifter(){

    p_lift.set(DoubleSolenoid.Value.kReverse);

  }

  public void LifterReverse(){

    p_lift.set(DoubleSolenoid.Value.kForward);

  }

  public void BackLifter(){

    p_backLift.set(DoubleSolenoid.Value.kReverse);

  }

  public void BackLifterReverse(){

    p_backLift.set(DoubleSolenoid.Value.kForward);

  }

  public void LotusLauncher(){

    p_lotusLaunch.set(DoubleSolenoid.Value.kForward);

  }

  public void LotusLauncherReverse(){

    p_lotusLaunch.set(DoubleSolenoid.Value.kReverse);

  }

  public void LotusLifter(){

    p_lotusLift.set(DoubleSolenoid.Value.kForward);

  }

  public void LotusLifterReverse(){

    p_lotusLift.set(DoubleSolenoid.Value.kReverse);

  }

  public void CompressorKill(){
    p_AirBoi.stop();
  }

  public void CompressorBegin(){
    p_AirBoi.start();
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
