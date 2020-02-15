/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.Delay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class RunConveyor extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final IntakeSubsystem m_subsystem;
  private Delay d = null;

  
  boolean checkIsDone = false;
  boolean isRunning = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunConveyor(IntakeSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.deployPiston.set(Value.kForward);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ( m_subsystem.limitSwitchCounter < 4) {
      if (m_subsystem.limitSwitch.get() == true) {
        m_subsystem.conveyorMotor.set(Constants.getConveyorForwardSpeed());
        isRunning = true;
      } 
      else if(isRunning && d == null){
        d = new Delay(Constants.getConveyorIntervalTime());
      }
      else if(d != null && d.isExpired()){
        m_subsystem.conveyorMotor.set(0);
        isRunning = false;
        d = null;
        m_subsystem.limitSwitchCounter++;
      }
    }
    else if(m_subsystem.limitSwitch.get() == true){
      m_subsystem.limitSwitchCounter = 5;
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
