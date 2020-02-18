package frc.robot;

//import edu.wpi.first.wpilibj.AnalogGyro;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AlignAtTargetCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.CloseLoaderCommand;
import frc.robot.commands.ColorWheelCommand;
import frc.robot.commands.FollowPathCommand;
import frc.robot.commands.HumanDriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OutakeCommand;
import frc.robot.commands.LowerIntakeCommand;
import frc.robot.commands.OpenLoaderCommand;
import frc.robot.commands.RaiseIntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.TestMoveFeetCommand;
import frc.robot.commands.TestShootCommand;
import frc.robot.commands.TestShootRPMCommand;
import frc.robot.commands.TestTurningCommand;
import frc.robot.subsystems.BeltSubsystem;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeRollerSubsystem;
import frc.robot.subsystems.LoaderSubsystem;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.IntakePneumaticSubsystem;

/**
 * The container for the robot. Contains subsystems, IO devices, and commands.
 */
public class RobotContainer {
    // Devices
    private final Joystick joystick = new Joystick(Constants.JOYSTICK_1);
    private final XboxController gamepad = new XboxController(Constants.GAMEPAD_1);

    // Gamepad Buttons
    private final JoystickButton gamepadX = new JoystickButton(gamepad, Constants.GAMEPAD_X);
    private final JoystickButton gamepadA = new JoystickButton(gamepad, Constants.GAMEPAD_A);
    private final JoystickButton gamepadB = new JoystickButton(gamepad, Constants.GAMEPAD_B);
    private final JoystickButton gamepadY = new JoystickButton(gamepad, Constants.GAMEPAD_Y);
    private final JoystickButton gamepadLeftBumper = new JoystickButton(gamepad, Constants.GAMEPAD_LEFT_BUMPER);
    private final JoystickButton gamepadRightBumper = new JoystickButton(gamepad, Constants.GAMEPAD_RIGHT_BUMPER);
    private final JoystickButton gamepadLeftTrigger = new JoystickButton(gamepad, Constants.GAMEPAD_LEFT_TRIGGER);
    private final JoystickButton gamepadRightTrigger = new JoystickButton(gamepad, Constants.GAMEPAD_RIGHT_TRIGGER);
    private final JoystickButton gamepadBack = new JoystickButton(gamepad, Constants.GAMEPAD_BACK);
    private final JoystickButton gamepadStart = new JoystickButton(gamepad, Constants.GAMEPAD_START);
    private final JoystickButton gamepadLeftJoystickClick = new JoystickButton(gamepad,
            Constants.GAMEPAD_LEFT_ANALOG_CLICK);
    private final JoystickButton gamepadRightJoystickClick = new JoystickButton(gamepad,
            Constants.GAMEPAD_RIGHT_ANALOG_CLICK);

    // Joystick Buttons
    private final JoystickButton joystickButton3 = new JoystickButton(joystick, 3);
    private final JoystickButton joystickButton4 = new JoystickButton(joystick, 4);
    private final JoystickButton joystickButton5 = new JoystickButton(joystick, 5);
    private final JoystickButton joystickButton6 = new JoystickButton(joystick, 6);
    private final JoystickButton joystickButton7 = new JoystickButton(joystick, 7);
    private final JoystickButton joystickButton8 = new JoystickButton(joystick, 8);
    private final JoystickButton joystickButton9 = new JoystickButton(joystick, 9);
    private final JoystickButton joystickButton10 = new JoystickButton(joystick, 10);
    private final JoystickButton joystickButton11 = new JoystickButton(joystick, 11);
    private final JoystickButton joystickButton12 = new JoystickButton(joystick, 12);

    // Sensors
    private final AHRS imu = new AHRS(SPI.Port.kMXP);

    // Subsystems
    private final CameraSubsystem cameraSubsystem = new CameraSubsystem();
    private final DriveSubsystem driveSubsystem = new DriveSubsystem(imu);
    private final ShootSubsystem shootSubsystem = new ShootSubsystem();
    private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
    private final IntakeRollerSubsystem intakeRollerSubsystem = new IntakeRollerSubsystem();
    private final IntakePneumaticSubsystem intakePneumaticSubsystem = new IntakePneumaticSubsystem();
    private final LoaderSubsystem loaderSubsystem = new LoaderSubsystem();
    private final BeltSubsystem beltSubsystem = new BeltSubsystem();

    // Commands
    private final HumanDriveCommand humanDriveCommand = new HumanDriveCommand(driveSubsystem, joystick, gamepad);
    private final AutonomousCommand autonomousCommand = new AutonomousCommand(this);
    private final ColorWheelCommand colorWheelCommand = new ColorWheelCommand(colorWheelSubsystem);
    private final ShootCommand shootCommand = new ShootCommand(shootSubsystem);
    private final AlignAtTargetCommand alignAtTargetCommand = new AlignAtTargetCommand(driveSubsystem, cameraSubsystem);
    private final TestTurningCommand testTurningCommand = new TestTurningCommand(driveSubsystem);
    private final TestShootCommand testShootCommand = new TestShootCommand(shootSubsystem);
    private final TestShootRPMCommand testShootRPMCommand = new TestShootRPMCommand(shootSubsystem);
    private final OpenLoaderCommand openLoaderCommand = new OpenLoaderCommand(loaderSubsystem);
    private final CloseLoaderCommand closeLoaderCommand = new CloseLoaderCommand(loaderSubsystem);
    private final IntakeCommand intakeCommand = new IntakeCommand(intakeRollerSubsystem);
    private final OutakeCommand outakeCommand = new OutakeCommand(intakeRollerSubsystem);

    private final LowerIntakeCommand lowerIntakeCommand = new LowerIntakeCommand(intakePneumaticSubsystem);
    private final RaiseIntakeCommand raiseIntakeCommand = new RaiseIntakeCommand(intakePneumaticSubsystem);
    private final FollowPathCommand followPathCommand = new FollowPathCommand();

    private final TestMoveFeetCommand testMoveFeetCommand = new TestMoveFeetCommand(driveSubsystem);


    public RobotContainer() {
        if (Constants.ENABLE_JOYSTICK) {
            configureJoystickButtons();
        }
        if (Constants.ENABLE_GAMEPAD) {
            configureGamepadButtons();
        }
        new Dashboard(this);
    }

    /**
     * Use this method to define your button->command mappings.
     */
    private void configureJoystickButtons() {
        joystickButton11.whenPressed(testTurningCommand);
        joystickButton3.whenPressed(closeLoaderCommand);
        joystickButton5.whenPressed(openLoaderCommand);
        joystickButton6.whenPressed(raiseIntakeCommand);
        joystickButton4.whenPressed(lowerIntakeCommand);
        joystickButton8.whenPressed(intakeCommand);
        joystickButton7.whenPressed(outakeCommand);

    }

    /**
     * Use this method to define your button->command mappings.
     */
    private void configureGamepadButtons() {
        gamepadB.whenPressed(shootCommand);// shoot after auto alignment is done and fly wheel is ramped up
        gamepadA.whenPressed(autonomousCommand);// auto align and auto ramp up
        gamepadX.whenPressed(autonomousCommand);
        gamepadY.whenPressed(humanDriveCommand);
        gamepadA.whenPressed(colorWheelCommand);

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

    public LoaderSubsystem getLoaderSubsystem() {
        return this.loaderSubsystem;
    }

    public IntakeRollerSubsystem getIntakeSubsystem() {
        return this.intakeRollerSubsystem;
    }

    public AutonomousCommand getAutonomousCommand() {
        return this.autonomousCommand;
    }

    public ShootCommand getShootCommand() {
        return this.shootCommand;
    }

    public HumanDriveCommand getHumanDriveCommand() {
        return this.humanDriveCommand;
    }

    public TestTurningCommand getTestTurningCommand() {
        return this.testTurningCommand;
    }

    public TestShootCommand getTestShootCommand() {
        return this.testShootCommand;
    }

    public TestShootRPMCommand getTestShootRPMCommand() {
        return this.testShootRPMCommand;
    }

    public TestMoveFeetCommand getTestMoveFeetCommand() {
        return this.testMoveFeetCommand;
    }

    public ColorWheelCommand getColorWheelCommand() {
        return this.colorWheelCommand;
    }

    public AlignAtTargetCommand getAlignAtTargetCommand() {
        return this.alignAtTargetCommand;
    }

    public OpenLoaderCommand getOpenLoaderCommand() {
        return this.openLoaderCommand;
    }

    public CloseLoaderCommand getCloseLoaderCommand() {
        return this.closeLoaderCommand;
    }

    public FollowPathCommand getFollowPathCommand() {
        return this.followPathCommand;
    }


	public LowerIntakeCommand getLowerIntakeCommand() {
		return this.lowerIntakeCommand;
  }

  public RaiseIntakeCommand getRaiseIntakeCommand() {
    return this.raiseIntakeCommand;
  }

  public IntakeCommand getIntakeCommand() {
    return this.intakeCommand;
  }

  public OutakeCommand getOutakeCommand() {
    return this.outakeCommand;
  }
  

}


