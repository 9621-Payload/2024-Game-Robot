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

    public static final int kEncoderLeftChannelA = 1;
    public static final int kEncoderLeftChannelB = 0;
    public static final int kEncoderRightChannelA = 3;
    public static final int kEncoderRightChannelB = 2;
  }

  public static class ShooterConstants {
    public static final int kShootMotorUpper = 9;
    public static final int kShootMotorLower = 8;
  }

  public static class ClimberBoxConstants {
    public static final int kClimberBoxMotor = 12;
    public static final double kMaxHeight = 370;
    public static final double kMinHeight = 3.0;
  }

  public static class GyroStuff {
    public static final Constraints kAimProfile = new Constraints(3 * Math.PI, 2 * Math.PI);
    public static boolean kManualArm = false;
  }

  public static class AutoContstants {
    public static final double kJitterTime = 1.0;
    public static final double kJitterDistance = 20.0;

    public static final double kKnockSpeed = 0.1;
    public static final double kFireTimeAUto = 1.4;

    public static final double kFinalHeading = 0.0;

    public static final double kFireTime = 1.5;
    public static final double kPrepareTime = 1.0;

    public static final double kBackupSourceDistance = -70.0 * 1.5;
    public static final double kBackupCenterDistance = -54.0;
    public static final double kBackupAmpDistance = -40.0;
    public static final double kBackupTime = 3.0;

    public static final double kSpeakerSideTurnTime = 3.5;
    public static final double kSpeakerSideForwardDistance = 98;
    public static final double kSpeakerSideForwardTime = 3.5;

    public static final double kSpeakerFrontForwardDistance = 7;
    public static final double kSpeakerFrontTurnTime = 6.5;
    public static final double kSpeakerFrontForwardTime = 3.5;

    public static final double kOnlyForwardDistance = 76.0;
  }
}
