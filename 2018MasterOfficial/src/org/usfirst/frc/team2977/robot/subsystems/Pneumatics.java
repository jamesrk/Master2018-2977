package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Pneumatics extends Subsystem {

	/*
	public DigitalInput rotatecounter = new DigitalInput(1);
	public DigitalInput rotateclock = new DigitalInput(2);
	public DigitalInput pOut = new DigitalInput(3);
	public DigitalInput pIn = new DigitalInput(4);
	*/
	
	public int autoMode = 0;
	public int autoStart = 0; // 0 = L, 1 = M, 2 = R
	public int autoSide = 0; // 0 = L, 1 = R
	
	public boolean lowArm;
	public Boolean done = false;
	public DigitalInput lowerArm = new DigitalInput(0);
	public Boolean isDIrequired = true; // Is the Digital Input Required to finish the command?
	Compressor compressor = new Compressor(RobotMap.Compressor);
	Solenoid bottomPushOut = new Solenoid(RobotMap.BottomPushOutSolenoid); // Pushy thing go out
	Solenoid bottomPushIn = new Solenoid(RobotMap.BottomPushInSolenoid); // Pushy thing go in
	Solenoid topPushOut = new Solenoid(RobotMap.TopPushOutSolenoid); // Spinny thing spin
	Solenoid topPushIn = new Solenoid(RobotMap.TopPushInSolenoid); // Spinny thing stop spin
	Solenoid armUp = new Solenoid(RobotMap.ArmUpSolenoid);
	Solenoid armDown = new Solenoid(RobotMap.ArmDownSolenoid);

	public void BottomClawOpen() {
		bottomPushOut.set(false);
		bottomPushIn.set(true);
		}
	
	public void BottomClawClosed(){
		compressor.setClosedLoopControl(true);
		bottomPushIn.set(false);
		bottomPushOut.set(true);
		}
	
	public void LowArmUp() {
		lowArm = lowerArm.get();
		armDown.set(false);
		armUp.set(true);
		if (lowArm = false)
			done = true;
		SmartDashboard.putBoolean("Arm In", lowArm);
		}
	
	public void LowArmDown() {
		lowArm = lowerArm.get();
		armUp.set(false);
		armDown.set(true);
		if (lowArm = true)
			done = true;
		SmartDashboard.putBoolean("Arm In", lowArm);
		}
	
	public void TopClawClose() {
		topPushIn.set(false);
		topPushOut.set(true);
		}
	
	public void TopClawOpen() {
		topPushOut.set(false);
		topPushIn.set(true);
		}
	
	//Autonomous Code goes below here. Sharing one subsystem because why not
	public void autoPushIn() {
		bottomPushOut.set(false);
		bottomPushIn.set(true);
		}
	
	public void autoPushOut(){
		compressor.setClosedLoopControl(true);
		bottomPushIn.set(false);
		bottomPushOut.set(true);
		}
	
	public void autoArmUp() {
		armDown.set(false);
		armUp.set(true);
		}
	
	public void autoArmDown() {
		armUp.set(false);
		armDown.set(true);
		}
	
	public void autoSpin() {
		topPushIn.set(false);
		topPushOut.set(true);
		}
	
	public void autoStopSpinning() {
		topPushOut.set(false);
		topPushIn.set(true);
		}
	
	public void smartDash() {
		SmartDashboard.putNumber("Test", 1.0);
	}
	

	
    public void initDefaultCommand() {
    	//There are no default commands needed.
    }
}

