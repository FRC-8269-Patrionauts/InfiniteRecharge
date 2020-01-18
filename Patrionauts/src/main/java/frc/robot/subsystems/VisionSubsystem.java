package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A subsystem for modifying and reading data from the camera.
 *
 * This class was originally named LimeLight in the design doc, but has been
 * renamed to CameraSubsystem.
 *
 * TODO(Tyla): Implement this camera subsystem. This class should contain all of
 * the methods needed for autonomous mode to figure out where the target is, by
 * reading the data from LimeLight.
 *
 * Things to consider:
 *
 * - What methods do we need to find the X and Y location of the target.
 *
 * - We need some way to toggle off the LEDs and disable all filtering. We'll
 * need to disable all filtering if we want the driver to be able to see
 * clearly.
 *
 * - We need to send picture data to the dashboard. This subsystem should
 * automatically be sending that data.
 */
public class VisionSubsystem extends SubsystemBase {

  public VisionSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
