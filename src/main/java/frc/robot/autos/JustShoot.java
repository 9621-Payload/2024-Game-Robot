package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

public class JustShoot extends SequentialCommandGroup {
    public JustShoot(RobotContainer robot){
        robot.GetTank().ResetEncode();

        // jerk forward
        addCommands(new TankMoveAuto(robot.GetTank(), -10.0).withTimeout(0.5));
        addCommands(new TankMoveAuto(robot.GetTank(), 10.0).withTimeout(0.5));

        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(1).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(2));
    }
}
