import java.lang.Math;

/**
 * LAB03_0_Driver.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 03
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 02/4/2015
 */

public class LAB03_0_Driver {
	public static void main(String[] args) {
		// Build some TrajectoryObjects
		TrajectoryObject obj1 = new TrajectoryObject("Obj1");
		obj1.setStartHeight(1d);
		obj1.setStartVelocity(10d, 45, false); // Set the start velocity using speed and angle in degrees
		
		TrajectoryObject obj2 = new TrajectoryObject("Obj2");
		obj2.setStartHeight(1d);
		obj2.setStartVelocity(10d, Math.PI / 4, true); // Set the start velocity using speed and angle in radians

		TrajectoryObject obj3 = new TrajectoryObject("Obj3");
		obj3.setStartHeight(2d);
		obj3.setStartSpeedXY(50, 20); // Set the start velocity using the ordinal start speeds

		// Launch the objects!
		obj1.launch();
		obj2.launch();
		obj3.launch();

		// Print the new states of these TrajectoryObjects (specifically the computed values such as flight time)
		// using the getter methods
		System.out.println(
			obj1.getName() 
			+ "\nLaunch height: " + obj1.getStartY()
			+ "\nLaunch speed: " + obj1.getStartVelocity(true)[0]
			+ "\nLaunch angle (degrees): " + obj1.getStartVelocity(true)[1]
			+ "\nLaunch angle (radians): " + obj1.getStartVelocity(false)[1]
			+ "\nFlight time: " + obj1.getFlightTime() 
			+ "\nRange: " + obj1.getRange()
			+ "\nTime to peak: " + obj1.getTimeToPeak()
			+ "\nPeak heigt: " + obj1.getPeakHeight()
			+ "\n");

		System.out.println(
			obj2.getName() 
			+ "\nLaunch height: " + obj2.getStartY()
			+ "\nLaunch speed: " + obj2.getStartVelocity(true)[0]
			+ "\nLaunch angle (degrees): " + obj2.getStartVelocity(true)[1]
			+ "\nLaunch angle (radians): " + obj2.getStartVelocity(false)[1]
			+ "\nFlight time: " + obj2.getFlightTime() 
			+ "\nRange: " + obj2.getRange()
			+ "\nTime to peak: " + obj2.getTimeToPeak()
			+ "\nPeak heigt: " + obj2.getPeakHeight()
			+ "\n");

		System.out.println(
			obj3.getName()
			+ "\nLaunch height: " + obj3.getStartY()
			+ "\nLaunch speed: " + obj3.getStartVelocity(true)[0]
			+ "\nLaunch angle (degrees): " + obj3.getStartVelocity(true)[1]
			+ "\nLaunch angle (radians): " + obj3.getStartVelocity(false)[1]			 
			+ "\nFlight time: " + obj3.getFlightTime() 
			+ "\nRange: " + obj3.getRange()
			+ "\nTime to peak: " + obj3.getTimeToPeak()
			+ "\nPeak heigt: " + obj3.getPeakHeight()
			+ "\n");	

		// Modify one of the objects using the setter methods
		obj3.setName("Obj3.modified");
		obj3.setStartHeight(1d);

		// Relaunch the modified object
		obj3.launch();

		// Reprint the state of an unmodified object showing that it has not changed
		System.out.println(
			obj1.getName() 
			+ "\nLaunch height: " + obj1.getStartY()
			+ "\nLaunch speed: " + obj1.getStartVelocity(true)[0]
			+ "\nLaunch angle (degrees): " + obj1.getStartVelocity(true)[1]
			+ "\nLaunch angle (radians): " + obj1.getStartVelocity(false)[1]
			+ "\nFlight time: " + obj1.getFlightTime() 
			+ "\nRange: " + obj1.getRange()
			+ "\nTime to peak: " + obj1.getTimeToPeak()
			+ "\nPeak heigt: " + obj1.getPeakHeight()
			+ "\n");

		// Print the new state of the modified object using the getter methods
		System.out.println(
			obj3.getName()
			+ "\nLaunch height: " + obj3.getStartY()
			+ "\nLaunch speed: " + obj3.getStartVelocity(true)[0]
			+ "\nLaunch angle (degrees): " + obj3.getStartVelocity(true)[1]
			+ "\nLaunch angle (radians): " + obj3.getStartVelocity(false)[1]	
			+ "\nFlight time: " + obj3.getFlightTime() 
			+ "\nRange: " + obj3.getRange()
			+ "\nTime to peak: " + obj3.getTimeToPeak()
			+ "\nPeak heigt: " + obj3.getPeakHeight()
			+ "\n");	
	}
}