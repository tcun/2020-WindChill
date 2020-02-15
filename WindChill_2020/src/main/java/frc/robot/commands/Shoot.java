/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.util.Delay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class Shoot extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_subsystem;
  private final IntakeSubsystem m_intakeSub;
  private Delay d;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

   private long time = 0;
  boolean isDone = false;
  public Shoot(ShooterSubsystem subsystem, IntakeSubsystem intakeSub) {
    m_intakeSub = intakeSub;
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    d = new Delay(time);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.rightLaunchMotor.set(Constants.getShootSpeed());
    m_subsystem.leftLaunchMotor.set(Constants.getShootSpeed());
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.rightLaunchMotor.set(0);
    m_subsystem.leftLaunchMotor.set(0);
    m_intakeSub.cancelIntake = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return d.isExpired();
  }
}
