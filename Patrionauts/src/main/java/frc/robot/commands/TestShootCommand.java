package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ShootSubsystem;

public class TestShootCommand extends InstantCommand {

    private final ShootSubsystem shoot;

    private boolean toggle = true;

    public TestShootCommand(ShootSubsystem shoot) {
        this.shoot = shoot;
    }

    @Override
    public void initialize() {
        if (toggle) {
            shoot.feedBall(1);
            shoot.setFlyWheel1(5000);
            shoot.setFlyWheel2(5200);
        } else if (!toggle) {
            shoot.feedBall(0);
            shoot.stopShooter();
        }
        toggle = !toggle;
    }
}
