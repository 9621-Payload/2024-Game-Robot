package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.kauailabs.navx.AHRSProtocol.AHRS_DATA_ACTION;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TelopTankMoveStraight extends Command {
    private TankDrive m_Drive;

    public TelopTankMoveStraight(TankDrive m_Drive){
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute(){
        /* Drive */
        m_Drive.SetStraight(true);
    }

    @Override
    public void end(boolean i){
        m_Drive.SetStraight(false);
    }
}
