package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ShootSubsystem;

public class LoaderTiltCommand extends InstantCommand{
    private final ShootSubsystem tiltSubsystem;

    boolean tilt = true;

    public LoaderTiltCommand(ShootSubsystem tilLoaderSubsystem){
        this.tiltSubsystem = tilLoaderSubsystem;
        addRequirements(tiltSubsystem);
    }

    @Override
    public void initialize(){
    }

    }
