package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants.AutoContstants;
import frc.robot.commands.*;

public class DriveForward extends SequentialCommandGroup {
    public DriveForward(RobotContainer robot){
        // Move forward 52 inches
        addCommands(new TankMoveAuto(robot.GetTank(), AutoContstants.kOnlyForwardDistance).withTimeout(6.5));
    }
}
