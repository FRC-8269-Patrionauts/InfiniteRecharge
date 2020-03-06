package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakeSubsystem;

public class TestIntakeRollerCommand extends InstantCommand{
    private final IntakeSubsystem rollerSubsystem;

    boolean spin = true;

    public TestIntakeRollerCommand (IntakeSubsystem rollerSubsystem){
        this.rollerSubsystem = rollerSubsystem;
        addRequirements(rollerSubsystem);
    }

    @Override
    public void initialize() {
        if (spin == true){
            rollerSubsystem.intake(.5);
            spin = false;
        } else {
            spin = true;
            rollerSubsystem.outake(0);
        }
    }
}