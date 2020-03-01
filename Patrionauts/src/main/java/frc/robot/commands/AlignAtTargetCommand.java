package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DetectedTarget;
import frc.robot.subsystems.DriveSubsystem;

public class AlignAtTargetCommand extends CommandBase {

    private final DriveSubsystem drive;
    private final CameraSubsystem camera;

    public AlignAtTargetCommand(DriveSubsystem drive, CameraSubsystem camera) {
        this.drive = drive;
        this.camera = camera;

        addRequirements(drive, camera);
    }

    @Override
    public void execute() {
        if (camera.hasDetectedTarget()) {
            DetectedTarget target = camera.getDetectedTarget();
            drive.turn(target.getXOffset());

            while (target.getArea() < 0) // 0 is the placeholder for the ideal area "distance"
            {
                drive.arcadeDrive(.2, 0);
            }
        }
    }

    public boolean isFinished() {
        // This should return true when the command is finished.
        return false;
    }

}