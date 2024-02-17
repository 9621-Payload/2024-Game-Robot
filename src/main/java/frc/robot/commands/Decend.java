package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberBox;

public class Decend extends Command {
    private ClimberBox m_ClimberBox;

    public Decend(ClimberBox Decend) {
        this.m_ClimberBox = Decend;
        addRequirements(m_ClimberBox);
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Decend */
        m_ClimberBox.Decend();
    }

    @Override
    public void end(boolean i){
        m_ClimberBox.Stop();
    }
}
