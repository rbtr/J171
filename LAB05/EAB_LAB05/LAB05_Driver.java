

/**
 * LAB05_Driver.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 05
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 02/15/15
 */

public class LAB05_Driver {

	public static void main(String[] args) {
		// No args
		if (args.length > 0) {
			System.out.println("No args allowed");
			return;
		}

		int sectionNum = 0;

		printHeader(++sectionNum);
		LAB05_Problem1.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem2.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem3.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem4.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem5.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem6.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem7.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem8.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem9.main(new String[0]);

		printHeader(++sectionNum);
		LAB05_Problem10.main(new String[0]);
	}

	public static void printHeader(int num) {
		String numStr;
		if (num < 10) {
			numStr = "0" + num;
		} else {
			numStr = "" + num;
		}
		System.out.println("\n*******************************");
		System.out.println("*          Section " + numStr + "         *");
		System.out.println("*******************************");
	}
}