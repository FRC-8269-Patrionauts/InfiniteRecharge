package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;

public class TestShootCommand extends CommandBase {

    private final ShootSubsystem shoot;

    public TestShootCommand(ShootSubsystem shoot) {
        this.shoot = shoot;
        addRequirements(shoot);
    }

    @Override
    public void initialize() {
        System.out.println("TestShootCommand initialize");
    }

    @Override
    public void execute() {
        shoot.setFlyWheel(0.3);
        System.out.println("TestShootCommand execute");
    }
}
