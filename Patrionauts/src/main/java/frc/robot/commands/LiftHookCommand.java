package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LiftHookCommand extends CommandBase{
    private final LiftSubsystem hookLiftSubsystem;

    boolean bru = true;
    public LiftHookCommand(LiftSubsystem liftSubsystem){
        this.hookLiftSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        hookLiftSubsystem.liftHook(.4);
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
        hookLiftSubsystem.liftHook(0);
    }

    
}