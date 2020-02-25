package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase{
    private final PWMVictorSPX HookLiftMotor = new PWMVictorSPX(0); //lifts of the hook to hang

    private final PWMVictorSPX BotLiftMotor1 = HookLiftMotor; //pulls the robot up
    private final PWMVictorSPX BotLiftMotor2 = HookLiftMotor;

    public LiftSubsystem(){

    }

    public void liftHook(double speed){
        HookLiftMotor.set(speed);
    }

    public void lowerHook(double speed){
        HookLiftMotor.set(-speed); //assumtion
    }

    public void liftBot(double speed){
        BotLiftMotor1.set(speed);
        BotLiftMotor2.set(speed);
    }

    public void lowerBot(double speed){
        BotLiftMotor1.set(-speed);
        BotLiftMotor2.set(-speed);
    }
    




}