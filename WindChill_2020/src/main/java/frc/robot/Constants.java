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
    private static double conveyorForwardSpeed = -0.5;
    private static double conveyorBackwardSpeed = 0.5;
    private static double shootSpeed = 0.5;
    private static double intakeSpeed = -0.5;
    private static double intakeReverseSpeed = 0.5;
    private static double autoDriveSpeed = 0.3;

    private static long conveyorIntervalTime = 1000;
    private static long activateConveyorTime = 5000;
    private static long activateIntakeTime = 1000;
    private static long autoDriveTime = 3000;
    private static long shootTime = 10000;


    public static double getConveyorForwardSpeed(){
        return conveyorForwardSpeed;
    }
    public static double getConveyorBackwardSpeed(){
        return conveyorBackwardSpeed;
    }
    public static double getShootSpeed(){
        return shootSpeed;
    }
    public static double getIntakeSpeed(){
        return intakeSpeed;
    }
    public static double getIntakeReverseSpeed(){
        return intakeReverseSpeed;
    }
    public static double getAutoDriveSpeed(){
        return autoDriveSpeed;
    }

    public static long getConveyorIntervalTime(){
        return conveyorIntervalTime;
    }
    public static long getActivateConveyorTime(){
        return activateConveyorTime;
    }
    public static long getActivateIntakeTime(){
        return activateIntakeTime;
    }
    public static long getAutoDriveTime(){
        return autoDriveTime;
    }
    public static long getShootTime(){
        return shootTime;
    }
}
