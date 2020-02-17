package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;

public class TestShootRPMCommand extends CommandBase {

    private final ShootSubsystem shoot;

    public TestShootRPMCommand(ShootSubsystem shoot) {
        this.shoot = shoot;
        addRequirements(shoot);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        while (true) {
            shoot.setFlyWheel(0.3);
        }
    }
}
