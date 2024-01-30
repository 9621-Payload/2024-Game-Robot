package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TelopTankMove extends Command {
    private TankDrive m_Drive;
    private DoubleSupplier v_leftForward;
    private DoubleSupplier v_rightForward;

    public TelopTankMove(TankDrive m_Drive, DoubleSupplier v_lForward, DoubleSupplier v_rForward){
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.v_leftForward = v_lForward;
        this.v_rightForward = v_rForward;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Drive */
        m_Drive.Move(v_leftForward.getAsDouble(), v_rightForward.getAsDouble());
    }
}
