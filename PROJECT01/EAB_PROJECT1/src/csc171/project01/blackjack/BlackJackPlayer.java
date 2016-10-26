package csc171.project01.blackjack;

/**
 * BlackJackPlayer.java
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
 * This class is an BlackJack Player (not dealer)
 * Can be added to a BlackJack game as an opponent to the dealer / player.
 * Can be the default human player or AI by using AI methods.
 */

public class BlackJackPlayer {
	
	private Hand hand;
	boolean isAi;
	String name;
	boolean canHit = true;

	BlackJackPlayer(boolean isAi) {
		this.isAi = isAi;
		hand = new Hand();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void printScore() {
		System.out.print("\t" + name + "\t" + hand.sum());
	}

	public boolean shouldHit() {
		// This algorithm could become very complex based on cards that 
		// have come out of the deck and probabilites of any card draw.
		// For now, it just determines if the Hand is <= 16 and hits 
		if (hand.sum() <= 16) {
			return true;
		} else {
			canHit = false;
			return false;
		}
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

	public boolean canHit() {
		return canHit;
	}

	public void setCanHit(boolean canHit) {
		this.canHit = canHit;
	}

	public boolean hasWon() {
		return hand.sum() == 21;
	}

	public boolean hasBusted() {
		return hand.sum() > 21;
	}

	public boolean hasCharlied() {
		return (hand.getHand().size() > 5);
	}
}