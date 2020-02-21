package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
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

    private final CANEncoder leftMotor1Encoder = leftMotor1.getEncoder();
    private final CANEncoder leftMotor2Encoder = leftMotor2.getEncoder();
    private final CANEncoder rightMotor1Encoder = rightMotor1.getEncoder();
    private final CANEncoder rightMotor2Encoder = rightMotor2.getEncoder();

    private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
    private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

    public final AHRS imu;

    public final double turnKp = .042;
    public final double turnKi = .0007;
    public final double turnKd = .008;
    public final PIDController turnPID = new PIDController(turnKp, turnKi, turnKd);

    public final double moveKp = 0;
    public final double moveKi = 0;
    public final double moveKd = 0;
    public final PIDController movePID = new PIDController(moveKp, moveKi, moveKd);

    private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

    boolean isTurning = false;
    boolean isMoving = false;
    double calculatedTurnPIDValue = 0;
    double calculatedMovePIDValue = 0;

    // static final double COUNTS_PER_MOTOR_REV = 0;
    // static final double WHEEL_DIAMETER_INCHES = 6.0;
    // static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV) /
    // (WHEEL_DIAMETER_INCHES * 3.1415);
    // static final double DRIVE_SPEED = .4;

    public DriveSubsystem(AHRS imu) {
        this.imu = imu;
        turnPID.reset();
        //saying that -180 = 180 degrees
        turnPID.enableContinuousInput(-180, 180);
        //done iff difference between where we're at and where we want to be is within .01% 
        turnPID.setTolerance(.01);
        movePID.reset();
        //movePID.enableContinuousInput(minimumInput, maximumInput);
        movePID.setTolerance(.01);
    }

    @Override
    public void periodic() {
        if (isTurning) {
            calculatedTurnPIDValue = turnPID.calculate(imu.getYaw());
            //it's essentially a limit
            calculatedTurnPIDValue = MathUtil.clamp(calculatedTurnPIDValue, -0.5, 0.5);

            // drive.arcadeDrive(0, calculatedTurnPIDValue);

            if (turnPID.atSetpoint()) {
                isTurning = false;
            }
        }
        if (isMoving) {
            calculatedMovePIDValue = movePID.calculate(leftMotor1Encoder.getPosition());
            // limit between max powers
            calculatedMovePIDValue = MathUtil.clamp(calculatedMovePIDValue, -1, 1);

            drive.arcadeDrive(calculatedMovePIDValue, 0);

            if (movePID.atSetpoint()) {
                isMoving = false;
            }
        }
    }

    public void arcadeDrive(double forward, double turn) {
         drive.arcadeDrive(forward, turn);
    }

    // public DifferentialDrive getDifferentialDrive() {
    // return drive;
    // }

    public void stop() {
         arcadeDrive(0, 0);
    }

    // PID
    public void turn(double degrees) {
        isTurning = true;
        imu.reset();
        turnPID.setSetpoint(degrees);
    }

    public void turnToAngle(double angle) {
        isTurning = true;
        turnPID.setSetpoint(angle);
    }

    public void move(double feet) {
        isMoving = true;
        movePID.setSetpoint(leftMotor1Encoder.getPosition() + (Constants.INCHES_PER_TICK * 12 * feet));
    }

    public double getCalculatedTurnPIDValue() {
        return calculatedTurnPIDValue;
    }

    public double getCalculatedMovePIDValue() {
        return calculatedMovePIDValue;
    }

    public PIDController getTurnPIDController() {
        return turnPID;
    }

    public PIDController getMovePIDController() {
        return movePID;
    }

    // Motors
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

}
