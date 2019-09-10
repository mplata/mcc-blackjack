/**
 * 
 */
package com.techprogramming.games.blackjack;

import java.util.List;
import java.util.Scanner;

import com.techprogramming.games.Deck;
import com.techprogramming.games.DeckBuilder;

/**
 * @author Marcos Plata
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		DeckBuilder  builder = DeckBuilder.getInstance();
		Deck deck = builder.getStandardDeck(true);
		
		PlayerBuilder playerBuilder = PlayerBuilder.getInstance();
		List<BlackJackPlayer> players = playerBuilder.generatePlayers(100);
		
		BlackjackBoard theGame = new BlackjackBoard(deck, players);
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Presione enter para iniciar juego");
		scn.nextLine();
		theGame.initRound();
	}

}
