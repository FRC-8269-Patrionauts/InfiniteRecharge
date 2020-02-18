package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeRollerSubsystem extends SubsystemBase {
    private final CANSparkMax rollerMoter = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);

    public IntakeRollerSubsystem() {

    }

    @Override
    public void periodic() {
        
    }

    public void intake(double speed){
        rollerMoter.set(speed);
    }
    public void outake(double speed){
        rollerMoter.set(-speed);
    }

}
