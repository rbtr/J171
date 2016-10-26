import java.util.Scanner;

/**
 * LAB02_2.java
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

class LAB02_2 {
	private static String PROMPT = "Enter the temperature in Fahrenheit: ";
	private static String DEG_F = " degrees Fahrenheit ";
	private static String DEG_C = " degrees Celsius ";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(PROMPT);
		double degF = scanner.nextDouble();
		double degC = convertFtoC(degF);
		System.out.println(degF + DEG_F + "= " + degC + DEG_C);
	}

	private static double convertFtoC(double degF) {
		return ((degF - 32d) * (5d/9d));
	}
}