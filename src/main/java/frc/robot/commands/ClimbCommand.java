/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ControllerSubsystem;


/**
 * An example command that uses an example subsystem.
 */
public class ClimbCommand extends CommandBase {
  private final ControllerSubsystem m_controllerSubsystem;
  private final ClimbSubsystem m_climbSubsystem;

  public ClimbCommand(ClimbSubsystem climbSubsystem, ControllerSubsystem controllerSubsystem) {
    m_controllerSubsystem = controllerSubsystem;
    m_climbSubsystem = climbSubsystem;
    addRequirements(m_controllerSubsystem, m_climbSubsystem);
  }

  @Override
  public void initialize() {
    m_climbSubsystem.Climb(1.0);
    System.out.println("Turning on climb!");
  }

  @Override
  public void execute() {
    System.out.println("Climb running!");
  }

  @Override
  public void end(boolean interrupted) {
    m_climbSubsystem.Climb(0);
    System.out.println("Turning off climb!");
  }
}
