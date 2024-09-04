package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterSpeakerShot extends Command {
    private Shooter s_Shooter;

    public ShooterSpeakerShot(Shooter shooter) {
        this.s_Shooter = shooter;
        addRequirements(shooter);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Shoot */
        s_Shooter.SpeakerShot();
    }
}
