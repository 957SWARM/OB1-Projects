package frc.robot.Subsystems;

import java.util.function.Supplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;


public class DrivebaseSubsystem extends SubsystemBase {

    SparkMax left = new SparkMax(1, MotorType.kBrushless);
    SparkMax right = new SparkMax(2, MotorType.kBrushless);

    //public void periodic() {

   // }

    public Command arcadeDrive(Supplier<Double> y, Supplier<Double> theta){
      return this.run(() -> {
        double ySpeed = y.get() * 3;
        double thetaSpeed = theta.get() * 10;

        double leftSpeed = -ySpeed + thetaSpeed;
        double rightSpeed = ySpeed + thetaSpeed;

        right.setVoltage(rightSpeed);
        left.setVoltage(leftSpeed);

        
      });  
    }
    
    
}
