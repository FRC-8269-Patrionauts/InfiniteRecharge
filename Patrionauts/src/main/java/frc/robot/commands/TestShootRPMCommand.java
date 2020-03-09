package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ShootSubsystem;

public class TestShootRPMCommand extends InstantCommand {

    boolean uwu = true;
    private final ShootSubsystem shooter;

    public TestShootRPMCommand(ShootSubsystem shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        if (uwu == true) {
            shooter.stopShooter();
            uwu = false;
        } else {
            uwu = true;
            shooter.setFlyWheel1(100);
            shooter.setFlyWheel2(100);
            shooter.feedBall(0.7);
        }

    }

}
