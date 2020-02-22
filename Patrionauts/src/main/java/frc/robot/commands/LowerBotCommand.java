package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LowerBotCommand extends InstantCommand{
    private final LiftSubsystem botLowerSubsystem;

    boolean bru = true;
    public LowerBotCommand(LiftSubsystem liftSubsystem){
        this.botLowerSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        if (bru == true){
            botLowerSubsystem.lowerBot(.5);
            bru = false;
        } else {
            bru = true;
            botLowerSubsystem.liftBot(0);
        }
    }
}