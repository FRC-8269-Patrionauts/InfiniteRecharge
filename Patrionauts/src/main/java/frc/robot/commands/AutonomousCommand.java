package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/**
 * A command that puts the robot in full autonomous mode.
 */
public class AutonomousCommand extends CommandBase {

    public enum State {
        FOLLOW_PATH, ALIGN_AT_TARGET, SHOOT
    }

    private State state = null;

    private RobotContainer robotContainer;

    public AutonomousCommand(RobotContainer robotContainer) {
        this.robotContainer = robotContainer;
    }

    @Override
    public void execute() {
        if (state == null) {
            state = State.FOLLOW_PATH;
            robotContainer.getFollowPathCommand().schedule();
        } else if (state == State.FOLLOW_PATH && robotContainer.getFollowPathCommand().isFinished()) {
            state = State.ALIGN_AT_TARGET;
            robotContainer.getAlignAtTargetCommand().schedule();
        } else if (state == State.ALIGN_AT_TARGET && robotContainer.getAlignAtTargetCommand().isFinished()) {
            state = State.SHOOT;
            robotContainer.getShootCommand().schedule();
        }
    }
}