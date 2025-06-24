// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  Joystick m_controller = new Joystick(0);
  // Shooter and the intake both are designed to run at the same time and are therefore in the same class, "Shooter"
  Shooter m_shooter = new Shooter();
  Drivetrain m_drivetrain = new Drivetrain();

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    //m_drivetrain.tankDrive(-m_controller.getRawAxis(1) * 0.25, -m_controller.getRawAxis(5) * 0.25);
    m_drivetrain.arcadeDrive(-m_controller.getRawAxis(1) * 0.25, -m_controller.getRawAxis(4) * 0.25);
    //m_shooter.update(m_controller.getRawButton(0));

    m_shooter.update(m_controller.getRawButton(1));

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
