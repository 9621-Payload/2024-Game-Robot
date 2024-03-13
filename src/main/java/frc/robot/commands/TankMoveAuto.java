package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.GyroStuff;
import frc.robot.subsystems.TankDrive;

public class TankMoveAuto extends Command {
    private TankDrive m_Drive;
    private Double distancevalue;
    //private ProfiledPIDController rotationControl = new ProfiledPIDController(0.4, 0, 0, GyroStuff.kAimProfile);
    private final PIDController disController;

    public TankMoveAuto (TankDrive m_Drive, Double distancevalue) {
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.disController = m_Drive.disController;

        this.distancevalue = distancevalue;
    }

    @Override
    public void initialize() {
        disController.reset();
        disController.setSetpoint(m_Drive.GetEncoderDistance().getAsDouble() + distancevalue);
    }

    @Override
    public void execute() {
        /* Rotate */
        m_Drive.MoveDis(distancevalue);
    }

    @Override
    public void end(boolean a){
        m_Drive.Stop();
    }

    @Override
    public boolean isFinished() {
        return false;
        //return !(m_Drive.GetEncoderDistance().getAsDouble() <= (distancevalue - 2) || m_Drive.GetEncoderDistance().getAsDouble() >= (distancevalue + 2));
    }
}
