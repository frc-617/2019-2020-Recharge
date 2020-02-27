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
public class TestMotorCommand extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final ControllerSubsystem m_controllerSubsystem;

  private static int frontLeft = 0;
  private static int rearLeft = 1;
  private static int frontRight = 2;
  private static int rearRight = 3;
  
  public TestMotorCommand(DriveSubsystem driveSubsystem, ControllerSubsystem controllerSubsystem) {
    m_driveSubsystem = driveSubsystem;
    m_controllerSubsystem = controllerSubsystem;
    addRequirements(m_driveSubsystem, controllerSubsystem);
  }

  @Override
  public void execute() {
    // Set each individual motor based on buttons being pressed

    if(m_controllerSubsystem.getXButton())
      m_driveSubsystem.setMotor(-m_controllerSubsystem.getLeftVertical(), frontLeft);
    else
      m_driveSubsystem.setMotor(0.0, frontLeft);
    
    if(m_controllerSubsystem.getAButton())
      m_driveSubsystem.setMotor(-m_controllerSubsystem.getLeftVertical(), rearLeft);
    else
      m_driveSubsystem.setMotor(0.0, rearLeft);
    
    if(m_controllerSubsystem.getYButton())
      m_driveSubsystem.setMotor(m_controllerSubsystem.getLeftVertical(), frontRight);
    else
      m_driveSubsystem.setMotor(0.0, frontRight);
    
    if(m_controllerSubsystem.getBButton())
      m_driveSubsystem.setMotor(m_controllerSubsystem.getLeftVertical(), rearRight);
    else
      m_driveSubsystem.setMotor(0.0, rearRight);
  }
}
