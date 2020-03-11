package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ColorWheelSubsystem;

public class TestSpinColorWheelCommand extends InstantCommand {
    private final ColorWheelSubsystem spinnerSubsystem;

    boolean foo = true;

    public TestSpinColorWheelCommand(ColorWheelSubsystem colorWheelSpinner) {
        this.spinnerSubsystem = colorWheelSpinner;
        addRequirements(colorWheelSpinner);
    }

    @Override
    public void initialize() {
        if (foo == true) {
            spinnerSubsystem.rotateWheel(.4);
            foo = false;
        } else {
            foo = true;
            spinnerSubsystem.rotateWheel(0);
        }
    }

}