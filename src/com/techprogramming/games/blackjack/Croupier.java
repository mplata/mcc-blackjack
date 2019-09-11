package com.techprogramming.games.blackjack;

import com.techprogramming.games.Suit;

import java.util.List;

import com.techprogramming.games.Card;

public class Croupier extends BlackJackPlayer{
	
	private static final String HIDDEN = "**********\t";
	private boolean reveal = false;
	
	public Croupier(String name, int money) {
		super(name, money);
	}
	
	public void setReveal(boolean reveal) {
		this.reveal = reveal;
	}
	@Override
	public void printHand() {
		
		List<Card> hand = this.getHand();
		int handSize = hand.size();
		System.out.println("Mano de jugador: "+this.getName());
		for (int i = 0; i < handSize; i++) {
			System.out.print("**********\t");
		}
		System.out.println("");
		
		for (int i = 0; i < handSize; i++) {
			int value = hand.get(i).getValue();
			String toPrint = "";
			switch (value) {
				case 11:
					toPrint = "J";
					break;
				case 12:
					toPrint = "Q";
					break;
				case 13:
					toPrint = "K";
					break;
				case 1:
					toPrint = "A";
					break;
				default:
					toPrint = String.valueOf(value);
					break;
			}
			String space = value >= 10?SPACE_PLUS:SPACE;
			if(i > 0 || this.reveal) {
				System.out.print("*"+toPrint+space);
			}else {
				System.out.print(HIDDEN);
			}
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			if(i > 0 || this.reveal) {
				System.out.print(ROW);
			}else {
				System.out.print(HIDDEN);
			}
			
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			Suit suit = hand.get(i).getSuit();
			if(i > 0 || this.reveal) {
				System.out.print("*   "+suit+"    *\t");
			}else {
				System.out.print(HIDDEN);
			}
			
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			if(i > 0 || this.reveal) {
				System.out.print(ROW);
			}else {
				System.out.print(HIDDEN);
			}
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			if(i > 0 || this.reveal) {
				System.out.print(ROW);
			}else {
				System.out.print(HIDDEN);
			}
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			if(i > 0 || this.reveal) {
				System.out.print("**********\t");
			}else {
				System.out.print(HIDDEN);
			}
		}
		System.out.println("");
	}


}
