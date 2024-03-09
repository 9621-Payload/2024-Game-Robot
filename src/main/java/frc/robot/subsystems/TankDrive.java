package frc.robot.subsystems;

import java.util.function.DoubleSupplier;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankConstants;

public class TankDrive extends SubsystemBase {
    /* Motor controllers to move the tank */
    private PWMSparkMax m_leftMotorFollower = new PWMSparkMax(TankConstants.kLeftMotorPort1);
    private PWMSparkMax m_leftMotors = new PWMSparkMax(TankConstants.kLeftMotorPort2);
    private PWMSparkMax m_rightMotorFollower = new PWMSparkMax(TankConstants.kRightMotorPort2);
    private PWMSparkMax m_rightMotors = new PWMSparkMax(TankConstants.kRightMotorPort1);

    /* Robot drive */
    private final DifferentialDrive m_Drive;
    private Encoder encoderLeft;
    private Encoder encoderRight;

    /* Odometry for tracking robot */
    private final AHRS m_navX;

    /* Creates a new TankDrive */
    public TankDrive() {
        /* Sets the motors up and add the followers */
        m_leftMotors.addFollower(m_leftMotorFollower);
        m_rightMotors.addFollower(m_rightMotorFollower);
        m_rightMotors.setInverted(true);

        /* Setups the encoders */
        encoderLeft = new Encoder(7,6, true, EncodingType.k2X);
        encoderRight = new Encoder(9, 8, false, EncodingType.k2X);

        encoderRight.setDistancePerPulse(4.86/512.0);
        encoderLeft.setDistancePerPulse(4.86/512.0);

        // Configures the encoder to consider itself stopped when its rate is below 10
        //encoderRight.setMinRate(10);

        // Configures an encoder to average its period measurement over 5 samples
        // Can be between 1 and 127 samples
        encoderRight.setSamplesToAverage(5);
        encoderLeft.setSamplesToAverage(5);

        m_Drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
        m_navX = new AHRS();
        m_navX.getDisplacementX();
    }

    /*
     * Drives the robot using tank controls.
     */
    public void Move(Double forward, Double rotate) {
        m_Drive.arcadeDrive(forward, rotate);
    }

    public void MoveDis(Double dis) {
        while (GetEncoderDistance().getAsDouble() <= (dis - 2) || GetEncoderDistance().getAsDouble() >= (dis + 2)) {
            if (encoderLeft.getDistance() < dis){
                m_Drive.arcadeDrive(-0.7, 0);
            } else {
                m_Drive.arcadeDrive(0.7, 0);
            }
        }
        Stop();
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

    public DoubleSupplier GetRightEncoder() {
        return () -> encoderRight.getDistance();
    }
    public DoubleSupplier GetLeftEncoder() {
        return () -> encoderLeft.getDistance();
    }

    /* 
     * Get the average of the encoder for straight driving
     */
    public DoubleSupplier GetEncoderDistance() {
        return () -> ((encoderLeft.getDistance() + encoderRight.getDistance()) / 2);
    }

    /*
     * Reset the 0 direction
     */
    public void Calibrate() {
        m_navX.reset();
        m_navX.zeroYaw();
        encoderRight.reset();
        encoderLeft.reset();
    }

    public void ResetEncode() {
        encoderLeft.reset();
        encoderRight.reset();
    }

    /*
     * Get the NavX of the tank drive
     */
    public AHRS GetNavX() {
        return m_navX;
    }
}
