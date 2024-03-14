package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ClimberBoxConstants;

public class ClimberBox extends SubsystemBase {
    /* Motor controllers to lift the Climber */
    private CANSparkMax m_WhinchMotor = new CANSparkMax(ClimberBoxConstants.kClimberBoxMotor, MotorType.kBrushless);

    /* Creates a new Shooter */
    public ClimberBox() {
        
    }

    /*
     * Spins the winch to extend the rope untill we reach max hieght 
     */
    public void Lift() {
        if (!Constants.GyroStuff.kManualArm){
            if (GetPos().getAsDouble() < Constants.ClimberBoxConstants.kMaxHeight) {
                m_WhinchMotor.set(1);
            } else {
                Stop();
            }
        } else {
            m_WhinchMotor.set(1);
        }
    }

    /* 
     * Get the position of the arm movement
     */
    public DoubleSupplier GetPos() {
        return () -> m_WhinchMotor.getEncoder().getPosition();
    }

    /*
     * Spins the winch to shorten the rope untill we reach min height
     */
    public void Decend() {
        if (!Constants.GyroStuff.kManualArm){
            if (GetPos().getAsDouble() > Constants.ClimberBoxConstants.kMinHeight) {
                m_WhinchMotor.set(-1);
            } else {
                Stop();
            }
        } else {
            m_WhinchMotor.set(-1);
        }
    }

    /*
     * Zero the winch encoders
     */
    public void Zero() {
        m_WhinchMotor.getEncoder().setPosition(0);
    }

    /*
     * Stops the winch motor
     */
    public void Stop() {
        m_WhinchMotor.set(0);
    }
}