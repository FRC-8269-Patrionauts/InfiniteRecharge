package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class OutakeCommand extends CommandBase{
    private final IntakeSubsystem rollerSubsystem;

    public OutakeCommand(IntakeSubsystem intakeSubsystem){
        this.rollerSubsystem = intakeSubsystem;
        addRequirements(rollerSubsystem);
    }

    @Override
    public void execute() {
        rollerSubsystem.outake(.5);
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
        rollerSubsystem.outake(0);
    }
}