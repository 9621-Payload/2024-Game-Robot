package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberBox;
import frc.robot.subsystems.TankDrive;

public class ZeroGyro extends Command {
    private TankDrive m_Drive;
    private ClimberBox arm;

    public ZeroGyro(TankDrive m_Drive, ClimberBox arm){
        this.m_Drive = m_Drive;
        this.arm = arm;
    }

    @Override
    public void initialize() {
        m_Drive.Calibrate();
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
