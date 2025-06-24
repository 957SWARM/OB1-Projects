package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HoodConstants;

import java.util.function.Supplier;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;

public class HoodSubsystem extends SubsystemBase {

    SparkMax hood = new SparkMax(HoodConstants.HOOD_MOTOR_ID, MotorType.kBrushless);
    RelativeEncoder encoder = hood.getEncoder();
    PIDController pid = new PIDController(HoodConstants.kp, HoodConstants.ki, HoodConstants.kd);

    private DigitalInput limitSwitch = new DigitalInput(0);

    public HoodSubsystem() {

    }
   
    public double getHoodAngle(){
        return encoder.getPosition()/HoodConstants.RATIO + HoodConstants.MIN_ANGLE;
    }

    public void periodic(){
        if (isAtMinimumLimit()){
            encoder.setPosition(0);
        }
    }

    public boolean isAtMinimumLimit(){
        return limitSwitch.get();

    }

    public Command resetPosition(){
        return this.run(() -> {
            if(isAtMinimumLimit()) {
                hood.setVoltage(0);
            } else {
                hood.setVoltage(-3);
            }
        });
    }

    public Command setAngle(double setpoint){
        return this.run(() -> {
            double voltage = pid.calculate(getHoodAngle(), setpoint);
            hood.setVoltage(voltage);
        });
    }

    public Command resetVoltage(){
        return this.run(() -> {
            hood.setVoltage(0);
        });
    }



}
