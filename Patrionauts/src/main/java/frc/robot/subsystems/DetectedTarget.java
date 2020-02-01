package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DetectedTarget extends SubsystemBase {
  double kpAim = -0.1;
  double kpDistance = -0.1;
  double minAimCommand = 0.05;
  double headingError = -getXOffset();
  double distanceError = -getYOffset();
  double steeringAdjust = 0.0;

  @Override
  public void periodic() {

    if (getXOffset() > 1.0) {
      steeringAdjust = kpAim * headingError - minAimCommand;
    } else if (getXOffset() < 1.0) {
      steeringAdjust = kpAim * headingError + minAimCommand;
    }

    double distanceAdjust = kpDistance * distanceError;
    // HOW DO YOU CONTROL LEFT AND RIGHT SIDES FROM HERE?!?!?!??!!?
    // left_command += steeringAdjust + distanceAdjust;
    // right_command -= steeringAdjust + distanceAdjust;

  }

  public double getArea() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
  }

  public double getXOffset() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
  }

  public double getYOffset() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
  }

  public boolean hasDetectedTarget() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 1;
  }

}