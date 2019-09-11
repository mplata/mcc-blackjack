package com.techprogramming.games;

public enum Suit {
	DIAMOND("\u2666"),
	HEART("\u2665"),
	CLUB("\u2663"),
	SPADE("\u2660");
	
	private String suitName;
	
	private Suit(String suit) {
		this.suitName = suit;
	}
	
	@Override
	public String toString() {
		
		return this.suitName;
	}
}
