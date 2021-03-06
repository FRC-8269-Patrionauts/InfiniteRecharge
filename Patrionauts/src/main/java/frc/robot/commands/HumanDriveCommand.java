package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * A command that allows the driver to take control of driving.
 */
public class HumanDriveCommand extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private final IntakeSubsystem intakeSubsystem;
    private final XboxController gamepad;
    // private final RobotContainer robotContainer;
    private final Joystick joystick;


    public HumanDriveCommand(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, Joystick joystick, XboxController gamepad) {

        this.driveSubsystem = driveSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.gamepad = gamepad;
        this.joystick = joystick;

        // If we add another subsystem to this command, we must add it to
        // addRequirements.
        addRequirements(driveSubsystem);
    }

    @Override 
    public void initialize() {
        intakeSubsystem.setFunnelOpen();

    }
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.setFunnelClose();
    }

    @Override
    public void execute() {
        if (Constants.ENABLE_JOYSTICK) {
            if (Math.abs(joystick.getY()) > .2 || Math.abs(joystick.getTwist()) > .2) {
                if (Math.abs(joystick.getTwist()) > .2) {
                    driveSubsystem.arcadeDrive(-joystick.getY(), joystick.getTwist()/2);
                } else {
                    driveSubsystem.arcadeDrive(-joystick.getY(), 0);
                }
            } else {
                driveSubsystem.stop();
            }
        }

        if (Constants.ENABLE_GAMEPAD) {
            if (Math.abs(gamepad.getRawAxis(1)) > .1 || Math.abs(gamepad.getRawAxis(2)) > .2) {
                driveSubsystem.arcadeDrive(gamepad.getRawAxis(1), gamepad.getRawAxis(2));
            } else {
                driveSubsystem.stop();
            }
        }
    }
}
