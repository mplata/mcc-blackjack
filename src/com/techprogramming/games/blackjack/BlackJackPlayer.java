package com.techprogramming.games.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.techprogramming.games.Card;
import com.techprogramming.games.Player;
import com.techprogramming.games.ScannerUtil;

public class BlackJackPlayer extends Player{
	
	PlayerStatus status;
	int aces = 0;
	
	public BlackJackPlayer(String name) {
		
		super(name);
	}
	
	public BlackJackPlayer(String name, int money) {
		super(name, new ArrayList<Card>(), money);
	}
	
	public boolean hasBlackjack() {
		this.getHand();
		return false;
	}
	
	public PlayerStatus getStatus() {
		return status;
	}
	
	public void setStatus(PlayerStatus status) {
		this.status = status;
	}
	
	public void reset() {
		this.setHand(new ArrayList<Card>());
	}
	
	public int choiceOption() {
		
		this.printHand();
		System.out.println("TOTAL: "+this.getTotal());
		ScannerUtil scn =  ScannerUtil.getInstance();
		System.out.println("Seleccione una opci�n:");
		System.out.println("1.- Plantarse");
		System.out.println("2.- Pedir carta");
		int choice = scn.getInt("Opci�n incorrecta");
		return choice;
	}
	
	
	public int getTotal() {
		
		List<Card> hand =  this.getHand();
		int total = 0, totalAces = 0;
		Card card;
		for (int i = 0; i < hand.size(); i++) {
			card = hand.get(i);
			int value = card.getValue();
			if (value == 1) {
				totalAces ++;
				value = 11;
			}
			else if(value > 10) {
				value = 10;
			}
			total += value;
		}
			
		while (totalAces > 0 && total > 21)
		{
			total -= 10;
			totalAces --;
		}
			
		return total;
	}
}
