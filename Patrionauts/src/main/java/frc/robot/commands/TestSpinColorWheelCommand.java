package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;

public class TestSpinColorWheelCommand extends CommandBase{
    private final ColorWheelSubsystem spinnerSubsystem;

    public TestSpinColorWheelCommand(ColorWheelSubsystem colorWheelSpinner){
        this.spinnerSubsystem = colorWheelSpinner;
        addRequirements(colorWheelSpinner);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute() {
        spinnerSubsystem.rotateWheel(.2);
    }

}