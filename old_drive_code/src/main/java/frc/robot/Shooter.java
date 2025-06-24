package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter{

    TalonSRX rightMotor = new TalonSRX(4);
    TalonSRX leftMotor = new TalonSRX(3);
    CANSparkMax feeder = new CANSparkMax(5, MotorType.kBrushless);

    // Button port

    boolean oldButtonPressed = false;
    boolean newButtonPressed = false;
    boolean isShooting = false;


    public Shooter(){
        // when class first run, this limits current to 20 amps in VictorSPX and sets it to follow the Talon motor
        rightMotor.configFactoryDefault();
        leftMotor.configFactoryDefault();

        // rightMotor.configPeakCurrentLimit(20);
        // leftMotor.follow(rightMotor);
        rightMotor.set(ControlMode.PercentOutput, 0);
        leftMotor.set(ControlMode.PercentOutput, 0);
        feeder.set(0);
    }

    public void update(boolean button){

        // 50% power proved to be a good intermediate level. For middle school up.
        // 40% - elementary, 60% - long shot, 90-100% showoff
        if(button){
            System.out.println("running");
            leftMotor.set(ControlMode.PercentOutput, -.5);
            rightMotor.set(ControlMode.PercentOutput, -.5);
            feeder.set(.4);
        }   
        else{
            System.out.println("stopping");
            leftMotor.set(ControlMode.PercentOutput, 0);
            rightMotor.set(ControlMode.PercentOutput, 0);

            feeder.set(0);
        }
        
    }
}