package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

/**
 * A subsystem that controls shooting a powercell.
 */

// GOAL: plug in an RPM (on shuffleboard) and the motor will go to it
public class ShootSubsystem extends SubsystemBase {
    private final PWMVictorSPX beltMotor = new PWMVictorSPX(Constants.BELT_MOTOR);

    private final CANSparkMax flyWheelMotor1 = new CANSparkMax(Constants.FLYWHEEL_MOTOR1, MotorType.kBrushless);
    private final CANSparkMax flyWheelMotor2 = new CANSparkMax(Constants.FLYWHEEL_MOTOR2, MotorType.kBrushless);

    private final CANEncoder flyWheelEncoder1 = flyWheelMotor1.getEncoder();
    private final CANEncoder flyWheelEncoder2 = flyWheelMotor2.getEncoder();

    public final double shootKp1 = .00001;
    public final double shootKi1 = 0;
    public final double shootKd1 = 0;
    public final PIDController pidShooter1 = new PIDController(shootKp1, shootKi1, shootKd1);

    public final double shootKp2 = .00001;
    public final double shootKi2 = 0;
    public final double shootKd2 = 0;
    public final PIDController pidShooter2 = new PIDController(shootKp2, shootKi2, shootKd2);

    public double flywheelMotor1Velocity = 0;

    boolean isRamping = false;
    double calculatedShootPIDValue1 = 0;
    double calculatedShootPIDValue2 = 0;

    double currentSpeed1 = 0;
    double currentSpeed2 = 0;

    public ShootSubsystem() {

    }

    @Override
    public void periodic() {
        if (isRamping) {
            calculatedShootPIDValue1 = pidShooter1.calculate(flyWheelEncoder1.getVelocity());
            calculatedShootPIDValue2 = pidShooter2.calculate(flyWheelEncoder2.getVelocity());

            calculatedShootPIDValue1 = MathUtil.clamp(calculatedShootPIDValue1, -1, 1);
            calculatedShootPIDValue2 = MathUtil.clamp(calculatedShootPIDValue2, -1, 1);

            currentSpeed1 += calculatedShootPIDValue1;
            currentSpeed2 += calculatedShootPIDValue2;

            currentSpeed1 = MathUtil.clamp(currentSpeed1, -1, 1);
            currentSpeed2 = MathUtil.clamp(currentSpeed2, -1, 1);

            flyWheelMotor1.set(currentSpeed1);
            flyWheelMotor2.set(currentSpeed2);
        }
    }

    public void setFlyWheel1(double rpm) {
        isRamping = true;
        currentSpeed1 = 0;
        pidShooter1.setSetpoint(-rpm);
    }

    public void setFlyWheel2(double rpm) {
        isRamping = true;
        currentSpeed2 = 0;
        pidShooter2.setSetpoint(-rpm);
    }

    public void feedBall(double speed) {
        beltMotor.set(-speed);
    }

    public PWMVictorSPX getBeltMotor() {
        return beltMotor;
    }

    public boolean isStillRamping() {
        return isRamping;
    }

    public void stopShooter() {
        isRamping = false;
        currentSpeed1 = 0;
        currentSpeed2 = 0;
        // sets Flywheels to 0 power
        flyWheelMotor1.set(0);
        flyWheelMotor2.set(0);
    }

    // the flywheel motors
    public CANSparkMax getFlyWheelMotor1() {
        return flyWheelMotor1;
    }

    public CANSparkMax getFlyWheelMotor2() {
        return flyWheelMotor2;
    }

    // the PID controllers
    public PIDController getShooterPIDController1() {
        return pidShooter1;
    }

    public PIDController getShooterPIDController2() {
        return pidShooter2;
    }

    // current speed of the flywheels
    public double getCurrentSpeed1() {
        return currentSpeed1;
    }

    public double getCurrentSpeed2() {
        return currentSpeed2;
    }

    // calculated shoot PID Values
    public double getCalculatedShootPIDValue1() {
        return calculatedShootPIDValue1;
    }

    public double getCalculatedShootPIDValue2() {
        return calculatedShootPIDValue2;
    }

    // Flywheel encoders
    public CANEncoder getFlyWheelEncoder1() {
        return flyWheelEncoder1;
    }
    /*
     * public CANEncoder getFlywheelEncoder2() { return flyWheelEncoder2; }
     */

    // get velocity
    public double calculateFlywheel1Velocity() {
        return flyWheelEncoder1.getVelocity();
    }

    public double calculateFlywheel2Velocity() {
        return flyWheelEncoder2.getVelocity();
    }

    public CANEncoder getFlyWheelEncoder2() {
        return flyWheelEncoder2;
    }
}
