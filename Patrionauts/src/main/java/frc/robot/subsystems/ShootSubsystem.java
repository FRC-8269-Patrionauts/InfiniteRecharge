package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * A subsystem that controls shooting a powercell.
 */
public class ShootSubsystem extends SubsystemBase {

    private final CANSparkMax flyWheelMotor1 = new CANSparkMax(Constants.FLYWHEEL_MOTOR1, MotorType.kBrushless);
    private final CANSparkMax flyWheelMotor2 = new CANSparkMax(Constants.FLYWHEEL_MOTOR2, MotorType.kBrushless);

    private final CANEncoder flyWheelEncoder1 = flyWheelMotor1.getEncoder();
    private final CANEncoder flyWheelEncoder2 = flyWheelMotor2.getEncoder();

    public ShootSubsystem() {

    }

    // public final flyCanEncoder1.setPIDSourceType(PIDSourceType.kRate);

    // public final PIDController pidShooter = new PIDController(0, 0, 0,
    // flyCanEncoder1);

    public final double RPM = 5000.0;
    // diameter of the Green compliant wheels
    public final double wheelDiameter = 4;
    // encoder counts per revolution for REV NEO Motor
    public final double countsPerRev = 42;
    // gear ratio
    public final double gearRatio = 1.0;

    // counts per second using the getRate() function
    public final double flyCanEncoder1Count = 0; // flyCanEncoder1.getRate();
    public final double flyCanEncoder2Count = 0; // flyCanEncoder2.getRate();

    public final double flyCanEncoder1RPM = flyCanEncoder1Count / countsPerRev * (wheelDiameter / gearRatio);
    public final double flyCanEncoder2RPM = flyCanEncoder2Count / countsPerRev * (wheelDiameter / gearRatio);

    // encoder count per second/#encoder counts per rev*diameter of wheel
    // counts per motor rev = revs of wheel/gearbox ratio

    public void setFlyWheel(double speed) {
        flyWheelMotor1.set(speed);
        flyWheelMotor2.set(-speed);
    }

    public void stopFlyWheel() {
        flyWheelMotor1.set(0);
        flyWheelMotor2.set(0);
    }

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

    public void setGoalRPM() {
        // int currentCount = flyCanEncoder1.get();
        // double rate = flyCanEncoder1.getRate();

        /*
         * flyCanEncoder1.reset(); flyCanEncoder1.setMinRate(10);
         */
    }
}
