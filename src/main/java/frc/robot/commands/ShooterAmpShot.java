package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterAmpShot extends Command {
    private Shooter s_Shooter;
    private double speed;

    public ShooterAmpShot(Shooter shooter) {
        this.s_Shooter = shooter;
        addRequirements(shooter);

        this.speed = 0.25;
        
    }
    public ShooterAmpShot(Shooter shooter, double speed) {
        this.s_Shooter = shooter;
        addRequirements(shooter);
        
        this.speed = speed;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Shoot */
        s_Shooter.AmpShot(speed);
    }
}
