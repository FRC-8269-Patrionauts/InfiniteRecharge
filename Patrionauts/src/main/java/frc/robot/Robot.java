package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveSubsystem;
=======
>>>>>>> bee3e895c14c90907855ea22520ae60595509ee6

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
<<<<<<< HEAD
    base.setRightMotors(m_joystick.getY());
    base.setLeftMotors(-m_joystick.getY());
    

=======
    robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getJoystick().getY());
    robotContainer.getDriveSubsystem().setLeftMotors(-robotContainer.getJoystick().getY());
>>>>>>> bee3e895c14c90907855ea22520ae60595509ee6
  }
}
