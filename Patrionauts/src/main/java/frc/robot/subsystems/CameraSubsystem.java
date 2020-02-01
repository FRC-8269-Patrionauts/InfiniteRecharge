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

  public void enablePowerPortPipeline() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);

  }

  public void disablePowerPortPipeline() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
  }

}