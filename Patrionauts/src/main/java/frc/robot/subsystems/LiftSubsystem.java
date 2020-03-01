package frc.robot.subsystems;

import edu.wpi.first.hal.sim.mockdata.PCMDataJNI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

<<<<<<< HEAD
public class LiftSubsystem extends SubsystemBase {
    private final PWMVictorSPX HookLiftMotor = new PWMVictorSPX(15); // lifts of the hook to hang

    private final PWMVictorSPX BotLiftMotor1 = new PWMVictorSPX(16); // pulls the robot up
    private final PWMVictorSPX BotLiftMotor2 = new PWMVictorSPX(17);
=======
public class LiftSubsystem extends SubsystemBase{
    private final PWMVictorSPX HookLiftMotor = new PWMVictorSPX(Constants.UNKNOWN); //lifts of the hook to hang

    private final PWMVictorSPX BotLiftMotor1 = new PWMVictorSPX(Constants.LIFT_MOTOR_1); //pulls the robot up
    private final PWMVictorSPX BotLiftMotor2 = new PWMVictorSPX(Constants.LIFT_MOTOR_2);
>>>>>>> 10e4a7363b131d558e1aaa2562b328b23914c2ce

    // private final DoubleSolenoid TransmissionSolenoid = new DoubleSolenoid(0, 1);

    public LiftSubsystem() {

    }

    public DoubleSolenoid getTransmissionSolenoid() {
        // return TransmissionSolenoid;
        return null;
    }

    public void transmissionIn() {
        // TransmissionSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void transmissionOut() {
        // TransmissionSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void liftHook(double speed) {
        HookLiftMotor.set(speed);
    }

    public void lowerHook(double speed) {
        HookLiftMotor.set(-speed); // assumtion
    }

    public void liftBot1(double speed) {
        // TransmissionSolenoid.set(DoubleSolenoid.Value.kForward);//lift the bot with
        // transmission engadged
        BotLiftMotor1.set(speed);
        BotLiftMotor2.set(speed);
    }

    public void lowerBot1(double speed) {
        // TransmissionSolenoid.set(DoubleSolenoid.Value.kForward);//lower bot with
        // transmission
        BotLiftMotor1.set(-speed);
        BotLiftMotor2.set(-speed);
    }

    public void liftBot2(double speed) { // lift bot without transmission
        // TransmissionSolenoid.set(DoubleSolenoid.Value.kReverse);
        BotLiftMotor1.set(speed);
        BotLiftMotor2.set(speed);
    }

    public void lowerBot2(double speed) { // lower bot without transmission
        // TransmissionSolenoid.set(DoubleSolenoid.Value.kReverse);
        BotLiftMotor1.set(-speed);
        BotLiftMotor2.set(-speed);
    }

}