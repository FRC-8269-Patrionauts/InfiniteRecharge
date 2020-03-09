package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;

/**
 * A command to shoot a power cell.
 */
public class ShootCommand extends CommandBase {

  private final ShootSubsystem shooter;
  private static final double RPM = 5000;
  private final Timer feedTimer = new Timer();

  public enum State {
    STARTING_RAMPING, IS_RAMPING, STARTING_BELT, BELT_RUNNING, FINISHED
  }

  private State state = null;

  public ShootCommand(ShootSubsystem shooter) {
    this.shooter = shooter;
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (state == null) {
      state = State.STARTING_RAMPING;
    }
    if (state == State.STARTING_RAMPING) {
      shooter.shoot1(RPM);
      shooter.shoot2(RPM);
      state = State.IS_RAMPING;
    }
    if (state == State.IS_RAMPING) {
      if (shooter.isStillRamping() == false) {
        state = State.STARTING_BELT;
      }
    }
    if (state == State.STARTING_BELT) {
      shooter.feedBall(1);
      feedTimer.reset();
      feedTimer.start();
      state = State.BELT_RUNNING;
    }
    if (state == State.BELT_RUNNING) {
      if (feedTimer.hasPeriodPassed(5)) {
        feedTimer.stop();
        shooter.shoot1(0);
        shooter.shoot2(0);
        state = State.FINISHED;
      }
    }

  }

  public boolean isFinished() {
    return state == State.FINISHED;
  }
}
