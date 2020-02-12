package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;

/**
 * A command to shoot a power cell.
 */
public class ShootCommand extends CommandBase {

  private final ShootSubsystem shoot;

  public ShootCommand(ShootSubsystem shoot) {
    this.shoot = shoot;
    addRequirements(shoot);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  
  }

  @Override
  public boolean isFinished() {
    // This needs to return true when this command is finished.
    return false;
  }
}
