/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTablesJNI;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * An example command that uses an example subsystem.
 */
public class LineUpToShoot extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrainSubsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   * 
   * @param subsystem The subsystem used by this command.
   */

  double tx = LimelightSubsystem.getTx();
  double Kp = -0.1f;
  double min_command = 0.05;

  double left_command = 0;
  double right_command = 0;

  // double moveP;
  // double moveI;
  // double moveError;
  // double moveIntegral;
  // double moveSetPoint;
  // double moveVisionValue;
  // double moveSpeed;

  public LineUpToShoot(DriveTrainSubsystem subsystem) {
    m_subsystem = subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double heading_error = -tx;
    double steering_adjust = 0.0;
    if (tx > 1.0) {
      steering_adjust = Kp * heading_error - min_command;
    } 
    else if (tx < 1.0) {
      steering_adjust = Kp * heading_error + min_command;
    }
    left_command += steering_adjust;
    right_command -= steering_adjust;

    if (left_command > 0.1){
      left_command = 0.1;
    }
    if (right_command > 0.1){
      right_command = 0.1;
    }

    m_subsystem.robotDrive.tankDrive(left_command, right_command);

    // turnVisionValue = table.getEntry("Horizontal Target Center").getDouble(240);

    // turnError = turnSetPoint - turnVisionValue;
    // turnIntegral = turnIntegral + (turnError*20);
    // turnSpeed = (turnP*turnError + turnI*turnIntegral)/2;
    // if (turnSpeed > 0.2){
    // turnSpeed = 0.2;
    // }
    // if (turnError >= -10 && turnError <= 10){
    // m_subsystem.robotDrive.tankDrive(turnSpeed, -turnSpeed);
    // }
    // if (turnError >= -5 && turnError <= 5) {
    // moveError = moveSetPoint - moveVisionValue;
    // moveIntegral = moveIntegral + (moveError*20);
    // moveSpeed = (moveP*moveError + moveI*moveIntegral)/2;
    // }
    // if (moveSpeed > 0.3){
    // moveSpeed = 0.3;
    // }
    // if (moveError >= -5 && moveError <= 5)
    // m_subsystem.robotDrive.tankDrive(moveSpeed, moveSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.robotDrive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return tx < 2 && tx > -2;
  }
}
