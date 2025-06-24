package frc.robot;

public final class Constants {
    public static final class HoodConstants {
        
        //Limit switch IDs
        public static final int HOOD_LIMIT_SWITCH_ID = 1;
        //CAN IDs
        public static final int HOOD_MOTOR_ID = 3;
        //Setpoints
        public static final double Q1 = 0;
        public static final double Q2 = 0;
        public static final double Q3 = 0;
        public static final double Q4 = 0;
        //PID
        public static final double kp = 1;
        public static final double ki = 0;
        public static final double kd = 0;
        //Volts
        public static final double STOP_VOLTS = 0;
        public static final double RESET_VOLTS = 0;
        //Ratio?
        public static final double RATIO = 1;
        //Angles
        public static final double MIN_ANGLE = 0;
        public static final double MAX_ANGLE = 1;
    }

    public static final class FlywheelConstants {
        //ID
        public static final int FLY_MOTOR_ID = 4;
        //Volts
        public static final double RUNNING_VOLTS = 1;
        public static final double OFF_VOLTS = 0;
        //Time
        public static final double SPIN_UP_TIME = 1;
    }

    public static final class FeedConstants {
        //ID
        public static final int FEED_MOTOR_ID = 5;
        //Volts
        public static final double FEED_FORWARD_VOLTS = 1;
        public static final double FEED_REVERSE_VOLTS = -1;
        public static final double FEED_STOP_VOLTS = 0;
        //Time
        public static final double TOTAL_FEED_TIME = 2.5;
        public static final double AGITATION_TIME = 0.5;




    }
}
