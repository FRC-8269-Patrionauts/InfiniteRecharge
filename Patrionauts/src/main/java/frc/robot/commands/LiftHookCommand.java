package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LiftHookCommand extends InstantCommand{
    private final LiftSubsystem hookLiftSubsystem;

    boolean hookLift = true;
    public LiftHookCommand(LiftSubsystem liftSubsystem){
        this.hookLiftSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        if (hookLift == true){
            hookLiftSubsystem.liftHook(.6);
            hookLift = false;
        } else {
            hookLift = true;
            hookLiftSubsystem.liftHook(0);
        }
    }


    
}