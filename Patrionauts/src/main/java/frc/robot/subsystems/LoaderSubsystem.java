package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LoaderSubsystem extends SubsystemBase {
<<<<<<< HEAD
    // private final DoubleSolenoid doubleSolenoid1 = new DoubleSolenoid(0, 1);
    // private final DoubleSolenoid doubleSolenoid2 = new DoubleSolenoid(2, 3);
=======
    private final CANSparkMax loaderTiltMotor = new CANSparkMax(Constants.TILT_MOTOR, MotorType.kBrushless);

    private final DoubleSolenoid doubleSolenoid1 = new DoubleSolenoid(0, 1);
    private final DoubleSolenoid doubleSolenoid2 = new DoubleSolenoid(2, 3);
>>>>>>> 10e4a7363b131d558e1aaa2562b328b23914c2ce

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

<<<<<<< HEAD
    public void setSolenoidTrue() {
        // doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        // doubleSolenoid2.set(DoubleSolenoid.Value.kForward);

=======
    public void tiltLoaderForward(){
        loaderTiltMotor.set(.5);
    }

    public void tiltLoaderBackward(){
        loaderTiltMotor.set(-.5);
    }

    public void tiltStatic(){
        loaderTiltMotor.set(0);
    }


    public void setSolenoidTrue(){
        doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        doubleSolenoid2.set(DoubleSolenoid.Value.kForward);
        
>>>>>>> 10e4a7363b131d558e1aaa2562b328b23914c2ce
    }

    public void setSolenoidFalse() {
        // doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
        // doubleSolenoid2.set(DoubleSolenoid.Value.kReverse);
    }

}