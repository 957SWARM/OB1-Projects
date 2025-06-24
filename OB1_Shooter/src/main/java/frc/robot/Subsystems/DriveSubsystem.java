package frc.robot.Subsystems;

import java.util.function.Supplier;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{

        SparkMax left = new SparkMax(1, MotorType.kBrushless);
        SparkMax right = new SparkMax(2, MotorType.kBrushless);

        double maxFreeSpeed;

        public void periodic() {

        }

        public Command arcadeDrive(Supplier<Double> y, Supplier<Double> theta) {
            return this.run(() -> {
                double ySpeed = y.get();
                double thetaSpeed = theta.get();
    
                double leftSpeed = -ySpeed + thetaSpeed;
                double rightSpeed = ySpeed + thetaSpeed;
    
                right.setVoltage(rightSpeed * 3);
                left.setVoltage(rightSpeed *3);
               
            });
        }

        }

        

