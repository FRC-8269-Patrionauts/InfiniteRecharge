package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * A subsystem that controls shooting a powercell.
 */

 //GOAL: plug in an RPM (on shuffleboard) and the motor will go to it
public class ShootSubsystem extends SubsystemBase {

    private final CANSparkMax flyWheelMotor1 = new CANSparkMax(Constants.FLYWHEEL_MOTOR1, MotorType.kBrushless);
    private final CANSparkMax flyWheelMotor2 = new CANSparkMax(Constants.FLYWHEEL_MOTOR2, MotorType.kBrushless);

    private final CANEncoder flyWheelEncoder1 = flyWheelMotor1.getEncoder();
    private final CANEncoder flyWheelEncoder2 = flyWheelMotor2.getEncoder();

    public ShootSubsystem() {

    }

  //public final PIDController pidShooter = new PIDController(0, 0, 0, flyCanEncoder1);
  public final double shootKp = 0;
  public final double shootKi = 0;
  public final double shootKd = 0;
  public final PIDController shooterPID = new PIDController(shootKp, shootKi, shootKd);

  boolean isRamping = false;
  double calculatedShootPIDValue = 0;

    // public final PIDController pidShooter = new PIDController(0, 0, 0,
    // flyCanEncoder1);

  //counts per second using the getRate() function
  public final double flyCanEncoder1Count = flyCanEncoder1.getRate();
  public final double flyCanEncoder2Count = flyCanEncoder2.getRate();


  //calculate RPM (from: https://www.chiefdelphi.com/t/calculate-velocity-with-encoders/159918/2)
  public final double flyCanEncoder1RPM = flyCanEncoder1Count/countsPerRev
      *(wheelDiameter/gearRatio);
  public final double flyCanEncoder2RPM = flyCanEncoder2Count/countsPerRev
      *(wheelDiameter/gearRatio);

    public final double flyCanEncoder1RPM = flyCanEncoder1Count / countsPerRev * (wheelDiameter / gearRatio);
    public final double flyCanEncoder2RPM = flyCanEncoder2Count / countsPerRev * (wheelDiameter / gearRatio);

  //encoder count per second/#encoder counts per rev*diameter of wheel

  //counts per motor rev = revs of wheel/gearbox ratio

    public void setFlyWheel(double speed) {
        flyWheelMotor1.set(speed);
        flyWheelMotor2.set(-speed);
    }

    public void stopFlyWheel() {
        flyWheelMotor1.set(0);
        flyWheelMotor2.set(0);
    }

    public CANSparkMax getflyWheelMotor1() {
        return flyWheelMotor1;
    }

    public CANSparkMax getflyWheelMotor2() {
        return flyWheelMotor2;
    }

    public CANEncoder getFlyWheelEncoder1() {
        return flyWheelEncoder1;
    }

    public CANEncoder getFlyWheelEncoder2() {
        return flyWheelEncoder2;
    }

  public CANSparkMax getflyWheelMotor2() {
    return flyWheelMotor2;
  }

  public CANEncoder getFlyCanEncoder1() {
    return flyCanEncoder1;
  }

  public CANEncoder getFlyCanEncoder2() {
    return flyCanEncoder2;
  }

  public void setFlyWheel(double speed) {
    flyWheelMotor1.set(speed);
    flyWheelMotor2.set(-speed);
  }

  public void stopFlyWheel() {
    flyWheelMotor1.set(0);
    flyWheelMotor2.set(0);
  }

  public void setGoalRPM(double RPM) {
    /*
    int power;
    //int currentCount = flyCanEncoder1.get();
    //double rate = flyCanEncoder1.getRate();

    setFlyWheel(power);

    flyCanEncoder1.reset();
    flyCanEncoder1.setMinRate(10);
    */
  }

  public void yeet(double RPM) {
    isRamping = true;

    flyCanEncoder1.reset();
    flyCanEncoder2.reset();

    shooterPID.reset();

    shooterPID.enableContinuousInput(0, 6000);
    shooterPID.setTolerance(.01);
  }

  public double getCalculatedShootPIDValue() {
    return calculatedShootPIDValue;
  }

  public PIDController getShooterPIDController() {
    return shooterPID;
  }

        /*
         * flyCanEncoder1.reset(); flyCanEncoder1.setMinRate(10);
         */
    }
}
