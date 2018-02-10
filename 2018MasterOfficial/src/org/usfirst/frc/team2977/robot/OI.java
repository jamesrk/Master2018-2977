/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2977.robot;

import org.usfirst.frc.team2977.robot.commands.ArmCommand;
import org.usfirst.frc.team2977.robot.commands.PneumaticCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static int A = 1;
	public static int B = 2;
	public static int X = 3;
	public static int Y = 4;
	public static int LB = 5;
	public static int RB = 6;
	public static int Back = 7;
	public static int Start = 8;
	public static int L3 = 9;
	public static int R3 = 10;

	//This is still button mapping, we have everything called here for the joysticks and button
	Joystick stick = new Joystick(1);
	Joystick stick2 = new Joystick(2);
	Button A1 = new JoystickButton(stick, A);
	Button A2 = new JoystickButton(stick2, A);
	Button B1 = new JoystickButton(stick, B);
	Button B2 = new JoystickButton(stick2, B);
	Button X1 = new JoystickButton(stick, X);
	Button X2 = new JoystickButton(stick2, X);
	Button Y1 = new JoystickButton(stick, Y);
	Button Y2 = new JoystickButton(stick2, Y);
	Button LB1 = new JoystickButton(stick, LB);
	Button LB2 = new JoystickButton(stick2, LB);
	Button RB1 = new JoystickButton(stick, RB);
	Button RB2 = new JoystickButton(stick2, RB);
	Button Start1 = new JoystickButton(stick, Start);
	Button Start2 = new JoystickButton(stick2, Start);
	Button Back1 = new JoystickButton(stick, Back);
	Button Back2 = new JoystickButton(stick2, Back);
	Button L3_1 = new JoystickButton(stick, L3);
	Button L3_2 = new JoystickButton(stick2, L3);
	Button R3_1 = new JoystickButton(stick, R3);
	Button R3_2 = new JoystickButton(stick2, R3);
	
	public double getLeftY() {
		if (stick.getRawAxis(1) > .1 || stick.getRawAxis(1) < -.1) {
			return stick.getRawAxis(1);
		}
		else {
			return 0;
		}
		
	}
	
	public double getLeftX() {
		if (stick.getRawAxis(0) > .1 || stick.getRawAxis(0) < -.1) {
			return stick.getRawAxis(0);
		}
		
		else {
			return 0;
		}
	}
	
	public double getRightY() {
		return stick.getRawAxis(5);
	}
	
	public OI() {
		A1.whenPressed(new ArmCommand());
		A2.whenPressed(new PneumaticCommands(1)); //BottomClawOpen
		B2.whenReleased(new PneumaticCommands(2)); //BottomClawClose
		X2.whenPressed(new PneumaticCommands(3)); //LowArmUp
		Y2.whenReleased(new PneumaticCommands(4)); //LowArmDown
		LB2.whenPressed(new PneumaticCommands(5)); //TopClawOpen
		RB2.whenReleased(new PneumaticCommands(6)); //TopClawClose
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
