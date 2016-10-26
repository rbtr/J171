import java.util.Date;
import java.util.Scanner;

/**
 * This is a StopWatch exercise
 * by Evan Baker
 * 16 April 2015
 */

class StopWatch {
	private long startTime = -1;
	private long endTime = -1;

	/**
	 * Main method so that this class is runnable
	 * Inits a new stopwatch, waits for user input, stops, prints the time elapsed
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Init the stopwatch
		StopWatch stopwatch = new StopWatch();

		// Wait for user input
		System.out.println("Waiting...enter a char...");
		scanner.next();

		// Stopping the stopwatch
		stopwatch.stop();

		// Print the time elapsed (in millis)
		long elapsedMillis = stopwatch.getElapsedTime();

		System.out.println("Elapsed time " + elapsedMillis + " (ms)");
	}

	/**
	 * Sets up the stopwatch, sets the start to now
	 */
	StopWatch() {
		reset();
	}

	/**
	 * Resets the startTime to now
	 */
	void reset() {
		Date now = new Date(); // This is a Java lib, it will be different in other languages
		long startTimeMillis = now.getTime();
		startTime = millisToSeconds(startTimeMillis);
	}

	/**
	 * Sets the stop time to now
	 */
	void stop() {
		Date now = new Date();
		long endTimeMillis = now.getTime();
		endTime = millisToSeconds(endTimeMillis);
	}

	/**
	 * @return the start time
	 */
	long getStartTime() {
		return startTime;
	}

	/**
	 * @return the end time
	 */
	long getEndTime() {
		return endTime;
	}

	/**
	 * @return the elapsed time in millis
	 */
	long getElapsedTime() {
		if (endTime < 0 || startTime < 0) {
			throw new IllegalStateException("endTime < 0 " + (endTime < 0) + "; startTime < 0 " + (startTime < 0));
		}

		long elapsedTime = endTime - startTime;

		return secondsToMillis(elapsedTime);
	}

	/**
	 * Helper to convert millis to seconds
	 * @param millis is the ms to be converted to seconds
	 * @return the converted time in seconds
	 */
	long millisToSeconds(long millis) {
		return millis / 1000;
	}

	/**
	 * Helper to convert seconds to millis
	 * @param secs is the time to be converted to millis
	 * @return the converted time in ms
	 */
	long secondsToMillis(long secs) {
		return secs * 1000;
	}
}