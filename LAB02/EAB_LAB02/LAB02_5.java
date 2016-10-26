import java.util.Scanner;

/**
 * LAB02_5.java
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

class LAB02_5 {
	private static final String 
			PROMPT_CURRENT_POPULATION = "Enter the current population: ",
			PROMPT_GROWTH_RATE = "Enter the growth rate as a float: ",
			PROMPT_CURRENT_YEAR = "Enter the current year: ",
			PROMPT_FUTURE_YEAR = "Enter the year to project to: ",
			RESULT_FUTURE_POPULATION = "The estimated future population is: ";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(PROMPT_CURRENT_POPULATION);
		long currentPop = scanner.nextLong();

		System.out.print(PROMPT_GROWTH_RATE);
		double rate = scanner.nextDouble();

		System.out.print(PROMPT_CURRENT_YEAR);
		int currentYear = scanner.nextInt();

		System.out.print(PROMPT_FUTURE_YEAR);
		int futureYear = scanner.nextInt();

		long futurePop = calculateFuturePopulation((double) currentPop, rate, currentYear, futureYear);
		System.out.println(RESULT_FUTURE_POPULATION + futurePop);
	}

	private static long calculateFuturePopulation(double currentPop, double rate, int currentYear, int futureYear) {
		int exp = (futureYear - currentYear);
		// Though I think 1.011 should be a float, Math.pow() REALLY doesn't like it as a float.
		// fRate has to be a double to get the correct results from Math.pow();
		double fRate = 1d + (rate / 100d);
		double futurePop = currentPop * Math.pow(fRate, exp);
		return (long) futurePop;
	}
}