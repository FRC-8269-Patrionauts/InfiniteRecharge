package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class TestPipelineCommand extends InstantCommand {
    private final CameraSubsystem camera; 

    public TestPipelineCommand(CameraSubsystem camera) {
        this.camera = camera;
        addRequirements(camera);
    }

    @Override
    public void initialize() {
        camera.enablePipeline();
        camera.setTestPipeline();
    }
}