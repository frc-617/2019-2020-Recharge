/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.MecanumDriveCommand;
import frc.robot.commands.TestMotorCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController m_stick = new XboxController(Constants.kJoystickChannel);

  private final ControllerSubsystem m_controllerSubsystem = new ControllerSubsystem(m_stick);
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ClimbSubsystem m_climbSubsystem = new ClimbSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();

  private final MecanumDriveCommand m_mecanumDriveCommand = new MecanumDriveCommand(m_driveSubsystem, m_controllerSubsystem, m_climbSubsystem, m_armSubsystem, m_intakeSubsystem);
  private final TestMotorCommand m_testMotorCommand = new TestMotorCommand(m_driveSubsystem, m_controllerSubsystem);
  private final ClimbCommand m_climbCommand = new ClimbCommand(m_climbSubsystem, m_controllerSubsystem);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public Command getTeleoptCommand() {
    if (!Constants.testMode)
      return m_mecanumDriveCommand;
    else
      return m_testMotorCommand;
  }

  public Command getTestCommand() {
    return null;
  }

  public Command getClimbCommand() {
    return m_climbCommand;
  }
}
