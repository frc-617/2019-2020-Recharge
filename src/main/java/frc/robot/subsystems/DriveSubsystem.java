/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private final VictorSPX frontLeft;
  private final VictorSPX rearLeft;
  private final VictorSPX frontRight;
  private final VictorSPX rearRight;

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    frontLeft = new VictorSPX(Constants.kFrontLeftChannel);
    rearLeft = new VictorSPX(Constants.kRearLeftChannel);
    frontRight = new VictorSPX(Constants.kFrontRightChannel);
    rearRight = new VictorSPX(Constants.kRearRightChannel);
  }

  public void setMotor(double speed, int motorNumber)
  {
    speed = applyDeadband(speed, Constants.kDeadBand);
    speed = speed*Constants.kMaxDriveSpeed;
    switch ( motorNumber )
    {
      case 0 :
        frontLeft.set(ControlMode.PercentOutput, speed);
        break;
      case 1 :
        rearLeft.set(ControlMode.PercentOutput, speed);
        break;
      case 2 :
        frontRight.set(ControlMode.PercentOutput, speed);
        break;
      case 3 :
        rearRight.set(ControlMode.PercentOutput, speed);
        break;
    }
  }

  public void mecanumDrive(double ySpeed, double xSpeed, double zRotation)
  {
    ySpeed = MathUtil.clamp(ySpeed, -1.0, 1.0);
    ySpeed = applyDeadband(ySpeed, 0.02);

    xSpeed = MathUtil.clamp(xSpeed, -1.0, 1.0);
    xSpeed = applyDeadband(xSpeed, Constants.kDeadBand);

    if(Constants.squareInputs)
    {
      xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
      ySpeed = Math.copySign(ySpeed * ySpeed, ySpeed);
      zRotation = Math.copySign(zRotation * zRotation, zRotation);
    }

    Vector2d input = new Vector2d(ySpeed, xSpeed);
    double[] wheelSpeeds = new double[4];
    wheelSpeeds[0] = input.x + input.y + zRotation;
    wheelSpeeds[1] = -input.x + input.y - zRotation;
    wheelSpeeds[2] = -input.x + input.y + zRotation;
    wheelSpeeds[3] = input.x + input.y - zRotation;

    normalize(wheelSpeeds);

    frontLeft.set(ControlMode.PercentOutput, -wheelSpeeds[0]*Constants.kMaxClimbSpeed);
    rearLeft.set(ControlMode.PercentOutput, wheelSpeeds[1]*Constants.kMaxClimbSpeed);
    frontRight.set(ControlMode.PercentOutput, -wheelSpeeds[2]*Constants.kMaxClimbSpeed);
    rearRight.set(ControlMode.PercentOutput, wheelSpeeds[3]*Constants.kMaxClimbSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  protected double applyDeadband(double value, double deadband) {
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

  protected void normalize(double[] wheelSpeeds) {
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
