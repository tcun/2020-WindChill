package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class ShootAll extends SequentialCommandGroup {

  public ShootAll(DriveTrainSubsystem m_drive, ShooterSubsystem m_shoot, ConveyorSubsystem m_convey) {
    addCommands(
        // new LineUpToShoot(m_drive),
        new LineUpToShoot(m_drive),
        new ParallelCommandGroup(
          new Shoot(m_shoot), 
          new SequentialCommandGroup(
            new WaitCommand(1),
            new ParallelCommandGroup(
             new ActivateConveyor(m_convey)
        ))));


  }

}