package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CameraSubsystem;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardCommand extends CommandBase {

    private RobotContainer robotContainer;
    private CameraSubsystem cameraSubsystem;

    public SmartDashboardCommand(RobotContainer robotContainer, CameraSubsystem cameraSubsystem) {
        this.robotContainer = robotContainer;
        this.cameraSubsystem = cameraSubsystem;
    }

    public void addDrive() {
        SmartDashboard.putNumber("Drive | Left Motor 1: ", robotContainer.getDriveSubsystem().getLeftMotor1Speed());
        SmartDashboard.putNumber("Drive | Left Motor 2: ", robotContainer.getDriveSubsystem().getLeftMotor2Speed());
        SmartDashboard.putNumber("Drive | Right Motor 1: ", robotContainer.getDriveSubsystem().getRightMotor1Speed());
        SmartDashboard.putNumber("Drive | Right Motor 2: ", robotContainer.getDriveSubsystem().getRightMotor2Speed());
        //SmartDashboard.putNumber("Drive | speedMult", robotContainer.getDriveSubsystem().getMaxSpeed());
        //SmartDashboard.putNumber("Drive | Gyro Angle", Math.abs(robotContainer.getGyro().getAngle()));
    }

    public void addIMU() {
        SmartDashboard.putNumber("IMU | Yaw", robotContainer.getAHRS().getYaw());
        SmartDashboard.putNumber("IMU | Roll", robotContainer.getAHRS().getRoll());
        SmartDashboard.putNumber("IMU | Pitch", robotContainer.getAHRS().getPitch());
    }

    public void addJoystick() {
        SmartDashboard.putNumber("Joystick | X", robotContainer.getJoystick().getX());
        SmartDashboard.putNumber("Joystick | Y", robotContainer.getJoystick().getY());
        SmartDashboard.putNumber("Joystick | Twist", robotContainer.getJoystick().getTwist());
        SmartDashboard.putNumber("Joystick | Fin", robotContainer.getJoystick().getThrottle());
        SmartDashboard.putBoolean("Joystick | Side Button", robotContainer.getJoystick().getRawButton(2));
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

    public void addCamera(){
        cameraSubsystem.startAutomaticCapture();
    }

}