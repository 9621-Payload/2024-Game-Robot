// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lib.Config.Constants;
import frc.lib.Util.Autonomous;
import frc.lib.Util.RoboMove;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  //Controlling the robot
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  // Parts of the robot drive base
  private DifferentialDrive m_robotDrive;
  private final PWMSparkMax m_leftMotor = new PWMSparkMax(0);
  private final PWMSparkMax m_rightMotor = new PWMSparkMax(1);

  //Auto choosing
  private int m_autoSelected;
  private final SendableChooser<Integer> m_chooser = new SendableChooser<>();
  private final SendableChooser<Integer> t_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    SendableRegistry.addChild(m_robotDrive, m_leftMotor);
    SendableRegistry.addChild(m_robotDrive, m_rightMotor);

    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward.
    m_rightMotor.setInverted(true);

    m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
    RoboMove.setRobot(m_robotDrive);

    // Creates the menus for SmartDashboard
    m_chooser.setDefaultOption("Drive Forward", 1);
    m_chooser.addOption("Left Side Red", 2);
    SmartDashboard.putData("Auto choices", m_chooser);
    t_chooser.setDefaultOption("Blue", 1);
    t_chooser.addOption("Red", 2);
    SmartDashboard.putData("Team", t_chooser);
    SmartDashboard.putData("Drive Base", m_robotDrive);
  }
    

  @Override
  public void teleopPeriodic() {
    m_robotDrive.tankDrive(-m_leftStick.getY(), -m_rightStick.getY());
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    // Set the team and auto choosen
    m_autoSelected = m_chooser.getSelected();
    Constants.Team = t_chooser.getSelected();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case 1:
        Autonomous.DriveForward();
        break;
      case 2:
        Autonomous.RightSide();
        break;
      default:
        // Put default auto code here
        break;
    }
  }
}
