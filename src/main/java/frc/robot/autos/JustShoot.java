package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoContstants;
import frc.robot.commands.*;

public class JustShoot extends SequentialCommandGroup {
    public JustShoot(RobotContainer robot){
        // Slight fire and intake to drop the robots lip
        addCommands(new ShooterFeedShot(robot.GetShooter(), AutoContstants.kKnockSpeed).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 0.5)).withTimeout(AutoContstants.kFireTimeAUto));
        addCommands(new ShooterIntake(robot.GetShooter()).withTimeout(1));

        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(AutoContstants.kFireTime));
    }
}
