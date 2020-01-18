package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.HumanDriveCommand;
import frc.robot.commands.SmartDashboardCommand;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation.
 */
public class Robot extends TimedRobot {

  private final RobotContainer robotContainer = new RobotContainer();
  private AutonomousCommand autonomousCommand;
  private HumanDriveCommand humanDriveCommand;
  private SmartDashboardCommand smartDashboardCommand = new SmartDashboardCommand(robotContainer, robotContainer.getCameraSubsystem();

  @Override
  public void robotInit() {
    smartDashboardCommand.addCamera();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

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
    humanDriveCommand = robotContainer.getHumanDriveCommand();
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    if (humanDriveCommand != null) {
      humanDriveCommand.schedule();
    }
  }

  @Override
  public void teleopPeriodic() {

    smartDashboardCommand.addDrive();
    smartDashboardCommand.addGamepad();
    smartDashboardCommand.addJoystick();

  }
}
