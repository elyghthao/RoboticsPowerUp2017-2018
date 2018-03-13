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
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3588.PowerUp.Robot;
import org.usfirst.frc3588.PowerUp.RobotMap;

/**
 *
 */
public class moveElevatorTele extends Command {
	public static double getY;
	public static boolean bottomLimit;
	public static boolean topLimit;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public moveElevatorTele() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	RobotMap.elevatorliftMotor.set(0.0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	
    	/*
    	 * Controller value is negative
    	 */
    	
    	
    	
    	
    	getY = Robot.oi.controller.getY();
    	bottomLimit = RobotMap.elevatorLimitSwitchBottom.get();
    	topLimit = RobotMap.elevatorLimitSwitchTop.get();
    	
    	if (getY > 0) {//This makes sure the negative value never exceed -0.5
    		getY *= 0.5;
    	}
    	//*******changes below can be changed to match with limit switch is used
    	//System.out.println("topLimit is " + topLimit);
    	//System.out.println("bottomLimit is " + bottomLimit);
    	//if (topLimit == false && bottomLimit == true) { //if elevator is in middle of constraints, not all the way top or bottom
    		//RobotMap.elevatorliftMotor.set(getY);
    	//}else if (topLimit == true) { //i0f elevator is low enough to trip bottom limit switch. What is not fully at bottom of elevator?
    		//if (getY < -0.05) { //if thumbstick is moving down, elevator might not fully reach the bottom ever
    			//getY=0; //set speed to zero
    			//System.out.println("getY is NEGATIVE");
    	//	}
    	//}else if (bottomLimit == false) { //if elevator is high enough to trip top limit switch. Might not fully reach top
//    		if (getY > 0.05) { //if thumb stick is moving up, elevator might not fully reach the top
//    			getY = 0; //set speed to zero
//    			System.out.println("getY is POSITIVE");
//    		}	
//    	}
//    	System.out.println("bottom limit is " + RobotMap.elevatorLimitSwitchBottom );
    	RobotMap.elevatorliftMotor.set(0.9 * getY);
    	double distance  = RobotMap.elevatorliftEncoder.get();
    	System.out.println("lift encoder is " + distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	
    	RobotMap.elevatorliftMotor.set(0.0);
    	RobotMap.elevatorliftEncoder.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	
    }
}
