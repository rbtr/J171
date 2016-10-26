package csc171.lab09;

import java.util.Scanner;

/**
 * Driver.java
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
 * This is a Driver class that ties everything together
 */

class Driver {

	private static final String prompt = "\n\nOptions:\n\t1) Run all tests\n\t2) Logger\n\t3) Equalizer\n\t4) PanelFrame\n\t5) Grid\n\t6) Checkerboard\n\t7) Bullseye\n\t8) Grid w/ Labels\n\t9) Grid w/ Bordered Labels\n\t10) Custom GUI";


	public static void main(String[] args) {
		boolean doContinue = true;

		Scanner scanner = new Scanner(System.in);

		while (doContinue) {
			System.out.print(prompt);

			int selection = -1;
			while (selection <= 0 || selection > 10) {
				System.out.print("\n\nEnter a selection or any other key to exit: ");

				try {
					selection = scanner.nextInt();
				} catch (Exception e) {
					return;
				}
			}

			test(selection);
		}
	}

	private static void test(int selection) {
		switch (selection) {
			case 1:
				Logger.getLogger().log("Testing all!");
				for (int i = 2; i <= 10; i++) {
					test(i);
				}
				break;
			case 2:
				Logger loggerA = Logger.getLogger();
				Logger loggerB = Logger.getLogger();
				loggerA.log("Testing logger. Is Logger a singleton? -> " + Equalizer.isEqual(loggerA, loggerB));
				break;
			case 3:
				Equalizer.main(new String[] {""});
				break;
			case 4:
				Logger.getLogger().log("Testing PanelFrame");
				PanelFrame.main(new String[] {""});
				break;
			case 5:
				Logger.getLogger().log("Testing Grid");
				Grid.main(new String[] {""});
				break;
			case 6:
				Logger.getLogger().log("Testing Checkerboard");
				Checkerboard.main(new String[] {""});
				break;
			case 7:
				Logger.getLogger().log("Testing Bullseye");
				Bullseye.main(new String[] {""});
				break;
			case 8:
				Logger.getLogger().log("Testing Grid w/ Labels");
				GridLayoutEx.main(new String[] {""});
				break;
			case 9:
				Logger.getLogger().log("Testing Bordered Grid w/ Labels");
				BorderedGridLayoutEx.main(new String[] {""});
				break;
			case 10:
				Logger.getLogger().log("Testing Custom GUI");
				MyLayout.main(new String[] {""});
				break;
			default:
				break;
		}
	}
}