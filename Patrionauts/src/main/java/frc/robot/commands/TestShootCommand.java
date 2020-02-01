package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;

public class TestShootCommand extends CommandBase {

    private final ShootSubsystem shoot;

    private boolean finished = false;

    public TestShootCommand(ShootSubsystem shoot) {
        this.shoot = shoot;
        addRequirements(shoot);
    }

    @Override
    public void initialize() {
        shoot.setFlyWheel(.5);
    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Test flywheel", true);
    }

    public boolean isFinished() {
        SmartDashboard.putBoolean("Test flywheel", false);
        return finished;
    }



}
