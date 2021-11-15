/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


/**
 * An example command that uses an example subsystem.
 */
public class AutonomousCommand extends CommandBase {
  protected long startTime;
  protected long endTime;
  protected long currentTime;
  protected long duration;

  DriveSubsystem driveSubsystem;

  public AutonomousCommand(long durationMillis, DriveSubsystem driveSubsystem) {
    duration = durationMillis;
    this.driveSubsystem = driveSubsystem;
  }

  @Override
  public void initialize () {
    startTime = System.currentTimeMillis();
    endTime = startTime + duration;
  }

  @Override
  public void execute() {
    currentTime = System.currentTimeMillis();

    driveSubsystem.mecanumDrive(0.3, 0, 0);
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.mecanumDrive(0, 0, 0);
  }

  @Override
  public boolean isFinished () {
    return (currentTime >= endTime);
  }
}
