// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intakeArm extends SubsystemBase {
  private PIDController pidController;
  public static WPI_TalonFX intakeMotorArm;
  /** Creates a new intakeArm. */
  public intakeArm() {
    intakeMotorArm = new WPI_TalonFX(Constants.intakeMotorArmID);
    pidController = new PIDController(0, 0, 0);
  }

  public PIDController getPIDController(){
      return pidController;
  }

  public double getEncoderTicks(){
    return intakeMotorArm.getSelectedSensorPosition();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setIntakeMotorArm(double speed){
    intakeMotorArm.set(ControlMode.PercentOutput, speed);
  }
  
}
