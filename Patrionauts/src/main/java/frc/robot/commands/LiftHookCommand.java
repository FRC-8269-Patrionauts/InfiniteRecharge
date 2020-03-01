package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LiftHookCommand extends InstantCommand{
    private final LiftSubsystem hookLiftSubsystem;

    boolean bru = true;
    public LiftHookCommand(LiftSubsystem liftSubsystem){
        this.hookLiftSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        if (bru == true){
            hookLiftSubsystem.liftHook(.2);
            bru = false;
        } else {
            bru = true;
            hookLiftSubsystem.liftHook(0);
        }
    }
}