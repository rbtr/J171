

/**
 * LAB05_Problem10.java
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

public class LAB05_Problem10 {

	public static void main(String[] args) {
		for (int day = 0; day < 12; day++) {
			System.out.print("On the " + getDayString(day + 1) + " of Christmas\nmy true love sent to me:\n");
			printItems(day + 1);
		}
	}

	public static String getDayString(int number) {
		switch (number) {
			case 1:
				return "first";
			case 2:
				return "second";
			case 3:
				return "third";
			case 4:
				return "fourth";
			case 5:
				return "fifth";
			case 6:
				return "sixth";
			case 7:
				return "seventh";
			case 8:
				return "eighth";
			case 9:
				return "ninth";
			case 10:
				return "tenth";
			case 11:
				return "eleventh";
			case 12:
				return "twelfth";
		}
		return "";
	}

	public static void printItems(int number) {
		switch (number) {
			case 12:
				System.out.print("12 Drummers Drumming\n");
			case 11:
				System.out.print("11 Pipers Piping\n");
			case 10:
				System.out.print("10 Lords a Leaping\n");
			case 9:
				System.out.print("9 Ladies Dancing\n");
			case 8:
				System.out.print("8 Maids a Milking\n");
			case 7:
				System.out.print("7 Swans a Swimming\n");
			case 6:
				System.out.print("6 Geese a Laying\n");
			case 5:
				System.out.print("5 Golden Rings\n");
			case 4:
				System.out.print("4 Calling Birds\n");
			case 3:
				System.out.print("3 French Hens\n");
			case 2:
				System.out.print("2 Turtle Doves\nand ");
			case 1:
				System.out.print((number == 1 ? "A" : "a" ) + " Partridge in a Pear Tree\n\n");
		}
	}
}