import java.util.Scanner;

/**
 * LAB02_1.java
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

class LAB02_1 {
	private static final String PROMPT = "Enter a number: ";
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.print(PROMPT);
			double operand1 = scanner.nextDouble();
			System.out.print(PROMPT);
			double operand2 = scanner.nextDouble();

			add(operand1, operand2);
			subtract(operand1, operand2);
			multiply(operand1, operand2);
			divide(operand1, operand2);
	}

	private static void add(double num1, double num2) {
		System.out.println("\t" + num1 + " + " + num2 + " = " + (num1 + num2));
	}
	private static void subtract(double num1, double num2) {
		System.out.println("\t" + num1 + " - " + num2 + " = " + (num1 - num2));
	}
	private static void multiply(double num1, double num2) {
		System.out.println("\t" + num1 + " * " + num2 + " = " + (num1 * num2));
	}
	private static void divide(double num1, double num2) {
		System.out.println("\t" + num1 + " / " + num2 + " = " + (num1 / num2));
	}
}