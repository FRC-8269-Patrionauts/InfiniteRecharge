package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
    // private final DoubleSolenoid doubleSolenoid1 = new DoubleSolenoid(0, 1);
    // private final DoubleSolenoid doubleSolenoid2 = new DoubleSolenoid(2, 3);

    public LoaderSubsystem() {

    }

    public DoubleSolenoid getSolenoid1() {
        // return doubleSolenoid1;
        return null;
    }

    public DoubleSolenoid getSolenoid2() {
        // return doubleSolenoid2;
        return null;
    }

    public void setSolenoidTrue() {
        // doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        // doubleSolenoid2.set(DoubleSolenoid.Value.kForward);

    }

    public void setSolenoidFalse() {
        // doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
        // doubleSolenoid2.set(DoubleSolenoid.Value.kReverse);
    }

}