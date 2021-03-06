/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private Command m_autonomousCommand;
  private Command driveCommand;

  private RobotContainer robotContainer;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    robotContainer = new RobotContainer();
    robotContainer.getDriveSubsystem().setPower(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // robotContainer.getDriveSubsystem().getLeftMotor2().set(.2);
    // robotContainer.getDriveSubsystem().getRightMotor2().set(.2);

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    driveCommand = robotContainer.getDriveCommand();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    if (driveCommand != null) {
      // driveCommand.schedule();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    if (robotContainer.getJoystick().getRawButton(3)) {
      robotContainer.getDriveSubsystem().getFlyMotor1().set(.1);
    }
    if (robotContainer.getJoystick().getRawButton(7)) {
      robotContainer.getDriveSubsystem().setPower(0);
    }

    if (robotContainer.getJoystick().getRawButton(8)) {
      robotContainer.getDriveSubsystem().setPower(0.15);
    }

    if (robotContainer.getJoystick().getRawButton(9)) {
      robotContainer.getDriveSubsystem().setPower(0.25);
    }

    if (robotContainer.getJoystick().getRawButton(10)) {
      robotContainer.getDriveSubsystem().setPower(0.35);
    }

    if (robotContainer.getJoystick().getRawButton(11)) {
      robotContainer.getDriveSubsystem().setPower(0.45);
    }

    if (robotContainer.getJoystick().getRawButton(12)) {
      robotContainer.getDriveSubsystem().setPower(0.50);
    }

    robotContainer.getDriveSubsystem().getFlyMotor1().set(robotContainer.getDriveSubsystem().getPower());
    robotContainer.getDriveSubsystem().getFlyMotor2().set(-robotContainer.getDriveSubsystem().getPower());
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
