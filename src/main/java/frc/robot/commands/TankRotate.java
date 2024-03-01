package frc.robot.commands;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.GyroStuff;
import frc.robot.subsystems.TankDrive;

public class TankRotate extends Command {
    private TankDrive m_Drive;
    private Double v_rotation;
    private ProfiledPIDController rotationControl = new ProfiledPIDController(0.3, 0, 0, GyroStuff.kAimProfile);

    public TankRotate(TankDrive m_Drive, Double v_rotation) {
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.v_rotation = v_rotation;
        rotationControl.setTolerance(Math.PI / 360);
        rotationControl.enableContinuousInput(0, 2 * Math.PI);
    }

    @Override
    public void initialize() {
        rotationControl.reset(Math.toRadians(m_Drive.GetRotation().getAsDouble()), 0);
        rotationControl.setGoal(Math.toRadians(v_rotation));
    }

    @Override
    public void execute() {
        /* Rotate */
        m_Drive.Move(0.0, -rotationControl.calculate(Math.toRadians(m_Drive.GetRotation().getAsDouble())));
    }

    @Override
    public void end(boolean a){
        m_Drive.Stop();
    }
}
