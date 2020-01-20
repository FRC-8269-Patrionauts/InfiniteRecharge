package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DetectedTarget extends SubsystemBase {
   
     @Override
     public void periodic() {
       // This method will be called once per scheduler run
     }
   
     public double getArea(){
       return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
     }
   
     public double getXOffset(){
       return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
     }
   
     public double getYOffset(){
       return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
     }
   
   }