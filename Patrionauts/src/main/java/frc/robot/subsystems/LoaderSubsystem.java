package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
    private final DoubleSolenoid doubleSolenoid = new DoubleSolenoid(0, 1);
    // private final boolean voltageStickyFault = doublesolenoid.getPCMSolenoidVoltageFault();
    // private final boolean voltageFault = solenoid.getPCMSolenoidVoltageFault();
    private boolean var = false;

    public LoaderSubsystem() {
        
    }

    public void setVar(boolean var) {
        this.var = var;
    }

    public boolean getVar() { 
        return var;
    }

    public DoubleSolenoid getSolenoid() {
        return doubleSolenoid;
    }

    public void setSolenoidTrue(){
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void setSolenoidFalse(){
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

}