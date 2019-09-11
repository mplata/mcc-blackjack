/**
 * 
 */
package com.techprogramming.games.blackjack;

import java.util.List;

import com.techprogramming.games.Deck;
import com.techprogramming.games.DeckBuilder;
import com.techprogramming.games.ScannerUtil;

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
		
		ScannerUtil scn = ScannerUtil.getInstance();
		int playerNumber = 0;
		while(playerNumber == 0) {
			System.out.println("Numero de jugadores (1 a 3)");
			playerNumber= scn.getInt("Ingrese un numero entre 1 y 3");
		}
		PlayerBuilder playerBuilder = PlayerBuilder.getInstance();
		List<BlackJackPlayer> players = playerBuilder.generatePlayers(playerNumber);
		
		BlackjackBoard theGame = new BlackjackBoard(deck, players);
		
		theGame.initRound();
	}

}
