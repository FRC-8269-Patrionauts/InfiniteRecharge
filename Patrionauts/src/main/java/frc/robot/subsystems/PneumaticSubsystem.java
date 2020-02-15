package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSubsystem extends SubsystemBase {
    private final Solenoid solenoid = new Solenoid(0); boolean blacklisted = solenoid.isBlackListed();
    private final boolean voltageStickyFault = solenoid.getPCMSolenoidVoltageFault();
    private final boolean voltageFault = solenoid.getPCMSolenoidVoltageFault();
    
    public PneumaticSubsystem() {
        
    }

    public Solenoid getSolenoid() {
        return solenoid;
    }

    

}