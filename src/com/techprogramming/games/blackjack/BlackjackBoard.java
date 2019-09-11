/**
 * 
 */
package com.techprogramming.games.blackjack;

import java.util.Iterator;
import java.util.List;

import com.techprogramming.games.Card;
import com.techprogramming.games.Deck;
import com.techprogramming.games.DeckBuilder;
import com.techprogramming.games.ScannerUtil;

/**
 * @author Marcos Plata
 *
 */
public class BlackjackBoard {
	
	private Deck deck;
	private Croupier croupier;
	private List<BlackJackPlayer> players;
	
	public BlackjackBoard(Deck deck, List<BlackJackPlayer> players) {
		this.deck = deck;
		this.players = players;
		this.croupier = new Croupier("Croupier", 0);
		
	}
	
	private void restartGame() {
		this.deck = DeckBuilder.getInstance().getStandardDeck(true);
		for (int i = 0; i < this.players.size(); i++) {
			this.players.get(i).reset();
		}
		croupier.reset();
		croupier.setReveal(false);
		Card card;
		card = deck.draw();
		croupier.giveCard(card);
		card = deck.draw();
		croupier.giveCard(card);
		//croupier.printHand();
	}
	
	private void askBets() {
		
		BlackJackPlayer player;
		Card card;
		int bet = 0;
		int money = 0;
		for (int i = 0; i < players.size(); i++) {
			bet = 0;
			player = players.get(i);
			player.setStatus(PlayerStatus.HIT);
			money = player.getMoney();
			while(bet > money || bet == 0 ) {
				System.out.println("Ingrese apuesta de "+player.getName()+ " (TIENE: "+money+")");
				bet = ScannerUtil.getInstance().getInt("Ingrese un numero valido");
			}
			player.setBet(bet);
			card = deck.draw();
			player.giveCard(card);
			card = deck.draw();
			player.giveCard(card);
		}
	}
	
	private void checkWin() {
		BlackJackPlayer player;
		int croupierTotal = this.croupier.getTotal();
		int playerTotal = 0;
		String result = "";
        for (int i = 0; i < this.players.size(); i++) {
			player = this.players.get(i);
			playerTotal = player.getTotal();
			System.out.println("Total de "+player.getName()+": "+playerTotal);
		    if((playerTotal < croupierTotal) && croupierTotal <= 21 ) {
		    	result = "¡Jugador "+player.getName()+ " ha perdido!";
		    	player.setMoney(player.getMoney() - player.getBet());
		    }                
		    else if ((playerTotal == croupierTotal) && croupierTotal <= 21 ) {
		    	result = "¡Jugador "+player.getName()+ " ha empatado!";
		    }
		    else if(playerTotal > 21){
		    	result = "¡Jugador "+player.getName()+ " ha perdido!";
		    	player.setMoney(player.getMoney() - player.getBet());
		    }else {
		    	result = "¡Jugador "+player.getName()+ " ha ganado!";
		    	player.setMoney(player.getMoney() + player.getBet());
		    }
		    System.out.println(result);
		}
    }
	
	private boolean keepPlaying() {
		
		boolean keepPlaying = false;
		BlackJackPlayer player;
		Iterator<BlackJackPlayer> iterator = this.players.iterator();
		
		while (iterator.hasNext()) {
			player = iterator.next();
			if(player.getMoney() > 0) {
				keepPlaying = true;
			}else {
				System.out.println("El jugador "+player.getName()+" ha sido eliminado :(");
				iterator.remove();
			}
		}
		return keepPlaying;
	}
	
	public void initRound() {
		BlackJackPlayer player;
		//ScannerUtil scn =  ScannerUtil.getInstance();
		
		do {
			System.out.flush();
			this.restartGame();
			this.askBets();
			for (int i = 0; i < this.players.size(); i++) {
				player= this.players.get(i);
				int total = player.getTotal();
				String name = player.getName();
				this.croupier.printHand();
				System.out.println("Turno de: "+name);
				System.out.println();
				if(total > 21) {
					player.printHand();
					System.out.println("¡JUGADOR "+name+" HA PERDIDO CON TOTAL="+total+"!");
					player.setStatus(PlayerStatus.LOSE);
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
					}
				}
			}
			this.croupier.setReveal(true);
			this.croupier.printHand();
			Card card;
			int croupierHandsBefore = this.croupier.getHand().size();
			while(this.croupier.getTotal() < 17) {
				card = deck.draw();
				this.croupier.giveCard(card);
			}
			int croupierHandsAfter = this.croupier.getHand().size();
			if(croupierHandsBefore != croupierHandsAfter) {
				this.croupier.printHand();
			}
			System.out.println("Total de croupier: "+this.croupier.getTotal());
			this.checkWin();
		}while(this.keepPlaying());
		System.out.println("¡Todos los jugadores han perdido!");
	}

}
