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
    public static final int TALON_TIMEOUT = 10;

    public static class Turret {

        public static final int TICKS_PER_DEGREE = 0;

        public static final int TURRET_JOYSTICK_DEGREES = 15; //angle of the turret will move in accordance to joystick position (0%-100%) every 20ms.

        public static final double KP = 0;

        public static final double KI = 0;

        public static final double KD = 0;

        public static final double TOLERANCE = 1;

        public static final double MAXIMUM_POSITION = 270;

        public static final double MINIMUM_POSITION = -40;

        public static final double MINIMUM_DEADZONE = 38;

        public static final double MAXIMUM_DEADZONE = 86;
    }

    public static final double G = 9.806;

    public static class Drivetrain {
        public static int TICKS_PER_METER = 0;
        public static int TICKS_PER_METER_2 = 0;
    }
}
