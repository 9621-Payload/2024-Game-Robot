// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.autos.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ShooterSpeakerShot;
import frc.robot.commands.TelopTankMove;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj.XboxController;
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
  private final CommandXboxController c_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController c_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /* Drive Values */

  /* The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    /* Setup the default command -> moving */
    s_tankDrive.setDefaultCommand(
      new TelopTankMove(
        s_tankDrive, 
        () -> c_driverController.getLeftY(),
        () -> c_driverController.getRightX()));

    /* Register the subsystems */
    CommandScheduler.getInstance().registerSubsystem(s_tankDrive);
    CommandScheduler.getInstance().registerSubsystem(s_Shooter);

    configureBindings();
  }

  /* Assign commands to certain actions on the controllerss */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    /* Driver */
    /* ====== */
    c_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    /* Operator */
    /* ======== */
    c_operatorController.leftTrigger().whileTrue(new ShooterSpeakerShot(s_Shooter));
  }

  /*
   * Use this to pass the autonomous command to the main {@link Robot} class.
   */
  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
