package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LoaderSubsystem;

public class LoaderTiltForwardCommand extends InstantCommand{
    private final LoaderSubsystem tiltSubsystem;

    boolean tilt = true;

    public LoaderTiltForwardCommand(LoaderSubsystem tilLoaderSubsystem){
        this.tiltSubsystem = tilLoaderSubsystem;
        addRequirements(tiltSubsystem);
    }

    @Override
    public void initialize(){
        if (tilt == true){
            tiltSubsystem.tiltLoaderForward();
            tilt = false;
        } else {
            tilt = true;
            tiltSubsystem.tiltStatic();
        }
    }

    }
