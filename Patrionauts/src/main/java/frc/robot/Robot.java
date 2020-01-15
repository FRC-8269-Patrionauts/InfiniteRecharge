package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation.
 */
public class Robot extends TimedRobot {

  private final RobotContainer robotContainer = new RobotContainer();
  private AutonomousCommand autonomousCommand;

  @Override
  public void autonomousInit() {
    autonomousCommand = robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    robotContainer.getHumanDriveCommand().schedule();
  }

  @Override
  public void teleopPeriodic() {

    SmartDashboard.putNumber("Joystick Twist", robotContainer.getJoystick().getTwist());
    SmartDashboard.putNumber("Joystick Y", robotContainer.getJoystick().getY());
    
    // if (Math.abs(robotContainer.getJoystick().getTwist()) > .1) {
    //   robotContainer.getDriveSubsystem().rotation(-robotContainer.getJoystick().getTwist());
    // } else if (Math.abs(robotContainer.getJoystick().getY()) > .1) {
    //   robotContainer.getDriveSubsystem().setBase(robotContainer.getJoystick().getY());
    // } else {
    //   robotContainer.getDriveSubsystem().stop();
    // }
   
    if (Math.abs(robotContainer.getJoystick().getY()) > .2 || Math.abs(robotContainer.getJoystick().getTwist()) > .2) {
      robotContainer.getDriveSubsystem().arcadeDrive(robotContainer.getJoystick().getY(), robotContainer.getJoystick().getTwist());
  } else if (Math.abs(robotContainer.getJoystick().getX()) > .2) {
      robotContainer.getDriveSubsystem().Strafe(robotContainer.getJoystick().getX());
} else {
  robotContainer.getDriveSubsystem().stop();
}
}
}