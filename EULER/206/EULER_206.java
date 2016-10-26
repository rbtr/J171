import java.lang.Math;

/**
 * Evan Baker
 * 206.java
 * Project Euler P206
 * 21 March 2015
 * 
 * Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0
 * Where _ is *wildcard
 */

class EULER_206 {
	// These are too big for integers or floats, so I'll use doubles and longs
	static final double lowerBound = 1020304050607080900d;
	static final double upperBound = 1929394959697989990d;

	// The root will be between these two values
	static long lowerRoot;
	static long upperRoot;

	// This is what the square has to look like
	static final String template = "1_2_3_4_5_6_7_8_9_0";

	public static void main(String[] args) {
		// This narrowing cast is appropriate, since I need the integer root
		// Using longs because digits
		lowerRoot = (long) Math.sqrt(lowerBound);
		upperRoot = (long) Math.sqrt(upperBound);
		findRoot();
	}

	static void findRoot() {
		// I'm going to bruteforce this.
		// Since I've restricted the range, it shouldn't take too long.
		for (long l = lowerRoot; l <= upperRoot; l++) {
			if (isRoot(l)) {
				System.out.println("Found root: " + l);
			}
		}
	}

	static boolean isRoot(long root) {
		// Determine if a given integer has the correct square

		// This is a lossy cast, but it's okay here
		long square = (long) Math.pow(root, 2);
		return checkSquareCorrect(square);
	}

	static boolean checkSquareCorrect(long l) {
		// This isn't a great way to do this, mathematically speaking. But it works.
		String square = String.valueOf(l);

		// Immediately return false if the squares aren't the same length
		if (square.length() != template.length()) {
			return false;
		}

		// Loop over the strings and compare the non-wildcard characters
		for (int i = 0; i < template.length(); i = i + 2) {
			if (square.charAt(i) != template.charAt(i)) {
				// If there is a discrepancy, return false
				return false;
			}
		}

		// If the method has progressed this far, the square is correct
		return true;
	}
}