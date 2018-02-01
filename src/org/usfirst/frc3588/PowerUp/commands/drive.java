// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3588.PowerUp.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3588.PowerUp.OI;
import org.usfirst.frc3588.PowerUp.Robot;
import org.usfirst.frc3588.PowerUp.RobotMap;

/**
 *
 */
public class drive extends Command {
	double distance ;
	public double sliderInput = SmartDashboard.getNumber("DB/Slider 1", 0.0); 

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public drive() {
    	

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	RobotMap.chassisleftMotor.set(0);
    	RobotMap.chassisrightMotor.set(0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    		RobotMap.chassisleftMotor.set(Robot.oi.rightJoystick.getY());
    		RobotMap.chassisrightMotor.set(Robot.oi.leftJoystick.getY());
    		distance = RobotMap.chassisUltrasonic1.getRangeInches();
    		System.out.println(distance);
    		    	RobotMap.chassisleftMotor.set(Robot.oi.rightJoystick.getY());
    	RobotMap.chassisrightMotor.set(Robot.oi.leftJoystick.getY());
    	distance = RobotMap.chassisGyro.getAngle();
    	System.out.println(distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
