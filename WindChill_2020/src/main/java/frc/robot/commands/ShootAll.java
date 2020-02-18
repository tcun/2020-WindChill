package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class ShootAll extends SequentialCommandGroup {

  public ShootAll(IntakeSubsystem m_intake, ShooterSubsystem m_shoot, ConveyorSubsystem m_convey) {
    addCommands(
        new ParallelCommandGroup(
          new Shoot(m_shoot, m_intake), 
          new SequentialCommandGroup(
            new WaitCommand(1),
            new ParallelCommandGroup(
             new ActivateIntakeWheels(m_intake), 
             new ActivateConveyor(m_convey)
        ))));


  }

}