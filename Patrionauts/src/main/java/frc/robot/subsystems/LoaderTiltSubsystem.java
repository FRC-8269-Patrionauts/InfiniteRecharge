package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderTiltSubsystem extends SubsystemBase{
    private final PWMVictorSPX TiltMotor = new PWMVictorSPX(11);

    public LoaderTiltSubsystem(){
    }


}