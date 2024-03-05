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
        autoModeChooser.addOption("Drive Forward", DriveForward(container));
        autoModeChooser.addOption("Speaker Center", SpeakerCenter(container));
        autoModeChooser.addOption("Speaker Left", SpeakerLeft(container));
        autoModeChooser.addOption("Speaker Right", SpeakerRight(container));
        autoModeChooser.addOption("Just Shoot", JustShoot(container));
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
    private SequentialCommandGroup JustShoot(RobotContainer container) {
        return new JustShoot(container);
    }
    private SequentialCommandGroup SpeakerCenter(RobotContainer container) {
        return new SpeakerCenter(container);
    }
    private SequentialCommandGroup SpeakerRight(RobotContainer container) {
        return new SpeakerRight(container);
    }
    private SequentialCommandGroup SpeakerLeft(RobotContainer container) {
        return new SpeakerLeft(container);
    }

}
