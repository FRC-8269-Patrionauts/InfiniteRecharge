package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

public class LoaderSubsystem extends SubsystemBase {
    
    private final CANSparkMax loaderTiltMotor = new CANSparkMax(Constants.TILT_MOTOR, MotorType.kBrushless);
    private final CANEncoder loaderTiltEncoder = loaderTiltMotor.getEncoder();

    public final double tiltKp = .0;
    public final double tiltKi = .0;
    public final double tiltKd = .0;
    public final PIDController tiltPID = new PIDController(tiltKp, tiltKi, tiltKd);

    private final DoubleSolenoid doubleSolenoid1 = new DoubleSolenoid(0, 1);
    private final DoubleSolenoid doubleSolenoid2 = new DoubleSolenoid(2, 3);

    boolean isTilting = false;
    double calculatedTiltPIDValue;

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

    @Override
    public void periodic(){
        if (isTilting) {
            calculatedTiltPIDValue = tiltPID.calculate(loaderTiltEncoder.getPosition());

            calculatedTiltPIDValue = MathUtil.clamp(calculatedTiltPIDValue, -0.5, 0.5);

            loaderTiltMotor.set(calculatedTiltPIDValue);

            if (tiltPID.atSetpoint()) {
                isTilting = false;
            }
        }

    }

    //tilt to bottom = 0
    //tilt to shoot = blah
    //method to return if it's finished tilting (boolean)
    
    public void tiltLoaderForward() {
        loaderTiltMotor.set(.5);
    }

    public void tiltLoaderBackward() {
        loaderTiltMotor.set(-.5);
    }

    public void tiltStatic() {
        loaderTiltMotor.set(0);
    }

    public void setSolenoidTrue() {
        doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        doubleSolenoid2.set(DoubleSolenoid.Value.kForward);
    }

    public void setSolenoidFalse() {
        // doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
        // doubleSolenoid2.set(DoubleSolenoid.Value.kReverse);
    }

    public double getCalculatedTiltPIDValue(){
        return calculatedTiltPIDValue;
    } 

    public void tiltToShoot(double encoderTicks) {
        isTilting = true;
        tiltPID.setSetpoint(loaderTiltEncoder.getPosition() + encoderTicks);
    }

    public void tiltToBottom() {
        isTilting = true;
        tiltPID.setSetpoint(0);
    }

   




}