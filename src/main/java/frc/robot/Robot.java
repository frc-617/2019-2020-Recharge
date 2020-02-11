/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a demo program showing how to use Mecanum control with the RobotDrive
 * class.
 */
public class Robot extends TimedRobot {
  // NO TOUCH OR I KILL YOU!
  private static final int kFrontLeftChannel = 1;
  private static final int kRearLeftChannel = 3;
  private static final int kFrontRightChannel = 0;
  private static final int kRearRightChannel = 2;

  private static final int kJoystickChannel = 0;

  private MecanumDrive m_robotDrive;
  private XboxController m_stick;

  private static final double m_maxSpeed = 0.4;

  @Override
  public void robotInit() {
    Spark frontLeft = new Spark(kFrontLeftChannel);
    Spark rearLeft = new Spark(kRearLeftChannel);
    Spark frontRight = new Spark(kFrontRightChannel);
    Spark rearRight = new Spark(kRearRightChannel);

    // Invert the left side motors.
    // You may need to change or remove this to match your robot.
    //frontLeft.setInverted(true);
    //rearRight.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    m_stick = new XboxController(kJoystickChannel);
  }

  @Override
  public void teleopPeriodic() {
    m_robotDrive.setSafetyEnabled(true);
    

    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    m_robotDrive.driveCartesian(m_maxSpeed*m_stick.getRawAxis(4), -m_maxSpeed*m_stick.getRawAxis(1), m_maxSpeed*getZRotation());
        m_robotDrive.feed();
  }

  private double getZRotation() 
  {
    if(m_stick.getRawButton(5))
    {
      if(m_stick.getRawButton(6))
        return 0.0;
      else
        return -1.0;
    }
    else
      if(m_stick.getRawButton(6))
        return 1.0;
      else
        return 0.0;
  }
}
