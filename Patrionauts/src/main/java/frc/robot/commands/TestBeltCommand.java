package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ShootSubsystem;

public class TestBeltCommand extends InstantCommand{
    private final ShootSubsystem beltSubsystem;

    boolean feed = true;

    public TestBeltCommand (ShootSubsystem beltSubsystem){
        this.beltSubsystem = beltSubsystem;
        addRequirements(beltSubsystem);
    }

    @Override
    public void initialize() {
        if (feed == true){
            beltSubsystem.feedBall(.4);
            feed = false;
        } else {
            feed = true;
            beltSubsystem.feedBall(0);
        }
    }
}