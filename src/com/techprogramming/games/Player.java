package com.techprogramming.games;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	protected final String SPACE = "       *\t";
	protected final String SPACE_PLUS = "      *\t";
	protected final String ROW = "*        *\t";
	
	public final String ANSI_RESET = "\u001B[0m";
	
	private String name;
	private List<Card> hand;
	private int money;
	public int bet;
	
	public Player() {
		this.setName("");
		this.hand = new ArrayList<Card>();
		this.money = 0;
	}
	
	public Player(String name) {
		this.setName(name);
		this.hand = new ArrayList<Card>();
		this.money = 0;
	}
	
	public Player(String name, List<Card> hand, int money) {
		this.name = name;
		this.hand = hand;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void giveCard(Card card) {
		this.hand.add(card);
	}
	
	public List<Card> getHand(){
		return this.hand;
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getBet() {
		return bet;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public void printHand() {
		
		int handSize = this.hand.size();
		System.out.println("Mano de jugador: "+this.name);
		for (int i = 0; i < handSize; i++) {
			System.out.print("**********\t");
		}
		System.out.println("");
		
		for (int i = 0; i < handSize; i++) {
			int value = this.hand.get(i).getValue();
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
			System.out.print("*"+toPrint+space);
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			System.out.print(ROW);
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			Suit suit = this.hand.get(i).getSuit();
			System.out.print("*   "+suit+"    *\t");
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			System.out.print(ROW);
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			System.out.print(ROW);
		}
		System.out.println("");
		for (int i = 0; i < handSize; i++) {
			System.out.print("**********\t");
		}
		System.out.println("");
	}
}
