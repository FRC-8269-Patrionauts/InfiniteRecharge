// package frc.robot.pathfollow;

// import java.io.IOException;

// import edu.wpi.first.wpilibj.AnalogGyro;
// import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.Notifier;
// import edu.wpi.first.wpilibj.Spark;
// import frc.robot.subsystems.DriveSubsystem;
// import jaci.pathfinder.Pathfinder;
// import jaci.pathfinder.PathfinderFRC;
// import jaci.pathfinder.Trajectory;
// import jaci.pathfinder.followers.EncoderFollower;

// public class PathFollower {

//     private static final int TICKS_PER_REVOLUTION = 0;
//     private static final double WHEEL_DIAMETER = 0;
//     private static final double MAX_VELOCITY = 0;

//     private final DriveSubsystem driveSubsystem;

//     private EncoderFollower leftFollower;
//     private EncoderFollower rightFollower;
//     private Notifier followerNotifier;

//     public PathFollower(DriveSubsystem driveSubsystem) {
//         this.driveSubsystem = driveSubsystem;
//     }

//     public void followPathRedInitToTarget() {
//         followPath("red_init_to_target");
//     }

//     public void stopFollowing() {
//         if (followerNotifier != null) {
//             followerNotifier.stop();
//         }
//     }

//     private void followPath(String pathName) {
//         try {
//             Trajectory leftTrajectory = PathfinderFRC.getTrajectory(pathName + ".left");
//             Trajectory rightTrajectory = PathfinderFRC.getTrajectory(pathName + ".right");

//             leftFollower = new EncoderFollower(leftTrajectory);
//             rightFollower = new EncoderFollower(rightTrajectory);

//             leftFollower.configureEncoder(getLeftEncoder().get(), TICKS_PER_REVOLUTION, WHEEL_DIAMETER);
//             // TODO: You must tune the PID values on the following line!
//             leftFollower.configurePIDVA(1.0, 0.0, 0.0, 1 / MAX_VELOCITY, 0);

//             rightFollower.configureEncoder(getRightEncoder().get(), TICKS_PER_REVOLUTION, WHEEL_DIAMETER);
//             // TODO: You must tune the PID values on the following line!
//             rightFollower.configurePIDVA(1.0, 0.0, 0.0, 1 / MAX_VELOCITY, 0);

//             followerNotifier = new Notifier(this::calculateAndSetMotors);
//             followerNotifier.startPeriodic(leftTrajectory.get(0).dt);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private void calculateAndSetMotors() {
//         if (leftFollower.isFinished() || rightFollower.isFinished()) {
//             stopFollowing();
//         } else {
//             double left_speed = leftFollower.calculate(getLeftEncoder().get());
//             double right_speed = rightFollower.calculate(getRightEncoder().get());
//             double heading = getGyro().getAngle();
//             double desired_heading = Pathfinder.r2d(leftFollower.getHeading());
//             double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
//             double turn = 0.8 * (-1.0 / 80.0) * heading_difference;

//             getLeftMotor().set(left_speed + turn);
//             getRightMotor().set(right_speed - turn);
//         }
//     }

//     // TODO: Implement this method.
//     private Spark getLeftMotor() {
//         return false;
//     }

//     // TODO: Implement this method.
//     private Spark getRightMotor() {
//         return null;
//     }

//     // TODO: Implement this method.
//     private Encoder getLeftEncoder() {
//         return null;
//     }

//     // TODO: Implement this method.
//     private Encoder getRightEncoder() {
//         return null;
//     }

//     // TODO: Implement this method.
//     private AnalogGyro getGyro() {
//         return null;
//     }

// }