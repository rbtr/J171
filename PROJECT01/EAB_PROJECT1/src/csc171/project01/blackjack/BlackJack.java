package csc171.project01.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * BlackJack.java
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
 * A game of BlackJack
 */

public class BlackJack {

	// Game objects
	Deck deck;
	ArrayList<BlackJackPlayer> players = new ArrayList<>();
	Dealer dealer;
	boolean isGameOver = false;
	Scanner scanner;
	
	public BlackJack() {
		newGame(1, 1, new String[] {""});
	}

	public BlackJack(int numPlayers) {
		newGame(numPlayers, 1, new String[] {""});
	}

	public BlackJack(int numPlayers, String humanName) {
		newGame(numPlayers, 1, new String[] {humanName});
	}

	public BlackJack(int numPlayers, int numHuman) {
		newGame(numPlayers, numHuman, new String[] {""});
	}

	private void newGame(int numPlayers, int numHuman, String[] humanNames) {
		scanner = new Scanner(System.in);
		if (numHuman > numPlayers) {
			numHuman = numPlayers;
		}
		// Set up a new game of BlackJack with all necessary objects

		// Add all players
		for (int i = 0; i < numPlayers; i++) {
			BlackJackPlayer player = new BlackJackPlayer(i >= numHuman);
			if (i < humanNames.length) {
				player.setName(humanNames[i]);
			} else {
				player.setName("Player " + i);
			}
			players.add(player);
		}

		// Add a dealer
		dealer = new Dealer();

		// Get a deck;
		deck = Deck.getDeck();
	} 

	public void printScores() {
		dealer.printScore();
		for (BlackJackPlayer p : players) {
			p.printScore();
		}
		System.out.println("\n");
	}

	public boolean isGameOver() {
		boolean hasAllBusted = true;

		for (BlackJackPlayer p : players) {
			if (!p.hasBusted()) {
				hasAllBusted = false;
			}
		}

		return hasAllBusted || dealer.hasBusted() || isGameOver;
	}

	public void playRound() {
		boolean didAnyHit = false;
		boolean shouldDealerHit = false;
		for (BlackJackPlayer p : players) {
			boolean hit = false;
			if (p.isAi) {
				hit = p.shouldHit();
			} else {
				if (!p.hasBusted()) {
					if (!(p.getScore() == 0)) {
						if (p.canHit()) {
							System.out.println("Would you like to hit?");
							String response = scanner.next();
							hit = isResponseContinue(response);
							p.setCanHit(hit);
						}
					} else {
						hit = true;
					}
				}
			}
			if (hit) {
				didAnyHit = true;
				Card c = deck.drawCard();
				p.giveCard(c);
			}

			if (dealer.shouldHit(p.getScore())) {
				shouldDealerHit = true;
			}
		}

		if (shouldDealerHit) {
			Card c = deck.drawCard();
			dealer.giveCard(c);
		}

		isGameOver = !didAnyHit;
	}

	public void whoWon() {
		for (BlackJackPlayer p : players) {
			if ((p.hasCharlied()) || (dealer.getScore() > 21 && p.getScore() <= 21) || ((p.getScore() > dealer.getScore()) && (p.getScore() <= 21))) {
				System.out.println(p.getName() + " beat the Dealer");
			} else {
				System.out.println("The dealer beat " + p.getName());
			}
		}
	}

	private boolean isResponseContinue(String response) {
		return response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y") || response.equalsIgnoreCase("hit") || response.equalsIgnoreCase("card");
	}
}