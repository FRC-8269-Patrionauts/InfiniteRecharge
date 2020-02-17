package frc.robot;

import java.util.function.Supplier;

import com.revrobotics.CANError;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.HumanDriveCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation.
 */
public class Robot extends TimedRobot {

    private final RobotContainer robotContainer = new RobotContainer();
    private AutonomousCommand autonomousCommand;
    private HumanDriveCommand humanDriveCommand;

    Supplier<Double> leftEncoderPosition;
    Supplier<Double> leftEncoderRate;
    Supplier<Double> rightEncoderPosition;
    Supplier<Double> rightEncoderRate;
    Supplier<Double> gyroAngleRadians;

    NetworkTableEntry autoSpeedEntry = NetworkTableInstance.getDefault().getEntry("/robot/autospeed");
    NetworkTableEntry telemetryEntry = NetworkTableInstance.getDefault().getEntry("/robot/telemetry");
    NetworkTableEntry rotateEntry = NetworkTableInstance.getDefault().getEntry("/robot/rotate");

    double priorAutospeed = 0;
    Number[] numberArray = new Number[10];

    @Override
    public void robotInit() {

        // Disable LiveWindow telemetry which causes the "loop time of 0.02s overrun"
        // warning.
        LiveWindow.disableAllTelemetry();

        // smartDashboardCommand.addCamera();
        // robotContainer.getAHRS().reset();

        // robotContainer.getDriveSubsystem().getLeftMotor1().follow(robotContainer.getDriveSubsystem().getLeftMotor2());
        // robotContainer.getDriveSubsystem().getRightMotor1().follow(robotContainer.getDriveSubsystem().getRightMotor2());

        // robotContainer.getDriveSubsystem().getLeftMotor1().setInverted(false);
        // robotContainer.getDriveSubsystem().getLeftMotor2().setInverted(false);
        // robotContainer.getDriveSubsystem().getRightMotor1().setInverted(false);
        // robotContainer.getDriveSubsystem().getRightMotor2().setInverted(false);

        robotContainer.getImu().reset();
        // robotContainer.getCameraSubsystem().startAutomaticCapture();
    }

    @Override
    public void robotPeriodic() {
        try {
            CommandScheduler.getInstance().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = robotContainer.getAutonomousCommand();

        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        humanDriveCommand = robotContainer.getHumanDriveCommand();
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
        if (humanDriveCommand != null) {
            humanDriveCommand.schedule();
        }
    }

    @Override
    public void teleopPeriodic() {
    }
}
