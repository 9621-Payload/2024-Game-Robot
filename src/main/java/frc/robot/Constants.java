// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.




package frc.robot;

import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }

  public static class TankConstants {
    public static final int kLeftMotorPort1 = 5;
    public static final int kLeftMotorPort2 = 7;
    public static final int kRightMotorPort1 = 4;
    public static final int kRightMotorPort2 = 6;
  }

  public static class ShooterConstants {
    public static final int kShootMotorUpper = 9;
    public static final int kShootMotorLower = 8;
  }
  public static class ClimberBoxConstants {
    public static final int kClimberBoxMotor = 12;
  }

  public static class GyroStuff{
    public static final Constraints kAimProfile = new Constraints(3* Math.PI, 2* Math.PI);
    public static boolean manualArm = false;
  }
}
