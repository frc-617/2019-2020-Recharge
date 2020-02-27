/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ControllerSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class ArmCommand extends CommandBase {
  private final ArmSubsystem m_armSubsystem;
  private final ControllerSubsystem m_controllerSubsystem;
  
  public ArmCommand(ArmSubsystem armSubsystem, ControllerSubsystem controllerSubsystem) {
    m_armSubsystem = armSubsystem;
    m_controllerSubsystem = controllerSubsystem;
    addRequirements(m_armSubsystem, m_controllerSubsystem);
  }

  @Override
  public void execute() {
    m_armSubsystem.Move(m_controllerSubsystem.getLeftVertical());
  }
}
