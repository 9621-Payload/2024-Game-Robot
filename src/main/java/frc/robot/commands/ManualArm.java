package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class ManualArm extends Command {

    public ManualArm(){
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute(){
        /* Change the value of manual arm  */
        Constants.GyroStuff.kManualArm = !Constants.GyroStuff.kManualArm;
        /* Output to the drive team */
        System.out.println((Constants.GyroStuff.kManualArm ? "You can move manually": "You cannot move manually"));
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}