package com.techprogramming.games;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	
	private Stack<Card> cards;
	
	public Deck() {
		this.cards = new Stack<Card>();
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public void addCard(Card card) {
		this.cards.push(card);
	}
	
	public Card draw() {
		return this.cards.pop();
	}
	
	@Override
	public String toString() {
		
		/*for (int i = 0; i < this.cards.size(); i++) {
			Card card = cards.get(i);
			System.out.println(card);
		}*/
		return "Total: "+this.cards.size();
	}
}
