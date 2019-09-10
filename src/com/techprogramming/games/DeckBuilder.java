/**
 * 
 */
package com.techprogramming.games;

/**
 * @author Marcos Plata
 * @author Daniel Leyva
 *
 */
public class DeckBuilder {
	
	private final int NUMBERS_BY_SUIT = 13;
	private static DeckBuilder builder = null;
	
	private DeckBuilder() {}
	
	public static DeckBuilder getInstance() {
		if(builder == null) {
			builder = new DeckBuilder();
		}
		return builder;
	}
	
	public Deck getStandardDeck(boolean shuffle) {
		
		Deck deck = new Deck();
		
		Suit[] suits = Suit.values();
		Suit suit;
		Card card = null;
		int value = 0;
		
		for (int i = 0; i < suits.length; i++) {
			suit = suits[i];
			for (int j = 0; j < NUMBERS_BY_SUIT; j++) {
				value = j+1;
				card = new Card(value, suit);
				deck.addCard(card);
			}
		}
		if(shuffle) {
			deck.shuffle();
		}
		return deck;
	}
	
}
