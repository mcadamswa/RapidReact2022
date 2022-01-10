// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class arm extends SubsystemBase {


  private WPI_TalonFX motor = new WPI_TalonFX(Constants.armPort);



  /*
	 * Talon FX has 2048 units per revolution
	 * 
	 * https://phoenix-documentation.readthedocs.io/en/latest/ch14_MCSensor.html#sensor-resolution
	 */
	final int kUnitsPerRevolution = 2048; /* this is constant for Talon FX */

   /** Creates a new climberS1. */
  public arm() {

    motor.configFactoryDefault();

		motor.setNeutralMode(NeutralMode.Brake);
		motor.configOpenloopRamp(0.2, 0);

		motor.setNeutralMode(NeutralMode.Brake);
		motor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		motor.overrideLimitSwitchesEnable(true);
		motor.config_kP(0, 5, 10);
		motor.config_kD(0, 4000, 10);
		motor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
		motor.configMotionCruiseVelocity(0.01, 0); 
		motor.configMotionAcceleration(0.01, 0);
		
		//current limit                                                       enabled | Limit(amp) | Trigger Threshold(amp) | Trigger Threshold Time(s)  */
	  motor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(      true,       20,                25,                         1.0));

    //left.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);



  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getPosition(){
    double selSenPos = motor.getSelectedSensorPosition(0);
    return selSenPos;
  }

  public double getVelocity(){
    double selSenVel = motor.getSelectedSensorVelocity(0);
    return selSenVel;
  }

  public void setClimberPostion(double targetPos) {
  motor.set(ControlMode.MotionMagic, targetPos);
  }

  public void setInverted() {
    motor.setInverted(true);
  }


}