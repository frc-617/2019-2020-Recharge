/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpiutil.math.MathUtil;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a demo program showing how to use Mecanum control with the RobotDrive
 * class.
 */
public class Robot extends TimedRobot {
  // NO TOUCH OR I KILL YOU!
  private static final int kFrontLeftChannel = 2;
  private static final int kRearLeftChannel = 4;
  private static final int kFrontRightChannel = 3;
  private static final int kRearRightChannel = 1;

  private static final int kJoystickChannel = 0;

  private XboxController m_stick;

  private static final double m_maxSpeed = 0.4;

  VictorSPX frontLeft = new VictorSPX(kFrontLeftChannel);
  VictorSPX rearLeft = new VictorSPX(kRearLeftChannel);
  VictorSPX frontRight = new VictorSPX(kFrontRightChannel);
  VictorSPX rearRight = new VictorSPX(kRearRightChannel);

  @Override
  public void robotInit() {
    m_stick = new XboxController(kJoystickChannel);
  }

  @Override
  public void teleopPeriodic() {

    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    driveCartesian(m_maxSpeed, m_stick.getRawAxis(1), -m_stick.getRawAxis(4), -getZRotation());
  }

  private void driveCartesian(double m_maxSpeed, double ySpeed, double xSpeed, double zRotation)
  {
    ySpeed = MathUtil.clamp(ySpeed, -1.0, 1.0);
    ySpeed = applyDeadband(ySpeed, 0.02);

    xSpeed = MathUtil.clamp(xSpeed, -1.0, 1.0);
    xSpeed = applyDeadband(xSpeed, 0.02);

    Vector2d input = new Vector2d(ySpeed, xSpeed);
    double[] wheelSpeeds = new double[4];
    wheelSpeeds[0] = input.x + input.y + zRotation;
    wheelSpeeds[1] = -input.x + input.y - zRotation;
    wheelSpeeds[2] = -input.x + input.y + zRotation;
    wheelSpeeds[3] = input.x + input.y - zRotation;

    normalize(wheelSpeeds);

    frontLeft.set(ControlMode.PercentOutput, -wheelSpeeds[0]*m_maxSpeed);
    rearLeft.set(ControlMode.PercentOutput, wheelSpeeds[1]*m_maxSpeed);
    frontRight.set(ControlMode.PercentOutput, -wheelSpeeds[2]*m_maxSpeed);
    rearRight.set(ControlMode.PercentOutput, wheelSpeeds[3]*m_maxSpeed);
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

  
  private double applyDeadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }

  private void normalize(double[] wheelSpeeds) {
    double maxMagnitude = Math.abs(wheelSpeeds[0]);
    for (int i = 1; i < wheelSpeeds.length; i++) {
      double temp = Math.abs(wheelSpeeds[i]);
      if (maxMagnitude < temp) {
        maxMagnitude = temp;
      }
    }
    if (maxMagnitude > 1.0) {
      for (int i = 0; i < wheelSpeeds.length; i++) {
        wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
      }
    }
  }
}
