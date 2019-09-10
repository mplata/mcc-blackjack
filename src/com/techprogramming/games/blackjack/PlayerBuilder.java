package com.techprogramming.games.blackjack;

import java.util.ArrayList;
import java.util.List;

public class PlayerBuilder {

	private static PlayerBuilder builder = null;
	
	private PlayerBuilder() {}
	
	public static PlayerBuilder getInstance() {
		if(builder == null) {
			builder = new PlayerBuilder();
		}
		return builder;
	}
	
	public List<BlackJackPlayer> generatePlayers(int totalPlayers){
		
		List<BlackJackPlayer> players = new ArrayList<BlackJackPlayer>();
		
		BlackJackPlayer p1 = new BlackJackPlayer("Daniel", 100);
		BlackJackPlayer p2 = new BlackJackPlayer("Marcos",200);
		
		players.add(p1);
		players.add(p2);
		return players;
	}
}
