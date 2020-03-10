/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControllerSubsystem extends SubsystemBase {
  private XboxController m_stick;

  /**
   * Creates a new DriveSubsystem.
   */
  public ControllerSubsystem(XboxController m_stickIn) {
    m_stick = m_stickIn;
  }

  @Override
  public void periodic() {

  }

  public double getZRotation() 
  {
    if(m_stick.getRawAxis(2) > 0.0)
    {
      if(m_stick.getRawAxis(3) > 0.0)
        return 0.0;
      else
        return m_stick.getRawAxis(2);
    }
    else
      if(m_stick.getRawAxis(3) > 0.0)
        return -m_stick.getRawAxis(3);
      else
        return 0.0;
  }

  public double getForwardSpeed()
  {
    return m_stick.getRawAxis(1);
  }

  public double getSideSpeed()
  {
    return -1*m_stick.getRawAxis(4);
  }

  public boolean getAButton()
  {
    return m_stick.getRawButton(1);
  }

  public boolean getBButton()
  {
    return m_stick.getRawButton(2);
  }

  public boolean getXButton()
  {
    return m_stick.getRawButton(3);
  }

  public boolean getYButton()
  {
    return m_stick.getRawButton(4);
  }

  public boolean getLeftBumper()
  {
    return m_stick.getRawButton(5);
  }

  public boolean getRightBumper()
  {
    return m_stick.getRawButton(6);
  }

}
