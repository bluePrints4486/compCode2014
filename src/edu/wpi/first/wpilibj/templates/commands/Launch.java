/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Launcher;
import edu.wpi.first.wpilibj.templates.subsystems.Loader;

/**
 *
 * @author Developer
 */
public class Launch extends CommandBase {
    
    boolean ended = false;
    
    public void Launch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        requires(launcher);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       ended = launcher.launch();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ended;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}