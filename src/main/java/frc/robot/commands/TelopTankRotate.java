package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TelopTankRotate extends Command {
    private TankDrive m_Drive;
    private Double v_rotation;

    public TelopTankRotate(TankDrive m_Drive, Double v_rotation){
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.v_rotation = v_rotation;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Drive */
        m_Drive.Rotate(v_rotation);
    }

    //@Override
    //public void 
}
