// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase {
  /** Creates a new driveTrain. */

  WPI_TalonFX motor0;
  WPI_TalonFX motor1;
  WPI_TalonFX motor2;
  WPI_TalonFX motor3;

  SpeedControllerGroup leftMotors, rightMotors;
  DifferentialDrive diffDrive;

  public driveTrain(int a, int b, int c, int d) {
    motor0 = new WPI_TalonFX(a);
    motor1 = new WPI_TalonFX(b);
    motor2 = new WPI_TalonFX(c);
    motor3 = new WPI_TalonFX(d);

    motor0.setNeutralMode(NeutralMode.Brake);
    motor1.setNeutralMode(NeutralMode.Brake);
    motor2.setNeutralMode(NeutralMode.Brake);
    motor3.setNeutralMode(NeutralMode.Brake);

    leftMotors = new SpeedControllerGroup(motor0, motor1);
    rightMotors = new SpeedControllerGroup(motor2, motor3);

    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tankDrive(double l, double r) {
    diffDrive.tankDrive(l, r);

  }
}
