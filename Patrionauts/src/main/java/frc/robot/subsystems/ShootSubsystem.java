package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * A subsystem that controls shooting a powercell.
 * 
 * TODO(ryssa): Start planning out this subsystem, and the encoders/motors that
 * we'll need for this. You should implement this system.
 */
public class ShootSubsystem extends SubsystemBase {

  private final CANSparkMax flyWheelMotor1 = new CANSparkMax(Constants.FLYWHEEL_MOTOR1, MotorType.kBrushless);
  private final CANSparkMax flyWheelMotor2 = new CANSparkMax(Constants.FLYWHEEL_MOTOR2, MotorType.kBrushless);

  private final CANEncoder flyCanEncoder1 = flyWheelMotor1.getEncoder();
  private final CANEncoder flyCanEncoder2 = flyWheelMotor2.getEncoder();

  private final SpeedControllerGroup flyWheel1 = new SpeedControllerGroup(flyWheelMotor1);
  private final SpeedControllerGroup flyWheel2 = new SpeedControllerGroup(flyWheelMotor2);

  public ShootSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run


  }

  public void setFlyWheel (double speed){
    flyWheelMotor1.set(.5);
    flyWheelMotor2.set(-.5);
  }

  public void stopFlyWheel (){
    flyWheelMotor1.set(0);
    flyWheelMotor2.set(0);
  }

}
