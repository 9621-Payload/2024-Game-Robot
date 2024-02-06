// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TankDrive;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  /* Subsystems */
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
  private final Trigger driverLeftTriggerDepressed = new Trigger(
      () -> c_driverController.getRawAxis(2) > 0.1);
  private final Trigger operatorUpPad = c_operatorController.povUp();

  private AutoModeSelector autoModeSelector;

  /*
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    /* Setup the default command -> moving */
    s_tankDrive.setDefaultCommand(
        new TankMove(
            s_tankDrive,
            () -> c_driverController.getRawAxis(1),
            () -> c_driverController.getRawAxis(5)));

    autoModeSelector = new AutoModeSelector(this);

    /* Register the subsystems */
    CommandScheduler.getInstance().registerSubsystem(s_tankDrive);
    CommandScheduler.getInstance().registerSubsystem(s_Shooter);

    /* Shuffleboard setup */
    ShuffleboardTab mainTab = Shuffleboard.getTab("Main");
    Map<String, Object> pressureSensorMax = new HashMap<String, Object>() {
      {
        put("max", 120);
      }
    };
    //mainTab.addString("Gamepiece State", () -> s_GamePieceSelector.getCurrentGamepiece().toString()).withSize(1, 1)
    //    .withPosition(0, 0);
    mainTab.addString("Alliance", () -> DriverStation.getAlliance().toString()).withSize(1, 1)
        .withPosition(1, 0);
    //mainTab.addString("Selected Node", () -> s_NodeSelector.getSelectedNodeLabel()).withSize(1, 1)
    //    .withPosition(2, 0);
    mainTab.addDouble("Gyro", () -> s_tankDrive.GetRotation().getAsDouble()).withSize(1, 1)
        .withPosition(3, 0);
    mainTab.add("AutoMode", autoModeSelector.getAutoChooser()).withSize(2, 1).withPosition(0, 1);
    mainTab.add("Gyro zero", new ZeroGyro(s_tankDrive)).withSize(2, 1).withPosition(2, 1);
    //mainTab.addDouble("Analog Pressure Sensor", () -> PressureSensor.getAnalogPressureReading()).withSize(2, 1)
    //    .withPosition(0, 2).withWidget(BuiltInWidgets.kDial).withProperties(pressureSensorMax);
    //mainTab.add("Reset angle encoders", new ResetSwerveAngleEncoders(s_Swerve)).withSize(2, 1).withPosition(2, 2);
    //mainTab.add("Game Field", s_tankDrive.getField()).withSize(5, 3).withPosition(4, 0);

    configureBindings();
  }

  /* Assign commands to certain actions on the controllerss */
  private void configureBindings() {
    /* Driver */
    /* ====== */
    driverDownPad.whileTrue(new TankRotate(s_tankDrive, 180.0));
    driverupPad.whileTrue(new TankRotate(s_tankDrive, 0.0));
    driverrightPad.whileTrue(new TankRotate(s_tankDrive, 90.0));
    driverleftPad.whileTrue(new TankRotate(s_tankDrive, 270.0));
    driverY.onTrue(new ZeroGyro(s_tankDrive));
    driverLeftTriggerDepressed.whileTrue(new TankMoveStraight(s_tankDrive));

    /* Operator */
    /* ======== */
    operatorLeftTriggerDepressed.whileTrue(new ShooterIntake(s_Shooter));
    operatorRightTriggerDepressed.onTrue(
        new ShooterSpeakerShot(s_Shooter).withTimeout(1).andThen(new ShooterFire(s_Shooter, 1.0)).withTimeout(2));
    operatorRightBumper
        .onTrue(new ShooterAmpShot(s_Shooter).withTimeout(1).andThen(new ShooterFire(s_Shooter, 0.6).withTimeout(1.4)));
    operatorUpPad.whileTrue(new ShooterFarShot(s_Shooter));
  }

  public TankDrive GetTank(){
    return s_tankDrive;
  }

  public Shooter GetShooter(){
    return s_Shooter;
  }

  public Command getAutonomousCommand() {
    return autoModeSelector.getAutoChooser().getSelected();
}
}
