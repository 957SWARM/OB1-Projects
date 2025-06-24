package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain{

    double deadband = .05;
    CANSparkMax leftMotor = new CANSparkMax(1, MotorType.kBrushless);
    CANSparkMax rightMotor = new CANSparkMax(2, MotorType.kBrushless);

    

    public Drivetrain(){

        leftMotor.restoreFactoryDefaults();
        rightMotor.restoreFactoryDefaults();

        leftMotor.setIdleMode(IdleMode.kBrake);
        rightMotor.setIdleMode(IdleMode.kBrake);

    }

    public void tankDrive(double leftStick, double rightStick){
        if(leftStick > deadband || leftStick < -deadband){
            leftMotor.set(leftStick);
        }
        else{
            leftMotor.set(0);
        }

        if(rightStick > deadband || rightStick < -deadband){
            rightMotor.set(-rightStick);
        }
        else{
            rightMotor.set(0);
        }
    }

    public void arcadeDrive(double leftStick, double rightStick){

        if(rightStick == 0 || leftStick > deadband || leftStick < -deadband){
            leftMotor.set(leftStick);
            rightMotor.set(-leftStick);
        }
        if(rightStick > deadband || rightStick < -deadband){
            leftMotor.set(-rightStick);
            rightMotor.set(-rightStick);
        }
        if( (rightStick < deadband && rightStick > -deadband) && (leftStick < deadband && leftStick > -deadband) ){
            leftMotor.set(0);
            rightMotor.set(0);
        }

    }

}
