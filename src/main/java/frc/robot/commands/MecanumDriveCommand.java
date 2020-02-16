/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.DriveSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class MecanumDriveCommand extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final ControllerSubsystem m_controllerSubsystem;
  
  public MecanumDriveCommand(DriveSubsystem driveSubsystem, ControllerSubsystem controllerSubsystem) {
    m_driveSubsystem = driveSubsystem;
    m_controllerSubsystem = controllerSubsystem;
    addRequirements(m_driveSubsystem, m_controllerSubsystem);
  }

  @Override
  public void execute() {
    m_driveSubsystem.mecanumDrive(m_controllerSubsystem.getForwardSpeed(), m_controllerSubsystem.getSideSpeed(), m_controllerSubsystem.getZRotation());
  }
}
