package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PneumaticCommands extends Command {

	int num; 
	int i;
    public PneumaticCommands(int numbers) {
    	this.num = numbers;
    	requires(Robot.pneu);
    	Robot.pneu.done = false;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = num;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//This is calling separate methods in one command. Check the OI for further documentation
    	Robot.pneu.done = false;
    	if (i == 1) {
    		Robot.pneu.BottomClawOpen();
    	}
    	if (i == 2) { 
    		Robot.pneu.BottomClawClosed();
    	}
    	if (i == 3) {  
    		Robot.pneu.LowArmUp();
    	}              
    	if (i == 4) {  
    		Robot.pneu.LowArmDown();
    	}
    	if (i == 5) {
    		Robot.pneu.TopClawOpen();
    	}
    	if (i == 6) {
    		Robot.pneu.TopClawClose();
    	}
    	if (i == 7) {
    		Robot.pneu.smartDash();
    	}
    	if (Robot.pneu.isDIrequired = true) {
    		if ((i == 1)||(i == 2)||(i == 5)||(i == 6))
    			Robot.pneu.done = true;
    		if ((i == 3) && (Robot.pneu.lowArm = false))
    			Robot.pneu.done = true;
    		if ((i == 4) && (Robot.pneu.lowArm = true))
    			Robot.pneu.done = true;
    	}
    	if (Robot.pneu.isDIrequired = false) {
    		Robot.pneu.done = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.pneu.done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
