package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterFire extends Command {
    private Shooter s_Shooter;
    private Double speed;

    public ShooterFire(Shooter shooter, Double speed) {
        this.s_Shooter = shooter;
        addRequirements(shooter);
        
        this.speed = speed;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Fire */
        s_Shooter.Fire(speed);
    }

    @Override
    public void end(boolean i ){
        s_Shooter.stop();
    }

}
