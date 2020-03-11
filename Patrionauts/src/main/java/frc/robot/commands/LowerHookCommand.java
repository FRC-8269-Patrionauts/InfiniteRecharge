package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LowerHookCommand extends InstantCommand{
    private final LiftSubsystem hookLowerSubsystem;

    boolean bru = true;
    public LowerHookCommand(LiftSubsystem liftSubsystem){
        this.hookLowerSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        if (bru == true){
            hookLowerSubsystem.lowerHook(1);
            bru = false;
        } else {
            bru = true;
            hookLowerSubsystem.liftHook(0);
        }
    }
}