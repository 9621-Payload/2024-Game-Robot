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
     * Uses tank drive to move the motors to shoot high.
     */
    public void Lift() {
        if (!Constants.GyroStuff.manualArm){
            if (GetPos().getAsDouble() < Constants.ClimberBoxConstants.kArmMax) {
                m_WhinchMotor.set(1);
            } else {
                Stop();
            }
        } else {
            m_WhinchMotor.set(1);
            //Stop();
        }
    }

    public DoubleSupplier GetPos() {
        return () -> m_WhinchMotor.getEncoder().getPosition();
    }

    public void Decend() {
        if (!Constants.GyroStuff.manualArm){
            if (GetPos().getAsDouble() > 5) {
                m_WhinchMotor.set(-1);
            } else {
                Stop();
            }
        } else {
            m_WhinchMotor.set(-1);
            //Stop();
        }
    }

    public void Zero() {
        m_WhinchMotor.getEncoder().setPosition(0);
    }

    public void Stop() {
        m_WhinchMotor.set(0);
    }
}