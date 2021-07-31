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

//import com.analog.adis16448.frc.ADIS16448_IMU;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;

//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PWM;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  public final WPI_TalonSRX leftMotorFront = new WPI_TalonSRX(1);
  public final WPI_TalonSRX leftMotorBack = new WPI_TalonSRX(2);
  public final SpeedControllerGroup leftDriveMotors = new SpeedControllerGroup(leftMotorFront, leftMotorBack);

  public final WPI_TalonSRX rightMotorFront = new WPI_TalonSRX(3);
  public final WPI_TalonSRX rightMotorBack = new WPI_TalonSRX(4);
  public final SpeedControllerGroup rightDriveMotors = new SpeedControllerGroup(rightMotorFront, rightMotorBack);

  public final DifferentialDrive robotDrive = new DifferentialDrive(leftDriveMotors, rightDriveMotors);

  // public final DigitalOutput di = new DigitalOutput(1);
  public final WPI_TalonSRX LED = new WPI_TalonSRX(7);

  // public final ADIS16448_IMU gyro = new ADIS16448_IMU();

  CANCoder leftFrontEncoder = new CANCoder(0);
  CANCoder rightFrontEncoder = new CANCoder(1);

  public DriveTrainSubsystem() {
    
  }

  public void takeXboxInputs(XboxController xbox) {
    robotDrive.tankDrive(-xbox.getY(Hand.kLeft), -xbox.getY(Hand.kRight));
  }

  public void takeJoystickInputs(Joystick leftJoy, Joystick rightJoy) {
    robotDrive.tankDrive(leftJoy.getY(), rightJoy.getY());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
