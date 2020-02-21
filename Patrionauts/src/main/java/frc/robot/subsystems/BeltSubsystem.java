package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BeltSubsystem extends SubsystemBase {
    private final PWMVictorSPX beltMoter = new PWMVictorSPX(Constants.BELT_MOTOR);

    public BeltSubsystem() {
    }


    @Override
    public void periodic() {
    }

    public void feedBall(double speed){
        beltMoter.set(speed);
    }

}