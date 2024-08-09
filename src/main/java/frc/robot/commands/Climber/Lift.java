package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberBox;

public class Lift extends Command {
    private ClimberBox m_ClimberBox;

    public Lift(ClimberBox Lift) {
        this.m_ClimberBox = Lift;
        addRequirements(m_ClimberBox);
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Lift */
        m_ClimberBox.Lift();
    }

    @Override
    public void end(boolean i){
        m_ClimberBox.Stop();
    }
}
