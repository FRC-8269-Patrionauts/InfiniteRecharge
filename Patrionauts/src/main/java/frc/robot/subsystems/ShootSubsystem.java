package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * A subsystem that controls shooting a powercell.
 */

// GOAL: plug in an RPM (on shuffleboard) and the motor will go to it
public class ShootSubsystem extends SubsystemBase {

    private final CANSparkMax flyWheelMotor1 = new CANSparkMax(Constants.FLYWHEEL_MOTOR1, MotorType.kBrushless);
    private final CANSparkMax flyWheelMotor2 = new CANSparkMax(Constants.FLYWHEEL_MOTOR2, MotorType.kBrushless);

    private final CANEncoder flyWheelEncoder1 = flyWheelMotor1.getEncoder();
    private final CANEncoder flyWheelEncoder2 = flyWheelMotor2.getEncoder();

    // public final PIDController pidShooter = new PIDController(0, 0, 0,
    // flyWheelEncoder1);
    public final double shootKp = 0;
    public final double shootKi = 0;
    public final double shootKd = 0;
    public final PIDController shooterPID = new PIDController(shootKp, shootKi, shootKd);

    public final double RPM = 5000.0;
    // diameter of the Green compliant wheels
    public final double wheelDiameter = 4;
    // encoder counts per revolution for REV NEO Motor
    public final double countsPerRev = 42;
    // gear ratio
    public final double gearRatio = 1.0;

    // public final PIDController pidShooter = new PIDController(0, 0, 0,
    // flyWheelEncoder1);

    // counts per second using the getRate() function
    // public final double flyWheelEncoder1Count = flyWheelEncoder1.getRate();
    // public final double flyWheelEncoder2Count = flyWheelEncoder2.getRate();

    // boolean isRamping = false;
    // double calculatedShootPIDValue = 0;

    // public ShootSubsystem() {

    // }

    // // calculate RPM (from:
    // // https://www.chiefdelphi.com/t/calculate-velocity-with-encoders/159918/2)
    // public final double flyWheelEncoder1RPM = flyWheelEncoder1Count /
    // countsPerRev * (wheelDiameter / gearRatio);
    // public final double flyWheelEncoder2RPM = flyWheelEncoder2Count /
    // countsPerRev * (wheelDiameter / gearRatio);

    public final double flyWheelEncoder1RPM = 0;
    public final double flyWheelEncoder2RPM = 0;

    // // encoder count per second/#encoder counts per rev*diameter of wheel

    // // counts per motor rev = revs of wheel/gearbox ratio

    public void setFlyWheel(double speed) {
        flyWheelMotor1.set(speed);
        flyWheelMotor2.set(-speed);
    }

    public void stopFlyWheel() {
        flyWheelMotor1.set(0);
        flyWheelMotor2.set(0);
    }

    // public void setGoalRPM(double RPM) {
    // /*
    // * int power; //int currentCount = flyWheelEncoder1.get(); //double rate =
    // * flyWheelEncoder1.getRate();
    // *
    // * setFlyWheel(power);
    // *
    // * flyWheelEncoder1.reset(); flyWheelEncoder1.setMinRate(10);
    // */
    // }

    // public void yeet(double RPM) {
    // isRamping = true;

    // flyWheelEncoder1.reset();
    // flyWheelEncoder2.reset();

    // shooterPID.reset();

    // shooterPID.enableContinuousInput(0, 6000);
    // shooterPID.setTolerance(.01);
    // }

    // public double getCalculatedShootPIDValue() {
    // return calculatedShootPIDValue;
    // }

    // public PIDController getShooterPIDController() {
    // return shooterPID;
    // }

    public CANSparkMax getflyWheelMotor1() {
        return flyWheelMotor1;
    }

    public CANSparkMax getflyWheelMotor2() {
        return flyWheelMotor2;
    }

    public CANEncoder getFlyWheelEncoder1() {
        return flyWheelEncoder1;
    }

    public CANEncoder getFlyWheelEncoder2() {
        return flyWheelEncoder2;
    }

}
