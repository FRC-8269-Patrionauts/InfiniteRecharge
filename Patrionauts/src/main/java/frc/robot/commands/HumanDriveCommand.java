package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A command that allows the driver to take control of driving.
 */
public class HumanDriveCommand extends CommandBase {

  private final DriveSubsystem driveSubsystem;
  private final XboxController gamepad;
  private final Joystick joystick;

  public HumanDriveCommand(DriveSubsystem driveSubsystem, Joystick joystick, XboxController gamepad) {
    this.driveSubsystem = driveSubsystem;
    this.gamepad = gamepad;
    this.joystick = joystick;

    // If we add another subsystem to this command, we must add it to
    // addRequirements.
    addRequirements(driveSubsystem);
  }

  @Override
  public void execute() {
    if (joystick != null) {

      if (joystick.getRawButton(2)) {
        driveSubsystem.getLeftMotor1().set(.5);
        driveSubsystem.getLeftMotor2().set(.5);
      } else {
        driveSubsystem.getLeftMotor1().set(0);
        driveSubsystem.getLeftMotor2().set(0);
      }
    }

    if (gamepad != null) {
      if (Math.abs(gamepad.getRawAxis(1)) > .1 || Math.abs(gamepad.getRawAxis(2)) > .2) {
        driveSubsystem.arcadeDrive(gamepad.getRawAxis(1), gamepad.getRawAxis(2));
      } else {
        driveSubsystem.stop();
      }
    }
  }
}
