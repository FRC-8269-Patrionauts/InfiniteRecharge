package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A command that puts the robot in full autonomous mode.
 */
public class TestEncoderAutoCommand extends CommandBase {

    private final DriveSubsystem drive;
    public static final double wheelDiameter = 6;
    public static final double pulsePerRevolution = 360;
    public static final double encoderGearRatio = 3;
    public static final double gearRatio = 64.0/20.0;
    public static final double Fudgefactor = 1.0;
  
    private final Timer timer = new Timer();

    public TestEncoderAutoCommand(DriveSubsystem drive) {
        this.drive = drive;
        
        // If we add another subsystem to this command, we must add it to
        // addRequirements.
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        //final double distancePerPulse = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / 
        //ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;

        timer.reset();
        timer.start();
        drive.arcadeDrive(0.5, 0);
    }

    @Override
    public void execute() {
        // drive.arcadeDrive(0.5, 0);
    }

    public void phaseOne() {
        drive.arcadeDrive(.4, 0);
    }

    public void phaseTwo() {
        drive.arcadeDrive(0, .4);
    }

    public void phaseThree() {
        drive.arcadeDrive(0, -.4);
    }

    public void phaseFour() {
        drive.stop();
    }

    public double getCurrentTime() {
        return Timer.getFPGATimestamp();
    }
}