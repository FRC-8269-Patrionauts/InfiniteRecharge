package frc.robot;

//import edu.wpi.first.wpilibj.AnalogGyro;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ColorWheelCommand;
import frc.robot.commands.HumanDriveCommand;
import frc.robot.commands.SmartDashboardCommand;
import frc.robot.commands.TestTurningCommand;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DetectedTarget;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShootSubsystem;

/**
 * The container for the robot. Contains subsystems, IO devices, and commands.
 */
public class RobotContainer {

  // Devices
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_1);
  private final XboxController gamepad = new XboxController(Constants.GAMEPAD_1);
  private final AHRS imu = new AHRS(SPI.Port.kMXP);

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
  JoystickButton button3Joystick = new JoystickButton(joystick, 3);
  JoystickButton button4Joystick = new JoystickButton(joystick, 4);
  JoystickButton button5Joystick = new JoystickButton(joystick, 5);
  JoystickButton button6Joystick = new JoystickButton(joystick, 6);
  JoystickButton button7Joystick = new JoystickButton(joystick, 7);
  JoystickButton button8Joystick = new JoystickButton(joystick, 8);
  JoystickButton button9Joystick = new JoystickButton(joystick, 9);
  JoystickButton button10Joystick = new JoystickButton(joystick, 10);
  JoystickButton button11Joystick = new JoystickButton(joystick, 11);
  JoystickButton button12Joystick = new JoystickButton(joystick, 12);

  // Sensors
  // Initializing an encoder on DIO pins 4 and 5
  Encoder flywheel1 = new Encoder(4, 5);
  Encoder flywheel2 = new Encoder(6, 7);

  // Subsystems
  private final CameraSubsystem cameraSubsystem = new CameraSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem(imu);
  private final ShootSubsystem shootSubsystem = new ShootSubsystem();
  private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
  private final DetectedTarget detectedTarget = new DetectedTarget();

  // Commands
  private final HumanDriveCommand humanDriveCommand = new HumanDriveCommand(driveSubsystem, joystick, gamepad);
  private final AutonomousCommand autonomousCommand = new AutonomousCommand(driveSubsystem, cameraSubsystem,
      shootSubsystem);
  private final ColorWheelCommand colorWheelCommand = new ColorWheelCommand(colorWheelSubsystem);
  private final TestTurningCommand testTurningCommand = new TestTurningCommand(driveSubsystem);
  private final SmartDashboardCommand smartDashboardCommand = new SmartDashboardCommand(this);

  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    X.whenPressed(autonomousCommand);
    Y.whenPressed(humanDriveCommand);
    A.whenPressed(colorWheelCommand);
    button11Joystick.whenPressed(testTurningCommand);
  }

  /**
   * Returns the command for human driving.
   */
  public AutonomousCommand getAutonomousCommand() {
    return this.autonomousCommand;
  }

  public AHRS getImu() {
    return this.imu;
  }

  public Joystick getJoystick() {
    return this.joystick;
  }

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

  public ColorWheelSubsystem getColorWheelSubsystem() {
    return this.colorWheelSubsystem;
  }

  public HumanDriveCommand getHumanDriveCommand() {
    return this.humanDriveCommand;
  }

  public TestTurningCommand getTestTurningCommand() {
    return this.testTurningCommand;
  }

  public ColorWheelCommand getColorWheelCommand() {
    return this.colorWheelCommand;
  }

  public SmartDashboardCommand getSmartDashboardCommand() {
    return this.smartDashboardCommand;
  }

  public DetectedTarget getDetectedTarget() {
    return this.detectedTarget;
  }

}