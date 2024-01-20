package frc.lib.Util;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class RoboMove {
    private static DifferentialDrive _robot;
    private final static Talon m_leftMotor = new Talon(0);
    private final static Talon m_rightMotor = new Talon(1);

    public static void setRobot() {
        // We need to invert one side of the drivetrain so that positive voltages
        // result in both sides moving forward.
        m_rightMotor.setInverted(true);

        _robot = new DifferentialDrive(m_leftMotor, m_rightMotor);
    }

    public void forward() {

    }

    public void backward() {

    }

    public void rotation() {

    }

    public static void move(double leftSpeed, double rightSpeed) {
        _robot.tankDrive(leftSpeed, rightSpeed);
    }

}
