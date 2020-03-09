package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;

public class TiltPIDToggle extends InstantCommand {

    boolean run = true;
    private final IntakeSubsystem tilt;

    public TiltPIDToggle(IntakeSubsystem tilt) {
        this.tilt = tilt;
        addRequirements(tilt);
    }

    @Override
    public void initialize() {
        if (run == true) {
            tilt.tiltToShoot(10);
            run = false;
        } else {
            tilt.tiltToBottom(10);
            run = true;
        }
    }

}
