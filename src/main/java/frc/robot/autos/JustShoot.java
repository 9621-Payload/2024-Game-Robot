package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoContstants;
import frc.robot.commands.*;

public class JustShoot extends SequentialCommandGroup {
    public JustShoot(RobotContainer robot){
        robot.GetTank().ResetEncode();

        // // jerk forward
        // addCommands(new TankMoveAuto(robot.GetTank(), -AutoContstants.kJitterDistance).withTimeout(AutoContstants.kJitterTime));
        // addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kJitterDistance).withTimeout(AutoContstants.kJitterTime));

        addCommands(new ShooterAmpShot(robot.GetShooter(), 0.17).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 0.5)).withTimeout(2.5));
        addCommands(new ShooterIntake(robot.GetShooter()).withTimeout(1));

        // Shoot high
        addCommands(new ShooterSpeakerShot(robot.GetShooter()).withTimeout(AutoContstants.kPrepareTime).andThen(new ShooterFire(robot.GetShooter(), 1.0)).withTimeout(AutoContstants.kFireTime));
    }
}
