package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakeSubsystem;

public class ToggleIntakeCommand extends InstantCommand{
    private final IntakeSubsystem rollerSubsystem;

    boolean intake = true;

    public ToggleIntakeCommand(IntakeSubsystem intakeSubsystem){
        this.rollerSubsystem = intakeSubsystem;
        addRequirements(rollerSubsystem);[perpetually()]
    }

    @Override
    public void initialize() {
        if(intake == true){
            rollerSubsystem.setDownIntake();
            rollerSubsystem.intake(-.5);
            rollerSubsystem.setTensionerUp(); 
            intake = false;
        } else {
            intake = true;
            rollerSubsystem.setUpIntake();
            rollerSubsystem.intake(0);
            rollerSubsystem.setTensionerDown();
        }
    }

}