package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Ports {
    public static class Drivetrain {
        public static final int MASTER_RIGHT = 12;
        public static final int SLAVE_RIGHT = 13;
        public static final int MASTER_LEFT = 10;
        public static final int SLAVE_LEFT = 11;
        public static final int SOLENOID = 1;
        public static final boolean MASTER_RIGHT_INVERTED = true;
        public static final boolean SLAVE_RIGHT_INVERTED = true;
        public static final boolean MASTER_RIGHT_SENSOR_PHASE = true;
        public static final boolean MASTER_LEFT_INVERTED = false;
        public static final boolean SLAVE_LEFT_INVERTED = false;
        public static final boolean MASTER_LEFT_SENSOR_PHASE = false;
    }

    public static class Turret {
        public static final int MASTER = 1;
    }


}

