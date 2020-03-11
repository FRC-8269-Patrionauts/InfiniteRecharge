package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
//import sun.java2d.cmm.PCMM;

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
    private final JoystickButton joystickButton1 = new JoystickButton(joystick, 1);
    private final JoystickButton joystickButton2 = new JoystickButton(joystick, 2);
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
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    private final LiftSubsystem liftSubsystem = new LiftSubsystem();

    // Commands
    private final HumanDriveCommand humanDriveCommand = new HumanDriveCommand(driveSubsystem, intakeSubsystem, joystick,
            gamepad);
    private final AutonomousCommand autonomousCommand = new AutonomousCommand(this);
    private final ColorWheelCommand colorWheelCommand = new ColorWheelCommand(colorWheelSubsystem);
    private final ShootCommand shootCommand = new ShootCommand(shootSubsystem);
    private final AlignAtTargetCommand alignAtTargetCommand = new AlignAtTargetCommand(driveSubsystem, cameraSubsystem);
    private final TestTurningCommand testTurningCommand = new TestTurningCommand(driveSubsystem);
    private final TestShootCommand testShootCommand = new TestShootCommand(shootSubsystem);
    private final TestShootRPMCommand testShootRPMCommand = new TestShootRPMCommand(shootSubsystem);
    private final ToggleIntakeCommand toggleIntakeCommand = new ToggleIntakeCommand(intakeSubsystem);
    private final OuttakeCommand outtakeCommand = new OuttakeCommand(intakeSubsystem);
    private final TestSpinColorWheelCommand testSpinColorWheelCommand = new TestSpinColorWheelCommand(
            colorWheelSubsystem);
    private final LiftHookCommand liftHookCommand = new LiftHookCommand(liftSubsystem);
    private final LowerHookCommand lowerHookCommand = new LowerHookCommand(liftSubsystem);
    private final LiftBotCommand liftBotCommand = new LiftBotCommand(liftSubsystem);
    private final LowerBotCommand lowerBotCommand = new LowerBotCommand(liftSubsystem);
    private final LoaderTiltCommand loaderTiltCommand = new LoaderTiltCommand(shootSubsystem);

    private final TestIntakePneumaticsCommand testIntakePneumaticsCommand = new TestIntakePneumaticsCommand(intakeSubsystem);
    private final FollowPathCommand followPathCommand = new FollowPathCommand();

    private final TestMoveFeetCommand testMoveFeetCommand = new TestMoveFeetCommand(driveSubsystem);
    private final TestBeltCommand testBeltCommand = new TestBeltCommand(shootSubsystem);
    private final TestIntakeRollerCommand testIntakeRollerCommand = new TestIntakeRollerCommand(intakeSubsystem);
    private final PowerPortPipelineCommand powerPortPipelineCommand = new PowerPortPipelineCommand(cameraSubsystem);
    private final TestPipelineCommand testPipelineCommand = new TestPipelineCommand(cameraSubsystem);
    private final TestTurrentPneumaticsCommand testTurrentPneumaticsCommand = new TestTurrentPneumaticsCommand(intakeSubsystem);

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
        joystickButton1.whenPressed(shootCommand);

        joystickButton6.whenPressed(liftBotCommand);
        joystickButton4.whenPressed(lowerBotCommand);
        joystickButton5.whenPressed(liftHookCommand);// change t toggele
        joystickButton3.whenPressed(lowerHookCommand);

        joystickButton7.whenPressed(loaderTiltCommand); // tilt the loader

        joystickButton8.whenPressed(toggleIntakeCommand); // everything to begin intaking powercells , chnage name

        joystickButton9.whenPressed(alignAtTargetCommand); // auto aim at target

        joystickButton2.whenPressed(testIntakeRollerCommand);

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

    public IntakeSubsystem getIntakeSubsystem() {
        return this.intakeSubsystem;
    }

    public LiftSubsystem getLiftSubsystem() {
        return this.liftSubsystem;
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

    public TestBeltCommand getTestBeltCommand() {
        return this.testBeltCommand;
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

    public FollowPathCommand getFollowPathCommand() {
        return this.followPathCommand;
    }


  public TestIntakePneumaticsCommand getTestIntakePneumaticsCommand() {
    return this.testIntakePneumaticsCommand;
  }


  public OuttakeCommand getOuttakeCommand() {
    return this.outtakeCommand;
  }

    public ToggleIntakeCommand getToggleIntakeCommand() {
        return this.toggleIntakeCommand;
    }



    public TestSpinColorWheelCommand getTestSpinColorWheelCommand() {
        return this.testSpinColorWheelCommand;
    }

    public LiftHookCommand getLiftHookCommand() {
        return this.liftHookCommand;
    }

    public LowerHookCommand getLowerHookCommand() {
        return this.lowerHookCommand;
    }

    public LiftBotCommand getLiftBotCommand() {
        return this.liftBotCommand;
    }

    public LowerBotCommand getLowerBotCommand() {
        return this.lowerBotCommand;
    }

    public LoaderTiltCommand getLoaderTiltCommand() {
        return this.loaderTiltCommand;
    }

    public TestIntakeRollerCommand getTestIntakeRollerCommand() {
        return this.testIntakeRollerCommand;
    }

    public PowerPortPipelineCommand getPowerPortPipelineCommand() {
        return this.powerPortPipelineCommand;
    }

    public TestPipelineCommand getTestPipelineCommand() {
        return this.testPipelineCommand;
    }

    public TestTurrentPneumaticsCommand getTestTurrentPneumaticsCommand() {
        return this.testTurrentPneumaticsCommand;
    }


}
