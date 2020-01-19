package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.HumanDriveCommand;
import frc.robot.commands.SmartDashboardCommand;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.RobotController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation.
 */
public class Robot extends TimedRobot {

  private final RobotContainer robotContainer = new RobotContainer();
  private AutonomousCommand autonomousCommand;
  private HumanDriveCommand humanDriveCommand;
  private SmartDashboardCommand smartDashboardCommand = new SmartDashboardCommand(robotContainer, robotContainer.getCameraSubsystem());

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
    smartDashboardCommand.addCamera();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    // for robot characterization
    // Retrieve values to send back before telling the motors to do something
    double now = autonomousCommand.getCurrentTime();

    double leftPosition = leftEncoderPosition.get();
    double leftRate = leftEncoderRate.get();

    double rightPosition = rightEncoderPosition.get();
    double rightRate = rightEncoderRate.get();

    double battery = RobotController.getBatteryVoltage();
    double motorVolts = battery * Math.abs(priorAutospeed);

    double leftMotorVolts = motorVolts;
    double rightMotorVolts = motorVolts;

    // Retrieve the commanded speed from NetworkTables
    double autospeed = autoSpeedEntry.getDouble(0);
    priorAutospeed = autospeed;

    // command motors to do things
    robotContainer.getDriveSubsystem().getDifferentialDrive().tankDrive((rotateEntry.getBoolean(false) ? -1 : 1) * autospeed, autospeed, false);

    // send telemetry data array back to NT
    numberArray[0] = now;
    numberArray[1] = battery;
    numberArray[2] = autospeed;
    numberArray[3] = leftMotorVolts;
    numberArray[4] = rightMotorVolts;
    numberArray[5] = leftPosition;
    numberArray[6] = rightPosition;
    numberArray[7] = leftRate;
    numberArray[8] = rightRate;
    numberArray[9] = gyroAngleRadians.get();

    telemetryEntry.setNumberArray(numberArray);
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

    smartDashboardCommand.addDrive();
    smartDashboardCommand.addGamepad();
    smartDashboardCommand.addJoystick();

  }
}
