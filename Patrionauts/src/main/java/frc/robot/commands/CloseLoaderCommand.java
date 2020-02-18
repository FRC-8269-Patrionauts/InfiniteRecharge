package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LoaderSubsystem;

public class CloseLoaderCommand extends CommandBase {
    private final LoaderSubsystem solenoidSubsystem;

    public CloseLoaderCommand(LoaderSubsystem loaderSubsystem) {
        this.solenoidSubsystem = loaderSubsystem;
        addRequirements(solenoidSubsystem);   
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        solenoidSubsystem.setSolenoidFalse();
    }
}
