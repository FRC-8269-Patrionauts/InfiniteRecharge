package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TestMoveFeetCommand extends CommandBase {

    private final DriveSubsystem drive;

    private boolean finished = false;
    private Timer timer = new Timer();

    public TestMoveFeetCommand(DriveSubsystem drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.move(167.625);
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.hasPeriodPassed(10)) {
            timer.reset();
        }

    }
}