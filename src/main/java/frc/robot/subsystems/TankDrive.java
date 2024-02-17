package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankConstants;
import java.lang.Math;

public class TankDrive extends SubsystemBase {
    /* Motor controllers to move the tank */
    private PWMSparkMax m_leftMotorFollower = new PWMSparkMax(TankConstants.kLeftMotorPort1);
    private PWMSparkMax m_leftMotors = new PWMSparkMax(TankConstants.kLeftMotorPort2);
    private PWMSparkMax m_rightMotorFollower = new PWMSparkMax(TankConstants.kRightMotorPort2);
    private PWMSparkMax m_rightMotors = new PWMSparkMax(TankConstants.kRightMotorPort1);

    /* Robot drive */
    private final DifferentialDrive m_Drive;
    private boolean v_driveStraight;

    /* Odometry for tracking robot */
    private final AHRS m_navX;

    /* Creates a new TankDrive */
    public TankDrive() {
        /* Sets the motors up and add the followers */
        m_leftMotors.addFollower(m_leftMotorFollower);
        m_rightMotors.addFollower(m_rightMotorFollower);
        m_rightMotors.setInverted(true);

        m_Drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
        m_navX = new AHRS();
        m_navX.getDisplacementX();
        v_driveStraight = false;
    }

    /*
     * Drives the robot using tank controls.
     */
    public void Move(Double leftForward, Double rightForward) {
        if (v_driveStraight) {
            m_Drive.arcadeDrive(leftForward, 0);
        } else {
            m_Drive.arcadeDrive(leftForward, rightForward);
        }

        // m_Drive.tankDrive(leftForward, rightForward);
    }

    /*
     * Rotate to a set direction
     */
    public void Rotate(Double rotation) {
        double v_goal = GetRotation().getAsDouble() + rotation;

        while (-4 > rotation || rotation > 4) {
            if (rotation < 0) {
                m_Drive.arcadeDrive(0, -0.5);
            } else if (rotation > 0) {
                m_Drive.arcadeDrive(0, 0.5);
            }

            rotation = v_goal - GetRotation().getAsDouble();
        }

        Stop();
    }

    public void Stop() {
        m_Drive.stopMotor();
    }

    /*
     * Get the rotation of the tank drive
     */
    public DoubleSupplier GetRotation() {
        return () -> m_navX.getAngle();
    }

    /*
     * Reset the 0 direction
     */
    public void Calibrate() {
        m_navX.reset();
        m_navX.zeroYaw();
    }

    /*
     * Get the NavX of the tank drive
     */
    public AHRS GetNavX() {
        return m_navX;
    }

    /*
     * Set the straight value
     */
    public void SetStraight(boolean value) {
        if (value != v_driveStraight) {
            v_driveStraight = value;
        }
    }
}
