import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class colorWheelSubsystem extends SubsystemBase
{
    public String targetColor;
    public String myColor;

    public colorWheelSubsystem()
    {

    }

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

    //sets myColor to what the color sensor sees as a string and wowwee turns the rgb values to strings? Probably gonna need to make a range?
    public void getMyColor(){

    }
    //returns true or false if the color is the one that the field wants and sees it (2 colors ahead from the one the robot sees)
    public void getTargetColor(){
        /* PSEUDO CODE?
        if (sensor sees green)
        {
            targetColor = "yellow";
        }
        else if (sensor sees blue)
        {
            targetColor = "red";
        }
        else if (sensor sees yellow)
        {
            targetColor = "green";
        }
        else if (sensor sees red)
        {
            targetColor = "blue";
        }
        */
    }
    //rotates the wheel autonomously UNTIL getTargetColor is true
    public void rotateWheel(){
        /* PSEUDOCODE
        while(targetColor == false)
        {
            activate spinny motor
        }
        */
    }
    public void controlWheel(){
        
        /*
        idk turn on the camera feed that allows drivers to see the color wheel
        wowee buttons control the spinny motor  ez
        */
    }


}