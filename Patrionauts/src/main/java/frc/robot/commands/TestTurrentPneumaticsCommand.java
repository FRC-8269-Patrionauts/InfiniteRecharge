package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakeSubsystem;

public class TestTurrentPneumaticsCommand extends InstantCommand{
    private final IntakeSubsystem intakeSubsystem;

    boolean boop = true;

    public TestTurrentPneumaticsCommand(IntakeSubsystem intakeSolenoids){
        this.intakeSubsystem = intakeSolenoids;
        addRequirements(intakeSolenoids);
    }

    @Override
    public void initialize() {
        if (boop == true){
            intakeSubsystem.setTensionerDown();
            boop = false;
        } else {
            boop = true;
            intakeSubsystem.setTensionerUp();
        }

    }

}