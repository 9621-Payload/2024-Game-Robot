package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveTrain.*;

public class MidDestory extends SequentialCommandGroup {
    public MidDestory(RobotContainer robot, double blue){
        robot.GetTank().ResetEncode();
        // Move forward 76 inches
        addCommands(new TankMoveAuto(robot.GetTank(), blue * 250).withTimeout(6.5));

        // Turn to wipeout the notes
        addCommands(new TankRotate(robot.GetTank(), -90.0).withTimeout(2));

        // WIPEOUTT
        addCommands(new TankMoveAuto(robot.GetTank(), 120.0).withTimeout(5));
    }
}
