package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


/*Notes
* Be able to auto align using webcam
* Also have a method to be able to disable auto align just in case we need to manually adjust
*/
public class IntakeRollerSubsystem extends SubsystemBase {
    private final PWMVictorSPX rollerMotor = new PWMVictorSPX(Constants.INTAKE_MOTOR);

    //private final DoubleSolenoid funnelPiston1 = new DoubleSolenoid(2, 3);
    //private final DoubleSolenoid funnelPiston2 = new DoubleSolenoid(4, 5);

    public IntakeRollerSubsystem() {
    }

    public DoubleSolenoid getFunnelPiston1(){
        //return funnelPiston1;
        return null;
    }

    public DoubleSolenoid getFunnelPiston2(){
        //return funnelPiston2;
        return null;
    }

    @Override
    public void periodic() {
        
    }

    public void setFunnelOpen(){
        //funnelPiston1.set(DoubleSolenoid.Value.kForward); // set at begginging of tele or auto
        //funnelPiston2.set(DoubleSolenoid.Value.kForward);
    }

    public void setFunnelClose(){
        //funnelPiston1.set(DoubleSolenoid.Value.kReverse); // use to put pistons back in (just shuffleboard)
        //funnelPiston2.set(DoubleSolenoid.Value.kReverse);
    }

    public void intake(double speed){
        rollerMotor.set(speed);
    }
    public void outake(double speed){
        rollerMotor.set(-speed);
    }

    public PWMVictorSPX getRollerMotor() {
        return rollerMotor;
    }

}
