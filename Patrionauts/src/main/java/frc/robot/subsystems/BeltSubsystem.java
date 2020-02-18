package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BeltSubsystem extends SubsystemBase {
    private final CANSparkMax beltMoter = new CANSparkMax(Constants.BELT_MOTOR, MotorType.kBrushless);

    public BeltSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void feedBall(double speed){
        beltMoter.set(speed);
    }

}