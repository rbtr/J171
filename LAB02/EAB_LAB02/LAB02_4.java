
/**
 * LAB02_4.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 02 
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 01/30/2015
 */

class LAB02_4 {
	private static final int SEC_IN_MIN = 60;
	private static final int MIN_IN_HOUR = 60;

	public static void main(String[] args) {
		long totalSeconds = Integer.parseInt(args[0]);
		long hours = totalSeconds / (SEC_IN_MIN * MIN_IN_HOUR);
		long hoursRemainder = totalSeconds % (SEC_IN_MIN * MIN_IN_HOUR);
		long minutes = hoursRemainder / SEC_IN_MIN;
		long minutesRemainder = hoursRemainder % SEC_IN_MIN;

		System.out.println("\thours: " + hours + 
			"\n\tminutes: " + minutes + 
			"\n\tseconds: " + minutesRemainder);
	}
}