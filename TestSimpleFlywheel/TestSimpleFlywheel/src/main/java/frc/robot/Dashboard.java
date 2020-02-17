package frc.robot;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandBase;;

public class Dashboard extends CommandBase {
    
    private final RobotContainer robotContainer;

    public Dashboard(RobotContainer robotContainer) {
        this.robotContainer = robotContainer;
        configureDrive();
    }

    public void configureDrive() {
        // Shuffleboard.getTab("Drive")
        //     .add("DifferentialDrive", (Sendable) robotContainer.getDriveSubsystem().getDrive())
        //     .withWidget(BuiltInWidgets.kDifferentialDrive).withPosition(0, 0);
        // Shuffleboard.getTab("Drive")
        //     .addNumber("LeftMotor1Pos", 
        //                 () -> robotContainer.getDriveSubsystem().getLeftMotor1Encoder().getPosition())
        //     .withPosition(3, 0).withSize(2, 1);
        // Shuffleboard.getTab("Drive")
        //         .addNumber("LeftMotor2Pos",
        //                 () -> robotContainer.getDriveSubsystem().getLeftMotor2Encoder().getPosition())
        //         .withPosition(3, 1).withSize(2, 1);
        // Shuffleboard.getTab("Drive")
        //         .addNumber("RightMotor1Pos",
        //                 () -> robotContainer.getDriveSubsystem().getRightMotor1Encoder().getPosition())
        //         .withPosition(5, 0).withSize(2, 1);
        // Shuffleboard.getTab("Drive")
        //         .addNumber("RightMotor2Pos",
        //                 () -> robotContainer.getDriveSubsystem().getRightMotor1Encoder().getPosition())
        //         .withPosition(5, 1).withSize(2, 1);
        /*
        Shuffleboard.getTab("Drive").addNumber("RightMotor2Pos",
                () -> robotContainer.getDriveSubsystem().getRightMotor1Encoder().getPosition())
                        .withPosition(7, 1).withSize(2, 1);
        Shuffleboard.getTab("Drive").addNumber("RightMotor2Pos",
                () -> robotContainer.getDriveSubsystem().getRightMotor1Encoder().getPosition())
                        .withPosition(7, 3).withSize(2, 1);
        Shuffleboard.getTab("Drive").addNumber("RightMotor2Pos",
                () -> robotContainer.getDriveSubsystem().getRightMotor1Encoder().getPosition())
                        .withPosition(9, 1).withSize(2, 1);
                        */
        Shuffleboard.getTab("Flywheel").addNumber("flyMotor1Pos",
                () -> robotContainer.getDriveSubsystem().getFlyMotor1Encoder().getPosition())
                        .withPosition(1, 1).withSize(2, 1);
                        
                
        Shuffleboard.getTab("Flywheel").addNumber("flyMotor1",
                () -> robotContainer.getDriveSubsystem().getFlyMotor1().get())
                        .withPosition(1, 3).withSize(2, 1);
        Shuffleboard.getTab("Flywheel").addNumber("flyMotor2",
                                () -> robotContainer.getDriveSubsystem().getFlyMotor2().get())
                                .withPosition(2, 1).withSize(2, 1);
        Shuffleboard.getTab("Flywheel")
                                .addNumber("flywheelPower", () -> robotContainer.getDriveSubsystem().getPower())
                                .withPosition(2, 3).withSize(2, 1);
                                

            
    }
}