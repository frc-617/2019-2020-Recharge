/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class MecanumDriveCommand extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final ControllerSubsystem m_controllerSubsystem;
  private final ClimbSubsystem m_climbSubsystem;
  private final ArmSubsystem m_armSubsystem;
  private final IntakeSubsystem m_intakeSubsystem;
  private boolean intakeToggle = true;
  
  public MecanumDriveCommand(DriveSubsystem driveSubsystem, ControllerSubsystem controllerSubsystem, ClimbSubsystem climbSubsystem, ArmSubsystem armSubsystem, IntakeSubsystem intakeSubsystem) {
    m_driveSubsystem = driveSubsystem;
    m_controllerSubsystem = controllerSubsystem;
    m_climbSubsystem = climbSubsystem;
    m_armSubsystem = armSubsystem;
    m_intakeSubsystem = intakeSubsystem;
    addRequirements(m_driveSubsystem, m_controllerSubsystem);
  }
  

  @Override
  public void execute() {
    m_driveSubsystem.mecanumDrive(m_controllerSubsystem.getForwardSpeed(), m_controllerSubsystem.getSideSpeed(), m_controllerSubsystem.getZRotation());
    // System.out.println("Driving!");
    if(m_controllerSubsystem.getAButton() == true) {
      m_climbSubsystem.Climb(1);
      System.out.println("Climbing now");
    }
    else{
      m_climbSubsystem.Climb(0.0);
    }

    
    if(m_controllerSubsystem.getLeftBumper())
    {
      m_armSubsystem.MoveArm(-1); // This Might Be The Issue
      System.out.println("Left Bumper Pressed, Arm lowering");
    }
    if(m_controllerSubsystem.getRightBumper())
    {
      m_armSubsystem.MoveArm(0.5); // This Might Be The Issue, should it be 1?*
      System.out.println("Right Bumper Pressed, Arm Raising");
    }
    else{
      m_armSubsystem.MoveArm(0);
    }

    if(m_controllerSubsystem.getBButton()){
      if(intakeToggle == true){
        intakeToggle = false;
      }
      else{
        intakeToggle = true;
      }
    }

    if(intakeToggle == true){
      m_intakeSubsystem.Intake(-1);
    }
    else{
      m_intakeSubsystem.Intake(1);
    }
  }
}
