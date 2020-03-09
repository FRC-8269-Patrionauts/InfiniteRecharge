package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/**
 * A command that puts the robot in full autonomous mode.
 */
public class AutonomousCommand extends CommandBase {

    public enum State {
        STARTING, FOLLOW_PATH, START_ALIGN, ALIGN_AT_TARGET, START_SHOOT, SHOOTING, FINISHED
    }

    private State state = State.STARTING;

    private RobotContainer robotContainer;

    public AutonomousCommand(RobotContainer robotContainer) {
        this.robotContainer = robotContainer;
    }

    @Override
    public void initialize() {
        state = State.STARTING;
    }

    @Override
    public void execute() {
        if (state == State.STARTING) {
            state = State.START_ALIGN;
        }
        if (state == State.START_ALIGN) {
            state = State.ALIGN_AT_TARGET;
            robotContainer.getAlignAtTargetCommand().schedule();
        }
        if (state == State.ALIGN_AT_TARGET && robotContainer.getAlignAtTargetCommand().isFinished()) {
            state = State.START_SHOOT;
        }
        if (state == State.START_SHOOT) {
            state = State.SHOOTING;
            robotContainer.getShootCommand().schedule();
        }
        if (state == State.SHOOTING && robotContainer.getShootCommand().isFinished()) {
            state = State.FINISHED;
        }
    }

    @Override
    public boolean isFinished() {
        return state == State.FINISHED;
    }

    public State getState() {
        return state;
    }
}