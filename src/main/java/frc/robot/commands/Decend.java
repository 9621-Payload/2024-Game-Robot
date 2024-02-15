package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberBox;

public class Decend extends Command {
    private ClimberBox s_Decend;

    public Decend(ClimberBox Decend) {
        this.s_Decend = Decend;
        addRequirements(s_Decend);
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Decend */
        s_Decend.Decend();
    }

    @Override
    public void end(boolean i){
        s_Decend.Stop();
    }
}
