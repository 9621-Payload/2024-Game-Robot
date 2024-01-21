package frc.lib.Util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.lib.Config.Constants;

public class RobotContainer {
    /* Controllers */
    private final XboxController driver = new XboxController(0);
    private final XboxController operator = new XboxController(1);

    /* Controller Triggers */
    private final Trigger driverLeftTriggerDepressed = new Trigger(
            () -> driver.getRawAxis(XboxController.Axis.kLeftTrigger.value) > 0.1);
    private final Trigger driverRightTriggerDepressed = new Trigger(
            () -> driver.getRawAxis(XboxController.Axis.kRightTrigger.value) > 0.1);


    /* Robot Systems */
    private DifferentialDrive _robot;
    private final Talon m_leftDrive = new Talon(Constants.LeftMotorPin);
    private final Talon m_rightDrive = new Talon(Constants.RightMotorPin);
    private final Talon m_shooter = new Talon(Constants.ShooterPin);



    public RobotContainer() {
        // Robot systems
        _robot = new DifferentialDrive(m_leftDrive, m_rightDrive);

        // Shuffleboard
        ShuffleboardTab homeTab = Shuffleboard.getTab("Home");

        ButtonKeyBindings();
    }

    public void Move(){
        _robot.tankDrive(driver.getLeftY(), driver.getRightY());
    }

    private void ButtonKeyBindings() {
        //driverLeftTriggerDepressed.onTrue();
        //driverRightTriggerDepressed.onTrue();
    }
}