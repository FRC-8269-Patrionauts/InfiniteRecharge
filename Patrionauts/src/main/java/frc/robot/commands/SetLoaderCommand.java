package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LoaderSubsystem;

public class SetLoaderCommand extends InstantCommand {
    private final LoaderSubsystem solenoidSubsystem;

    boolean breh = true;

    public SetLoaderCommand(LoaderSubsystem loaderSubsystem) {
        this.solenoidSubsystem = loaderSubsystem;
        addRequirements(solenoidSubsystem);   

    }

    @Override
    public void initialize() {
        if (breh == true){
            solenoidSubsystem.setSolenoidTrue();
            breh = false;
        } else {
            breh = true;
            solenoidSubsystem.setSolenoidFalse();
        }
    }

   
}
