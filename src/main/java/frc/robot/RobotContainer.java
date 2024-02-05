// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.autos.Autos;
import frc.robot.commands.*;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  /* Subsystems */
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final TankDrive s_tankDrive = new TankDrive();
  private final Shooter s_Shooter = new Shooter();

  /* Controllers */
  private final CommandXboxController c_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);
  private final CommandXboxController c_operatorController = new CommandXboxController(
      OperatorConstants.kOperatorControllerPort);

  /* Triggers/Buttons */
  private final Trigger operatorLeftTriggerDepressed = new Trigger(
      () -> c_operatorController.getRawAxis(2) > 0.1);
  private final Trigger operatorRightTriggerDepressed = new Trigger(
      () -> c_operatorController.getRawAxis(3) > 0.1);
  private final Trigger operatorRightBumper = c_operatorController.rightBumper();
  private final Trigger driverDownPad = c_driverController.povDown();
  private final Trigger driverupPad = c_driverController.povUp();  
  private final Trigger driverrightPad = c_driverController.povRight();
  private final Trigger driverleftPad = c_driverController.povLeft();
  private final Trigger driverY = c_driverController.y();
  private final Trigger operatorA = c_operatorController.a();
  private final Trigger operatorUpPad = c_operatorController.povUp();

  /*
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    /* Setup the default command -> moving */
    s_tankDrive.setDefaultCommand(
        new TelopTankMove(
            s_tankDrive,
            () -> c_driverController.getRawAxis(1),
            () -> c_driverController.getRawAxis(5)));

    /* Register the subsystems */
    CommandScheduler.getInstance().registerSubsystem(s_tankDrive);
    CommandScheduler.getInstance().registerSubsystem(s_Shooter);

    configureBindings();
  }

  /* Assign commands to certain actions on the controllerss */
  private void configureBindings() {
    /* Driver */
    /* ====== */
    driverDownPad.whileTrue(new TelopTankRotate(s_tankDrive, 180.0));
    driverupPad.whileTrue(new TelopTankRotate(s_tankDrive, 0.0));
    driverrightPad.whileTrue(new TelopTankRotate(s_tankDrive, 90.0));
    driverleftPad.whileTrue(new TelopTankRotate(s_tankDrive, 270.0));
    driverY.whileTrue(new GyroReset(s_tankDrive));

    /* Operator */
    /* ======== */
    operatorLeftTriggerDepressed.whileTrue(new TelopShooterIntake(s_Shooter));
    operatorRightTriggerDepressed.whileTrue(new TelopShooterSpeakerShot(s_Shooter));
    operatorRightBumper.whileTrue(new TelopShooterAmpShot(s_Shooter));
    operatorA.whileTrue(new TelopShooterSpeakerShotFire(s_Shooter));
    operatorUpPad.whileTrue(new TelopShooterFarShot(s_Shooter));
  }

  /*
   * Use this to pass the autonomous command to the main {@link Robot} class.
   */
  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
