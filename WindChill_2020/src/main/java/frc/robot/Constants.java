/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static double conveyorForwardSpeed = 0.5;
    public static double conveyorBackwardSpeed = -0.5;
    public static double shootSpeed = 0.8;
    public static double intakeSpeed = -0.5;
    public static double intakeReverseSpeed = 0.5;
    public static double autoDriveSpeed = 0.3;

    public static long conveyorIntervalTime = 1000;
    public static long activateConveyorTime = 5000;
    public static long activateIntakeTime = 1000;
    public static long autoDriveTime = 3000;
    public static long shootTime = 10000;

    
}
