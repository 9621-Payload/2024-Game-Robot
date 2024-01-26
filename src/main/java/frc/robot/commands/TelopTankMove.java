package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TelopTankMove extends Command {
    private TankDrive m_Drive;
    private DoubleSupplier v_forward;
    private DoubleSupplier v_rotation;

    public TelopTankMove(TankDrive m_Drive, DoubleSupplier v_forward, DoubleSupplier v_rotation){
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.v_forward = v_forward;
        this.v_rotation = v_rotation;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Drive */
        m_Drive.Move(v_forward, v_rotation);
    }
}
