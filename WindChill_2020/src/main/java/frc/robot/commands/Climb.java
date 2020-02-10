/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
// import edu.wpi.first.wpilibj.XboxController;
// import frc.robot.RobotContainer;

//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class Climb extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimbSubsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Climb(ClimbSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DoubleSolenoid.Value val = m_subsystem.climbSolenoid.get();

    

    if(frc.robot.RobotContainer.xboxController.getBumper(Hand.kLeft) == true) {
      if(val == DoubleSolenoid.Value.kForward) {
        m_subsystem.climbSolenoid.set(DoubleSolenoid.Value.kReverse);
        m_subsystem.climbSolenoid2.set(DoubleSolenoid.Value.kReverse);
		  } else {
        m_subsystem.climbSolenoid.set(DoubleSolenoid.Value.kForward);
        m_subsystem.climbSolenoid2.set(DoubleSolenoid.Value.kForward);
      }
    }
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // m_subsystem.climbSolenoid.set(Value.kOff);
    // m_subsystem.climbSolenoid2.set(Value.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
