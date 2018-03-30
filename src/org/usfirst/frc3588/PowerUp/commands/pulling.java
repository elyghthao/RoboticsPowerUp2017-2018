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
import org.usfirst.frc3588.PowerUp.Robot;
import org.usfirst.frc3588.PowerUp.RobotMap;

/**
 *
 */
public class pulling extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public pulling() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.wheels);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	/*
    	 * Right Side is Official Side
    	 */
    	RobotMap.wheelsrightWheel.set(0.0);
    	RobotMap.wheelsleftWheel.set(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	//These move the arms individually
    	while (Robot.oi.controller.getRawButton(2)) {
    		if (Robot.oi.controller.getPOV() == 90) {
    			RobotMap.armshorizontalMotorRight.set(-0.5);
    		}
    		else if (Robot.oi.controller.getPOV() == 270) {
    			RobotMap.armshorizontalMotorRight.set(0.5);
    		}else {
    			RobotMap.armshorizontalMotorRight.set(-0.0);
    		}
    	}
    	while(Robot.oi.controller.getRawButton(3)) {
    		if (Robot.oi.controller.getPOV() == 90) {
    			RobotMap.armshorizontalMotorLeft.set(-0.5);
    		}else if (Robot.oi.controller.getPOV() == 270) {
    			RobotMap.armshorizontalMotorLeft.set(0.5);
    		}else {
    			RobotMap.armshorizontalMotorLeft.set(-0.0);
    		}
    	}
    	
    	
    	//This moves both arms
    	if ((Robot.oi.controller.getPOV() == 270) && (!Robot.oi.controller.getRawButton(2)) && (!Robot.oi.controller.getRawButton(3)) ) {
        	RobotMap.wheelsleftWheel.set(1.0);
        	RobotMap.wheelsrightWheel.set(1.0);	
    	}
    	else if (Robot.oi.controller.getPOV() == 90  && (!Robot.oi.controller.getRawButton(2)) && (!Robot.oi.controller.getRawButton(3))) {
    		RobotMap.wheelsleftWheel.set(-1.0);
    		RobotMap.wheelsrightWheel.set(-1.0);
    	}else {
    		RobotMap.wheelsrightWheel.set(0.0);
        	RobotMap.wheelsleftWheel.set(0.0);
    	}
//    	System.out.println(Robot.oi.controller.getPOV());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	RobotMap.wheelsrightWheel.set(0.0);
    	RobotMap.wheelsleftWheel.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
