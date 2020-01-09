package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
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
 * execute is called. We need to call the DriveSubsystems methods with that data.
 * What should that method be named, and what arguments should we send it.
 */
public class HumanDriveCommand extends CommandBase {

  private final DriveSubsystem drive;
  //private final XboxController gamepad;
  private final Joystick joystick;

  public HumanDriveCommand(DriveSubsystem drive, Joystick joystick) {
    this.drive = drive;
    //this.gamepad = gamepad;
    this.joystick = joystick;
    // If we add another subsystem to this command, we must add it to
    // addRequirements.
    addRequirements(drive);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  }

  public void drive(double speed) {
    drive.setBase(speed);
  }

  public void rotate(double speed) {
    drive.rotation(speed);
  }

  public void stop(){
    drive.stop();
  }
}
