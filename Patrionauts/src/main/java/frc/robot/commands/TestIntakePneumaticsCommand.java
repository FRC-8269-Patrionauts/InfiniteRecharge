package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakeSubsystem;

public class TestIntakePneumaticsCommand extends InstantCommand{
    private final IntakeSubsystem intakeSubsystem;

    boolean boop = true;

    public TestIntakePneumaticsCommand(IntakeSubsystem intakeSolenoids){
        this.intakeSubsystem = intakeSolenoids;
        addRequirements(intakeSolenoids);
    }

    @Override
    public void initialize() {
        if (boop == true){
            intakeSubsystem.setDownIntake();
            boop = false;
        } else {
            boop = true;
            intakeSubsystem.setUpIntake();
        }

    }

}