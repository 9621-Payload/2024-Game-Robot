package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoContstants;
import frc.robot.commands.*;

public class SpeakerRight extends SequentialCommandGroup {
    public SpeakerRight(RobotContainer robot){
        // Slight fire and intake to drop the robots lip
        addCommands(new ShooterFeedShot(robot.GetShooter(), AutoContstants.kKnockSpeed).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 0.5)).withTimeout(AutoContstants.kFireTimeAUto));
        addCommands(new ShooterIntake(robot.GetShooter()).withTimeout(1));

        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(AutoContstants.kFireTime));
        
        // back up 15 inches
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kBackupDistance - 15).withTimeout(AutoContstants.kBackupTime));

        // turn around
        addCommands(new TankRotate(robot.GetTank(), AutoContstants.kFinalHeading).withTimeout(AutoContstants.kSpeakerSideTurnTime));
        robot.GetTank().ResetEncode();

        // move forward
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kSpeakerSideForwardDistance).withTimeout(AutoContstants.kSpeakerSideForwardTime));
    }
}
