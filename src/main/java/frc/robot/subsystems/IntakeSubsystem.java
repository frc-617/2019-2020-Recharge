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

public class IntakeSubsystem extends SubsystemBase {
  private final Spark m_intakeSpark;

  /**
   * Creates a new DriveSubsystem.
   */
  public IntakeSubsystem() {
    m_intakeSpark = new Spark(Constants.kIntakeSpark);
  }

  public void Intake(double speed) {
    m_intakeSpark.setSpeed(speed);
  }
}
