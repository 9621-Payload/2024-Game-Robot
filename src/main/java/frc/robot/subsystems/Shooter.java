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
     * Uses tank drive to move the motors to shoot high.
     */
    public void SpeakerShot() {
        m_upperMotor.set(-1);
    }

    /*
     * Uses tank drive to move the motors to shoot high.
     */
    public void Fire(Double speed) {
        m_lowerMotor.set(-speed);
    }


    /*
     * Uses tank drive to move the motors to bring in the note in.
     */
    public void Intake() {
        m_lowerMotor.set(0.7);
        m_upperMotor.set(0.7);
    }

    /*
     * Moves motors at seperate speeds to drop the note into the amp.
     */
    public void AmpShot() {
        m_upperMotor.set(-0.185);
    }

    public void farShot() {
        m_upperMotor.set(-.85);
    }

    public void stop(){
        m_upperMotor.set(0);
        m_lowerMotor.set(0);
    }
}
