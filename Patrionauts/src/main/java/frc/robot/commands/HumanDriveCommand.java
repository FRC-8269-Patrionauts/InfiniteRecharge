package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A command that allows the driver to take control of driving.
 * 
 * This should be used as the default command for the {@link DriveSubsystem}.
 * When this command is executing, the Joystick or Gamepad should be sending
 * inputs to the {@link DriveSubsystem} to move the robot.
 * 
 * TODO(jacob): Coordinate with Alonzo for the following:
 * 
 * - We need to read input from the Joystick or Gamepad controller whenever
 * execute is called. We need to call the DriveSubsystems methods with that
 * data. What should that method be named, and what arguments should we send it.
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
      
      if (joystick.getRawButton(2)){
      driveSubsystem.setSpeed(((-joystick.getThrottle() + 1) / 2));
      }
      if (Math.abs(joystick.getY()) > .1 || Math.abs(joystick.getTwist()) > .1) {
        driveSubsystem.arcadeDrive(joystick.getY(), joystick.getTwist());
      } else {
        driveSubsystem.stop();
      }
    } else if (gamepad != null) {
      if (Math.abs(gamepad.getRawAxis(1)) > .1 || Math.abs(gamepad.getRawAxis(2)) > .1) {
        driveSubsystem.arcadeDrive(gamepad.getRawAxis(1), gamepad.getRawAxis(2));
      } else {
        driveSubsystem.stop();
      }
    
      }
    }
  }

