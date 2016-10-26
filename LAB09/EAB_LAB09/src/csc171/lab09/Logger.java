package csc171.lab09;

/**
 * Logger.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 09
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 4/3/15
 *
 * This class is a Logger utility. It is a singleton pattern.
 */

public class Logger {

	private static Logger logger;

	private Logger() {}

	public static Logger getLogger() {
		if (logger == null) {
			logger = new Logger();
		}
		return logger;
	}

	public void log(String message) {
		System.out.println(message);
	}
}