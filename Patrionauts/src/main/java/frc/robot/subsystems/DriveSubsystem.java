package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PIDSource;
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


private final SpeedController testMotor = new PWMVictorSPX(6);
  // private final SpeedController leftMotor1 = testMotor;
  // private final SpeedController leftMotor2 = testMotor;
  // private final SpeedController rightMotor1 = testMotor;
  // private final SpeedController rightMotor2 = testMotor;

  // private final CANSparkMax m_motor = new CANSparkMax(Constants.NEO_MOTOR_TEST,
  // MotorType.kBrushless);
  private final CANSparkMax leftMotor2 = new CANSparkMax(Constants.LEFT_MOTOR_2, MotorType.kBrushless);
  private final CANSparkMax leftMotor1 = new CANSparkMax(Constants.LEFT_MOTOR_1, MotorType.kBrushless);
  private final CANSparkMax rightMotor1 = new CANSparkMax(Constants.RIGHT_MOTOR_1, MotorType.kBrushless);
  private final CANSparkMax rightMotor2 = new CANSparkMax(Constants.RIGHT_MOTOR_2, MotorType.kBrushless);

  private final CANEncoder leftMotor2Encoder = leftMotor2.getEncoder();
  private final CANEncoder leftMotor1Encoder = leftMotor1.getEncoder();
  private final CANEncoder rightMotor1Encoder = rightMotor1.getEncoder();
  private final CANEncoder rightMotor2Encoder = rightMotor2.getEncoder();

  // private final CANSparkMax leftMotor2 = new
  // CANSparkMax(Constants.LEFT_MOTOR_2, MotorType.kBrushless);
  // private final CANSparkMax rightMotor1 = new
  // CANSparkMax(Constants.RIGHT_MOTOR_1, MotorType.kBrushless);
  // private final CANSparkMax rightMotor2 = new
  // CANSparkMax(Constants.RIGHT_MOTOR_2, MotorType.kBrushless);

  int P, I, D = 1;

  int integral, previous_error, setpoint = 0;

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

  public final AHRS imu;

  // private final double error = goalPosition - current position
  // P = 1/(error*error)
  /*
   * Turn = k*error where Tp is the turn power for going forward //one motor will
   * be Tp+turn (left) the other will be Tp-turn (right)
   */

  public final double turnKp = .05;
  public final double turnKi = .001;
  public final double turnKd = 0;
  public final PIDController turnPID = new PIDController(turnKp, turnKi, turnKd);
  

  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  private double goalSpeedx = Constants.GOAL_SPEED;
  private double goalSpeedz = Constants.GOAL_SPEED;

  // private final Encoder leftEncoder = new Encoder(3, 4);
  public double goalAngle = 0;

  private double currentSpeedx = Constants.CURRENT_SPEED;
  private double currentSpeedz = Constants.CURRENT_SPEED;

  private static final double SPEED_STEP_UP = Constants.SPEED_STEP_UP;
  private static final double SPEED_STEP_DOWN = Constants.SPEED_STEP_DOWN;

  // static final double COUNTS_PER_MOTOR_REV = 0;
  // static final double WHEEL_DIAMETER_INCHES = 6.0;
  // static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV) /
  // (WHEEL_DIAMETER_INCHES * 3.1415);
  // static final double DRIVE_SPEED = .4;

  double maxSpeed = 1;

  public DriveSubsystem(AHRS imu) {
    this.imu = imu;
  }

  @Override
  public void periodic() {
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

  public void pidTurn(int degrees){
    double pidValue = turnPID.calculate(imu.getYaw(), goalAngle);
    drive.arcadeDrive(0, pidValue);
  }

  public void setNeoMovment(double speed){
    leftMotor1.set(speed);
    leftMotor2.set(speed);
    rightMotor1.set(speed);
    rightMotor2.set(speed);
  }

  public void setNeoTurning(double speed){
    leftMotor1.set(-speed);
    leftMotor2.set(-speed);
    rightMotor1.set(speed);
    rightMotor2.set(speed);
  }

  public void setNeoMoveTurn(double speed){
    leftMotor1.set(speed);
    leftMotor2.set(speed);
    rightMotor1.set(0);
    rightMotor2.set(0);
  }

  

  

  public void setBase(double lM1, double lM2, double rM1, double rM2) {
    // goalSpeedx = Constants.GOAL_SPEED;
    // goalSpeedz = Constants.GOAL_SPEED;
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

  public CANSparkMax getLeftMotor1() {
    return leftMotor1;
  }

  public CANSparkMax getLeftMotor2() {
    return leftMotor2;
  }

  public CANSparkMax getRightMotor1() {
    return rightMotor1;
  }

  public CANSparkMax getRightMotor2() {
    return rightMotor2;
  }

  // public CANSparkMax getCanSparkMax() {
  // return m_motor;
  // }

  public SpeedController getTestMotor() {
    return testMotor;
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

  public CANEncoder getLeftMotor2Encoder() {
    return leftMotor2Encoder;
  }

  public CANEncoder getLeftMotor1Encoder() {
    return leftMotor1Encoder;
  }

  public CANEncoder getRightMotor1Encoder() {
    return rightMotor1Encoder;
  }

  public CANEncoder getRightMotor2Encoder() {
    return rightMotor2Encoder;
  }

  public DifferentialDrive getDifferentialDrive() {
    return drive;
  }

  public void setSetpoint(int setpoint) {
    this.setpoint = setpoint;
  }

  public PIDController getTurnPIDController() {
    return turnPID;
  }

  protected void useOutput(double output, double setpoint) {
  
  }

 
  /*public void PID() {
    double error = setpoint - imu.getAngle();
    this.integral += (error * .02);
    double derivative = (error - this.previous_error) / .02;
    // this.rcw = P*error + I*this.integral
  }
  */

}
