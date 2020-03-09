package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubsystem;

/**
 * A command to shoot a power cell.
 */
public class ShootCommand extends CommandBase {

    private final ShootSubsystem shooter;
    private final Timer feedTimer = new Timer();

    public enum State {
        STARTING, STARTING_RAMPING, IS_RAMPING, STARTING_BELT, BELT_RUNNING, FINISHED
    }

    private State state = State.STARTING;

    public ShootCommand(ShootSubsystem shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        state = State.STARTING;
    }

    @Override
    public void execute() {
        if (state == State.STARTING) {
            state = State.STARTING_RAMPING;
        }
        if (state == State.STARTING_RAMPING) {
            shooter.setFlyWheel1(5200);
            shooter.setFlyWheel2(5000);
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
            if (feedTimer.hasPeriodPassed(5.0)) {
                feedTimer.stop();
                state = State.FINISHED;
            }
        }
    }

    public boolean isFinished() {
        return state == State.FINISHED;
    }

    public State getState() {
        return state;
    }
}
