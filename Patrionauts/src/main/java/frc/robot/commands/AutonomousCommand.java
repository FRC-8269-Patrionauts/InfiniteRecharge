package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShootSubsystem;

/**
 * A command that puts the robot in full autonomous mode.
 */
public class AutonomousCommand extends CommandBase {

    private final DriveSubsystem drive;
    private final CameraSubsystem camera;
    private final ShootSubsystem shoot;

    private final Timer timer = new Timer();

    public AutonomousCommand(DriveSubsystem drive, CameraSubsystem camera, ShootSubsystem shoot) {
        this.drive = drive;
        this.camera = camera;
        this.shoot = shoot;
        // If we add another subsystem to this command, we must add it to
        // addRequirements.
        addRequirements(drive, camera, shoot);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        drive.arcadeDrive(0.5, 0);
    }

    @Override
    public void execute() {
        // drive.arcadeDrive(0.5, 0);
    }

    public void phaseOne() {
        drive.arcadeDrive(.4, 0);
    }

    public void phaseTwo() {
        drive.arcadeDrive(0, .4);
    }

    public void phaseThree() {
        drive.arcadeDrive(0, -.4);
    }

    public void phaseFour() {
        drive.stop();
    }

    public double getCurrentTime() {
        return Timer.getFPGATimestamp();
    }
}