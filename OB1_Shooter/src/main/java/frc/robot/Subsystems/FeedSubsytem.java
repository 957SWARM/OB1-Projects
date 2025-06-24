package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FeedConstants;

import java.util.function.Supplier;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class FeedSubsytem extends SubsystemBase {
        
    SparkMax feed = new SparkMax(FeedConstants.FEED_MOTOR_ID, MotorType.kBrushless);

    Timer feedTimer = new Timer();

    public FeedSubsytem(){
        feedTimer.start();
    }

    public void periodic(){

        if(feedTimer.get() > FeedConstants.TOTAL_FEED_TIME){
            feedTimer.restart();
        }

    }


    public Command runFeedForward(){
        return this.run(() -> {

            if(feedTimer.get() > FeedConstants.TOTAL_FEED_TIME - FeedConstants.AGITATION_TIME){
                feed.setVoltage(FeedConstants.FEED_FORWARD_VOLTS);
            } else {
                feed.setVoltage(FeedConstants.FEED_REVERSE_VOLTS);
            }

        });
    }

    public Command stopFeed(){
        return this.run(()-> {
            feed.setVoltage(FeedConstants.FEED_STOP_VOLTS);
        });
    }

}
