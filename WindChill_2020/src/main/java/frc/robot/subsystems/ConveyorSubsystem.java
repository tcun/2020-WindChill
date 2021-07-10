/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyorSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public final WPI_TalonSRX conveyorMotor = new WPI_TalonSRX(8);

  public ConveyorSubsystem() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
