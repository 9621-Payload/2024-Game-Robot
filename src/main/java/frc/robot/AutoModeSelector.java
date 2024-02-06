package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autos.*;

public class AutoModeSelector {
    private SendableChooser<Command> autoModeChooser = new SendableChooser<>();

    public AutoModeSelector(RobotContainer container) {
        autoModeChooser.setDefaultOption("Select...", doNothingCommand(container));

        /*
         * Add all the options
         */
        autoModeChooser.addOption("Center Drive Forward", DriveForward(container));
    }

    public SendableChooser<Command> getAutoChooser() {
        return autoModeChooser;
    }

    private SequentialCommandGroup doNothingCommand(RobotContainer container) {
        SequentialCommandGroup command = new SequentialCommandGroup();
        container.GetTank().Calibrate();
        return command;
    }

    /*
     * Allow calling the autos as a method
     */
    private SequentialCommandGroup DriveForward(RobotContainer container) {
        return new DriveForward(container);
    }

}
