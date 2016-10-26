import java.util.Scanner;

/**
 * Evan Baker
 * PrimesAdder.java
 * v1 March 5 2015
 * This program requests a positive even number from the user and finds all pairs
 * of primes that add up to it, and prints them out.
 * It does this via brute force.
 */


class PrimesAdder {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int _even = -3; // This is obviously not even, so is sufficient to use as a marker

		// Use the marker to determine when the user has entered an even
		while (_even == -3 || _even < 0 || _even % 2 != 0) { 
			System.out.print("Enter a positive even number: ");

			try {
				_even = scanner.nextInt(); // Try to set the marker to an even int
			} catch (Exception e) {
				scanner.nextLine(); // Flush the buffer
				System.out.println("Invalid number. Try again.");
			}
		}

		findPrimes(_even);
	}

	static void findPrimes(int _even) {
		// We already know even is a valid even int, move on to parsing
		System.out.println("The primes that sum to your number are: ");

		// Run the for loop from 1 to half of _even (only need half for full search)
		for (int i = 1; i < _even / 2; i++) {

			// Check if i is a prime
			if (isPrime(i)) {
				// i is prime. 
				// Check if (even - i) is also prime
				if (isPrime(_even - i)) {
					// if this is true, we're done.
					// The two primes that sum to _even are:
					// {i, _even - i}
					System.out.println(i + " and " + (_even - i));
				}
			}
		}
	}

	// This method checks if an arbitrary integer is prime by 
	// checking if it can be divided evenly by any other positive
	// integer from 2 to it.
	// This is EXPENSIVE.
	static boolean isPrime(int i) {
		for (int j = 1; j < i; j++) {
			if (i % j == 0) {
				return false; // If i % j == 0, then i can be divided and so is not prime
			}
		}
		return true; // i was not divisible, so it must be prime.
	}
}