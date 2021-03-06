/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  
  //PWM
  public static int leftMotorPort = 0;
  public static int rightMotorPort = 1;

  //USB
  public static int joystickPort = 0;

  //AdjustableValues
  public static double deadzone = 0.05;
  public static double maxSpeed = 0.5;
  public static double minSpeed = -0.5;

  //Driver Sation, Inside Selected Joystick/Controller
  public static int powerAxis = 1;
  public static int angleAxis = 4;


  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
