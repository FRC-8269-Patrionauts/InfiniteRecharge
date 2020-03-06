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
        shoot.getFlyWheelMotor1().set(.2);
        shoot.getFlyWheelMotor2().set(.2);
    }

    @Override
    public void execute() {
        //shoot.setFlyWheel(.1);
        //shoot.getFlyWheelMotor2().set(.2);
        System.out.println("TestShootCommand execute");
    }

}
