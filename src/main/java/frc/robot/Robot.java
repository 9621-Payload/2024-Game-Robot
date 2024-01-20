// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.lib.Config.Constants;
import frc.lib.Util.Autonomous;
import frc.lib.Util.RobotContainer;

/**
 * This is a demo program showing the use of the DifferentialDrive class,
 * specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  // Controlling the robot
  private XboxController m_driverStick;
  private XboxController m_operatorStick;

  RobotContainer m_RobotContainer;

  // Auto choosing
  private int m_autoSelected;
  private final SendableChooser<Integer> m_chooser = new SendableChooser<>();
  private final SendableChooser<Integer> t_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_RobotContainer = new RobotContainer();


    // Creates the menus for SmartDashboard
    //m_chooser.setDefaultOption("Drive Forward", 1);
    //m_chooser.addOption("Left Side Red", 2);
    //SmartDashboard.putData("Auto choices", m_chooser);
    //t_chooser.setDefaultOption("Blue", 1);
    //t_chooser.addOption("Red", 2);
    //SmartDashboard.putData("Team", t_chooser);
    //SmartDashboard.putData("Drive Base", m_robotDrive);
  }

  @Override
  public void teleopPeriodic() {
    _robot.tankDrive(-m_driverStick.getRawAxis(1), -m_driverStick.getRawAxis(5));
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
