package csc171.project01.blackjack;

import csc171.project01.blackjack.Dealer;

/**
 * Test_Dealer.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: Project 01
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/5/15
 */

public class Test_Dealer {
	
	public static void main(String[] args) {
		Dealer dealer = new Dealer();

		boolean shouldDealerHit = true;
		for (int i = 1; i < 22; i++) {
			if (!dealer.shouldHit(i)) {
				shouldDealerHit = false;
			}
		}

		if (!shouldDealerHit) {
			System.out.println("Dealer didn't hit for all scores.");
		}

		if (dealer.shouldHit(22)) {
			System.out.println("Dealer hit out of bounds.");
		}

		System.out.println("Dealer test finished.");
	}
}