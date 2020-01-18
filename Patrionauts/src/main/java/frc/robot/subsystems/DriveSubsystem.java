package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

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

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  
  private double goalSpeedlM1 = 0;
  private double goalSpeedlM2 = 0;
  private double goalSpeedrM1 = 0;
  private double goalSpeedrM2 = 0;

  private double currentSpeedlM1 = 0;
  private double currentSpeedlM2 = 0;
  private double currentSpeedrM1 = 0;
  private double currentSpeedrM2 = 0;
  
  double speedMult = 1;
  public DriveSubsystem(){
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //leftMotor1
    if (goalSpeedlM1 > currentSpeedlM1){
      currentSpeedlM1 += .02;
    }else if (goalSpeedlM1 < currentSpeedlM1){
      currentSpeedlM1 -= .02;
    }
     if (currentSpeedlM1 > 1){
       currentSpeedlM1 = 1;
     }else if (currentSpeedlM1 < -1){
       currentSpeedlM1 = -1;
     }
    leftMotor1.set(currentSpeedlM1);

    //leftMotor2
    if (goalSpeedlM2 > currentSpeedlM2){
      currentSpeedlM2 += .02;
    }else if (goalSpeedlM2 < currentSpeedlM2){
      currentSpeedlM2 -= .02;
    }
    if (currentSpeedlM2 > 1){
      currentSpeedlM2 = 1;
    }else if (currentSpeedlM2 < -1){
      currentSpeedlM2 = -1;
    }
    leftMotor2.set(currentSpeedlM2);

    //rightMotor1
    if (goalSpeedrM1 > currentSpeedrM1){
      currentSpeedrM1 += .02;
    }else if (goalSpeedrM1 < currentSpeedrM1){
      currentSpeedrM1 -= .02;
    }
    if (currentSpeedrM1 > 1){
      currentSpeedrM1 = 1;
    }else if (currentSpeedrM1 < -1){
      currentSpeedrM1 = -1;
    }
    rightMotor1.set(currentSpeedrM1);

    //rightMotor2
    if (goalSpeedrM2 > currentSpeedrM2){
      currentSpeedrM2 += .02;
    }else if (goalSpeedrM2 < currentSpeedrM2){
      currentSpeedrM2 -= .02;
    }
    if (currentSpeedrM2 > 1){
      currentSpeedrM2 = 1;
    }else if (currentSpeedrM2 < -1){
      currentSpeedrM2 = -1;
    }
    rightMotor2.set(currentSpeedrM2);
  }
  public void setBase(double lM1, double lM2, double rM1, double rM2) {
    goalSpeedlM1 = lM1;
    goalSpeedlM2 = lM2;
    goalSpeedrM1 = -rM1;
    goalSpeedrM2 = -rM2;
    //leftMotor1.set(lM1*speedMult);
    //leftMotor2.set(lM2*speedMult);
    //rightMotor1.set(rM1*speedMult);
    //rightMotor2.set(rM2*speedMult);
  }

  public void arcadeDrive(double x, double z){ 
    //drive.arcadeDrive(x * speedMult, z * speedMult);
    goalSpeedlM1 = x;
    goalSpeedlM2 = x;
    goalSpeedrM1 = -x;
    goalSpeedrM2 = -x;
  }

  public void strafe(double x) {   //please for the love of all that is holy stafe with the grace of our permethious
    double xValue = x;
    if (Math.abs(xValue) < .5){
      xValue = 0;
    }
      setBase(x, -x, x, -x);
  }
  public void setBaseAll(double speed){
    setBase(-speed,-speed,speed,speed);
  }

  public void spin180(double speed){
    // we need encoders
  }
  
  public void rotation(double speed) {
    setBase(-speed,-speed,-speed,-speed);
  }

  public void stop() {
    setBase(0, 0, 0, 0);
  }

  public void Limit(){//idk man
    setBase(.2,.2,.2,.2);
  }

  public void setSpeed(double speed){
    this.speedMult = speed;
  }
  // autonnomous thingies


  public SpeedController getLeftMotor1(){
    return leftMotor1;
  }
  public SpeedController getLeftMotor2(){
    return leftMotor2;
  }
  public SpeedController getRightMotor1(){
    return rightMotor1;
  }
  public SpeedController getRightMotor2(){
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
