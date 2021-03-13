// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.drive;
import frc.robot.commands.runIntake;
import frc.robot.commands.runIntakeArm;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.intakeArm;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public static XboxController driver = new XboxController(0);
  public driveTrain m_driveTrain = new driveTrain(0, 1, 2, 3);
  public intake Intake = new intake();
  public static JoystickButton driver0Button = new JoystickButton(driver, 0);
  public static JoystickButton driver1Button = new JoystickButton(driver, 1);
  //arm up and down buttons
  public intakeArm IntakeArm = new intakeArm();
  public static JoystickButton driver2Button = new JoystickButton(driver, 5);
  public static JoystickButton driver3Button = new JoystickButton(driver, 6);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    m_driveTrain.setDefaultCommand(new drive(m_driveTrain));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driver0Button.whileHeld(new runIntake(Intake, 1));
    driver1Button.whileHeld(new runIntake(Intake, -1));
    driver2Button.whileHeld(new runIntakeArm(IntakeArm, -1));
    driver3Button.whileHeld(new runIntakeArm(IntakeArm, 1));

   //this is down   driver2Button.toggleWhenPressed(new runIntake(IntakeArm));
    //this is up    driver3Button.toggleWhenPressed(new runIntake(IntakeArm));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static double getYLeftStick() {
    return driver.getY(Hand.kLeft);
  }

  public static double getYRightStick() {
    return driver.getY(Hand.kRight);
  }
}
