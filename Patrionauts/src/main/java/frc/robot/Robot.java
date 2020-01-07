package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation.
 */
public class Robot extends TimedRobot {
  private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;

  private SpeedController m_motor;
  private Joystick m_joystick;

  private final DriveSubsystem base = new DriveSubsystem();
  

  @Override
  public void robotInit() {
    m_motor = new PWMVictorSPX(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
  }
//please god oh mighty, let this bot move with the swifthness as that of one graced by your hand
  @Override
  public void teleopPeriodic() {
    base.setRightMotors(m_joystick.getY());
    base.setLeftMotors(-m_joystick.getY());

  }
}
}
