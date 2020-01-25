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
    }

    @Override
    public void execute() {
        drive.turn(180);
        SmartDashboard.putBoolean("Test Turning", true);

        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

}