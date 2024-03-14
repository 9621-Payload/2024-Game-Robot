package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
    /* Motor controllers to move the tank */
    private PWMSparkMax m_lowerMotor = new PWMSparkMax(ShooterConstants.kShootMotorLower);
    private PWMSparkMax m_upperMotor = new PWMSparkMax(ShooterConstants.kShootMotorUpper);
   
    
    /* Creates a new Shooter */
    public Shooter() {
    }

    /*
     * Spins the top motoro full speed for speaker shot
     */
    public void SpeakerShot() {
        m_upperMotor.set(-1);
    }

    /*
     * Spins the bottom motor to launch the note
     */
    public void Fire(Double speed) {
        m_lowerMotor.set(-speed);
    }


    /*
     * Spins both motors reverse to intake the note
     */
    public void Intake() {
        m_lowerMotor.set(0.7);
        m_upperMotor.set(0.7);
    }

    /*
     * Spins the top motor enouch to drop the note
     */
    public void AmpShot(double speed) {
        m_upperMotor.set(-speed);
    }

    /* Moksh did this, idk but is the same as SpeakerShot */
    public void farShot() {
        m_upperMotor.set(-1.0);
    }

    /* Stop the motors for the shooter */
    public void stop(){
        m_upperMotor.set(0);
        m_lowerMotor.set(0);
    }
}
