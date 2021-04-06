// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class runIntake extends CommandBase {
  public intake runIntake;
  private double output;
  /** Creates a new runIntake. */
  public runIntake(intake a, double output) {
    runIntake = a;
    this.output = output;
    addRequirements(runIntake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    runIntake.setIntakeMotor(.75*output);
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    runIntake.setIntakeMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
