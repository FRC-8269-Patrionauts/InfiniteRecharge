package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BeltSubsystem;

public class BeltFeedCommand extends CommandBase{
    private final BeltSubsystem feederSubsystem;

    public BeltFeedCommand(BeltSubsystem tensionerSubsystem){
        this.feederSubsystem = tensionerSubsystem;
        addRequirements(feederSubsystem);
    }

    @Override
    public void execute() {
        feederSubsystem.feedBall(.3);
    }
}