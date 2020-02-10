/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

// import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class ClimbSubsystem extends SubsystemBase {
  public final WPI_TalonSRX climbSRX = new WPI_TalonSRX(7);
  public final DoubleSolenoid climbSolenoid = new DoubleSolenoid(1, 2);
  public final DoubleSolenoid climbSolenoid2 = new DoubleSolenoid(/* The PCM CAN ID */ 9, 4, 5);


  // exampleDouble.set(kOff);
  // exampleDouble.set(kForward);
  // exampleDouble.set(kReverse);


  /**
   * Creates a new ExampleSubsystem.
   */
  public ClimbSubsystem() {

  }
  
  public void getBumperStatus(XboxController xbox){
    xbox.getBumper(Hand.kLeft);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
