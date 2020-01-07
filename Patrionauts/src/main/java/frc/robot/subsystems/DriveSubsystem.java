package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Controller;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.spline.Spline.ControlVector;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * A subsystem that controls driving the robot.
 * 
 * TODO(alonzo): Implement the DriveSubsystem. This class was originally named
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
 * TODO(ryssa and alonzo): We may need encoders here, you two should coordinate to figure out
 * how to implement them for this system.
 */
public class DriveSubsystem {
  private final PWMVictorSPX leftMotor1 = new PWMVictorSPX(Constants.LEFT_MOTOR_1);
  private final PWMVictorSPX leftMotor2 = new PWMVictorSPX(Constants.LEFT_MOTOR_2);
  private final PWMVictorSPX rightMotor1 = new PWMVictorSPX(Constants.RIGHT_MOTOR_1);
  private final PWMVictorSPX rightMotor2 = new PWMVictorSPX(Constants.RIGHT_MOTOR_2);

  public DriveSubsystem() {

  }


}
