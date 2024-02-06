package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TankMoveStraight extends Command {
    private TankDrive m_Drive;

    public TankMoveStraight(TankDrive m_Drive){
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute(){
        /* Set the drive straight */
        m_Drive.SetStraight(true);
    }

    @Override
    public void end(boolean i){
        m_Drive.SetStraight(false);
    }
}
