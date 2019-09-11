package com.techprogramming.games.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.techprogramming.games.ScannerUtil;

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
		
		ScannerUtil scn = ScannerUtil.getInstance();
		
		String name = "";
		int money = 0;
		BlackJackPlayer player;
		
		for(int i=0; i<totalPlayers; i++) {
			System.out.println("Ingrese nombre para jugador: "+(i+1));
			name = scn.getString("Ingrese un nombre valido");
			System.out.println("Ingrese monto para jugador: "+(i+1));
			money = scn.getInt("Ingrese un monto valido");
			player = new BlackJackPlayer(name,money);
			players.add(player);
		}
		
		return players;
	}
}
