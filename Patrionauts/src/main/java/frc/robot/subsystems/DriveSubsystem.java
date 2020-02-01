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
 */
public class DriveSubsystem extends SubsystemBase {

  private final SpeedController testMotor = new PWMVictorSPX(6);
  private final CANSparkMax leftMotor2 = new CANSparkMax(Constants.LEFT_MOTOR_2, MotorType.kBrushless);
  private final CANSparkMax leftMotor1 = new CANSparkMax(Constants.LEFT_MOTOR_1, MotorType.kBrushless);
  private final CANSparkMax rightMotor1 = new CANSparkMax(Constants.RIGHT_MOTOR_1, MotorType.kBrushless);
  private final CANSparkMax rightMotor2 = new CANSparkMax(Constants.RIGHT_MOTOR_2, MotorType.kBrushless);

  private final CANEncoder leftMotor2Encoder = leftMotor2.getEncoder();
  private final CANEncoder leftMotor1Encoder = leftMotor1.getEncoder();
  private final CANEncoder rightMotor1Encoder = rightMotor1.getEncoder();
  private final CANEncoder rightMotor2Encoder = rightMotor2.getEncoder();

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

  public final AHRS imu;

  public final double turnKp = .05;
  public final double turnKi = .001;
  public final double turnKd = 0;
  public final PIDController turnPID = new PIDController(turnKp, turnKi, turnKd);

  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  boolean isTurning = true;
  double integral, previous_error, setpoint = 0;
  double goalPIDYaw = 0;

  // static final double COUNTS_PER_MOTOR_REV = 0;
  // static final double WHEEL_DIAMETER_INCHES = 6.0;
  // static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV) /
  // (WHEEL_DIAMETER_INCHES * 3.1415);
  // static final double DRIVE_SPEED = .4;

  public DriveSubsystem(AHRS imu) {
    this.imu = imu;
  }

  @Override
  public void periodic() {
    if (isTurning) {
      double turnPidValue = turnPID.calculate(imu.getYaw(), goalPIDYaw);
      drive.arcadeDrive(0, turnPidValue);

      if (turnPID.atSetpoint()) {
        isTurning = false;
      }
    }
  }

  public void turn(double degrees) {
    isTurning = true;
    turnPID.reset();
    turnPID.setSetpoint(imu.getYaw() + degrees);
  }

  public void arcadeDrive(double forward, double turn) {
    drive.arcadeDrive(forward, turn);
  }

  public void stop() {
    arcadeDrive(0, 0);
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

  public SpeedController getTestMotor() {
    return testMotor;
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
}
