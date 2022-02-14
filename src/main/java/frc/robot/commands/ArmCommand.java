package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ControllerSubsystem;


public class ArmCommand extends CommandBase {
    private final ControllerSubsystem m_controllerSubsystem;
    private final ArmSubsystem m_armSubsystem;

    public ArmCommand(ArmSubsystem armSubsystem, ControllerSubsystem controllerSubsystem) {
        m_controllerSubsystem = controllerSubsystem;
        m_armSubsystem = armSubsystem;
        addRequirements(m_controllerSubsystem, m_armSubsystem);
    }

    @Override
    public void initialize() {
        m_armSubsystem.MoveArm(-0.65);
        System.out.println("Turning on arm!");
    }
    @Override
    public void execute() {
        System.out.println("Arm running!");
    }
    @Override
    public void end(boolean interrupted) {
        m_armSubsystem.MoveArm(0.0);
        System.out.println("Turning off Arm!");
    }
}