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
    }

    @Override
    public void execute() {
        //shoot.setFlyWheel(1);
        shoot.getFlyWheelMotor1().set(.1);
        System.out.println("TestShootCommand execute");
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
        shoot.getFlyWheelMotor1().set(0);
    }

}
