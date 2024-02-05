package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
    /* Motor controllers to move the tank */
    private PWMSparkMax m_lowerMotor = new PWMSparkMax(ShooterConstants.kShootMotorLower);
    private PWMSparkMax m_upperMotor = new PWMSparkMax(ShooterConstants.kShootMotorUpper);
   
    /* Robot drive */
    private final DifferentialDrive m_Shooter;

    
    /* Creates a new Shooter */
    public Shooter() {
       m_Shooter = new DifferentialDrive(m_lowerMotor, m_upperMotor);
    }

    /*
     * Uses tank drive to move the motors to shoot high.
     */
    public void SpeakerShot1() {
        m_upperMotor.set(-1);
    }

    /*
     * Uses tank drive to move the motors to shoot high.
     */
    public void Fire() {
        m_lowerMotor.set(-1);
    }


    /*
     * Uses tank drive to move the motors to bring in the note in.
     */
    public void Intake() {
        m_Shooter.tankDrive(0.7, 0.7);
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
}
