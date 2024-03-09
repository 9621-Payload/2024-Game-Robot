package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoContstants;
import frc.robot.commands.*;

public class SpeakerCenter extends SequentialCommandGroup {
    public SpeakerCenter(RobotContainer robot){
        robot.GetTank().ResetEncode();

        // jerk forward
        addCommands(new TankMoveAuto(robot.GetTank(), -AutoContstants.kJitterDistance).withTimeout(AutoContstants.kJitterTime));
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kJitterDistance).withTimeout(AutoContstants.kJitterTime));

        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(AutoContstants.kFireTime));

        // back up 10 inches
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kBackupDistance).withTimeout(AutoContstants.kBackupTime));

        // turn around
        addCommands(new TankRotate(robot.GetTank(), AutoContstants.kFinalHeading - 20).withTimeout(AutoContstants.kSpeakerFrontTurnTime));
        robot.GetTank().ResetEncode();

        // move forward
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kSpeakerFrontForwardDistance).withTimeout(AutoContstants.kSpeakerFrontForwardTime));
    }
}
