package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberBox;

public class ArmAutoReset extends Command {
    private ClimberBox m_ClimberBox;

    public ArmAutoReset(ClimberBox arm) {
        this.m_ClimberBox = arm;
        addRequirements(m_ClimberBox);
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Decend */
        if (m_ClimberBox.GetPos().getAsDouble() > 5){
        m_ClimberBox.Decend();
        } else if (m_ClimberBox.GetPos().getAsDouble() < 0) {
            m_ClimberBox.Lift();
        }
    }

    @Override
    public void end(boolean i){
        m_ClimberBox.Stop();
    }
}
