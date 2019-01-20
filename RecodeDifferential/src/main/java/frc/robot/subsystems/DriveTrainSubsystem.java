/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDriveCommand;

/**
 * Add your docs here.
 */
public class DriveTrainSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Talon leftMotor = new Talon(RobotMap.leftMotorPort);
  public Talon rightMotor = new Talon(RobotMap.rightMotorPort);

  public DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

  //Empty Constructor
  public DriveTrainSubsystem(){

  }

  public void manualDrive(double power, double angle){
    //This sets a deadzone on the power function joystick
    if(Math.abs(power) < RobotMap.deadzone) power = 0;

    //This can set a max speed ~ Rahul
    // if(power > RobotMap.maxSpeed) power = RobotMap.maxSpeed;
    // if(power < RobotMap.minSpeed) power = RobotMap.minSpeed;

    drive.arcadeDrive(power, angle);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualDriveCommand());
  }
}
