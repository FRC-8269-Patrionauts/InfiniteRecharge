package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TestTurningCommand extends CommandBase {

    private final DriveSubsystem drive;

    private boolean finished = false;
    private Timer timer = new Timer();

    public TestTurningCommand(DriveSubsystem drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.turn(90);
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Test Turning", true);
        if (timer.hasPeriodPassed(3)) {
            // drive.turn(90);
            timer.reset();
        }
    }
}