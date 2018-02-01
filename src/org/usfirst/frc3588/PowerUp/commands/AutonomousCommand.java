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
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3588.PowerUp.Robot;
import org.usfirst.frc3588.PowerUp.RobotMap;

/**
 *
 */
public class AutonomousCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
	private String consoleString = "";
	public static String position = "";
	public int delay = 0;
	public double dashData = SmartDashboard.getNumber("DB/Slider 0", 0.0); 
	public static String gameData;
	public static double Delay = SmartDashboard.getNumber("DB/Slider 2", 0.0);
	public double pickAuto = SmartDashboard.getNumber("DB/Slider 1", 0.0); 
	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCommand() {
    	

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	if (dashData == 0.0) {
    		position = "L"; 
    	}
    	else if (dashData == 1.0) {
    		position = "M";  
    	}
    	else if (dashData == 2.0) {
    		position = "R"; 
    	}
    	
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		setTimeout(delay * 2);
		
		while (!isTimedOut()) {
		
		}
		
		RobotMap.chassisleftMotor.set(RobotMap.STOP);
		RobotMap.chassisrightMotor.set(RobotMap.STOP);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    
    	AUTO_LOOP:
    	if (pickAuto == 0.0) {
    		Command autoRun = new AutoRun();
    		autoRun.start();
    		if (autoRun.isCompleted()) {
    			break AUTO_LOOP;
    		}
    	}
    	else if (pickAuto == 1.0) {
    		Command autoSwitch = new AutoSwitch(position, gameData);
    		autoSwitch.start();
    		if (autoSwitch.isCompleted()) {
    			break AUTO_LOOP;
    		}
    	}
    	else if (pickAuto == 2.0) {
    		Command ScalePosition = new scalePosition(position, gameData);
    		ScalePosition.start();
    		if (ScalePosition.isCompleted()) {
    			break AUTO_LOOP;
    		}
    	}
    	else {
    		Command newTest = new moveElevatorAuto(0.6, 15);
    			newTest.start();
    			if (newTest.isCompleted()) {
    				break AUTO_LOOP;
    			}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
        
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	RobotMap.chassisleftMotor.set(RobotMap.STOP);
		RobotMap.chassisrightMotor.set(RobotMap.STOP);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
