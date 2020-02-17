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
    // while (true) {
    //   driveSubsystem.getLeftMotor2().set(.2);
    //   driveSubsystem.getLeftMotor1().set(-driveSubsystem.getLeftMotor2().get());
    // }
    while (true) {
    if (joystick != null) {

      if (Math.abs(joystick.getY()) > .1 || Math.abs(joystick.getTwist()) > .1) {
        driveSubsystem.arcadeDrive(joystick.getY(), joystick.getTwist());
      } else {
        driveSubsystem.stop();
      }
      // if (Math.abs(joystick.getY()) > .1) {
      //   driveSubsystem.getLeftMotor2().set(joystick.getY());
      // }
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
}
