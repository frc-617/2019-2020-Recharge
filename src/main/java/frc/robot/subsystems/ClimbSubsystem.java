/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
  private final Spark m_climbMotor;

  /**
   * Creates a new DriveSubsystem.
   */
  public ClimbSubsystem() {
    m_climbMotor = new Spark(Constants.kClimbChannel);
  }

  public void Climb(double speed) {
    m_climbMotor.setSpeed(speed*Constants.kMaxClimbSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
