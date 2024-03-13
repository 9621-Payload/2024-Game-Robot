package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TankMove extends Command {
    private TankDrive m_Drive;
    private DoubleSupplier v_leftForward;
    private DoubleSupplier v_rightForward;

    public TankMove(TankDrive m_Drive, DoubleSupplier v_lForward, DoubleSupplier v_rForward) {
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);
        
        this.v_leftForward = v_lForward;
        this.v_rightForward = v_rForward;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        
        //DoubleSupplier left = () -> (Math.abs(v_leftForward.getAsDouble()) < 0.06) ? 0.0 : Math.signum(v_leftForward.getAsDouble()) * (Math.abs(v_leftForward.getAsDouble()) - 0.06)/(1-0.06);
        //DoubleSupplier right = () -> (Math.abs(v_rightForward.getAsDouble()) < 0.06) ? 0.0 : Math.signum(v_rightForward.getAsDouble()) * (Math.abs(v_rightForward.getAsDouble()) - 0.06)/(1-0.06);
        //System.out.println("real: " + right.getAsDouble() + " " + left.getAsDouble() + "  fake: " + v_rightForward.getAsDouble() + " " + v_leftForward.getAsDouble());
        /* Drive */

        double leftY = MathUtil.applyDeadband(v_leftForward.getAsDouble(), 0.01);
        double rightX = MathUtil.applyDeadband(v_rightForward.getAsDouble(), 0.01);

        m_Drive.Move(leftY, rightX);
        
    }

    @Override
    public void end(boolean i) {
        m_Drive.Stop();
    }
}
