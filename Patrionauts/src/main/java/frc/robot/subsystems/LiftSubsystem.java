package frc.robot.subsystems;

import edu.wpi.first.hal.sim.mockdata.PCMDataJNI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase{
    private final PWMVictorSPX HookLiftMotor = new PWMVictorSPX(0); //lifts of the hook to hang

    private final PWMVictorSPX BotLiftMotor1 = new PWMVictorSPX(10); //pulls the robot up
    private final PWMVictorSPX BotLiftMotor2 = new PWMVictorSPX(11);

    private final DoubleSolenoid TransmissionSolenoid = new DoubleSolenoid(0, 1);

    

    public LiftSubsystem(){

    }

    public DoubleSolenoid getTransmissionSolenoid() {
        return TransmissionSolenoid;
    }

    public void transmissionIn(){
        TransmissionSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void transmissionOut(){
        TransmissionSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void liftHook(double speed){
        HookLiftMotor.set(speed);
    }

    public void lowerHook(double speed){
        HookLiftMotor.set(-speed); //assumtion
    }

    public void liftBot1(double speed){
        TransmissionSolenoid.set(DoubleSolenoid.Value.kForward);//lift the bot with transmission engadged 
        BotLiftMotor1.set(speed);
        BotLiftMotor2.set(speed);
    }

    public void lowerBot1(double speed){
        TransmissionSolenoid.set(DoubleSolenoid.Value.kForward);//lower bot with transmission
        BotLiftMotor1.set(-speed);
        BotLiftMotor2.set(-speed);
    }

    public void liftBot2(double speed){ //lift bot without transmission
        TransmissionSolenoid.set(DoubleSolenoid.Value.kReverse);
        BotLiftMotor1.set(speed);
        BotLiftMotor2.set(speed);
    }

    public void lowerBot2(double speed){ //lower bot without transmission
        TransmissionSolenoid.set(DoubleSolenoid.Value.kReverse);
        BotLiftMotor1.set(-speed);
        BotLiftMotor2.set(-speed);
    }



    




}