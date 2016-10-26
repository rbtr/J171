
/**
 * LAB02_3.java
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

class LAB02_3 {
	private static final String DEG_F = " degrees Fahrenheit ";
	private static final String DEG_C = " degrees Celsius ";

	public static void main(String[] args) {
		double degC = Double.parseDouble(args[0]);
		double degF = convertCtoF(degC);
		System.out.println(degC + DEG_C + "= " + degF + DEG_F);
	}

	private static double convertCtoF(double degC) {
		return (degC * (9d/5d) + 32d);
	}
}