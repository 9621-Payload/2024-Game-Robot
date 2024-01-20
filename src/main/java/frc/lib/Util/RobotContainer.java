package frc.lib.Util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    /* Controllers */

    private final Joystick driver = new Joystick(0);
    private final Joystick operator = new Joystick(1);

    /* Controller Triggers */
    private final Trigger driverLeftTriggerDepressed = new Trigger(
            () -> driver.getRawAxis(XboxController.Axis.kLeftTrigger.value) > 0.1);
    private final Trigger driverRightTriggerDepressed = new Trigger(
            () -> driver.getRawAxis(XboxController.Axis.kRightTrigger.value) > 0.1);


    /* Robot Systems */
    private DifferentialDrive _robot;
    private final Talon m_leftMotor = new Talon(4);
    private final Talon m_rightMotor = new Talon(5);

    public RobotContainer() {
        _robot = new DifferentialDrive(m_leftMotor, m_rightMotor);

        ButtonKeyBindings();
    }

    private void ButtonKeyBindings() {
        driverLeftTriggerDepressed.onTrue();
        driverRightTriggerDepressed.onTrue();
    }
}