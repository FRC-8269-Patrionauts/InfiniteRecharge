/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {

  private final CANSparkMax leftMotor2 = new CANSparkMax(Constants.LEFT_MOTOR_2, MotorType.kBrushless);
  private final CANSparkMax leftMotor1 = new CANSparkMax(Constants.LEFT_MOTOR_1, MotorType.kBrushless);
  private final CANSparkMax rightMotor1 = new CANSparkMax(Constants.RIGHT_MOTOR_1, MotorType.kBrushless);
  private final CANSparkMax rightMotor2 = new CANSparkMax(Constants.RIGHT_MOTOR_2, MotorType.kBrushless);

  private final CANEncoder leftMotor1Encoder = leftMotor1.getEncoder();
  private final CANEncoder leftMotor2Encoder = leftMotor2.getEncoder();
  private final CANEncoder rightMotor1Encoder = rightMotor1.getEncoder();
  private final CANEncoder rightMotor2Encoder = rightMotor2.getEncoder();

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  public DriveSubsystem() {
    
    rightMotor1.follow(rightMotor2, false);
    leftMotor1.follow(leftMotor2, false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double x, double z) {
    drive.arcadeDrive(x, z);
  }

  public CANSparkMax getLeftMotor1() {
    return leftMotor1;
  }

  /**
   * @return the leftMotor2
   */
  public CANSparkMax getLeftMotor2() {
    return leftMotor2;
  }

  /**
   * @return the rightMotor1
   */
  public CANSparkMax getRightMotor1() {
    return rightMotor1;
  }

  /**
   * @return the leftMotor2
   */
  public CANSparkMax getRightMotor2() {
    return rightMotor2;
  }


  public CANEncoder getLeftMotor1Encoder() {
    return leftMotor1Encoder;
  }

  public CANEncoder getLeftMotor2Encoder() {
    return leftMotor2Encoder;
  }

  public CANEncoder getRightMotor1Encoder() {
    return rightMotor1Encoder;
  }

  public CANEncoder getRightMotor2Encoder() {
    return rightMotor2Encoder;
  }

  public DifferentialDrive getDrive() {
    return drive;
  }
  
}
