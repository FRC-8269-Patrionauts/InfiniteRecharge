package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.AnalogGyro;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ColorWheelCommand;
import frc.robot.commands.HumanDriveCommand;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DetectedTarget;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShootSubsystem;

/**
 * The container for the robot. Contains subsystems, IO devices, and commands.
 * 
 * TODO(team): Think about all of the other devices, subsystems, and commands
 * that we'll need here. For example, a command for auto assisted aiming, a
 * command for moving the wheel, a subsystem for moving the wheel, etc.
 * 
 * TODO(jacob): finish setting up these systems, commands, and devices.
 */
public class RobotContainer {

  // Devices
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_1); // TODO(team): initialize this correctly.
  private final XboxController gamepad = new XboxController(Constants.GAMEPAD_1);
  //private final AnalogGyro gyro = new AnalogGyro(0);
  private final AHRS ahrs = new AHRS(SPI.Port.kMXP);

  // Gamepad Buttons
  JoystickButton X = new JoystickButton(gamepad, Constants.GAMEPAD_X);
  JoystickButton A = new JoystickButton(gamepad, Constants.GAMEPAD_A);
  JoystickButton B = new JoystickButton(gamepad, Constants.GAMEPAD_B);
  JoystickButton Y = new JoystickButton(gamepad, Constants.GAMEPAD_Y);
  JoystickButton leftBumper = new JoystickButton(gamepad, Constants.GAMEPAD_LEFT_BUMPER);
  JoystickButton rightBumper = new JoystickButton(gamepad, Constants.GAMEPAD_RIGHT_BUMPER);
  JoystickButton leftTrigger = new JoystickButton(gamepad, Constants.GAMEPAD_LEFT_TRIGGER);
  JoystickButton rightTrigger = new JoystickButton(gamepad, Constants.GAMEPAD_RIGHT_TRIGGER);
  JoystickButton back = new JoystickButton(gamepad, Constants.GAMEPAD_BACK);
  JoystickButton start = new JoystickButton(gamepad, Constants.GAMEPAD_START);
  JoystickButton leftJoystickClick = new JoystickButton(gamepad, Constants.GAMEPAD_LEFT_ANALOG_CLICK);
  JoystickButton rightJoystickClick = new JoystickButton(gamepad, Constants.GAMEPAD_RIGHT_ANALOG_CLICK);

  // Joystick Buttons
  JoystickButton button1 = new JoystickButton(joystick, 1);

  // Sensors
  // Initializing an encoder on DIO pins 4 and 5
  Encoder flywheel1 = new Encoder(4, 5);
  Encoder flywheel2 = new Encoder(6, 7);

  // Subsystems
  private final CameraSubsystem cameraSubsystem = new CameraSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShootSubsystem shootSubsystem = new ShootSubsystem();
  private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
  private final DetectedTarget detectedTarget = new DetectedTarget();

  // Commands
  private final HumanDriveCommand humanDriveCommand = new HumanDriveCommand(driveSubsystem, joystick, gamepad);
  private final AutonomousCommand autonomousCommand = new AutonomousCommand(driveSubsystem, cameraSubsystem,
      shootSubsystem);
  private final ColorWheelCommand colorWheelCommand = new ColorWheelCommand(colorWheelSubsystem);

  public RobotContainer() {
    configureButtonBindings();
    // driveSubsystem.setBase(.3);
  }


  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    X.whenPressed(getAutonomousCommand());
    Y.whenPressed(getHumanDriveCommand());
    A.whenPressed(getColorWheelCommand());
  }

  /**
   * Returns the command for human driving.
   */
  public AutonomousCommand getAutonomousCommand() {
    return this.autonomousCommand;
  }
  /*
  public AnalogGyro getGyro() {
    return this.gyro;
  }
  */
  public AHRS getAHRS(){
    return this.ahrs;
  }

  public Joystick getJoystick() {
    return this.joystick;
  }

  //public AnalogGyro getGyro(){
    //return //this.gyro;
  //}

  public XboxController getGamepad() {
    return this.gamepad;
  }

  public JoystickButton getButton() {
    return this.leftJoystickClick;
  }

  public CameraSubsystem getCameraSubsystem() {
    return this.cameraSubsystem;
  }

  

  public DriveSubsystem getDriveSubsystem() {
    return this.driveSubsystem;
  }

  public ShootSubsystem getShootSubsystem() {
    return this.shootSubsystem;
  }

  public ColorWheelSubsystem getColorWheelSubsystem(){
    return this.colorWheelSubsystem;
  }

  public HumanDriveCommand getHumanDriveCommand() {
    return this.humanDriveCommand;
  }

  public ColorWheelCommand getColorWheelCommand() {
    return this.colorWheelCommand;
  }

  public DetectedTarget getDetectedTarget() {
    return this.detectedTarget;
  }
}