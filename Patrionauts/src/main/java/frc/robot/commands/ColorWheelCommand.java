package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;

public class ColorWheelCommand extends CommandBase {

    private final ColorWheelSubsystem colorWheel;

    public ColorWheelCommand(ColorWheelSubsystem colorWheel) {
        this.colorWheel = colorWheel;
        addRequirements(colorWheel);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
    }

    public boolean isFinished() {
        // This should return true when the command is finished.
        return false;
    }

}