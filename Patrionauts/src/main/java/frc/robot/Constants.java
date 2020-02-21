package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 */
public final class 
Constants {

    /**
     * Set to true if all of the components for the DriveSubsystem are connected,
     * otherwise set to false. This will prevent the
     * {@code [CAN SPARK MAX] WPILib or External HAL Error} from showing up in the
     * simulation.
     */
    public static final boolean ENABLE_DRIVE_SUBSYSTEM = true;

    /**
     * Set to true if all of the components for the ShootSubsystem are connected.
     */
    public static final boolean ENABLE_SHOOT_SUBSYSTEM = true;

    /**
     * Set to true if the joystick is connected, otherwise set to false. This will
     * prevent the
     * {@code Joystick Button 1 on port 1 not available, check if controller is plugged in errors}
     * from showing up in the simulation.
     */
    public static final boolean ENABLE_JOYSTICK = true;

    /**
     * Set to true if the gamepad is connected, otherwise set to false. This will
     * prevent the
     * {@code Joystick Button 1 on port 1 not available, check if controller is plugged in errors}
     * from showing up in the simulation.
     */
    public static final boolean ENABLE_GAMEPAD = false;

    public static final int FLYWHEEL_MOTOR1 = 2;
    public static final int FLYWHEEL_MOTOR2 = 3;

    /**
     * Set to true if the Limelight is connected, otherwise set to false.
     */
    public static final boolean ENABLE_LIMELIGHT = false;

    public static final int JOYSTICK_1 = 0;
    public static final int GAMEPAD_1 = 1;

    public static final int LEFT_MOTOR_1 = 6;
    public static final int LEFT_MOTOR_2 = 7;
    public static final int RIGHT_MOTOR_1 = 4;
	public static final int RIGHT_MOTOR_2 = 5;
	
	public static final int BELT_MOTOR = 10;

    public static final double CURRENT_SPEED = 0;
    public static final double GOAL_SPEED = 0;
    public static final double SPEED_STEP_DOWN = 0.05;
    public static final double SPEED_STEP_UP = 0.03;
    public static final double MAX_SPEED = 1;

    public static final int GAMEPAD_X = 0;
    public static final int GAMEPAD_A = 1;
    public static final int GAMEPAD_B = 2;
    public static final int GAMEPAD_Y = 3;
    public static final int GAMEPAD_LEFT_BUMPER = 4;
    public static final int GAMEPAD_RIGHT_BUMPER = 5;
    public static final int GAMEPAD_LEFT_TRIGGER = 6;
    public static final int GAMEPAD_RIGHT_TRIGGER = 7;
    public static final int GAMEPAD_BACK = 8;
    public static final int GAMEPAD_START = 9;
    public static final int GAMEPAD_LEFT_ANALOG_CLICK = 10;
    public static final int GAMEPAD_RIGHT_ANALOG_CLICK = 11;

    public static final int JOYSTICK_3 = 3;
    public static final int JOYSTICK_4 = 4;
    public static final int JOYSTICK_5 = 5;
    public static final int JOYSTICK_6 = 6;
    public static final int JOYSTICK_7 = 7;
    public static final int JOYSTICK_8 = 8;
    public static final int JOYSTICK_9 = 9;
    public static final int JOYSTICK_10 = 10;
    public static final int JOYSTICK_11 = 11;
    public static final int JOYSTICK_12 = 12;
    /*
     * public static final double ksVolts = 0.0; public static final double
     * ksVoltsSecondsPerMeter = 0.0; public static final double
     * kaVoltSecondsSquaredPerMeter = 0.0;
     * 
     * public static final double kPDriveVel = 0.0;
     */
    public static final int NEO_MOTOR_TEST = 1;

    public static final double INCHES_PER_TICK = 0.44881;

	public static final int INTAKE_MOTOR = 9;

}
