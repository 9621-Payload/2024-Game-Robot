package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

public class DriveForward extends SequentialCommandGroup {
    public DriveForward(RobotContainer robot){
        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(1).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(2));

        // turn around
        addCommands(new TankRotate(robot.GetTank(), 180.0));

        //addCommands(new TankMove(robot.GetTank(), -0.5, -0.5).withTimeout(4));
    }
}
