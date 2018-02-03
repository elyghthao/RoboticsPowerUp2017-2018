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
public class moveElevatorAuto extends Command {
	private double m_power;
	private double m_encoderDistance;
	
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public moveElevatorAuto(double power, double encoderDistance) {
   
    	

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    	m_power = -power;
    	m_encoderDistance = encoderDistance;
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	RobotMap.elevatorliftEncoder.reset();
    	RobotMap.elevatorliftMotor.set(0.0);
    	if (m_encoderDistance < 0) {
    		m_power *= -1;
    		
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	
    	RobotMap.elevatorliftMotor.set(m_power);
    	System.out.println(RobotMap.elevatorliftEncoder.getRaw());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	
    	if (m_encoderDistance > 0) {
    		return RobotMap.elevatorliftEncoder.getRaw() >= m_encoderDistance;
    	}else {
    	return RobotMap.elevatorliftEncoder.getRaw() <= m_encoderDistance;
    	}
    	
    	
    }
    

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	RobotMap.elevatorliftMotor.set(RobotMap.STOP);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
