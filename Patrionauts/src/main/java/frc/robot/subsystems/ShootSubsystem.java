package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
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

    public void setFlyWheel(double speed) {
        flyWheelMotor1.set(speed);
        flyWheelMotor2.set(-speed);
    }

    public void stopFlyWheel() {
        flyWheelMotor1.set(0);
        flyWheelMotor2.set(0);
    }

    public CANSparkMax getFlyWheelMotor1() {
        return flyWheelMotor1;
    }

    public CANSparkMax getFlyWheelMotor2() {
        return flyWheelMotor2;
    }

    public CANEncoder getFlyWheelEncoder1() {
        return flyWheelEncoder1;
    }

    public CANEncoder getFlyWheelEncoder2() {
        return flyWheelEncoder2;
    }
}
