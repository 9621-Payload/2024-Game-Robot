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
        Constants.GyroStuff.manualArm = !Constants.GyroStuff.manualArm;
        System.out.println(String.valueOf(Constants.GyroStuff.manualArm));
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}