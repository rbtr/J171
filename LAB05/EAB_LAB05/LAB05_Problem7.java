import java.util.Random;

/**
 * LAB05_Problem7.java
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

public class LAB05_Problem7 {

	public static void main(String[] args) {
		Random random = new Random();
		// Get two radnom integers (1 to 10) and (11 to 20)
		int x = random.nextInt(9) + 1;
		int y = random.nextInt(9) + 10;
		if (args.length > 0) {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		}

		System.out.println("Lower bound " + x);
		System.out.println("Upper bound " + y);

		if (x > y) {
			System.out.println("Range reversed.");
			return;
		}

		RandomTest randomTest = new RandomTest(random, x, y);
		boolean continueTest = true;
		for (int i = 0; i < 100 && continueTest; i++) {
			continueTest = randomTest.testRandom();
		}

		if (randomTest.wereAllUsed()) {
			System.out.println("All values were used and all within bounds.");
		} else {
			System.out.println("Not all values were used.");
		}
	}

	public static int randomInt(Random random, int lower, int upper) {
		return random.nextInt((upper + 1) - lower) + lower;
	}


	private static class RandomTest {
		private Random random;
		private boolean continueTest;
		private int[] boundVals = new int[2];
		private int[] allValues;
		private boolean[] usedValues;


		public RandomTest(Random random, int lower, int upper) {
			this.random = random;
			boundVals[0] = lower;
			boundVals[1] = upper;
			allValues = new int[(upper + 1) - lower];
			usedValues = new boolean[(upper + 1) - lower];
			for (int i = lower; i <= upper; i++) {
				allValues[i - lower] = i;
			}
		}

		public boolean testRandom() {
			int m = randomInt(random, boundVals[0], boundVals[1]);
			System.out.println("" + boundVals[0] + " ?<= " + m + " ?<= " + boundVals[1]);
			if (!(m <= boundVals[1]) || !(m >= boundVals[0])) {
				System.out.println("m out of bounds.");
				return false;
			}

			if (allValues[m - boundVals[0]] == m) {
				usedValues[m - boundVals[0]] = true;
			}
			return true;
		}

		public boolean wereAllUsed() {
			for (int i = 0; i < allValues.length; i++) {
				System.out.print(allValues[i] + " " + usedValues[i] + "\n");
			}

			for (boolean b : usedValues) {
				if (!b) {
					return false;
				}
			}
			return true;
		}

	}
}