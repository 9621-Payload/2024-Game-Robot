package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoContstants;
import frc.robot.commands.*;

public class SpeakerLeft extends SequentialCommandGroup {
    public SpeakerLeft(RobotContainer robot){
        // jerk forward
        addCommands(new TankMoveAuto(robot.GetTank(), -AutoContstants.kJitterDistance - 2).withTimeout(AutoContstants.kJitterTime - 1));
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kJitterDistance + 2).withTimeout(AutoContstants.kJitterTime + 1));

        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(AutoContstants.kFireTime));

        // back up 10 inches
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kBackupDistance).withTimeout(AutoContstants.kBackupTime));

        // turn around
        addCommands(new TankRotate(robot.GetTank(), AutoContstants.kFinalHeading).withTimeout(AutoContstants.kSpeakerSideTurnTime));
        robot.GetTank().ResetEncode();

        // move forward
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kSpeakerSideForwardDistance).withTimeout(AutoContstants.kSpeakerSideForwardTime));
    }
}
