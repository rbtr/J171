import java.util.Scanner;

/**
 * LAB02_0_DRIVER.java
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

class LAB02_0_DRIVER {
	private static final String PROMPT_PART3 = "Enter the temperature in Celsius: ";
	private static final String PROMPT_PART4 = "Enter a large number of seconds: ";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nExecuting PART 1");
		LAB02_1.main(null);

		System.out.println("\nExecuting PART 2");
		LAB02_2.main(null);
		
		System.out.println("\nExecuting PART 3");
		System.out.print(PROMPT_PART3);
		double degC = scanner.nextDouble();

		LAB02_3.main(new String[] {"" + degC});

		System.out.println("\nExecuting PART 4");
		System.out.print(PROMPT_PART4);
		long seconds = scanner.nextLong();
		LAB02_4.main(new String[] {"" + seconds});

		System.out.println("\nExecuting PART 5");
		LAB02_5.main(null);
	}
}