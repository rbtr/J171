import java.lang.Math;

/**
 * TrajectoryObject.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 03
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 02/4/2015
 * 
 * This class represents a Trajectory Object - some object flying through the air (with negligible drag).
 * The object needs a name, launch height, and launch velocity (velocity = direction and speed).
 * The launch() method calculates range, flight time, peak height, and time to peak.
 * Note: without accounting for drag (which requires solving differential equations for the flight position),
 * this is an okay model but not strictly accurate. 
 */

public class TrajectoryObject {
	/* Constant gravity */
	private static final double GRAVITY = -9.8d;
	/* These vars store the object's initial position in 2D space */
	private double startX = 0, startY;
	/* These store the object's inital velocity */
	private double startSpeedX, startSpeedY;

	/* These booleans keep track of the construction process */
	private boolean nameSet, heightSet, velocitySet;

	private String name;

	/*
	 * These vars are set at launch
	 */ 

	private double flightTime, timeToPeak;
	private double range, peakHeight;


	public TrajectoryObject(String name) {
		setName(name);
	}

	public void setName(String name) {
		nameSet = true;
		this.name = name;
	}

	public void setStartHeight(double startY) {
		heightSet = true;
		this.startY = startY;
	}

	public void setStartSpeedXY(double startSpeedX, double startSpeedY) {
		if (!velocitySet) {
			velocitySet = true;
			this.startSpeedX = startSpeedX;
			this.startSpeedY = startSpeedY; 
		} else {
			System.out.println("Error: velocity overdefined.");
		}
	}

	public void setStartVelocity(double startSpeed, double startAngle, boolean inRadians) {
		if (inRadians) {
			if (!velocitySet) {
				velocitySet = true;
				this.startSpeedX = Math.sin(startAngle) * startSpeed;
				this.startSpeedY = Math.cos(startAngle) * startSpeed;
			} else {
				System.out.println("Error: velocity overdefined.");
			}
		} else {
			if (!velocitySet) {
				velocitySet = true;
				double startAngleRads = Math.toRadians(startAngle);
				this.startSpeedX = Math.sin(startAngleRads) * startSpeed;
				this.startSpeedY = Math.cos(startAngleRads) * startSpeed;
			} else {
				System.out.println("Error: velocity overdefined.");
			}
		}
	}

	public void launch() {
		if (nameSet && heightSet && velocitySet) {
			calculateTrajectory();
		}
	}

	private void calculateTrajectory() {
		flightTime = calculateFlightTime(startSpeedY, startY);
		range = calculateHorizontalTravel(flightTime, startSpeedX);
		timeToPeak = calculateTimeToPeak(startSpeedY);
		peakHeight = calculatePeak(timeToPeak, startY, startSpeedY);
	}

	private double calculateFlightTime(double startVerticalSpeed, double startHeight) {
		double[] flightTimes = quadratic(0.5 * GRAVITY, startVerticalSpeed, -startHeight);
		return Math.max(flightTimes[0], flightTimes[1]);
	}

	private double calculateHorizontalTravel(double flightTime, double horizontalSpeed) {
		return flightTime * horizontalSpeed;
	}

	private double calculateTimeToPeak(double verticalSpeed) {
		return verticalSpeed / (-GRAVITY);
	}
	private double calculatePeak(double timeToPeak, double startHeight, double startVerticalSpeed) {
		return startHeight + (startVerticalSpeed * timeToPeak) + (0.5 * GRAVITY * Math.pow(timeToPeak, 2));

	}

	/*
	 * All the getters
	 */
	
	public String getName() {
		return name;
	}

	public double getStartX() {
		return startX;
	}

	public double getStartY() {
		return startY;
	}

	public double[] getStartXY() {
		return new double[] {startX, startY};
	}

	public double getStartSpeedX() {
		return startSpeedX;
	}

	public double getStartSpeedY() {
		return startSpeedY;
	}

	public double[] getStartSpeedXY() {
		return new double[] {startSpeedX, startSpeedY};
	}

	public double[] getStartVelocity(boolean degrees) {
		double velocity = hypotenuse(startSpeedX, startSpeedY);
		double inclinationRads = inclination(startSpeedX, startSpeedY);

		if (degrees) {
			return new double[] {velocity, Math.toDegrees(inclinationRads)};
		}

		return new double[] {velocity, inclinationRads};
	}

	public double getFlightTime() {
		return flightTime;
	}

	public double getRange() {
		return range;
	}

	public double getTimeToPeak() {
		return timeToPeak;
	}

	public double getPeakHeight() {
		return peakHeight;
	}

	/*
	 * Math utility methods
	 */

	private double[] quadratic(double a, double b, double c) {
		return new double[] { 
			(-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a),
			(-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a)};
	}

	private double hypotenuse(double a, double b) {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	private double inclination(double a, double b) {
		return Math.atan(a/b);
	}

}