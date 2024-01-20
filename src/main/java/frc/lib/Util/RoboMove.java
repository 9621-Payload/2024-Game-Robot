package frc.lib.Util;

import edu.wpi.first.wpilibj.drive.*;

public class RoboMove {
    private static DifferentialDrive _robot;
    public static void setRobot(DifferentialDrive robo){
        _robot = robo;
    }

    public void forward(){

    }

    public void backward(){

    }

    public void rotation(){

    }

    public static void move(double leftSpeed, double rightSpeed){
        _robot.tankDrive(leftSpeed, rightSpeed);
    }

}
