package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakePneumaticSubsystem;

public class SetIntakeRollerCommand extends InstantCommand{
    private final IntakePneumaticSubsystem intakePneumatics;

    boolean boop = true;

    public SetIntakeRollerCommand(IntakePneumaticSubsystem intakeSolenoids){
        this.intakePneumatics = intakeSolenoids;
        addRequirements(intakeSolenoids);
    }

    @Override
    public void initialize() {
        if (boop == true){
            intakePneumatics.setDownIntake();
            boop = false;
        } else {
            boop = true;
            intakePneumatics.setUpIntake();
        }

    }

}