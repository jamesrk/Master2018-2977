package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        //requires(Robot.pidarm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    //int DriveM = Robot.chassis.DriveMode;
    protected void execute() {
    	//Robot.pidarm.usePIDOutput(Robot.m_oi.getLeftY(), Robot.m_oi.getLeftX());
    	SmartDashboard.putNumber("test", Robot.m_oi.getLeftY());
    	Robot.chassis.Driving(-Robot.m_oi.getLeftY(), -Robot.m_oi.getLeftX());
    	//if (DriveM == 1) {
    		//Robot.chassis.ArcadeDrive(Robot.m_oi.getLeftY(), Robot.m_oi.getLeftX(), Robot.m_oi.getRightY());
    	//}
    	//else if(DriveM == 2) {
    		//Robot.chassis.TankDrive(Robot.m_oi.getLeftY(), Robot.m_oi.getLeftX(), Robot.m_oi.getRightY());
    	//}
    	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
