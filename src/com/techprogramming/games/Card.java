/**
 * 
 */
package com.techprogramming.games;

/**
 * @author Marcos Plata
 * @author Daniel Leyva
 *
 */
public class Card {

	private int value;
	private Suit suit;
	
	public Card(int value, Suit suit) {
		
		this.setValue(value);
		this.setSuit(suit);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value+" de "+this.suit;
	}
}
