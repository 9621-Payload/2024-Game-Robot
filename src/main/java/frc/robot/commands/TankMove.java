package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TankMove extends Command {
    private TankDrive m_Drive;
    private DoubleSupplier v_leftForward;
    private DoubleSupplier v_rightForward;
    private Double auto_left;
    private Double auto_right;
    private boolean controlled = false;

    public TankMove(TankDrive m_Drive, DoubleSupplier v_lForward, DoubleSupplier v_rForward) {
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.v_leftForward = v_lForward;
        this.v_rightForward = v_rForward;
        this.controlled = true;
    }

    public TankMove(TankDrive m_Drive, Double left, Double right) {
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.auto_left = left;
        this.auto_right = right;
        this.controlled = false;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        /* Drive */
        if (controlled) {
            m_Drive.Move(v_leftForward.getAsDouble(), v_rightForward.getAsDouble());
        } else {
            m_Drive.Move(auto_right, auto_left);
        }
    }
}
