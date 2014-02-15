/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopLauncher;

/**
 *
 * @author Developer
 */

 

public class Launcher extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Talon launcherTalon = new Talon(RobotMap.Launcher_Talon);
    Timer timer = new Timer();
    double launcherSpeed = -.8;
    double runTime = .65; 
    boolean init = true;
    
    public boolean launch(){
        if(init){
            timer.start();
            timer.reset();
            init = false;
        }
        
        launcherTalon.set(launcherSpeed);
        
        if(timer.get()>=runTime){
            launcherTalon.set(0);
            timer.stop();
            timer.reset();
            init = true;
            return true;
        }
        return false;
    }
    
    public void nudge(){
        launcherTalon.set(launcherSpeed);
    }
    
    public void stop(){
        launcherTalon.set(0);
    }
    
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new StopLauncher());

        }
    
}

