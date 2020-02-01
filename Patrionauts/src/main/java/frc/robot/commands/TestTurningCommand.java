package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TestTurningCommand extends CommandBase {

    private final DriveSubsystem drive;

    private boolean finished = false;

    public TestTurningCommand(DriveSubsystem drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.turn(90);
    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Test Turning", true);
    }
}