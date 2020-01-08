package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

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
    robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getJoystick().getY());
    robotContainer.getDriveSubsystem().setLeftMotors(-robotContainer.getJoystick().getY());
  }
}
