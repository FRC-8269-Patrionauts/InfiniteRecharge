package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LoaderSubsystem;

public class OpenLoaderCommand extends CommandBase {
    private final LoaderSubsystem solenoidSubsystem;

    public OpenLoaderCommand(LoaderSubsystem loaderSubsystem) {
        this.solenoidSubsystem = loaderSubsystem;
        addRequirements(solenoidSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        solenoidSubsystem.setSolenoidTrue();
    }
}