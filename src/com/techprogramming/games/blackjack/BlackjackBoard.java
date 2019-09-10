/**
 * 
 */
package com.techprogramming.games.blackjack;

import java.util.List;

import com.techprogramming.games.Card;
import com.techprogramming.games.Deck;
import com.techprogramming.games.ScannerUtil;

/**
 * @author Marcos Plata
 *
 */
public class BlackjackBoard {
	
	private Deck deck;
	private BlackJackPlayer croupier;
	private List<BlackJackPlayer> players;
	
	public BlackjackBoard(Deck deck, List<BlackJackPlayer> players) {
		this.deck = deck;
		this.players = players;
		this.croupier = new BlackJackPlayer("Croupier");
		
		BlackJackPlayer player;
		Card card;
		
		card = deck.draw();
		croupier.giveCard(card);
		card = deck.draw();
		croupier.giveCard(card);
		croupier.printHand();
		
		for (int i = 0; i < players.size(); i++) {
			player = players.get(i);
			player.setStatus(PlayerStatus.HIT);
			player.setBet(10);
			card = deck.draw();
			player.giveCard(card);
			card = deck.draw();
			player.giveCard(card);
			player.printHand();
		}
		
	}
	
	public void initRound() {
		BlackJackPlayer player;
		ScannerUtil scn =  ScannerUtil.getInstance();
		System.out.flush();
		for (int i = 0; i < this.players.size(); i++) {
			player= this.players.get(i);
			int total = player.getTotal();
			String name = player.getName();
			System.out.println("Turno de: "+name);
			System.out.println();
			if(total > 21) {
				player.printHand();
				System.out.println("¡JUGADOR "+name+" HA PERDIDO CON TOTAL="+total+"!");
				player.setStatus(PlayerStatus.LOSE);
				scn.waitForEnter();
			}
			while(player.getStatus() == PlayerStatus.HIT) {
				int choice = player.choiceOption();
				switch (choice) {
				case 1:
					player.setStatus(PlayerStatus.STAND);
					break;
				case 2:
					player.setStatus(PlayerStatus.HIT);
					player.giveCard(this.deck.draw());
				default:
					break;
				}
				total = player.getTotal();
				if(total > 21) {
					player.printHand();
					System.out.println("¡JUGADOR "+name+" HA PERDIDO CON TOTAL="+total+"!");
					player.setStatus(PlayerStatus.LOSE);
					scn.waitForEnter();
				}
			}
		}
	}

}
