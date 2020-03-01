package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BeltSubsystem;
import frc.robot.subsystems.ShootSubsystem;

/**
 * A command to shoot a power cell.
 */
public class ShootCommand extends CommandBase {

  private final ShootSubsystem shoot;
  private final BeltSubsystem belt;
  private static final double RPM = 50;
  private final Timer feedTimer = new Timer();

  public enum State {
    STARTING_RAMPING, IS_RAMPING, STARTING_BELT, BELT_RUNNING, FINISHED
  }

  private State state = null;

  public ShootCommand(ShootSubsystem shoot, BeltSubsystem belt) {
    this.belt = belt;
    this.shoot = shoot;
    addRequirements(shoot, belt);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if(state == null){
      state = State.STARTING_RAMPING;
    }
    if(state == State.STARTING_RAMPING){
      shoot.yeet1(RPM);
      shoot.yeet2(RPM);
      state = State.IS_RAMPING;
    }
    if(state == State.IS_RAMPING){
      if(shoot.isStillRamping() == false){
        state = State.STARTING_BELT;
      }
    }
    if(state == State.STARTING_BELT){
      belt.feedBall(.5);
      feedTimer.reset();
      feedTimer.start();
      state = State.BELT_RUNNING;
    }
    if(state == State.BELT_RUNNING){
      if(feedTimer.hasElapsed(5)){
        feedTimer.stop();
        state = State.FINISHED;
      }
    }

  }

  public boolean isFinished(){
    return state == State.FINISHED;
  }
}
