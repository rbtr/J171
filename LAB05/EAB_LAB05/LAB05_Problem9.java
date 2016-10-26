import java.util.Random;

/**
 * LAB05_Problem9.java
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

public class LAB05_Problem9 {

	public static void main(String[] args) {
		Random random = new Random();
		// This array holds {the last drawn card, the cumulative score including last drawn card}
		int[] lastDrawAndScore = new int[] {0, 0};
		int draws = 0;
		do {
			lastDrawAndScore = drawCard(lastDrawAndScore[1], random);
			System.out.println("Drew a " + lastDrawAndScore[0] + ", score is " + lastDrawAndScore[1]);
			draws++;
		} while (lastDrawAndScore[1] < 21 && draws < 5);

		// Triage the score
		if (lastDrawAndScore[1] == 21) {
			System.out.println("21! You win!");
		} else if (lastDrawAndScore[1] > 21) {
			System.out.println("Ouch. Busted.");
		} else if (draws >= 5) {
			System.out.println("Tough luck, Charlie.");
		}
	}

	public static int[] drawCard(int prevScore, Random random) {
		int draw = LAB05_Problem7.randomInt(random, 2, 11);
		int newScore = draw + prevScore;
		return new int[] {draw, newScore};
	}
}