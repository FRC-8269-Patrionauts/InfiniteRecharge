package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class pidTurningCommand extends  PIDSubsystem {

    DriveSubsystem driveSubsystem;

    public pidTurningCommand(DriveSubsystem driveSubsystem) {
        super(new PIDController(driveSubsystem.turnKp, driveSubsystem.turnKi, driveSubsystem.turnKd));
        this.driveSubsystem = driveSubsystem;
        //super(new PIDController(driveSubsystem.turnKp, driveSubsystem.turnKi, driveSubsystem.turnKd);
        //super(new PIDController(0.05, 0.1, 0);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void useOutput(double output, double setpoint) {
        // TODO Auto-generated method stub

    }

    @Override
    protected double getMeasurement() {
        // TODO Auto-generated method stub
        return 0;
    }

}