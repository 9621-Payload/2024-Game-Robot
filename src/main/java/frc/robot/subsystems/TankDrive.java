package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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

    /* Gyro Sensor */
    private final ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();

    /* Odometry for tracking robot */
    // private final DifferentialDriveOdometry m_odometry;

    /* Creates a new TankDrive */
    public TankDrive() {
        /* Sets the motors up and add the followers */
        m_leftMotors.addFollower(m_leftMotorFollower);
        m_rightMotors.addFollower(m_rightMotorFollower);
        m_rightMotors.setInverted(true);

       m_Drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    }

    /*
     * Drives the robot using arcade controls.
     */
    public void Move(Double leftForward, Double rightForward) {
        m_Drive.tankDrive(leftForward * TankConstants.kDriveMultiplier, rightForward * TankConstants.kDriveMultiplier);
    }

    /*
     * Drives the robot using arcade controls.
     */
    public void Rotate(Double rotation) {
        double differ = m_gyro.getAngle() - rotation;
        if (differ > 3) {
            m_Drive.arcadeDrive(0, -0.75);
        } else if (differ < -3){
            m_Drive.arcadeDrive(0, 0.75);
        } else {
            m_Drive.arcadeDrive(0, 0.5 * (Math.abs(differ) / differ));
        }
    }

    /*
     * Get the rotation of the tank drive
     */
    public DoubleSupplier GetRotation() {
        return () -> m_gyro.getAngle();
    }

    public void Calibrate() {
        m_gyro.calibrate();
    }
}
