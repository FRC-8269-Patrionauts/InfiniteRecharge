package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

/**
 * A subsystem that controls shooting a powercell.
 */

// GOAL: plug in an RPM (on shuffleboard) and the motor will go to it
public class ShootSubsystem extends SubsystemBase {

    private final CANSparkMax flyWheelMotor1 = new CANSparkMax(Constants.FLYWHEEL_MOTOR1, MotorType.kBrushless);
    //private final CANSparkMax flyWheelMotor2 = new CANSparkMax(Constants.FLYWHEEL_MOTOR2, MotorType.kBrushless);

    private final CANEncoder flyWheelEncoder1 = flyWheelMotor1.getEncoder();
    //private final CANEncoder flyWheelEncoder2 = flyWheelMotor2.getEncoder();

    public final double shootKp1 = 0;
    public final double shootKi1 = 0;
    public final double shootKd1 = 0;
    public final PIDController pidShooter1 = new PIDController(shootKp1, shootKi1, shootKd1);


    public final double shootKp2 = 0;
    public final double shootKi2 = 0;
    public final double shootKd2 = 0;
    public final PIDController pidShooter2 = new PIDController(shootKp2, shootKi2, shootKd2);

    public double flyWheelEncoder1RPM = 0;
    public double flyWheelEncoder2RPM = 0;

    boolean isRamping = false;
    double calculatedShootPIDValue1 = 0;
    double calculatedShootPIDValue2 = 0;

    double currentSpeed1 = 0;
    double currentSpeed2 = 0;


    public ShootSubsystem() {

    }


    @Override
    public void periodic() {
        if (isRamping) {
            //double flyWheelEncoder1RPM = flyWheelEncoder1.getVelocity();
            //double flyWheelEncoder2RPM = flyWheelEncoder2.getVelocity();

            calculatedShootPIDValue1 = pidShooter1.calculate(flyWheelEncoder1.getVelocity());
            //calculatedShootPIDValue2 = pidShooter2.calculate(flyWheelEncoder2.getVelocity());

            calculatedShootPIDValue1 = MathUtil.clamp(calculatedShootPIDValue1, -.5, .5);
            calculatedShootPIDValue2 = MathUtil.clamp(calculatedShootPIDValue2, -.5, .5);

            currentSpeed1 += calculatedShootPIDValue1;
            currentSpeed2 += calculatedShootPIDValue2;
            
            currentSpeed1 = MathUtil.clamp(currentSpeed1, -.5, .5);
            currentSpeed2 = MathUtil.clamp(currentSpeed2, -.5, .5);
            System.out.println("Current Speed 1:" + currentSpeed1 );

            flyWheelMotor1.set(currentSpeed1);
           // flyWheelMotor2.set(currentSpeed2);

            if (pidShooter1.atSetpoint() /*&& pidShooter2.atSetpoint()*/) {
                isRamping = false;
            }
        }
    }

    public void setFlyWheel(double speed) {
        flyWheelMotor1.set(-speed);
        //flyWheelMotor2.set(-speed);
    }

    public void stopFlyWheel() {
        flyWheelMotor1.set(0);
       // flyWheelMotor2.set(0);
    }

    public void yeet1(double RPM) {
        isRamping = true;
        pidShooter1.setSetpoint(RPM);
        currentSpeed1 = 0;
    }

    public void yeet2(double RPM) {
        isRamping = true;
        pidShooter2.setSetpoint(RPM);
        currentSpeed2 = 0;
    }

    //NEED
    //periodic, current RPM, goal RPM, take output of periodic loop and set that to motor controllers, ask it if we're done
    //also look at turn method and compare how it works

    //call pid controller, get output of pid controller and send to motor
    //Every time we do a periodic, we use the output and send it to the motor controller

    public double getCalculatedShootPIDValue1() {
        return calculatedShootPIDValue1;
    }

    public double getCalculatedShootPIDValue2() {
        return calculatedShootPIDValue2;
    }

    public double getCurrentSpeed1() {
        return currentSpeed1;
    }

    public double getCurrentSpeed2() {
        return currentSpeed2;
    }

    public PIDController getShooterPIDController1() {
        return pidShooter1;
    }

    public PIDController getShooterPIDController2() {
        return pidShooter2;
    }


    public CANSparkMax getFlyWheelMotor1() {
        return flyWheelMotor1;
    }

    /*public CANSparkMax getFlyWheelMotor2() {
       // return flyWheelMotor2;
    }
    */

    public CANEncoder getFlyWheelEncoder1() {
        return flyWheelEncoder1;
    }

    /*public CANEncoder getFlyWheelEncoder2() {
        //return flyWheelEncoder2;
    }
    */


}
