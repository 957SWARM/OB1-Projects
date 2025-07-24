// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.DrivebaseSubsystem;

public class RobotContainer {
 
  DrivebaseSubsystem drive = new DrivebaseSubsystem();

  CommandXboxController xbox = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();

    drive.setDefaultCommand(
      drive.arcadeDriveNormal(
        xbox::getLeftY, 
        xbox::getRightX
      )
    );

  //  
  }
  private void configureBindings() {
    xbox.rightTrigger()
    .whileTrue(
      drive.arcadeDriveTurbo(
        xbox::getLeftY,
        xbox::getRightX
      )
    );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
//