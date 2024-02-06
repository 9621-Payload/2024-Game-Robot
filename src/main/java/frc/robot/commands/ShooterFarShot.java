package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterFarShot extends Command {
    private Shooter s_Shooter;

    public ShooterFarShot(Shooter shooter) {
        this.s_Shooter = shooter;
        addRequirements(shooter);
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Far Shot */
        s_Shooter.farShot();
    }
}
