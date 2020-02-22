package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

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
        if (Constants.ENABLE_DRIVE_SUBSYSTEM) {
            configureDriveSubsystem();
        }
        if (Constants.ENABLE_SHOOT_SUBSYSTEM) {
            configureShootSubsystem();
        }
        if (Constants.ENABLE_JOYSTICK) {
            configureJoystick();
        }
        if (Constants.ENABLE_GAMEPAD) {
            configureGamepad();
        }
        if (Constants.ENABLE_LIMELIGHT) {
            configureLimeLight();
        }
        configurePneumatics();
        configureBelt();
    }

    private void configureCommands() {
        Shuffleboard.getTab("Commands").add("Autonomous", (Sendable) robotContainer.getAutonomousCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(0, 0).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("HumanDrive", (Sendable) robotContainer.getHumanDriveCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(2, 0).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("ColorWheel", (Sendable) robotContainer.getColorWheelCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(4, 0).withSize(2, 1);     
        Shuffleboard.getTab("TestCommands").add("TestTurning", (Sendable) robotContainer.getTestTurningCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(0, 1).withSize(2, 1);
        Shuffleboard.getTab("TestCommands").add("TestShoot", (Sendable) robotContainer.getTestShootCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(2, 1).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("AlignAtTarge", (Sendable) robotContainer.getAlignAtTargetCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(4, 1).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("OpenLoader", (Sendable) robotContainer.getOpenLoaderCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(0, 2).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("CloseLoader", (Sendable) robotContainer.getCloseLoaderCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(2, 2).withSize(2, 1);

        Shuffleboard.getTab("Commands").add("LowerIntake", (Sendable) robotContainer.getLowerIntakeCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(4, 2).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("RaiseIntake", (Sendable) robotContainer.getRaiseIntakeCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(0, 3).withSize(2, 1);

        

        Shuffleboard.getTab("DriveSubsystem").add("TestMoveFeet", (Sendable) robotContainer.getTestMoveFeetCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(0, 3).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("RollerIntake", (Sendable) robotContainer.getIntakeCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(6, 0).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("RollerOutake", (Sendable) robotContainer.getOutakeCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(6, 1).withSize(2, 1);
        Shuffleboard.getTab("Commands").add("BeltFeed", (Sendable) robotContainer.getBeltFeedCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(6, 2).withSize(2, 1);
        Shuffleboard.getTab("TestCommands").add("TestColorWheelSpinner", (Sendable) robotContainer.getTestSpinColorWheelCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(6, 2).withSize(2, 1);

    }

    private void configureDriveSubsystem() {
        Shuffleboard.getTab("DriveSubsystem")
                .add("DifferentialDrive", (Sendable) robotContainer.getDriveSubsystem().getDifferentialDrive())
                .withWidget(BuiltInWidgets.kDifferentialDrive).withPosition(0, 0);

        // Motor speed
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("Left Motor 1", () -> robotContainer.getDriveSubsystem().getLeftMotor1().get())
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(3, 0).withSize(1, 1);
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("Left Motor 2", () -> robotContainer.getDriveSubsystem().getLeftMotor2().get())
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(3, 1).withSize(1, 1);
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("Right Motor 1", () -> robotContainer.getDriveSubsystem().getRightMotor1().get())
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(4, 0).withSize(1, 1);
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("Right Motor 2", () -> robotContainer.getDriveSubsystem().getRightMotor2().get())
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(4, 1).withSize(1, 1);

        // encoder positions
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("LM1 Enc",
                        () -> robotContainer.getDriveSubsystem().getLeftMotor1Encoder().getPosition())
                .withPosition(5, 0).withSize(1, 1);
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("LM2 Enc",
                        () -> robotContainer.getDriveSubsystem().getLeftMotor2Encoder().getPosition())
                .withPosition(5, 1).withSize(1, 1);
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("RM1 Enc",
                        () -> robotContainer.getDriveSubsystem().getRightMotor1Encoder().getPosition())
                .withPosition(6, 0).withSize(1, 1);
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("RM2 Enc",
                        () -> robotContainer.getDriveSubsystem().getRightMotor2Encoder().getPosition())
                .withPosition(6, 1).withSize(1, 1);

        // PID
        Shuffleboard.getTab("DriveSubsystem")
                .add("TurnPIDController", (Sendable) robotContainer.getDriveSubsystem().getTurnPIDController())
                .withWidget(BuiltInWidgets.kPIDController).withPosition(7, 0).withSize(2, 2);

        Shuffleboard.getTab("DriveSubsystem").addNumber("IMU Yaw", () -> robotContainer.getImu().getYaw())
                .withPosition(0, 2);
        Shuffleboard.getTab("DriveSubsystem").addNumber("IMU Pitch", () -> robotContainer.getImu().getPitch())
                .withPosition(1, 2);
        Shuffleboard.getTab("DriveSubsystem").addNumber("IMU Roll", () -> robotContainer.getImu().getRoll())
                .withPosition(2, 2);

        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("Calculated Turn PID", () -> robotContainer.getDriveSubsystem().getCalculatedTurnPIDValue())
                .withPosition(3, 2).withSize(1, 1);
        Shuffleboard.getTab("DriveSubsystem")
                .add("MovePIDController", (Sendable) robotContainer.getDriveSubsystem().getMovePIDController())
                .withWidget(BuiltInWidgets.kPIDController).withPosition(7, 2).withSize(2, 2);
        Shuffleboard.getTab("DriveSubsystem")
                .addNumber("Calculated Move PID", () -> robotContainer.getDriveSubsystem().getCalculatedMovePIDValue())
                .withPosition(5, 2).withSize(1, 1);
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
        Shuffleboard.getTab("Joystick").addBoolean("Side Button", () -> robotContainer.getJoystick().getRawButton(2))
                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(0, 2);
        Shuffleboard.getTab("Joystick").addBoolean("Button 11", () -> robotContainer.getJoystick().getRawButton(11))
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

        Shuffleboard.getTab("Gamepad").addBoolean("Start Button", () -> robotContainer.getGamepad().getStartButton())
                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(0, 1);
        Shuffleboard.getTab("Gamepad").addBoolean("Back Button", () -> robotContainer.getGamepad().getBackButton())
                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(1, 1);
        Shuffleboard.getTab("Gamepad")
                .addBoolean("Left Bumper", () -> robotContainer.getGamepad().getBumper(Hand.kLeft))
                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(2, 1);
        Shuffleboard.getTab("Gamepad")
                .addBoolean("Right Bumper", () -> robotContainer.getGamepad().getBumper(Hand.kRight))
                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(3, 1);

        Shuffleboard.getTab("Gamepad")
                .addBoolean("Left Joystick Click", () -> robotContainer.getGamepad().getStickButton(Hand.kLeft))
                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(0, 2);
        Shuffleboard.getTab("Gamepad")
                .addBoolean("Right Joystick Click", () -> robotContainer.getGamepad().getStickButton(Hand.kRight))
                .withWidget(BuiltInWidgets.kBooleanBox).withPosition(1, 2);

        Shuffleboard.getTab("Gamepad")
                .addNumber("Left Trigger Axis", () -> robotContainer.getGamepad().getTriggerAxis(Hand.kLeft))
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(0, 3).withSize(2, 1);
        Shuffleboard.getTab("Gamepad")
                .addNumber("Right Trigger Axis", () -> robotContainer.getGamepad().getTriggerAxis(Hand.kRight))
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(2, 3).withSize(2, 1);
    }

    private void configureLimeLight() {
        Shuffleboard.getTab("LimeLight")
                .addNumber("Area",
                        () -> robotContainer.getCameraSubsystem().hasDetectedTarget()
                                ? robotContainer.getCameraSubsystem().getDetectedTarget().getArea()
                                : 0)
                .withPosition(0, 0);
        Shuffleboard.getTab("LimeLight")
                .addNumber("X Offset",
                        () -> robotContainer.getCameraSubsystem().hasDetectedTarget()
                                ? robotContainer.getCameraSubsystem().getDetectedTarget().getXOffset()
                                : 0)
                .withPosition(1, 0);
        Shuffleboard.getTab("LimeLight")
                .addNumber("Y Offset",
                        () -> robotContainer.getCameraSubsystem().hasDetectedTarget()
                                ? robotContainer.getCameraSubsystem().getDetectedTarget().getYOffset()
                                : 0)
                .withPosition(2, 0);
    }

    public void configurePneumatics() {
        // Shuffleboard.getTab("Commands").addBoolean("PneumaticsActive", () ->
        // robotContainer.getPneumaticSubsystem().getSolenoid().get())
        // .withPosition(6, 2);
        // Shuffleboard.getTab("Commands")
        // .addBoolean("PneumaticsVar",
        // () -> robotContainer.getPneumaticSubsystem().getVar())
        // .withPosition(6, 4);
    }

    public void configureShootSubsystem() {
        //display calculated values
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("Flywheel1 Calculated Value", () -> robotContainer.getShootSubsystem().getCalculatedShootPIDValue1())
                .withPosition(0,2).withSize(2, 1);
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("Flywheel2 Calculated Value", () -> robotContainer.getShootSubsystem().getCalculatedShootPIDValue2())
                .withPosition(2,2).withSize(2, 1);

        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("FlyWheel 1 Speed", () -> robotContainer.getShootSubsystem().getFlyWheelMotor1().get())
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(4, 0).withSize(2, 1);
        
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("FlyWheel 2 Speed", () -> robotContainer.getShootSubsystem().getFlyWheelMotor2().get())
                .withWidget(BuiltInWidgets.kNumberBar).withPosition(6, 0).withSize(2, 1);
        
        //Calculated current speed
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("FlyWheel 1 Current Speed", () -> robotContainer.getShootSubsystem().getCurrentSpeed1())
                .withPosition(0,1).withSize(2,1);
         Shuffleboard.getTab("ShootSubsystem")
                .addNumber("FlyWheel 2 Current Speed", () -> robotContainer.getShootSubsystem().getCurrentSpeed2())
                .withPosition(0,2).withSize(2,1);

        //Add test shoot widget to shoot subsystem tab
        Shuffleboard.getTab("ShootSubsystem").add("TestShootRPM", (Sendable) robotContainer.getTestShootRPMCommand())
                .withWidget(BuiltInWidgets.kCommand).withPosition(2, 3).withSize(2, 1);
        //Flywheel RPM's
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("Flywheel1 Encoder RPM", () -> robotContainer.getShootSubsystem().getFlyWheelEncoder1().getVelocity())
                .withPosition(4,1).withSize(2, 1);
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("Flywheel2 Encoder RPM", () -> robotContainer.getShootSubsystem().getFlyWheelEncoder1().getVelocity())
                .withPosition(6,1).withSize(2, 1);

        //PID
        Shuffleboard.getTab("ShootSubsystem")
                .add("ShootPIDController1", (Sendable) robotContainer.getShootSubsystem().getShooterPIDController1())
                .withWidget(BuiltInWidgets.kPIDController).withPosition(0, 0).withSize(2, 2);
        Shuffleboard.getTab("ShootSubsystem")
                .add("ShootPIDController2", (Sendable) robotContainer.getShootSubsystem().getShooterPIDController2())
                .withWidget(BuiltInWidgets.kPIDController).withPosition(2, 0).withSize(2, 2);
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("ShootPIDController1Output", () -> robotContainer.getShootSubsystem().getCalculatedShootPIDValue1())
                                .withPosition(4, 2).withSize(2, 1);
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("ShootPIDController2Output", () -> robotContainer.getShootSubsystem().getCalculatedShootPIDValue2())
                                .withPosition(6, 2).withSize(2, 1);
    }

    public void configureBelt() {
        Shuffleboard.getTab("ShootSubsystem")
                .addNumber("Belt Speed", () -> robotContainer.getBeltSubsystem().getBeltMotor().get())
                .withPosition(0, 3).withSize(1, 1);
    }
}
