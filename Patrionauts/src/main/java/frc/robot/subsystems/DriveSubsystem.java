package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
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
 * TODO(ryssa and alonzo): We may need encoders here, you two should coordinate
 * to figure out how to implement them for this system.
 */
public class DriveSubsystem extends SubsystemBase {

  private final SpeedController leftMotor1 = new PWMVictorSPX(Constants.LEFT_MOTOR_1);
  private final SpeedController leftMotor2 = new PWMVictorSPX(Constants.LEFT_MOTOR_2);
  private final SpeedController rightMotor1 = new PWMVictorSPX(Constants.RIGHT_MOTOR_1);
  private final SpeedController rightMotor2 = new PWMVictorSPX(Constants.RIGHT_MOTOR_2);

  public DriveSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setBase(double speed) {
    leftMotor1.set(speed);
    leftMotor2.set(speed);
    rightMotor1.set(-speed);
    rightMotor2.set(-speed);
  }

  public void setBase(double lM1, double lM2, double rM1, double rM2) {
    leftMotor1.set(lM1);
    leftMotor2.set(lM2);
    rightMotor1.set(rM1);
    rightMotor2.set(rM2);
  }

  public void setLeftPower(double speed) {
    leftMotor1.set(speed);
    leftMotor2.set(speed);
  }

  public void setRightPower(double speed) {
    rightMotor1.set(speed);
    rightMotor2.set(speed);
  }

  
  /*
   * "cleaned up" version of the arcade drive, it alows
   *  us to rotate and go forward and rotate 
   * at the same time and vise versa 
   */

  public void arcadeDrive(double y, double x){    //"cleaned up" version of the arcade drive, it alows us to rotate and go forward and rotate at the same time and vise versa 
    double yValue = y;
    double xValue = -x;
    if (Math.abs(xValue) < 0.2) {
      xValue = 0;
    }
    if (Math.abs(yValue) < 0.2) {
      yValue = 0;
    }
    double leftPower = yValue + xValue;
    double rightPower = yValue - xValue;
    if (leftPower < -1) {
      leftPower = -1;
    } else if (leftPower > 1) {
      leftPower = 1;
    }
    if (rightPower < -1) {
      rightPower = -1;
    }else if (rightPower > 1){
      rightPower = 1;
    }
    setLeftPower(-leftPower);
    setRightPower(rightPower);
  }

  public void Strafe(double x) {   //please for the love of all that is holy stafe with the grace of our permethious
    double xValue = x;
    if (Math.abs(xValue) < 0.2){
      xValue = 0;
    }
      setBase(x, -x, x, -x);

  }
  
  public void rotation(double speed) {
    setBase(-speed,-speed,-speed,-speed);
  }

  public void stop() {
   setBase(0, 0, 0, 0);
  }

  // // autonnomous thingies

  public void setRotation(double speed) {
    setBase(speed);
    // leftMotor1.set(speed);
    // leftMotor2.set(speed);
    // rightMotor1.set(speed);
    // rightMotor2.set(speed);
  }

  public void setRightTurn(double speed) {
    setBase(speed);
    // leftMotor1.set(-speed);
    // leftMotor2.set(-speed);
    // rightMotor1.set(0);
    // rightMotor2.set(0);
  }

  public void setLeftTurn(double speed) {
    setBase(speed);
    // leftMotor1.set(0);
    // leftMotor2.set(0);
    // rightMotor1.set(speed);
    // rightMotor2.set(speed);
  }

  public SpeedController getLeftMotor1(){
    return leftMotor1;
  }public SpeedController getLeftMotor2(){
    return leftMotor2;
  }public SpeedController getRightMotor1(){
    return rightMotor1;
  }public SpeedController getRightMotor2(){
    return rightMotor2;
  }


  public double getLeftMotor1Speed() {
    return leftMotor1.get();
  }

  public double getLeftMotor2Speed() {
    return leftMotor2.get();
  }

  public double getRightMotor1Speed() {
    return rightMotor1.get();
  }

  public double getRightMotor2Speed() {
    return rightMotor2.get();
  }

  public double[] getSpeeds() {
    return new double[] { getLeftMotor1Speed(), getLeftMotor2Speed(), getRightMotor1Speed(), getRightMotor2Speed() };
  }

}
