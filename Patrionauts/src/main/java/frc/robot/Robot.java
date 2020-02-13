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
    robotContainer.getDriveSubsystem().getLeftMotor1().follow(robotContainer.getDriveSubsystem().getLeftMotor2(), true);
    robotContainer.getDriveSubsystem().getRightMotor1().follow(robotContainer.getDriveSubsystem().getRightMotor2());

    //robotContainer.getDriveSubsystem().getLeftMotor1().setInverted(false);
    //robotContainer.getDriveSubsystem().getLeftMotor2().setInverted(false);
    //robotContainer.getDriveSubsystem().getRightMotor1().setInverted(false);
    //robotContainer.getDriveSubsystem().getRightMotor2().setInverted(false);

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
    // robotContainer.getDriveSubsystem().getLeftEncoder().setDistancePerPulse(1./256.);
    autonomousCommand = robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      // autonomousCommand.schedule();
      robotContainer.getTestTurningCommand().schedule();
    }
  }

  // AUTOALIGN
  // NetworkTable table = NetworkTable.getTable("limelight");

  @Override
  public void autonomousPeriodic() {
    // for robot characterization
    // Retrieve values to send back before telling the motors to do something
    double now = autonomousCommand.getCurrentTime();

    // AUTOALIGN
    // double angle = table.getDouble("tx", 0.0);
    // double error = (angle / 45) * 2.0;
    // robotContainer.getDriveSubsystem().arcadeDrive(0, error);

    /*
     * double leftPosition = leftEncoderPosition.get(); double leftRate =
     * leftEncoderRate.get();
     * 
     * double rightPosition = rightEncoderPosition.get(); double rightRate =
     * rightEncoderRate.get();
     * 
     * double battery = RobotController.getBatteryVoltage(); double motorVolts =
     * battery * Math.abs(priorAutospeed);
     * 
     * double leftMotorVolts = motorVolts; double rightMotorVolts = motorVolts;
     * 
     * // Retrieve the commanded speed from NetworkTables double autospeed =
     * autoSpeedEntry.getDouble(0); priorAutospeed = autospeed;
     * 
     * // command motors to do things
     * robotContainer.getDriveSubsystem().getDifferentialDrive()
     * .tankDrive((rotateEntry.getBoolean(false) ? -1 : 1) * autospeed, autospeed,
     * false);
     * 
     * // send telemetry data array back to NT numberArray[0] = now; numberArray[1]
     * = battery; numberArray[2] = autospeed; numberArray[3] = leftMotorVolts;
     * numberArray[4] = rightMotorVolts; numberArray[5] = leftPosition;
     * numberArray[6] = rightPosition; numberArray[7] = leftRate; numberArray[8] =
     * rightRate; numberArray[9] = gyroAngleRadians.get();
     * 
     * telemetryEntry.setNumberArray(numberArray);
     */
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
    //robotContainer.getDriveSubsystem().getLeftMotor2().set(-.5);
    //robotContainer.getShootSubsystem().setFlyWheel(.5);
    robotContainer.getDriveSubsystem().getLeftMotor2().set(.15);
    robotContainer.getDriveSubsystem().getRightMotor2().set(.15);
    
  }
}
