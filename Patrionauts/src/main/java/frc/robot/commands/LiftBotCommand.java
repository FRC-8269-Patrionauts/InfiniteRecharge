package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LiftBotCommand extends InstantCommand{
    private final LiftSubsystem botLiftSubsystem;

    boolean lift = true;

    boolean bru = true;
    public LiftBotCommand(LiftSubsystem liftSubsystem){
        this.botLiftSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        if (lift == true){
            botLiftSubsystem.liftBot1(.4);
            lift = false;
        } else {
            lift = true;
            botLiftSubsystem.liftBot1(0);
        }
    }

}