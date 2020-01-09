package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.HumanDriveCommand;
import frc.robot.subsystems.CameraSubsystem;
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
  
  //Gamepad Buttons
  JoystickButton X = new JoystickButton(gamepad, 0); 
  JoystickButton A = new JoystickButton(gamepad, 1); 
  JoystickButton B = new JoystickButton(gamepad, 2); 
  JoystickButton Y = new JoystickButton(gamepad, 3); 
  JoystickButton leftBumper = new JoystickButton(gamepad, 4); 
  JoystickButton rightBumper = new JoystickButton(gamepad, 5); 
  JoystickButton leftTrigger = new JoystickButton(gamepad, 6); 
  JoystickButton rightTrigger = new JoystickButton(gamepad, 7); 
  JoystickButton back = new JoystickButton(gamepad, 8); 
  JoystickButton start = new JoystickButton(gamepad, 9);
  JoystickButton leftJoystickClick = new JoystickButton(gamepad, 10); 
  JoystickButton rightJoystickClick = new JoystickButton(gamepad, 11); 

  // Subsystems
  private final CameraSubsystem cameraSubsystem = new CameraSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShootSubsystem shootSubsystem = new ShootSubsystem();

  // Commands
  private final HumanDriveCommand humanDriveCommand = new HumanDriveCommand(driveSubsystem, joystick);
  private final AutonomousCommand autonomousCommand = new AutonomousCommand(driveSubsystem, cameraSubsystem,
      shootSubsystem);

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
    
  }

  /**
   * Returns the command for human driving.
   */
  public Command getAutonomousCommand() {
    return autonomousCommand;
  }

  public Joystick getJoystick() {
    return this.joystick;
  }

  public XboxController getGamepad() {
    return this.gamepad;
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

  public HumanDriveCommand getHumanDriveCommand() {
    return this.humanDriveCommand;
  }
}
