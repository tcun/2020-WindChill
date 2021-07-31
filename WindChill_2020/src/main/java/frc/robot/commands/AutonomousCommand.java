package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class AutonomousCommand extends SequentialCommandGroup {

  public AutonomousCommand(DriveTrainSubsystem m_drive, ShooterSubsystem m_shoot, ConveyorSubsystem m_convey) {
    addCommands(
      new DriveForward(m_drive), 
      new GyroTurnLeft(m_drive),
      new ShootAll(m_drive, m_shoot, m_convey),
      new GyroTurnRight(m_drive),
      new ParallelCommandGroup(
        new DriveForward(m_drive),
        new ActivateConveyor(m_convey)), 
        new DriveBackward(m_drive), // Calibrate Time
        new GyroTurnLeft(m_drive),
        new ShootAll(m_drive, m_shoot, m_convey)
   
     
      
      
    );

// drive backward, aim and shoot, turn back, drive backward and intake balls, drive forward same distance, turn and shoot. then I-an takes it from there

  }

}