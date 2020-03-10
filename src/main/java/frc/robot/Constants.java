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
    public static boolean testMode = false;
    public static boolean squareInputs = true;

    public static double kMaxSpeed = 1.25;
    public static double kDeadBand = 0.05;
    public static double kMaxArmSpeed = 0.7;
    
    public static int kJoystickChannel = 0;
    public static int kArmSpark = 1;
    public static int kIntakeSpark = 0;
    public static int kClimbSpark = 2;
    
    public static int kFrontLeftChannel = 1;
    public static int kRearLeftChannel = 3;
    public static int kFrontRightChannel = 0;
    public static int kRearRightChannel = 2;
}
