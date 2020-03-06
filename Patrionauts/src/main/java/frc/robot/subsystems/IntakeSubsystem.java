package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;


/*Notes
* Be able to auto align using webcam
* Also have a method to be able to disable auto align just in case we need to manually adjust

1. open up funnel, start roller, bring down roller, tilt loader and open loader; collect power cells
2. stop roller, close tensioner, tilt to shoot, start flywheel; prepare for shooting
3. drive to shooting posistion, start auto align, belt feed for like 10 seconds; shoots powercells
4. repeat of phase (1); get ready for collection

*/
public class IntakeSubsystem extends SubsystemBase {
    private final PWMVictorSPX rollerMoter = new PWMVictorSPX(Constants.INTAKE_MOTOR);

    private final DoubleSolenoid funnelPiston1 = new DoubleSolenoid(2, 3);
    private final DoubleSolenoid funnelPiston2 = new DoubleSolenoid(4, 5);

    private final DoubleSolenoid intakePiston1 = new DoubleSolenoid(4, 5); 
    private final DoubleSolenoid intakePiston2 = new DoubleSolenoid(6, 7);//intake pneumatics

    private final DoubleSolenoid turrentPiston1 = new DoubleSolenoid(0, 1);
    private final DoubleSolenoid turrentPiston2 = new DoubleSolenoid(2, 3); //turrent pneumatics

    private final CANSparkMax loaderTiltMotor = new CANSparkMax(Constants.TILT_MOTOR, MotorType.kBrushless);
    private final CANEncoder loaderTiltEncoder = loaderTiltMotor.getEncoder();

    public final double tiltKp = .0;
    public final double tiltKi = .0;
    public final double tiltKd = .0;
    public final PIDController tiltPID = new PIDController(tiltKp, tiltKi, tiltKd);

    boolean isTilting = false;
    double calculatedTiltPIDValue;

    public IntakeSubsystem() {
    }

    public DoubleSolenoid getTurrnetPiston1() {
        return turrentPiston1;
    }
    public DoubleSolenoid getTurrnetPiston2() {
        return turrentPiston2;
    }

    public DoubleSolenoid getFunnelPiston1(){
        return funnelPiston1;
    }

    public DoubleSolenoid getFunnelPiston2(){
        return funnelPiston2;
    }

    public DoubleSolenoid getIntakePiston1() {
        return intakePiston1;
    }
    public DoubleSolenoid getIntakePiston2() {
        return intakePiston2;
    }

    @Override
    public void periodic() {
        if (isTilting) {
            calculatedTiltPIDValue = tiltPID.calculate(loaderTiltEncoder.getPosition());

            calculatedTiltPIDValue = MathUtil.clamp(calculatedTiltPIDValue, -0.5, 0.5);

            loaderTiltMotor.set(calculatedTiltPIDValue);

            if (tiltPID.atSetpoint()) {
                isTilting = false;
            }
        }

    }
        
    public void setDownIntake(){
        intakePiston1.set(DoubleSolenoid.Value.kForward);
        intakePiston2.set(DoubleSolenoid.Value.kForward);
    }
    public void setUpIntake(){
        intakePiston1.set(DoubleSolenoid.Value.kReverse);
        intakePiston2.set(DoubleSolenoid.Value.kReverse);
        
    }
    public void setFunnelOpen(){
        funnelPiston1.set(DoubleSolenoid.Value.kForward); // set at begginging of tele or auto
        funnelPiston2.set(DoubleSolenoid.Value.kForward);
    }

    public void setFunnelClose(){
        funnelPiston1.set(DoubleSolenoid.Value.kReverse); // use to put pistons back in (just shuffleboard)
        funnelPiston2.set(DoubleSolenoid.Value.kReverse);
    }

    public void setTensionerUp(){
        turrentPiston1.set(DoubleSolenoid.Value.kForward);
        turrentPiston2.set(DoubleSolenoid.Value.kForward);
    }

    public void setTensionerDown(){
        turrentPiston1.set(DoubleSolenoid.Value.kReverse);
        turrentPiston2.set(DoubleSolenoid.Value.kReverse);
    }

    public void intake(double speed){
        rollerMoter.set(speed);
    }
    public void outake(double speed){
        rollerMoter.set(-speed);
    }

    public double getCalculatedTiltPIDValue(){
        return calculatedTiltPIDValue;
    } 

    public void tiltToShoot(double encoderTicks) {
        isTilting = true;
        tiltPID.setSetpoint(loaderTiltEncoder.getPosition() + encoderTicks);
    }

    public void tiltToBottom(double encoderTicks) {
        isTilting = true;
        tiltPID.setSetpoint(loaderTiltEncoder.getPosition() - encoderTicks);
    }

}
