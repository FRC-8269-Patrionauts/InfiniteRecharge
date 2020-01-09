package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation.
 */
public class Robot extends TimedRobot {
  private final RobotContainer robotContainer = new RobotContainer();

  @Override
  public void robotInit() {
  }
  // please god oh mighty, let this bot move with the swifthness as that of one
  // graced by your hand
  @Override
  public void teleopPeriodic() {

    robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getJoystick().getY()); // moves using y value of joystick
    robotContainer.getDriveSubsystem().setLeftMotors(-robotContainer.getJoystick().getY());

    i

    //robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getJoystick().getRawAxis(2)); // moves using "twist" yaw value
    //robotContainer.getDriveSubsystem().setLeftMotors(robotContainer.getJoystick().getRawAxis(2));

    //robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getGamepad().getRawAxis(3)); // right stick y value
    //robotContainer.getDriveSubsystem().setLeftMotors(-robotContainer.getGamepad().getRawAxis(1)); // left stick y value

  }
}
