package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class pidTurningCommand extends  PIDSubsystem {

  

    public pidTurningCommand() {

        super(new PIDController(DriveSubsystem.turnKp, DriveSubsystem.turnKi, DriveSubsystem.kD));
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