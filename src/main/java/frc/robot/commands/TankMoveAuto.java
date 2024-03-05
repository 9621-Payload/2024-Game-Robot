package frc.robot.commands;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.GyroStuff;
import frc.robot.subsystems.TankDrive;

public class TankMoveAuto extends Command {
    private TankDrive m_Drive;
    private Double distancevalue;
    private ProfiledPIDController rotationControl = new ProfiledPIDController(0.7, 0, 0, GyroStuff.kAimProfile);

    public TankMoveAuto (TankDrive m_Drive, Double distancevalue) {
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.distancevalue = distancevalue;
        //rotationControl.setTolerance(1);
        //rotationControl.enableContinuousInput(0, 2 * Math.PI);
    }

    @Override
    public void initialize() {
        //rotationControl.reset(Math.toRadians(m_Drive.GetRotation().getAsDouble()), 0);
        //rotationControl.setGoal(Math.toRadians(v_rotation));
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
}
