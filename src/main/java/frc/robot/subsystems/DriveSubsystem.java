/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private static final int kFrontLeftChannel = 1;
  private static final int kRearLeftChannel = 3;
  private static final int kFrontRightChannel = 0;
  private static final int kRearRightChannel = 2;

  private MecanumDrive m_robotDrive;

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    Spark frontLeft = new Spark(kFrontLeftChannel);
    Spark rearLeft = new Spark(kRearLeftChannel);
    Spark frontRight = new Spark(kFrontRightChannel);
    Spark rearRight = new Spark(kRearRightChannel);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    m_robotDrive.setSafetyEnabled(true);
  }

  public void mecanumDrive(double ySpeed, double xSpeed, double zRotation)
  {
    m_robotDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    m_robotDrive.feed();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
