/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.Delay;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class RunConveyor extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final IntakeSubsystem m_subsystem;
  private final ConveyorSubsystem m_conveySub;

  private Delay d = null;

  boolean checkIsDone = false;
  boolean isRunning = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunConveyor(ConveyorSubsystem conveySub, IntakeSubsystem subsystem) {
    m_subsystem = subsystem;
    m_conveySub = conveySub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(conveySub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.deployPiston.set(Value.kForward);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (IntakeSubsystem.limitSwitchCounter < 4) {
      if (m_subsystem.limitSwitch.get() == false) {
        m_conveySub.conveyorMotor.set(Constants.conveyorForwardSpeed);
        isRunning = true;
      } else if (isRunning && d == null) {
        d = new Delay(Constants.conveyorIntervalTime);
      } else if (d != null && d.isExpired()) {
        m_conveySub.conveyorMotor.set(0);
        isRunning = false;
        d = null;
        IntakeSubsystem.limitSwitchCounter++;
      }
    } else if (m_subsystem.limitSwitch.get() == false && IntakeSubsystem.limitSwitchCounter < 5) {
      IntakeSubsystem.limitSwitchCounter = 5;
      m_subsystem.cancelIntake = true;
      m_subsystem.armRollerMotor.set(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
