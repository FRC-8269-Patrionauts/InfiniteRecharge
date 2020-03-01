package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakePneumaticSubsystem extends SubsystemBase {
    // private final DoubleSolenoid doubleSolenoid3 = new DoubleSolenoid(4, 5);
    // private final DoubleSolenoid doubleSolenoid4 = new DoubleSolenoid(6, 7);

    public IntakePneumaticSubsystem() {
    }

    public DoubleSolenoid getSolenoid3() {
        // return doubleSolenoid3;
        return null;
    }

    public DoubleSolenoid getSolenoid4() {
        // return doubleSolenoid4;
        return null;
    }

    public void setDownIntake() {
        // doubleSolenoid3.set(DoubleSolenoid.Value.kForward);
        // doubleSolenoid4.set(DoubleSolenoid.Value.kForward);
    }

    public void setUpIntake() {
        // doubleSolenoid3.set(DoubleSolenoid.Value.kReverse);
        // doubleSolenoid4.set(DoubleSolenoid.Value.kReverse);

    }

}