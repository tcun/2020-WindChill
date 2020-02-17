/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TriggerSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  // return m_subsystem.TriggerSubsystem

  public static double axis;

  public TriggerSubsystem() {
  }

  public static double CompareTrigAxis(XboxController xbox) {
    if (xbox.getTriggerAxis(Hand.kLeft) > xbox.getTriggerAxis(Hand.kRight)) {
      axis = xbox.getTriggerAxis(Hand.kLeft);
    } else if (xbox.getTriggerAxis(Hand.kLeft) < xbox.getTriggerAxis(Hand.kRight)) {
      axis = -xbox.getTriggerAxis(Hand.kRight);
    }
    return axis;
  }

  // }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public double LeftTriggerAxis(XboxController xbox) {
    return xbox.getTriggerAxis(Hand.kLeft);
  }
}
