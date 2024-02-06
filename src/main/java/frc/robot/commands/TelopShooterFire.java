package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class TelopShooterFire extends Command {
    private Shooter s_Shooter;
    private Double speed;

    public TelopShooterFire(Shooter shooter, Double speed) {
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
        s_Shooter.Fire(speed);
    }

    @Override
    public void end(boolean i ){
        s_Shooter.stop();
    }

}
