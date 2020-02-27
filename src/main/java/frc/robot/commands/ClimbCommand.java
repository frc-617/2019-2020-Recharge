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
  private final ClimbSubsystem m_climbSubsystem;
  private final ControllerSubsystem m_controllerSubsystem;
  
  public ClimbCommand(ClimbSubsystem climbSubsystem, ControllerSubsystem controllerSubsystem) {
    m_climbSubsystem = climbSubsystem;
    m_controllerSubsystem = controllerSubsystem;
    addRequirements(m_climbSubsystem, m_controllerSubsystem);
  }

  @Override
  public void execute() {
    m_climbSubsystem.Climb(m_controllerSubsystem.getRightVertical());;
  }
}
