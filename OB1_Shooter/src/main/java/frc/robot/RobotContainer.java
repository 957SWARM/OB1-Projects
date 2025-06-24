// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.FlywheelConstants;
import frc.robot.Constants.HoodConstants;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.FeedSubsytem;
import frc.robot.Subsystems.FlywheelSubsystem;
import frc.robot.Subsystems.HoodSubsystem;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  HoodSubsystem hood = new HoodSubsystem();
  FeedSubsytem feed = new FeedSubsytem();
  FlywheelSubsystem flywheel = new FlywheelSubsystem();
  DriveSubsystem drive = new DriveSubsystem();

  CommandXboxController xbox = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();

    drive.setDefaultCommand(
      drive.arcadeDrive(
        xbox::getLeftY, 
        xbox::getRightX
        )
    );

    hood.setDefaultCommand(hood.resetPosition());

    feed.setDefaultCommand(feed.stopFeed());

    flywheel.setDefaultCommand(flywheel.disableFlywheel());

  }

  private void configureBindings() {
    /*hoodReset = new Trigger(RobotState::isEnabled)
      .onTrue(hood.resetPosition()
      .until(hood::isAtMinimumLimit));*/

    xbox.b().toggleOnTrue(hood.setAngle(HoodConstants.Q1));
    xbox.a().toggleOnTrue(hood.setAngle(HoodConstants.Q2));
    xbox.x().toggleOnTrue(hood.setAngle(HoodConstants.Q3));
    xbox.y().toggleOnTrue(hood.setAngle(HoodConstants.Q4));

    xbox.rightBumper().toggleOnTrue(
      flywheel.enableFlywheel()
      .withTimeout(FlywheelConstants.SPIN_UP_TIME)
      .andThen(flywheel.enableFlywheel()
        .alongWith(feed.runFeedForward())));
  }
  
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
/*public static final int LEFT_MOTOR_ID = 1;
public static final int RIGHT_MOTOR_ID = 2;
public static final int HOOD_MOTOR_ID = 3;
public static final int FLYWHEEL_MOTOR_ID = 4;
public static final int FEED_MOTOR_ID = 5;*/