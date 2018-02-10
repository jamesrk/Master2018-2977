package org.usfirst.frc.team2977.robot.subsystems;


//import org.usfirst.frc.team2977.robot.Robot;
import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {

	//Declaring motor controllers
	//Talon left = new Spark(RobotMap.LeftDriveMotor);
	//Spark right = new Spark(RobotMap.RightDriveMotor);
	//Talon fR = new Talon(2);
	//Talon fL = new Talon(4);
	//Talon bR = new Talon(3);
	//Talon bL = new Talon(5);

	WPI_TalonSRX leftF = new WPI_TalonSRX(RobotMap.LeftDriveMotor);
	WPI_TalonSRX rightF = new WPI_TalonSRX(RobotMap.RightDriveMotor);
	WPI_TalonSRX leftB = new WPI_TalonSRX(RobotMap.LeftDriveMotorRev);
	WPI_TalonSRX rightB = new WPI_TalonSRX(RobotMap.RightDriveMotorRev);
	WPI_TalonSRX arm = new WPI_TalonSRX(RobotMap.armMotor);
	public AnalogInput ultraSonicFront = new AnalogInput(RobotMap.UltraSonicFront);
	public AnalogInput ultraSonicBack = new AnalogInput(RobotMap.UltraSonicBack);
	double deadZone = 0.2;
	double test = 0;
	
	//Delcaring interger for drive mode switch
	/** 1 is arcade, 2 is tank. Feel free to switch it above to driver preference. 
	 	If it gets set above 2 or below 1 it will probably break so please dont do anything crazy.
	 **/
	public int DriveMode = 1;
	public int Speed = 1;
	
	
	//Declaring sensors and anything else
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();	//This is our gyro. does not require port because it is plugged into the SPI on RoboRIO
	//double angle = gyro.getAngle();
	public double angle = gyro.getAngle();
	

	/*public void ArcadeDrive(double LeftY, double LeftX, double rightY) {
	public void ArcadeDrive(double LeftY, double LeftX, double rightY) {
		angle = gyro.getAngle();
		SmartDashboard.putNumber("Angle", angle);
		if ((LeftY <= deadZone) && (LeftY >= -deadZone))
			LeftY = 0;
		if ((LeftX <= deadZone) && (LeftX >= -deadZone))
			LeftX = 0;
		if (Speed == 1) {
			leftF.set((-LeftY + LeftX) / 4);
			rightF.set((LeftY + LeftX) / 4);
			leftB.set((-LeftY + LeftX) / 4);
			rightB.set((LeftY + LeftX) / 4);
		}
		if (Speed == 2) {
			leftF.set((-LeftY + LeftX) / 2);
			rightF.set((LeftY + LeftX) / 2);
			leftB.set((-LeftY + LeftX) / 2);
			rightB.set((LeftY + LeftX) / 2);
		}
		
		//hi
		
		double leftget = leftB.get();
		double rightget = rightB.get();
		double ultraFget = ultraSonicFront.pidGet();
		double ultraBget = ultraSonicBack.pidGet();
		SmartDashboard.putNumber("UltraSonicFront", ultraFget);
		SmartDashboard.putNumber("UltraSonicBack", ultraBget);
		SmartDashboard.putNumber("Left", leftget);
		SmartDashboard.putNumber("Right", rightget);
	}
	
	public void TankDrive(double LeftY, double LeftX, double RightY) {
		angle = gyro.getAngle();
		SmartDashboard.putNumber("Angle", angle);
		test = test + 0.01;
		SmartDashboard.putNumber("Test", test);
		if ((LeftY <= deadZone) && (LeftY >= -deadZone))
			LeftY = 0;
		if ((RightY <= deadZone) && (RightY >= -deadZone))
			RightY = 0;
		if (Speed == 1) {
			leftF.set((-LeftY) / 4);
			rightF.set((RightY) / 4);
			leftB.set((-LeftY) / 4);
			rightB.set((RightY) / 4);
		}
		if (Speed == 2) {
			leftF.set((-LeftY) / 2);
			rightF.set((RightY) / 2);
			leftB.set((-LeftY) / 2);
			rightB.set((RightY) / 2);
		}
		
		
	}
*/
	public void Driving(double LeftY, double LeftX) {
		leftF.set(LeftY - LeftX);
		leftB.set(LeftY - LeftX);
		rightF.set(-LeftY - LeftX);
		rightB.set(-LeftY - LeftX);
	}

	public void ArmMove() {
		
	}
	/*
	
	6 ft = 0.66
	5 ft = 0.55
	4 ft = 0.44
	3 ft = 0.27
	2 ft = 0.22
	1 ft = 0.11
	
	AI = ft / 9.090909
	ft = AI * 9.090909
	
	*/
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
}

