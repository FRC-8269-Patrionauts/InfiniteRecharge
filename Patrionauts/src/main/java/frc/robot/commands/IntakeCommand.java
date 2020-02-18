package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRollerSubsystem;

public class IntakeCommand extends CommandBase{
    private final IntakeRollerSubsystem rollerSubsystem;

    public IntakeCommand(IntakeRollerSubsystem intakeSubsystem){
        this.rollerSubsystem = intakeSubsystem;
        addRequirements(rollerSubsystem);
    }

    @Override
    public void execute() {
        rollerSubsystem.intake(.3);
    }
}