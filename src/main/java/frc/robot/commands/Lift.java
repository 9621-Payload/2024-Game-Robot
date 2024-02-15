package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberBox;

public class Lift extends Command {
    private ClimberBox s_Lift;

    public Lift(ClimberBox Lift) {
        this.s_Lift = Lift;
        addRequirements(s_Lift);
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Lift */
        s_Lift.Lift();
    }

    @Override
    public void end(boolean i){
        s_Lift.Stop();
    }
}
