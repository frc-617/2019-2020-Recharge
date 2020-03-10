package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  private final Spark m_armSpark;

  /**
   * Creates a new DriveSubsystem.
   */
  public ArmSubsystem() {
    m_armSpark = new Spark(Constants.kArmSpark);
  }

  public void MoveArm(double speed) {
    m_armSpark.setSpeed(speed);
  }
}