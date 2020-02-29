package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LoaderTiltSubsystem extends SubsystemBase{
    private final PWMVictorSPX TiltMotor = new PWMVictorSPX(Constants.Tilt_MOTOR);

    public LoaderTiltSubsystem(){
    }


}