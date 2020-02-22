package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.HumanDriveCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation.
 */
public class Robot extends TimedRobot {

    private final RobotContainer robotContainer = new RobotContainer();
    private AutonomousCommand autonomousCommand;
    private HumanDriveCommand humanDriveCommand;

    @Override
    public void robotInit() {
        LiveWindow.disableAllTelemetry();
        robotContainer.getImu().reset();
    }

    @Override
    public void robotPeriodic() {
        try {
            CommandScheduler.getInstance().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = robotContainer.getAutonomousCommand();
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
        
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }
}
