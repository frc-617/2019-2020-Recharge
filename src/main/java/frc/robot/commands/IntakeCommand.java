/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class IntakeCommand extends CommandBase {
  private final IntakeSubsystem m_intakeSubsystem;
  private final ControllerSubsystem m_controllerSubsystem;
  
  public IntakeCommand(IntakeSubsystem intakeSubsystem, ControllerSubsystem controllerSubsystem) {
    m_intakeSubsystem = intakeSubsystem;
    m_controllerSubsystem = controllerSubsystem;
    addRequirements(m_intakeSubsystem, m_controllerSubsystem);
  }

  @Override
  public void execute() {
    m_intakeSubsystem.Intake(m_controllerSubsystem.getTriggers());
  }
}
