package csc171.project01.blackjack;

/**
 * Dealer.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: Project 01
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/5/15
 *
 * This is the dealer AI
 * The dealer is dumb and hits if it has a lower score than any other 
 * player (or 17) until it busts.
 */

 public class Dealer {
 	private Hand hand;
 	private String name = "Dealer";

 	public Dealer() {
 		hand = new Hand();
 	}

 	public boolean shouldHit(int otherPlayerScores) {
		return shouldHit(new int[] {otherPlayerScores});
 	}

	public boolean shouldHit(int[] otherPlayerScores) {
		boolean hit = false;
		int dealerScore = getScore();

		for (int s : otherPlayerScores) {
			if ((s <= 21 && dealerScore < s) || (dealerScore < 17))  {
				hit = true;
			}
		}

		return hit;
	}

	public void printScore() {
		System.out.print("\t" + name + "\t" + hand.sum());
	}

	public void giveCard(Card card) {
		if (hand == null) {
			hand = new Hand();
		}
		hand.addCard(card);
	}

	public int getScore() {
		return hand.sum();
	}

	public boolean hasWon() {
		return hand.sum() == 21;
	}

	public boolean hasBusted() {
		return hand.sum() > 21;
	}
 }