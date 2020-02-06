package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DetectedTarget {
 /*  double kpAim = -0.1;
  double kpDistance = -0.1;
  double minAimCommand = 0.05;
  double headingError = -getXOffset();
  double distanceError = -getYOffset();
  double steeringAdjust = 0.0;
  */
  private final double xOffset;
  private final double yOffset;
  private final double area;

public DetectedTarget(double xOffset, double yOffset, double area){
  this.xOffset = xOffset;
  this.yOffset = yOffset;
  this.area = area;
}

//  public DetectedTarget() {
//  }

public double getXOffset() {
  return xOffset;
}

public double getYOffset() {
  return yOffset;
}

public double getArea() {
  return area;
}
 // @Override
 /* public void periodic() {

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

  */

}