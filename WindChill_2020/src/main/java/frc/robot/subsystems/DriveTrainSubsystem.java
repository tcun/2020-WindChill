/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import com.analog.adis16448.frc.ADIS16448_IMU;

// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private final WPI_TalonSRX leftMotorFront = new WPI_TalonSRX(1);
  private final WPI_TalonSRX leftMotorBack = new WPI_TalonSRX(2); 
  private final SpeedControllerGroup leftDriveMotors = new SpeedControllerGroup(leftMotorFront, leftMotorBack);

  private final WPI_TalonSRX rightMotorFront = new WPI_TalonSRX(3); 
  private final WPI_TalonSRX rightMotorBack = new WPI_TalonSRX(4); 
  private final SpeedControllerGroup rightDriveMotors = new SpeedControllerGroup(rightMotorFront, rightMotorBack);


  public final DifferentialDrive robotDrive = new DifferentialDrive(leftDriveMotors, rightDriveMotors);

  CANCoder leftFrontEncoder = new CANCoder(0);
  CANCoder rightFrontEncoder = new CANCoder(1);

  
  public DriveTrainSubsystem() {

  }
  public void takeXboxInputs(XboxController xbox)
    {   
      robotDrive.tankDrive(-xbox.getY(Hand.kLeft), -xbox.getY(Hand.kRight));
    }

  public void takeJoystickInputs(Joystick leftJoy, Joystick rightJoy){
    robotDrive.tankDrive(leftJoy.getY(), rightJoy.getY());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
