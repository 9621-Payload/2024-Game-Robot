package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

public class DriveForward extends SequentialCommandGroup {
    public DriveForward(RobotContainer robot){
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(1));

        addCommands(new ShooterFire(robot.GetShooter(), 1.0).withTimeout(0.5));

        addCommands(new TankMove(robot.GetTank(), -1.0, -1.0).withTimeout(3));
    }
}
