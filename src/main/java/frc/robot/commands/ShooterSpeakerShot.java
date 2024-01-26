package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterHighShot extends Command {
    private Shooter s_Shooter;

    public ShooterHighShot(Shooter shooter) {
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
