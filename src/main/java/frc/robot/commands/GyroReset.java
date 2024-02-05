package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class GyroReset extends Command {
    private TankDrive m_Drive;

    public GyroReset(TankDrive m_Drive){
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Drive */
        m_Drive.Calibrate();;
    }

    //@Override
    //public void 
}
