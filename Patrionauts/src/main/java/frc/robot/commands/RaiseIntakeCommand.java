package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakePneumaticSubsystem;

public class RaiseIntakeCommand extends CommandBase{
    private final IntakePneumaticSubsystem intakePneumatics;

    public RaiseIntakeCommand(IntakePneumaticSubsystem intakeSolenoids){
        this.intakePneumatics = intakeSolenoids;
        addRequirements(intakeSolenoids);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intakePneumatics.setUpIntake();
    }

}