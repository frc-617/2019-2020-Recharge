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

public class ArmSubsystem extends SubsystemBase {
  private final Spark m_armMotor;

  /**
   * Creates a new DriveSubsystem.
   */
  public ArmSubsystem() {
    m_armMotor = new Spark(Constants.kArmChannel);
  }

  public void Move(double speed) {
    m_armMotor.setSpeed(speed*Constants.kMaxArmSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
