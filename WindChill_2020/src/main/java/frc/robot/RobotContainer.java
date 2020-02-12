/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.ActivateIntakeWheels;
import frc.robot.commands.DriveWithController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Shoot;
import frc.robot.commands.SpinControlMotor;
import frc.robot.commands.Climb;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PanelSpinnerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final DriveTrainSubsystem m_driveTrainSub = new DriveTrainSubsystem();
  public final PanelSpinnerSubsystem m_PanelSpinSub = new PanelSpinnerSubsystem();
  public final ShooterSubsystem m_ShootSub = new ShooterSubsystem();
  public final IntakeSubsystem m_intakeSub = new IntakeSubsystem();
  public final ClimbSubsystem m_ClimbSub = new ClimbSubsystem();

  
  public static XboxController xboxController = new XboxController(0);
  private static Joystick rightJoystick = new Joystick(0);
  private static Joystick leftJoystick = new Joystick(1);

  public final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public final DriveWithController drive = new DriveWithController(m_driveTrainSub);
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings & default commands

    m_driveTrainSub.setDefaultCommand(drive);

    configureButtonBindings();

    new JoystickButton(xboxController, Button.kA.value)
        .toggleWhenPressed(new ActivateIntakeWheels(m_intakeSub));

    new JoystickButton(xboxController, Button.kB.value)
        .whileHeld(new Shoot(m_ShootSub));

    new JoystickButton(xboxController, Button.kBumperLeft.value)
        .whenPressed(new Climb(m_ClimbSub));
      }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  public static XboxController getXboxController() {
    return xboxController;
  }
  public static Joystick getRightJoystick(){
    return rightJoystick;
  }
  public static Joystick getLeftJoystick(){
    return leftJoystick;
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
