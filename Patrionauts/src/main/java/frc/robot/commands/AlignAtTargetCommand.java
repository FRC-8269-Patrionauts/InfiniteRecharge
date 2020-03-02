package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DetectedTarget;
import frc.robot.subsystems.DriveSubsystem;

public class AlignAtTargetCommand extends CommandBase {

    private final DriveSubsystem drive;
    private final CameraSubsystem camera;

    public enum State {
        TURN_ALIGN, DIST_ALIGN, FINISHED, TURNING, MOVING
    }
    private State state = null;

    public AlignAtTargetCommand(DriveSubsystem drive, CameraSubsystem camera) {
        this.drive = drive;
        this.camera = camera;

        addRequirements(drive, camera);
    }

    @Override
    public void execute() {

        DetectedTarget target = camera.getDetectedTarget();

        if(state == null){
            state = State.TURN_ALIGN;
        }
        if(state == State.TURN_ALIGN){
            if (camera.hasDetectedTarget()) {
                drive.turn(target.getXOffset());
                state = State.TURNING;
            }
        } 
        if(state == State.TURNING){
            if(drive.isStillTurning()==false){
                state = State.DIST_ALIGN;
            }
        }
        
        if(state == State.DIST_ALIGN){
            if(camera.hasDetectedTarget()){
                drive.move(-target.getYOffset());
                state = State.MOVING;
            }
        }
        if(state == State.MOVING){
            if(drive.isStillMoving()==false){
                state = State.FINISHED;
            }
        }
           
    }

    public boolean isFinished() {
        // This should return true when the command is finished.
        return state == State.FINISHED;
    }

}