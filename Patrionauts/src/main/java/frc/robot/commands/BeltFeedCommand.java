package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.BeltSubsystem;

public class BeltFeedCommand extends InstantCommand{
    private final BeltSubsystem feederSubsystem;

    boolean foo = true;

    public BeltFeedCommand(BeltSubsystem tensionerSubsystem){
        this.feederSubsystem = tensionerSubsystem;
        addRequirements(feederSubsystem);
    }

    @Override
    public void initialize() {
        if (foo == true){
        feederSubsystem.feedBall(.3);
        foo = false;
        } else{
            foo = true;
            feederSubsystem.feedBall(0);
        }
    }
}