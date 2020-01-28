package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
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
    //if (joystick != null) {

      if (Math.abs(joystick.getY()) > .1) {
        driveSubsystem.setNeoMovment(joystick.getY() / 2);
    } else if (Math.abs(joystick.getTwist()) > .1){
        driveSubsystem.setNeoTurning(joystick.getTwist() / 2);
    } else {
      driveSubsystem.setNeoTurning(0);
      driveSubsystem.setNeoMovment(0);
    }



    //   if (Math.abs(joystick.getY()) > .1 || Math.abs(joystick.getTwist()) > .1) {
    //     if (Math.abs(joystick.getTwist()) > .1) {
    //       driveSubsystem.arcadeDrive(joystick.getY(), joystick.getTwist());
    //     } else {
    //       driveSubsystem.arcadeDrive(joystick.getY(), 0);
    //     }
    //   } else {
    //     driveSubsystem.stop();
    //   }
    // } 

    
    if (gamepad != null) {
      if (Math.abs(gamepad.getRawAxis(1)) > .1 || Math.abs(gamepad.getRawAxis(2)) > .2) {
        driveSubsystem.arcadeDrive(gamepad.getRawAxis(1), gamepad.getRawAxis(2));
      } else {
        driveSubsystem.stop();
      }
    }
  }
}
