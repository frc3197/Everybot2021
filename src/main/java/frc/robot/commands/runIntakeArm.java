// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakeArm;

public class runIntakeArm extends CommandBase {
  double armOutput;
  public intakeArm runIntakeArm;
  
  /** Creates a new runIntakeArm. */
  public runIntakeArm(intakeArm a, double armOutput) {
    runIntakeArm = a;
    this.armOutput = armOutput;
    addRequirements(runIntakeArm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //double output = runIntakeArm.getPIDController().calculate(runIntakeArm.getEncoderTicks(), 0);
    runIntakeArm.setIntakeMotorArm(.1 * armOutput);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    runIntakeArm.setIntakeMotorArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
