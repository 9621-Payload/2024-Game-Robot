package frc.robot.commands.DriveTrain;

import edu.wpi.first.math.controller.PIDController;
//import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.Command;
//import frc.robot.Constants.GyroStuff;
import frc.robot.subsystems.TankDrive;

public class TankRotate extends Command {
    private TankDrive m_Drive;
    private Double v_rotation;
    private PIDController rotationController = new PIDController(0.04, 0, 0.005);

    public TankRotate(TankDrive m_Drive, Double v_rotation) {
        this.m_Drive = m_Drive;
        addRequirements(m_Drive);

        this.v_rotation = v_rotation;
        // rotationController.setTolerance(Math.PI / 360);
        // rotationController.enableContinuousInput(-180, Math.PI);
    }

    @Override
    public void initialize() {
        rotationController.reset();
        rotationController.setSetpoint(v_rotation);
        //rotationController
    }

    @Override
    public void execute() {
        /* Rotate */
        m_Drive.Move(0.0, rotationController.calculate(m_Drive.GetRotation().getAsDouble()));
    }

    @Override
    public void end(boolean a){
        m_Drive.Stop();
    }

    /*
    @Override
    public boolean isFinished(){
        return true;
    }*/
}
