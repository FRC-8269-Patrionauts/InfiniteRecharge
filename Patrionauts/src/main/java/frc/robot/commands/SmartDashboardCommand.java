package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardCommand extends CommandBase {

    private RobotContainer robotContainer;

    public SmartDashboardCommand(RobotContainer robotContainer) {
        this.robotContainer = robotContainer;
    }

    public void addDrive() {
        SmartDashboard.putNumber("Drive | Left Motor 1: ", robotContainer.getDriveSubsystem().getLeftMotor1Speed());
        SmartDashboard.putNumber("Drive | Left Motor 2: ", robotContainer.getDriveSubsystem().getLeftMotor2Speed());
        SmartDashboard.putNumber("Drive | Right Motor 1: ", robotContainer.getDriveSubsystem().getRightMotor1Speed());
        SmartDashboard.putNumber("Drive | Right Motor 2: ", robotContainer.getDriveSubsystem().getRightMotor2Speed());
    }

    public void addJoystick() {
        SmartDashboard.putNumber("Joystick | X", robotContainer.getJoystick().getX());
        SmartDashboard.putNumber("Joystick | Y", robotContainer.getJoystick().getY());
        SmartDashboard.putNumber("Joystick | Twist", robotContainer.getJoystick().getTwist());
    }

    public void addGamepad() {
        SmartDashboard.putBoolean("Gamepad | X",
        robotContainer.getGamepad().getXButton());
        SmartDashboard.putBoolean("Gamepad | A",
        robotContainer.getGamepad().getAButton());
        SmartDashboard.putBoolean("Gamepad | B",
        robotContainer.getGamepad().getBButton());
        SmartDashboard.putBoolean("Gamepad | Y",
        robotContainer.getGamepad().getYButton());
        SmartDashboard.putBoolean("Gamepad | Left Bumper",
        robotContainer.getGamepad().getBumper(Hand.kLeft));
        SmartDashboard.putBoolean("Gamepad | Right Bumper",
        robotContainer.getGamepad().getBumper(Hand.kRight));
        SmartDashboard.putNumber("Gamepad | Left Trigger",
        robotContainer.getGamepad().getTriggerAxis(Hand.kLeft));
        SmartDashboard.putNumber("Gamepad | Right Trigger",
        robotContainer.getGamepad().getTriggerAxis(Hand.kRight));
        SmartDashboard.putBoolean("Gamepad | Back Button",
        robotContainer.getGamepad().getBackButton());
        SmartDashboard.putBoolean("Gamepad | Start Button", 
        robotContainer.getGamepad().getStartButton());
        SmartDashboard.putBoolean("Gamepad | Left Joystick Click", 
        robotContainer.getGamepad().getStickButton(Hand.kLeft));
        SmartDashboard.putBoolean("Gamepad | Right Joystick Click",
        robotContainer.getGamepad().getStickButton(Hand.kRight));
    }

}