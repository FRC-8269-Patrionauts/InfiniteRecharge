package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;

public class TestShootRPMCommand extends CommandBase {

    private final ShootSubsystem shoot;
    private Timer timer = new Timer();



    //
    public TestShootRPMCommand(ShootSubsystem shoot) {
        this.shoot = shoot;
        addRequirements(shoot);
    }

    @Override
    public void initialize() {
        shoot.yeet1(10);
        //shoot.yeet2(10);

    }

    @Override
    public void execute() {

    }
}
