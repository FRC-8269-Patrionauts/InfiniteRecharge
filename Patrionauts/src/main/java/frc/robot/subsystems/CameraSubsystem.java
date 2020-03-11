package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {

  public CameraSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void startAutomaticCapture() {
    CameraServer.getInstance().startAutomaticCapture();
  }

  public void enablePipeline() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);

  }

  public void disablePipeline() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
  }

  public void setPowerPortPipeline() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
  }

  public void setTestPipeline() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
  }

  public boolean hasDetectedTarget() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 1;
  }

  public DetectedTarget getDetectedTarget() {
    double area = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    double xOffset = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    double yOffset = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    return new DetectedTarget(xOffset, yOffset, area);
  }

}