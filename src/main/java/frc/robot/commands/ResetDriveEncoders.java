package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberBox;
import frc.robot.subsystems.TankDrive;

public class ResetDriveEncoders extends Command {
    private TankDrive m_Drive;
    private ClimberBox arm;

    public ResetDriveEncoders(TankDrive m_Drive, ClimberBox arm){
        this.m_Drive = m_Drive;
        this.arm = arm;
    }

    @Override
    public void initialize() {
        m_Drive.ResetEncode();
        arm.Zero();

    }

    @Override
    public void execute(){
        /* Calibrate the gyro */
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
