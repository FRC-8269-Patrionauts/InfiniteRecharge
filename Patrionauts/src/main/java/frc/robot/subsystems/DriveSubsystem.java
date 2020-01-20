package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.Encoder
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 * A subsystem that controls driving the robot.
 * 
 * TODO(alonzo): Implement the DriveSubsystem. This class was originally named
 * Movement in the design doc, but is now named DriveSubsystem.
 * 
 * Take a look at this example:
 * https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/motorcontrol/Robot.java
 * 
 * Things to consider:
 * 
 * - You may need SpeedControllers for each of the motors
 * 
 * - The autonomous mode may need to use the drive subsystem to turn left or
 * right
 * 
 * - The teleop mode may need to control the drive subsystem using joystick or
 * gamepad inputs
 * 
 * - The drive subsystem may need make sure that the movement is smooth.
 * 
 * TODO(ryssa and alonzo): We may need encoders here, you two should coordinate
 * to figure out how to implement them for this system.
 */
public class DriveSubsystem extends SubsystemBase {

  private final SpeedController leftMotor1 = new PWMVictorSPX(Constants.LEFT_MOTOR_1);
  private final SpeedController leftMotor2 = new PWMVictorSPX(Constants.LEFT_MOTOR_2);
  private final SpeedController rightMotor1 = new PWMVictorSPX(Constants.RIGHT_MOTOR_1);
  private final SpeedController rightMotor2 = new PWMVictorSPX(Constants.RIGHT_MOTOR_2);
  private final Spark neoMotor = new Spark(4);

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  private double goalSpeedx = 0;
  private double goalSpeedz = 0;

  private double currentSpeedx = 0;
  private double currentSpeedz = 0;

  private static final double SPEED_STEP_UP = 0.04;
  private static final double SPEED_STEP_DOWN = 0.05;

  double maxSpeed = 1;

  public DriveSubsystem() {
    // drive.setDeadband(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // leftMotor1
    if (goalSpeedx > currentSpeedx) {
      currentSpeedx += SPEED_STEP_UP;
    } else if (goalSpeedx < currentSpeedx) {
      currentSpeedx -= SPEED_STEP_DOWN;
    }
    if (currentSpeedx > maxSpeed) {
      currentSpeedx = maxSpeed;
    } else if (currentSpeedx < -maxSpeed) {
      currentSpeedx = -maxSpeed;
    }
    if (Math.abs(currentSpeedx) > maxSpeed) {
      currentSpeedx = maxSpeed;
    }

    if (goalSpeedz > currentSpeedz) {
      currentSpeedz += SPEED_STEP_UP;
    } else if (goalSpeedz < currentSpeedz) {
      currentSpeedz -= SPEED_STEP_DOWN;
    }
    if (currentSpeedz > maxSpeed) {
      currentSpeedz = maxSpeed;
    } else if (currentSpeedz < -maxSpeed) {
      currentSpeedz = -maxSpeed;
    }

    if (Math.abs(currentSpeedx) > 0.05 || Math.abs(currentSpeedz) > 0.05) {
      drive.arcadeDrive(currentSpeedx, currentSpeedz);
    }
    // Update to currentSpeedX and Z

  }

  public void setBase(double lM1, double lM2, double rM1, double rM2) {
    // goalSpeedlM1 = lM1;
    // goalSpeedlM2 = lM2;
    // goalSpeedrM1 = -rM1;
    // goalSpeedrM2 = -rM2;
    // leftMotor1.set(lM1*speedMult);
    // leftMotor2.set(lM2*speedMult);
    // rightMotor1.set(rM1*speedMult);
    // rightMotor2.set(rM2*speedMult);
  }

  public void arcadeDrive(double x, double z) {
    goalSpeedx = x;
    goalSpeedz = z;
  }

  public void turn(double speed) {
  }

  public void stop() {
    arcadeDrive(0, 0);
  }

  public void strafe(double x) { // please for the love of all that is holy strafe with the grace of our
                                 // permethious
    double xValue = x;
    if (Math.abs(xValue) < .5) {
      xValue = 0;
    }
    setBase(x, -x, x, -x);
  }

  public void setMaxSpeed(double speed) {
    this.maxSpeed = speed;
  }

  public double getMaxSpeed() {
    return maxSpeed;
  }

  public SpeedController getLeftMotor1() {
    return leftMotor1;
  }

  public SpeedController getLeftMotor2() {
    return leftMotor2;
  }

  public SpeedController getRightMotor1() {
    return rightMotor1;
  }

  public SpeedController getRightMotor2() {
    return rightMotor2;
  }

  public double getLeftMotor1Speed() {
    return leftMotor1.get();
  }

  public double getLeftMotor2Speed() {
    return leftMotor2.get();
  }

  public double getRightMotor1Speed() {
    return rightMotor1.get();
  }

  public double getRightMotor2Speed() {
    return rightMotor2.get();
  }

  public double[] getSpeeds() {
    return new double[] { getLeftMotor1Speed(), getLeftMotor2Speed(), getRightMotor1Speed(), getRightMotor2Speed() };
  }

  public DifferentialDrive getDifferentialDrive() {
    return drive;
  }

}
