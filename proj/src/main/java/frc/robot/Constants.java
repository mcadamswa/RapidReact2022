// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


 // hid ports \\ 
    public static int portDriverController = 0;
    public static int portCoDriverController = 1;
	public static int climberS1MotorLeft;
	public static int climberS1MotorRight;
	public static int armPort;
   
         
 // xbox buttons \\
    public final static int buttonA = 1;
    public final static int buttonB = 2;
    public final static int buttonX = 3; 
    public final static int buttonY = 4;
    public final int buttonO1 = -1;
    public final int buttonO2 = 8;
    public final int stickLeftDown = 9;
    public final int stickRightDown = 10;
    public final static int bumperLeft = 5;
    public final static int bumperRight = 6;

  //joystick axis lables 
  public static final int joystickX = 0;
  public static final int joystickY = 1;
  public static final int joystickZ = 2;




  
public static final int kPIDLoopIdx = 0;
public static final int kTimeoutMs = 0;
  



}
