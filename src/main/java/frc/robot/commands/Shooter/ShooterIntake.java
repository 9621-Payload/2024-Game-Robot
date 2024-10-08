package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterIntake extends Command {
    private Shooter s_Shooter;

    public ShooterIntake(Shooter shooter) {
        this.s_Shooter = shooter;
        addRequirements(shooter);
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Intake */
        s_Shooter.Intake();
    }

    @Override
    public void end(boolean i){
        s_Shooter.stop();
    }
}
