package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

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
  private final CANSparkMax m_motor = new CANSparkMax(Constants.NEO_MOTOR_TEST, MotorType.kBrushless);

  int P, I, D = 1;  

  int integral, previous_error, setpoint = 0;

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

  private final AHRS imu;

  //private final double error = goalPosition - current position
  //P = 1/(error*error)
  
  private final double turnKp = 10;
  private final double turnKi = 3;
  private final double turnKd = 0;
  private final PIDController turnPID = new PIDController(turnKp, turnKi, turnKd);

  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  private double goalSpeedx = Constants.GOAL_SPEED;
  private double goalSpeedz = Constants.GOAL_SPEED;

  // private final Encoder leftEncoder = new Encoder(3, 4);
  private double goalAngle = 0;

  private double currentSpeedx = Constants.CURRENT_SPEED;
  private double currentSpeedz = Constants.CURRENT_SPEED;

  private static final double SPEED_STEP_UP = Constants.SPEED_STEP_UP;
  private static final double SPEED_STEP_DOWN = Constants.SPEED_STEP_DOWN;

  //  static final double COUNTS_PER_MOTOR_REV = 0;
  //  static final double WHEEL_DIAMETER_INCHES = 6.0;
  //  static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV) / (WHEEL_DIAMETER_INCHES * 3.1415);
  //  static final double DRIVE_SPEED = .4;

  double maxSpeed = 1;

  public DriveSubsystem(AHRS imu) {
    // drive.setDeadband(0);
    this.imu = imu;
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
    // insert PID Loop Here
   
    double pidValue = turnPID.calculate(imu.getYaw(), goalAngle);
    SmartDashboard.putNumber("pidValue", pidValue);
    SmartDashboard.putNumber("Yaw", imu.getYaw());
    SmartDashboard.putNumber("goal", goalAngle);

   // drive.arcadeDrive(0, pidValue);

    // drive.arcadeDrive(0, pidValue);

    // figure out how to get zRotation

    /*
     * Should be able to take current angle, find difference from current angle to
     * goal angle, and use that info to get zRotation
     */

  }

  public void setBase(double lM1, double lM2, double rM1, double rM2) {
     //goalSpeedx = Constants.GOAL_SPEED;
      //goalSpeedz = Constants.GOAL_SPEED;
    //  goalSpeedrM1 = -rM1;
    //  goalSpeedrM2 = -rM2;
    // leftMotor1.set(lM1*speedMult);
    // leftMotor2.set(lM2*speedMult);
    // rightMotor1.set(rM1*speedMult);
    // rightMotor2.set(rM2*speedMult);
  }

  public void arcadeDrive(double x, double z) {
    goalSpeedx = x;
    goalSpeedz = z;
  }

  public void turn(double degrees) {
    goalAngle = degrees;
  }

  public void stop() {
    // arcadeDrive(0, 0);
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

  public CANSparkMax getCanSparkMax() {
    return m_motor;
  }

  /*
   * public Encoder getLeftEncoder() { return leftEncoder; }
   */

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
