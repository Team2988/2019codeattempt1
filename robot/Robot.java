/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PneumaticSubsystem;
//ladies, I need to import this stuff so that I can use this reeeaaaaally useful stuff
//import C:\Users\2988p\Downloads\pixy-master;
import frc.robot.subsystems.SensorSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI m_oi;
  public static PneumaticSubsystem pnuematicsubsystem = new PneumaticSubsystem();
  public static SensorSubsystem sensorSubsystem = new SensorSubsystem();
  //public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static CommandBase commandBase;
  double distanceValue;
  UsbCamera camera;
  Robot robot;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    commandBase = new CommandBase();
    m_oi = new OI();

    robot = this;
    // chooser.addOption("My Auto", new MyAutoCommand());

    //SmartDashboard.putData("Auto mode", m_chooser);
    camera = CameraServer.getInstance().startAutomaticCapture("Camera 1",0);
    camera.setResolution(160, 120);
    //camera.setVideoMode(PixelFormat.kMJPEG, 320, 240, 30);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    distanceValue = sensorSubsystem.SensorDistance();
    SmartDashboard.putNumber("Right Sensor Value:", distanceValue);
    System.out.println(distanceValue);

    PowerDistributionPanel pdp = new PowerDistributionPanel();
    double current0 = pdp.getCurrent(0);
    SmartDashboard.putNumber("The Current at port one is: ", current0);
    System.out.println(current0);
    double current1 = pdp.getCurrent(1);
    SmartDashboard.putNumber("The Current at port one is: ", current1);
    System.out.println(current1);    
    double current2 = pdp.getCurrent(2);
    SmartDashboard.putNumber("The Current at port one is: ", current2);
    System.out.println(current2);    
    double current3 = pdp.getCurrent(3);
    SmartDashboard.putNumber("The Current at port one is: ", current3);
    System.out.println(current3);    
    double current4 = pdp.getCurrent(4);
    SmartDashboard.putNumber("The Current at port one is: ", current4);
    System.out.println(current4);    
    double current5 = pdp.getCurrent(5);
    SmartDashboard.putNumber("The Current at port one is: ", current5);
    System.out.println(current5);
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    CommandBase.getDriveCommand().cancel();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    CommandBase.getDriveCommand().start();
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    CommandBase.getDriveCommand().start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  //@Override
  //public void operatorControl()
  //{
    //isDone = false;
    //Thread thread = new Thread()
    //{
      //public void run()
      //{
        //while (!isDone)
        //{
          //if(RobotMap.visionSystemEnable != -1)
          //{
            //vision.vision();
          //}
        //}
      //}
    //};
    //thread.start();
  //}
}
