package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticSubsystem;

public class PneumaticsCommand extends CommandBase {
    private final PneumaticSubsystem solenoidSubsystem;

    public PneumaticsCommand(PneumaticSubsystem solenoidSubsystem){
        this.solenoidSubsystem = solenoidSubsystem;
        addRequirements(solenoidSubsystem);
    }

    @Override
    public void initialize (){
    }
    @Override
    public void execute() {
        solenoidSubsystem.setVar(true);
        while (true) {
            solenoidSubsystem.getSolenoid().set(true);
        }
    }
}