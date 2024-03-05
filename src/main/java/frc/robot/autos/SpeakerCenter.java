package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

public class SpeakerCenter extends SequentialCommandGroup {
    public SpeakerCenter(RobotContainer robot){
        robot.GetTank().ResetEncode();

        // jerk forward
        addCommands(new TankMoveAuto(robot.GetTank(), -10.0).withTimeout(0.5));
        addCommands(new TankMoveAuto(robot.GetTank(), 10.0).withTimeout(0.5));

        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(1).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(2));

        // back up 10 inches
        addCommands(new TankMoveAuto(robot.GetTank(), -10.0).withTimeout(1));

        // turn around
        addCommands(new TankRotate(robot.GetTank(), 0.0).withTimeout(6.5));
        robot.GetTank().ResetEncode();

        // move forward
        addCommands(new TankMoveAuto(robot.GetTank(), 45.0).withTimeout(3.5));
    }
}
