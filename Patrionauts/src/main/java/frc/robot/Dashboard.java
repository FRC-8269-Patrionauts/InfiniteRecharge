package frc.robot;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Dashboard extends CommandBase {
        private final RobotContainer robotContainer;

        /**
         * Find the list of widgets here:
         * https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/shuffleboard/BuiltInWidgets.html.
         * 
         * Find the more detailed documentation of widgets here:
         * https://github.com/wpilibsuite/allwpilib/blob/master/wpilibj/src/main/java/edu/wpi/first/wpilibj/shuffleboard/BuiltInWidgets.java
         */
        public Dashboard(RobotContainer robotContainer) {
                this.robotContainer = robotContainer;
                configureCommands();
                configureDriveSubsystem();
                configureJoystick();
                configureGamepad();
                configureLimeLight();
        }

        private void configureCommands() {
                Shuffleboard.getTab("Commands")
                                .add("AutonomousCommand", (Sendable) robotContainer.getAutonomousCommand())
                                .withWidget(BuiltInWidgets.kCommand).withPosition(0, 0).withSize(2, 1);
                Shuffleboard.getTab("Commands")
                                .add("HumanDriveCommand", (Sendable) robotContainer.getHumanDriveCommand())
                                .withWidget(BuiltInWidgets.kCommand).withPosition(2, 0).withSize(2, 1);
                Shuffleboard.getTab("Commands")
                                .add("TestTurningCommand", (Sendable) robotContainer.getTestTurningCommand())
                                .withWidget(BuiltInWidgets.kCommand).withPosition(0, 1).withSize(2, 1);
                Shuffleboard.getTab("Commands")
                                .add("ColorWheelCommand", (Sendable) robotContainer.getColorWheelCommand())
                                .withWidget(BuiltInWidgets.kCommand).withPosition(2, 1).withSize(2, 1);
                Shuffleboard.getTab("Commands")
                                .add("AlignAtTarget", (Sendable) robotContainer.getAlignAtTargetCommand())
                                .withWidget(BuiltInWidgets.kCommand).withPosition(2, 1).withSize(2, 1);

        }

        private void configureDriveSubsystem() {
                Shuffleboard.getTab("DriveSubsystem")
                                .add("DifferentialDrive",
                                                (Sendable) robotContainer.getDriveSubsystem().getDifferentialDrive())
                                .withWidget(BuiltInWidgets.kDifferentialDrive).withPosition(0, 0);
                Shuffleboard.getTab("DriveSubsystem")
                                .add("Left Motor 1", robotContainer.getDriveSubsystem().getLeftMotor1Speed())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(3, 0).withSize(2, 1);
                Shuffleboard.getTab("DriveSubsystem")
                                .add("Left Motor 2", robotContainer.getDriveSubsystem().getLeftMotor2Speed())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(3, 1).withSize(2, 1);
                Shuffleboard.getTab("DriveSubsystem")
                                .add("Right Motor 1", robotContainer.getDriveSubsystem().getRightMotor1Speed())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(5, 0).withSize(2, 1);
                Shuffleboard.getTab("DriveSubsystem")
                                .add("Right Motor 2", robotContainer.getDriveSubsystem().getRightMotor2Speed())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(5, 1).withSize(2, 1);

                Shuffleboard.getTab("DriveSubsystem").addNumber("Left Motor 1 Encoder",
                                () -> robotContainer.getDriveSubsystem().getLeftMotor1Encoder().getPosition())
                                .withPosition(3, 2).withSize(2, 1);
                Shuffleboard.getTab("DriveSubsystem").addNumber("Left Motor 2 Encoder",
                                () -> robotContainer.getDriveSubsystem().getLeftMotor2Encoder().getPosition())
                                .withPosition(3, 3).withSize(2, 1);
                Shuffleboard.getTab("DriveSubsystem").addNumber("Right Motor 1 Encoder",
                                () -> robotContainer.getDriveSubsystem().getRightMotor1Encoder().getPosition())
                                .withPosition(5, 2).withSize(2, 1);
                Shuffleboard.getTab("DriveSubsystem").addNumber("Right Motor 2 Encoder",
                                () -> robotContainer.getDriveSubsystem().getRightMotor2Encoder().getPosition())
                                .withPosition(5, 3).withSize(2, 1);

                Shuffleboard.getTab("DriveSubsystem")
                                .add("TurnPIDController",
                                                (Sendable) robotContainer.getDriveSubsystem().getTurnPIDController())
                                .withWidget(BuiltInWidgets.kPIDController).withPosition(7, 0).withSize(2, 2);

                Shuffleboard.getTab("DriveSubsystem").addNumber("IMU Yaw", () -> robotContainer.getImu().getYaw())
                                .withPosition(0, 2);
                Shuffleboard.getTab("DriveSubsystem").addNumber("IMU Pitch", () -> robotContainer.getImu().getPitch())
                                .withPosition(1, 2);
                Shuffleboard.getTab("DriveSubsystem").addNumber("IMU Roll", () -> robotContainer.getImu().getRoll())
                                .withPosition(2, 2);
                Shuffleboard.getTab("DriveSubsystem")
                                .addNumber("Calculated Turn PID",
                                                () -> robotContainer.getDriveSubsystem().getCalculatedPIDValue())
                                .withPosition(7, 2).withSize(2, 1);
        }

        private void configureJoystick() {
                Shuffleboard.getTab("Joystick").addNumber("X", () -> robotContainer.getJoystick().getX())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(0, 0).withSize(2, 1);
                Shuffleboard.getTab("Joystick").addNumber("Y", () -> robotContainer.getJoystick().getY())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(2, 0).withSize(2, 1);

                Shuffleboard.getTab("Joystick").addNumber("Twist", () -> robotContainer.getJoystick().getTwist())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(0, 1).withSize(2, 1);
                Shuffleboard.getTab("Joystick").addNumber("Throttle", () -> robotContainer.getJoystick().getThrottle())
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(2, 1).withSize(2, 1);
                Shuffleboard.getTab("Joystick")
                                .addBoolean("Side Button", () -> robotContainer.getJoystick().getRawButton(2))
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(0, 2);
                Shuffleboard.getTab("Joystick")
                                .addBoolean("Button 11", () -> robotContainer.getJoystick().getRawButton(11))
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(1, 2);
        }

        private void configureGamepad() {
                Shuffleboard.getTab("Gamepad").addBoolean("A", () -> robotContainer.getGamepad().getAButton())
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(0, 0);
                Shuffleboard.getTab("Gamepad").addBoolean("B", () -> robotContainer.getGamepad().getBButton())
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(1, 0);
                Shuffleboard.getTab("Gamepad").addBoolean("X", () -> robotContainer.getGamepad().getXButton())
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(2, 0);
                Shuffleboard.getTab("Gamepad").addBoolean("Y", () -> robotContainer.getGamepad().getYButton())
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(3, 0);

                Shuffleboard.getTab("Gamepad")
                                .addBoolean("Start Button", () -> robotContainer.getGamepad().getStartButton())
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(0, 1);
                Shuffleboard.getTab("Gamepad")
                                .addBoolean("Back Button", () -> robotContainer.getGamepad().getBackButton())
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(1, 1);
                Shuffleboard.getTab("Gamepad")
                                .addBoolean("Left Bumper", () -> robotContainer.getGamepad().getBumper(Hand.kLeft))
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(2, 1);
                Shuffleboard.getTab("Gamepad")
                                .addBoolean("Right Bumper", () -> robotContainer.getGamepad().getBumper(Hand.kRight))
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(3, 1);

                Shuffleboard.getTab("Gamepad")
                                .addBoolean("Left Joystick Click",
                                                () -> robotContainer.getGamepad().getStickButton(Hand.kLeft))
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(0, 2);
                Shuffleboard.getTab("Gamepad")
                                .addBoolean("Right Joystick Click",
                                                () -> robotContainer.getGamepad().getStickButton(Hand.kRight))
                                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(1, 2);

                Shuffleboard.getTab("Gamepad")
                                .addNumber("Left Trigger Axis",
                                                () -> robotContainer.getGamepad().getTriggerAxis(Hand.kLeft))
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(0, 3).withSize(2, 1);
                Shuffleboard.getTab("Gamepad")
                                .addNumber("Right Trigger Axis",
                                                () -> robotContainer.getGamepad().getTriggerAxis(Hand.kRight))
                                .withWidget(BuiltInWidgets.kNumberBar).withPosition(2, 3).withSize(2, 1);
        }

        private void configureLimeLight() {
                Shuffleboard.getTab("LimeLight").addNumber("Area", () -> robotContainer.getDetectedTarget().getArea())
                                .withPosition(0, 0);
                Shuffleboard.getTab("LimeLight")
                                .addNumber("X Offset", () -> robotContainer.getDetectedTarget().getXOffset())
                                .withPosition(1, 0);
                Shuffleboard.getTab("LimeLight")
                                .addNumber("Y Offset", () -> robotContainer.getDetectedTarget().getYOffset())
                                .withPosition(2, 0);
        }
}
