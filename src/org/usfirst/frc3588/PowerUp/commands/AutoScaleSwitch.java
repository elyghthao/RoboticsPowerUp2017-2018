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

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc3588.PowerUp.subsystems.*;

/**
 *
 */
public class AutoScaleSwitch extends CommandGroup {
	boolean sameSwitch = false;
	boolean sameScale = false;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoScaleSwitch(String robotPosition, String switchPosition, String scalePosition) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
    	addSequential(new grabCube());
    	addParallel(new holdCube());
    	
    	// if in middle, go for switch
    	//addSequential (new moveElevatorAuto(0.5, 4000));//power encoderDistance
    	if (robotPosition.charAt(0) == 'M') {
    		// checks which side switch is on
    		// moves robot to same side as switch
    		addSequential (new newDriveStraight(0.8, 3.0, 700));
    		
    		if (switchPosition.charAt(0) == 'R') {
    			addSequential (new Pivot(-80.0)); //turn right 90 degrees
    			addSequential (new newDriveStraight(0.8, 3.0, 500));
    			addSequential (new Pivot(80.0)); //turn left 90 degrees
    		} else {	
    			addSequential (new Pivot(80.0)); //turn left 90 degrees
    			addSequential (new newDriveStraight(0.8, 3.0, 500));
    			addSequential (new Pivot(-80.0)); //turn right 90 degrees
    			
    		}
    		
    		// robot should be on the same side as switch by end of if/else statement
    		
    		
    		addSequential (new moveElevatorAuto(1, 12000));
        	addSequential (new newDriveStraight (0.7, 0.5, 1200));
        	addParallel ( new shootAuto(0.5));
        	addSequential (new newDriveStraight (-0.3, 0.5, 400));
        	
        	addSequential (new moveElevatorAuto(-0.5, 500));//power encoderDistance
        	
    		
    	}
    	
    	
    	if (robotPosition.charAt(0) == switchPosition.charAt(0)) {
    		sameSwitch = true;
    	}
    	if (robotPosition.charAt(0) == scalePosition.charAt(1)) {
    		sameScale = true;
    	}
    	
    	if (robotPosition.charAt(0) != 'M') {
    			if (sameSwitch) {
    			addSequential (new newDriveStraight(0.7, 2.0, 2500));
    		
    			if (switchPosition.charAt(0) == 'R') {
    				addSequential (new Pivot(80.0)); //turn left 90 degrees
    			} else {
    				addSequential (new Pivot(-80.0)); //turn right 90 degrees
    			}
    			//addSequential (new newDriveStraight(0.3, 0.0, 500));
    		
    			addSequential (new moveElevatorAuto(1, 8000));//power encoderDistance
        		addSequential (new newDriveStraight (0.5, 0.5, 500));
        		addParallel ( new shootAuto(0.5));
        		addSequential (new newDriveStraight (-0.5, 0.5, 1));
        	
        		
    		}else {
    			addSequential(new newDriveStraight (0.7, 0, 2000));
    			
    		}
    	}
    	
//    	else if (sameScale) {
//    		addSequential (new newDriveStraight(.5, .5, 1200));//power time distance
//    		if (robotPosition.charAt(0) == 'L' ) {
//    			addSequential (new Pivot(90.0));
//    			} else {
//    				addSequential (new Pivot (-90.0));
//    			}	
//    		addSequential (new moveElevatorAuto(0.5,500));//Move Elevator Up, to scale height
//    		addSequential (new newDriveStraight (.5, .5, 1));//newDrive Towards Scale
//    		addParallel ( new shootAuto(0.5));//Shoot Out Cube
//    		addSequential (new newDriveStraight (-.5, .5, 1));//lower elevator down
//    		addSequential (new moveElevatorAuto(-0.5,-500));//power encoderDistance
//    	}
    	
    	else {
    		//addSequential (new AutoRun());
    		
    	}
    } 
}
