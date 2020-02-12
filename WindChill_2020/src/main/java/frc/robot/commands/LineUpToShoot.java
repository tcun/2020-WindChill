/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class LineUpToShoot extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainSubsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LineUpToShoot(DriveTrainSubsystem subsystem) {
    m_subsystem = subsystem;
    double turnP;
    double turnI;
    double turnError;
    double turnIntegral;
    double turnSetPoint;
    double turnVisionValue;
    double turnSpeed;
    double moveP;
    double moveI;
    double moveError;
    double moveIntegral;
    double moveSetPoint;
    double moveVisionValue;
    double moveSpeed;
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
    // turnError = turnSetPoint - turnVisionValue;
    // turnIntegral = turnIntegral + (turnError*20);
    // turnSpeed = (P*error + I*integral)/2;
    // if (turnError >= -5 || turnError <= 5){
      // m_subsystem.robotDrive.tankDrive(turnSpeed, -turnSpeed);
    // }

    // if (turnError >= -5 ++ turnError <= 5) {
    // moveError = moveSetPoint - moveVisionValue;
    // moveIntegral = moveIntegral + (moveError*20);
    // moveSpeed = (moveP*moveError + moveI*moveIntegral)/2;
    // if (moveError >= -5 ++ moveError <= 5)
      // m_subsystem.robotDrive.tankDrive(moveSpeed, -moveSpeed);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.robotDrive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
