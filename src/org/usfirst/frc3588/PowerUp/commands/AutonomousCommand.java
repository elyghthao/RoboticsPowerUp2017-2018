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
 
	
	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	
	private String consoleString = "";
	static String position = "";
	private double dashData = SmartDashboard.getNumber("DB/Slider 0", 0.0); 
	static String gameData;
	private double Delay = SmartDashboard.getNumber("DB/Slider 2", 0.0);
	private double pickAuto = SmartDashboard.getNumber("DB/Slider 1", 0.0); 
	private final double AUTORUN = 0.0;
	private final double AUTOSWITCH = 1.0;
	private final double SCALEPOSITION = 2.0;
	
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
        Robot.Debug = SmartDashboard.getBoolean("DB/Button 0", false); 
    	if (dashData == 0.0) {
    		position = "L"; 
    	}
    	else if (dashData == 1.0) {
    		position = "M";  
    	}
    	else if (dashData == 2.0) {
    		position = "R"; 
    	}
    	
    	if (Robot.Debug) {
    		System.out.println("Robot Position is " + position);
    	}
    	
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		setTimeout(Delay * 2);
		
		while (!isTimedOut()) {
		
		}
		
		RobotMap.chassisleftMotor.set(RobotMap.STOP);
		RobotMap.chassisrightMotor.set(RobotMap.STOP);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    
    	AUTO_LOOP:
    	if (pickAuto == AUTORUN) {
    		Command autoRun = new AutoRun();
    		autoRun.start();
    		if (Robot.Debug) {
    			System.out.println("In AutoRun");
    		}
    		if (autoRun.isCompleted()) {
    			break AUTO_LOOP;
    		}
    	}
    	else if (pickAuto == AUTOSWITCH) {
    		Command autoSwitch = new AutoSwitch(position, gameData);
    		autoSwitch.start();
    		if (Robot.Debug) {
    			System.out.println("In AutoSwitch");
    		}
    		if (autoSwitch.isCompleted()) {
    			break AUTO_LOOP;
    		}
    	}
    	else if (pickAuto == SCALEPOSITION) {
    		Command ScalePosition = new scalePosition(position, gameData);
    		ScalePosition.start();
    		if (Robot.Debug) {
    			System.out.println("In scalePosition");
    		}
    		if (ScalePosition.isCompleted()) {
    			break AUTO_LOOP;
    		}
    	}
    	else {
    		System.out.println(pickAuto);
    		Command newTest = new moveElevatorAuto(0.5, -6000);
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
    	if (Robot.Debug) {
			System.out.println("In end");
		}
    	RobotMap.chassisleftMotor.set(RobotMap.STOP);
		RobotMap.chassisrightMotor.set(RobotMap.STOP);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
