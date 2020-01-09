package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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

    if (Math.abs(robotContainer.getJoystick().getTwist()) > .1) {
      robotContainer.getDriveSubsystem().rotation(robotContainer.getJoystick().getTwist());
    } else if (Math.abs(robotContainer.getJoystick().getY()) > .1) {
      robotContainer.getDriveSubsystem().setBase(robotContainer.getJoystick().getY());
    } else {
      robotContainer.getDriveSubsystem().stop();
    }
    
    //robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getJoystick().getRawAxis(2)); // moves using "twist" yaw value
    //robotContainer.getDriveSubsystem().setLeftMotors(robotContainer.getJoystick().getRawAxis(2));

    //robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getGamepad().getRawAxis(3)); // right stick y value
    //robotContainer.getDriveSubsystem().setLeftMotors(-robotContainer.getGamepad().getRawAxis(1)); // left stick y value
    
    //robotContainer.getDriveSubsystem().setRightMotors(robotContainer.getGamepad().getPOV());
    //robotContainer.getDriveSubsystem().setLeftMotors(-robotContainer.getGamepad().getPOV())

  }

}
