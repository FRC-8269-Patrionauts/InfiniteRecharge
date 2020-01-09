package frc.robot.commands;

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
    }

    @Override
    public void execute() {
    }

    public void phaseOne(){
        drive.setBase(.5); 
    }
    public void phaseTwo(){
        drive.rotation(.5);
    }
    public void phaseThree(){
        drive.setBase(-.5);
    }

    public void phaseFour(){
        drive.stop();
    }
}
