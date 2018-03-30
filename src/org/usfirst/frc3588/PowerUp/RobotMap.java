// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3588.PowerUp;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX chassisleftMotor;
    public static WPI_TalonSRX chassisrightMotor;
    public static RobotDrive chassisRobotDrive;
    public static Encoder chassisrightMotorEncoder;
    public static WPI_TalonSRX elevatorliftMotor;
    public static Encoder elevatorliftEncoder;
    public static DigitalInput elevatorLimitSwitchBottom;
    public static DigitalInput elevatorLimitSwitchTop;
    public static WPI_TalonSRX armshorizontalMotorLeft;
    public static WPI_TalonSRX armshorizontalMotorRight;
    public static WPI_TalonSRX armsclimbingMotor;
    public static WPI_TalonSRX wheelsleftWheel;
    public static WPI_TalonSRX wheelsrightWheel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static ADXRS450_Gyro chassisGyro;
    
    public static final double STOP = 0.0;
    public static final double TURN_SPEED = 0.5;
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisleftMotor = new WPI_TalonSRX(2);
        
        
        chassisrightMotor = new WPI_TalonSRX(1);
        
        
        chassisRobotDrive = new RobotDrive(chassisleftMotor, chassisrightMotor);
        
        chassisRobotDrive.setSafetyEnabled(true);
        chassisRobotDrive.setExpiration(0.1);
        chassisRobotDrive.setSensitivity(0.5);
        chassisRobotDrive.setMaxOutput(1.0);
        chassisRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        chassisrightMotorEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "rightMotorEncoder", chassisrightMotorEncoder);
        chassisrightMotorEncoder.setDistancePerPulse(1.0);
        chassisrightMotorEncoder.setPIDSourceType(PIDSourceType.kRate);
        elevatorliftMotor = new WPI_TalonSRX(3);
        
        
        elevatorliftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Elevator", "liftEncoder", elevatorliftEncoder);
        elevatorliftEncoder.setDistancePerPulse(1.0);
        elevatorliftEncoder.setPIDSourceType(PIDSourceType.kRate);
        elevatorLimitSwitchBottom = new DigitalInput(4);
        LiveWindow.addSensor("Elevator", "LimitSwitchBottom", elevatorLimitSwitchBottom);
        
        elevatorLimitSwitchTop = new DigitalInput(5);
        LiveWindow.addSensor("Elevator", "LimitSwitchTop", elevatorLimitSwitchTop);
        
        armshorizontalMotorLeft = new WPI_TalonSRX(6);
        
        
        armshorizontalMotorRight = new WPI_TalonSRX(0);
        
        
        armsclimbingMotor = new WPI_TalonSRX(7);
        
        
        wheelsleftWheel = new WPI_TalonSRX(5);
        
        
        wheelsrightWheel = new WPI_TalonSRX(4);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisGyro = new ADXRS450_Gyro();
    }
}
