package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LiftSubsystem;

public class LowerBotCommand extends InstantCommand{
    private final LiftSubsystem botLowerSubsystem;

    boolean lift = true;
    public LowerBotCommand(LiftSubsystem liftSubsystem){
        this.botLowerSubsystem = liftSubsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void initialize(){
        if (lift == true){
            botLowerSubsystem.lowerBot1(.6);
            lift = false;
        } else {
            lift = true;
            botLowerSubsystem.lowerBot1(0);
        }
    }
     

}