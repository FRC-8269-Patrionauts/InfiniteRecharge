package frc.robot.subsystems;

import javax.swing.JOptionPane;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A subsystem that controls driving the robot.
 * 
 * TODO(alfonzo): Implement the DriveSubsystem. This class was originally named
 * Movement in the design doc, but is now named DriveSubsystem.
 * 
 * Take a look at this example:
 * https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/motorcontrol/Robot.java
 * 
 * Things to consider:
 * 
 * - You may need SpeedControllers for each of the motors
 * 
 * - The autonomous mode may need to use the drive subsystem to turn left or
 * right
 * 
 * - The teleop mode may need to control the drive subsystem using joystick or
 * gamepad inputs
 * 
 * - The drive subsystem may need make sure that the movement is smooth.
 * 
 * TODO(ryssa and alfonzo): We may need encoders here, you two should coordinate to figure out
 * how to implement them for this system.
 */
public class DriveSubsystem extends SubsystemBase {
  private final SpeedController leftMotor1 = new PWMVictorSPX(12);
  private final SpeedController leftmotor2 = new PWMVictorSPX(13);
  private final SpeedController rightMotor1 = new PWMVictorSPX(14);
  private final SpeedController rightMotor2 = new PWMVictorSPX(15);

  public DriveSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setLeftMotors (double speed) {
    leftMotor1.set(speed);
    leftmotor2.set(speed);
  }

  public void setRightMotors(double speed) {
    rightMotor1.set(speed);
    rightMotor2.set(speed);
  }





}
