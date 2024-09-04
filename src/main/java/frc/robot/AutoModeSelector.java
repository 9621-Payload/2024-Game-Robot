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
        autoModeChooser.addOption("Just Drive", DriveForward(container));
        autoModeChooser.addOption("Just Shoot", JustShoot(container));
        autoModeChooser.addOption("Shoot and Backup", SpeakerCenter(container));
        autoModeChooser.addOption("Shoot, Backup Short", SpeakerAmp(container));
        autoModeChooser.addOption("Shoot, Backup Far", SpeakerSource(container));

        // Get the direction for turning
        //double v = container.AllianceColor() == "Blue" ? -1 : 1;
        //autoModeChooser.addOption("Untested - Mid Destory", MidDestory(container, v));
    }

    public SendableChooser<Command> getAutoChooser() {
        return autoModeChooser;
    }

    private SequentialCommandGroup doNothingCommand(RobotContainer container) {
        SequentialCommandGroup command = new SequentialCommandGroup();
        //container.GetTank().Calibrate();
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
    private SequentialCommandGroup SpeakerSource(RobotContainer container) {
        return new SpeakerSource(container);
    }
    private SequentialCommandGroup SpeakerAmp(RobotContainer container) {
        return new SpeakerAmp(container);
    }
    //private SequentialCommandGroup MidDestory(RobotContainer container, double v) {
    //    return new MidDestory(container, v);
    //}
}
