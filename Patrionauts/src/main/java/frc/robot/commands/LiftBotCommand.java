package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LiftBotCommand extends InstantCommand{
    private final LiftSubsystem botLiftSubsystem;

    boolean bru = true;
    public LiftBotCommand(LiftSubsystem liftSubsystem){
        this.botLiftSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        if (bru == true){
            botLiftSubsystem.liftBot1(.5);
            bru = false;
        } else {
            bru = true;
            botLiftSubsystem.liftBot1(0);
        }
    }
}