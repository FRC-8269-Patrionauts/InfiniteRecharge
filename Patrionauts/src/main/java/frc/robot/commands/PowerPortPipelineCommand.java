package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class PowerPortPipelineCommand extends InstantCommand {
    private final CameraSubsystem camera;

    boolean foo = false;

    public PowerPortPipelineCommand(CameraSubsystem camera) {
        this.camera = camera;
        addRequirements(camera);
    }

    @Override
    public void initialize() {
        camera.enablePipeline();
        if (foo) {
            camera.setPowerPortPipeline();
            foo = false;
        } else {
            foo = true;
            camera.setTestPipeline();
        }
    }
}