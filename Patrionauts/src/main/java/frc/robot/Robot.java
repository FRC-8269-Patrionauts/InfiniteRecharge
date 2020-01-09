/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together.
 */
public class Robot extends TimedRobot {
  private static final int rightMotor1Port = 0;
  private static final int rightMotor2Port = 1;
  private static final int leftMotor1Port = 2;
  private static final int leftMotor2Port = 3;  
  private static final int kJoystickPort = 1;

  private SpeedController rightMotor1;
  private SpeedController rightMotor2;
  private SpeedController leftMotor1;
  private SpeedController leftMotor2;

  private Joystick m_joystick;
  

  @Override
  public void robotInit() {
    rightMotor1 = new PWMVictorSPX(rightMotor1Port);
    rightMotor2 = new PWMVictorSPX(rightMotor2Port);
    leftMotor1 = new PWMVictorSPX(leftMotor1Port);
    leftMotor2 = new PWMVictorSPX(leftMotor2Port);
    m_joystick = new Joystick(kJoystickPort);
  }

  @Override
  public void autonomousInit() {
    rightMotor1.set(1);
    rightMotor2.set(1);
    leftMotor1.set(1);
    leftMotor2.set(1);
    
  }
  @Override
  public void teleopPeriodic() {
    rightMotor1.set(1);
    rightMotor2.set(1);
    leftMotor1.set(1);
    leftMotor2.set(1);

    //SmartDashboard.putString("Motor Value: ", rightMotor)
  }
}