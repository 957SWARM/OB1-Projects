package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

import java.util.function.Supplier;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;

public class FlywheelSubsystem extends SubsystemBase{
    
    SparkMax flywheel = new SparkMax(FlywheelConstants.FLY_MOTOR_ID, MotorType.kBrushless);


    public Command enableFlywheel(){
        return this.run(() -> {
            flywheel.setVoltage(FlywheelConstants.RUNNING_VOLTS);
        });
    }

    public Command disableFlywheel(){
        return this.run(() -> {
            flywheel.setVoltage(FlywheelConstants.OFF_VOLTS);
        });
    }
}
