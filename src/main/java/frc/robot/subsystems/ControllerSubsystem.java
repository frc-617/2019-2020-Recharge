/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ControllerSubsystem extends SubsystemBase {
  private XboxController m_stick;

  /**
   * Creates a new DriveSubsystem.
   */
  public ControllerSubsystem() {
    m_stick = new XboxController(Constants.kJoystickChannel);
  }

  @Override
  public void periodic() {

  }

  public double getZRotation() 
  {
    if(m_stick.getRawButton(5))
    {
      if(m_stick.getRawButton(6))
        return 0.0;
      else
        return 1.0;
    }
    else
      if(m_stick.getRawButton(6))
        return -1.0;
      else
        return 0.0;
  }

  public double getYSpeed()
  {
    return m_stick.getRawAxis(1);
  }

  public double getXSpeed()
  {
    return -1*m_stick.getRawAxis(4);
  }
}
